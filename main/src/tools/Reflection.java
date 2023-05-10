package tools;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Reflection<T> {
    public void executeLeetcode(List<String> input, List<String> methods, T t) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        /**
         * 第一步： 初始化一个Object[]数组
         */
        Object[] result;
        result = new Object[methods.size()];
        for (int i = 0; i < methods.size(); i++) {
            result[i] = new Object();
        }

        /**
         * 第二步： 处理输入方法与参数，调用MyHashMap的方法。
         */
//        Trie myHashMap = null;
//        Class<Trie> clazz = Trie.class;
        T myHashMap = t;
        Class<T> clazz = (Class<T>) myHashMap.getClass();

        // 1、循环构造方法，并clazz.newInstance();
        for (Constructor c : clazz.getDeclaredConstructors()) {
            if (c.getName().endsWith(methods.get(0))) {
                myHashMap = clazz.newInstance();
                result[0] = "null";
            }
        }
        // 2、循环方法，并method.invoke(myHashMap, inputArgs[i]);
        for (int i = 1; i < methods.size(); i++) {
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.getName().equalsIgnoreCase(methods.get(i))) {
                    result[i] = method.invoke(myHashMap, input.get(i));
                }
            }
        }

        /**
         * 第三步： 打印结果。
         */
        System.out.println(Arrays.deepToString(result));



    }



}
