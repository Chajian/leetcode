package tools.hy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class JsonUtils {
    public void main() throws FileNotFoundException {
        JSONArray jsonArray = JSON.parseArray(getJsonStringFromFile("C:\\Users\\HY\\Documents\\haoyun\\systemvariable.json"));
        Map<Long, JSONObject> map = new HashMap<>();//map缓存json对象
        for(int i = 0 ; i < jsonArray.size() ;i++){
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            map.put(jsonObject.getLong("id"),jsonObject);
        }
        Set<Long> isChoose = new HashSet<>();//set避免重复操作
        JSONArray result = new JSONArray();
        for(int i = 0 ; i < jsonArray.size() ;i++){
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            if(map.get(jsonObject.getLong("pid"))==null) {
                result.add(jsonObject);
                continue;
            }
            findParent(jsonObject,map,isChoose);
        }
        System.out.println(result.toJSONString());
    }

    /**
     * 递归查找父节点
     * 其中pid作为外键依赖
     * children是父节点中用于存储子节点的集合
     * @param vo
     * @param map
     * @param isChoose
     */
    public void findParent(JSONObject vo, Map<Long, JSONObject> map, Set<Long> isChoose){
        if(vo.getLong("pid")==0L||isChoose.contains(vo.getLong("id"))){
            isChoose.add(vo.getLong("id"));
            return;
        }
        else{
            isChoose.add(vo.getLong("id"));
            JSONObject parent = map.get(vo.getLong("pid"));
            if(parent!=null) {
                if(parent.getJSONArray("children")==null)
                    parent.put("children",new ArrayList<JSONObject>());
                parent.getJSONArray("children").add(vo);
                findParent(parent, map,isChoose);
            }
        }
    }

    /**
     * 获取json字符串从json文件中
     * @param path
     * @return
     * @throws FileNotFoundException
     */
    public String getJsonStringFromFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        StringBuilder stringBuilder = new StringBuilder();
        while(scanner.hasNext()){
            stringBuilder.append(scanner.next());
        }
        return stringBuilder.toString();
    }

}
