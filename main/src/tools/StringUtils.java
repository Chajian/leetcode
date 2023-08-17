package tools;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static String elimnateBracket(String source){
        StringBuilder stringBuilder = new StringBuilder(source);
        for(int i = 0 ; i < source.length() ;i++){
            char c  = source.charAt(i);
            if(c!='['&&c!=']')
                stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static String middleBracketToLarge(String source){
        return source.replaceAll("\\[","{").replaceAll("]","}");
    }

    public static String doubleDotToSingleDot(String source){
        return source.replaceAll("\"","'");
    }

    public static List<String> elimnateBracket(List<String> sources){
        List<String> list = new ArrayList<>();
        for(String s:sources){
            list.add(elimnateBracket(s));
        }
        return list;
    }

    public static String wipeOutPosition(String fieldType){
        String rule = "\\(\\d+\\)";
        return fieldType.replaceAll(rule,"");
    }

    public static boolean hasPosition(String fieldType){
        String rule = "\\(\\d+\\)";
        Pattern pattern = Pattern.compile(rule);
        Matcher matcher = pattern.matcher(fieldType);
        return matcher.matches();
    }

}
