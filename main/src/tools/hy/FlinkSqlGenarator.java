package tools.hy;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import tools.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 根据xlsx生成flink-cdc sql
 */
public class FlinkSqlGenarator {
    static String excelPath = "C:\\Users\\HY\\Documents\\haoyun\\flink\\同步数据(2).xlsx";
    static String outPath = "脚本.txt";
    static Map<String,String> targetFields = new LinkedHashMap<>();

    static String targetSuffix = "_sink";

    static String sourceSuffix = "_source";

    static Map<String,String> sourceFields = new LinkedHashMap<>();

    static String createTable = "CREATE TABLE ";
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream(new File(excelPath));
             Workbook workbook = new XSSFWorkbook(fileInputStream);
             FileWriter writer = new FileWriter(outPath)) {
            Iterator<Sheet> iterator = workbook.sheetIterator();
            while(iterator.hasNext()) {

                Sheet sheet = iterator.next();


                //get table name
                String targetTab = sheet.getRow(1).getCell(0).getStringCellValue().trim();
                String sourceTab = sheet.getRow(1).getCell(3).getStringCellValue().trim();

                //genarate source and tareget ddl
                int numRows = sheet.getLastRowNum();
                StringBuilder source = new StringBuilder();
                StringBuilder target = new StringBuilder();
                target.append(createTable + targetTab + targetSuffix+" (\n");
                source.append(createTable + sourceTab + sourceSuffix+" (\n");



                //generate field
                target.append(generateFields(sheet, 3, numRows, 0, 2, new FieldCallBack() {

                    //过滤字段
                    @Override
                    public boolean preFilter(String fieldName) {
                        if(fieldName.equals("sequence")||fieldName.equals("qty_flag") ||fieldName.equals("voucher_flag")||
                                fieldName.equals("estimate_sycn_flag")||fieldName.equals("estimate_sync_time")||fieldName.equals("entry_flag"))
                            return true;
                        return false;
                    }

                    //类型转换
                    @Override
                    public String preHandleType(String name,String fieldType) {
                        //map fieldType
                        if(fieldType.equals("year(4)")){
                            fieldType = "varchar(32)";
                        }
                        if(fieldType.equals("text")){
                            fieldType = "varchar";
                        }
                        if(fieldType.contains("bigint")||fieldType.contains("tinyint")||fieldType.contains("int"))
                            fieldType = StringUtils.wipeOutPosition(fieldType);
                        if(fieldType.equals("datetime")){
                            fieldType = "timestamp";
                        }
                        return fieldType;
                    }

                    @Override
                            public void callBack(String fieldName,String fieldType) {
                                targetFields.put(fieldName,fieldType);
                            }
                        }));
                source.append(generateFields(sheet, 3, numRows, 4, 5, new FieldCallBack() {


                    @Override
                    public boolean preFilter(String fieldName) {
                        return false;
                    }

                    @Override
                    public String preHandleType(String name,String fieldType) {
                        //map fieldType
                        if(fieldType.equals("year(4)")){
                            fieldType = "varchar(32)";
                        }
                        else if(fieldType.equals("text")){
                            fieldType = "varchar";
                        }
                        else if(fieldType.contains("bigint")||fieldType.contains("tinyint")||fieldType.contains("int"))
                            fieldType = StringUtils.wipeOutPosition(fieldType);
                        else if(fieldType.equals("datetime")){
                            fieldType = "timestamp";
                        }
                        if(targetFields.get(name)!=null){
                            if(!targetFields.get(name).equals(fieldType)&&(!name.equals("id")&&!name.equals("fid")))
                                fieldType = targetFields.get(name);
                        }



                        return fieldType;
                    }

                    @Override
                    public void callBack(String fieldName,String fieldType) {
                        sourceFields.put(fieldName,fieldType);
                    }
                }));
                source.append(")");
                target.append(")");

                //generate with
                source.append(generateSourceWith("192.168.9.158",sourceTab,"iotmp","Hy@21nbHh",13306,"cascade_test2","mysql-cdc"));
                target.append(generateTargetWith("jdbc","com.mysql.cj.jdbc.Driver","10.5.2.56",3306,"hy_test","hy","123456",targetTab));
                writer.write(source.toString());
                writer.write("\n");
                writer.write(target.toString());
                writer.write("\n");


                //generate insert
                writer.write(generateInsert(targetTab+targetSuffix,sourceTab+sourceSuffix));
                writer.write("\n\n\n");

                System.out.println("Text file created successfully!"+sheet.getSheetName());
                targetFields.clear();
                sourceFields.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成insert语句
     * @param insertTab
     * @param selectTab
     * @return
     */
    public static String  generateInsert(String insertTab,String selectTab){
        StringBuilder ddl = new StringBuilder();
        ddl.append("INSERT INTO "+insertTab+" SELECT\n");
        targetFields.keySet().stream()
                .filter(e->!e.equals("sequence"))
                .forEach(e->{
                    if(sourceFields.get(e)!=null){
                        if(e.equals("id")){
                            e = "string_to_long('1',"+selectTab+".id)";
                            ddl.append(e + " as id ,\n");
                        }
                        else if(e.equals("last_update_time")||e.equals("create_time")){
                            ddl.append("CASE WHEN "+selectTab+"."+e+" IS NULL THEN CURRENT_TIMESTAMP ELSE "+selectTab+"."+e+" END"+" as "+e+" ,\n");
                        }
                        else if(e.equals("fid")){
                            ddl.append("string_to_long('1',"+selectTab+".fid)"+" as "+e+" ,\n");
                        }
                        else {
                            ddl.append(selectTab + "." + e + " ,\n");
                        }
                    }
                    else{
                        //map handler
                        String supple = "Null";
                        if(e.equals("create_user_name")||e.equals("data_version")||e.equals("last_update_user_name")||e.equals("create_userid")||e.equals("last_update_userid")){
                            supple = "'1'";
                        }
                        if(e.equals("last_update_user_id")||e.equals("create_user_id"))
                            supple = "1";
                        if(e.equals("old_id")){
                            supple = selectTab+".id";
                        }
                        if(e.equals("fid")){
                            supple = "string_to_long('1',"+selectTab+".fid)";
                        }
                        if(e.equals("cangkubeizhu")){
                            supple = "warehouse_remark";
                        }
                        ddl.append(supple+" as "+e+" ,\n");
                    }
                });
        ddl.deleteCharAt(ddl.length()-2);
        ddl.append("FROM "+selectTab+";");
        return ddl.toString();
    }

    /**
     *
     * @param name name所在列
     * @param type 类型所在列
     * @param fieldCallBack 回调函数
     * @return 返回字符串
     */
    public static String  generateFields(Sheet sheet,int rowindex,int endRow,int name,int type,FieldCallBack fieldCallBack){
        StringBuilder stringBuilder = new StringBuilder();
        for(;rowindex<=endRow;rowindex++){
            Row row = sheet.getRow(rowindex);
            if(row.getCell(name)!=null) {
                String fieldName = row.getCell(name).getStringCellValue();
                if(fieldCallBack.preFilter(fieldName))
                    continue;


                String fieldType = row.getCell(type).getStringCellValue();
                fieldType = fieldCallBack.preHandleType(fieldName,fieldType);

                stringBuilder.append("`"+fieldName+"` "+fieldType+" ,\n");
                fieldCallBack.callBack(fieldName,fieldType);
            }
        }
        //插入主键
        stringBuilder.append("primary key (`id`) not enforced\n");
//        stringBuilder.deleteCharAt(stringBuilder.length()-2);
        return stringBuilder.toString();
    }

    /**
     * 生成SourceWith语句
     * @param host
     * @param tableName
     * @param userName
     * @param pass
     * @param port
     * @param dataName
     * @param connector
     * @return
     */
    public static String  generateSourceWith(String host,String tableName,String userName,String pass,int port,String dataName,String connector){
        return " WITH (\n" +
                "'connector' = '"+connector+"',\n" +
                "'hostname' = '"+host+"',\n" +
                "'port' = '"+port+"',\n" +
                "'username' = '"+userName+"',\n" +
                "'password' = '"+pass+"',\n" +
                "'database-name' = '"+dataName+"',\n" +
                "'table-name' = '"+tableName+"',\n"+
                "'jdbc.properties.useSSL' = 'false',\n" +
                "'server-time-zone' = 'Asia/Shanghai',\n" +
                "'scan.startup.mode' = 'initial'\n);";
    }

    /**
     * 生成targetWith语句
     * @param connector
     * @param driver
     * @param host
     * @param port
     * @param dbName
     * @param userName
     * @param pass
     * @param tableName
     * @return
     */
    public static String generateTargetWith(String connector,String driver,String host,int port,String dbName,String userName,String pass,String tableName){
        return " WITH (\n" +
                "'connector' = '"+connector+"',\n" +
                "'driver' = '"+driver+"',\n" +
                "'url' = 'jdbc:mysql://"+host+":"+port+"/"+dbName+"?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useSSL=false&rewriteBatchedStatements=true&tinyInt1isBit=false&zeroDateTimeBehavior=CONVERT_TO_NULL',\n" +
                "'username' = '"+userName+"',\n" +
                "'password' = '"+pass+"',\n" +
                "'table-name' = '"+tableName+"'\n);";
    }


    /**
     * 字段回调接口
     */
    interface FieldCallBack{
        boolean preFilter(String fieldName);
        String preHandleType(String name,String fieldType);
        void callBack(String fieldName,String fieldType);
    }
}