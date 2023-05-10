package tools;

import java.util.ArrayList;
import java.util.List;

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

    public static List<String> elimnateBracket(List<String> sources){
        List<String> list = new ArrayList<>();
        for(String s:sources){
            list.add(elimnateBracket(s));
        }
        return list;
    }



}
