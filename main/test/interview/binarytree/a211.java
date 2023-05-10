package interview.binarytree;

import entity.WordDictionary;
import org.junit.Test;
import tools.Reflection;
import tools.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class a211 {

    @Test
    public void test() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Reflection<WordDictionary> reflection = new Reflection<>();
        reflection.executeLeetcode(List.of("","at","and","an","add","a",".at","bat",".at","an.","a.d.","b.","a.d","."),List.of("WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"),new WordDictionary());


    }

    @Test
    public void testString(){
        System.out.println((int)'a');
//        System.out.println(StringUtils.elimnateBracket("[],[\"at\"],[\"and\"],[\"an\"],[\"add\"],[\"a\"],[\".at\"],[\"bat\"],[\".at\"],[\"an.\"],[\"a.d.\"],[\"b.\"],[\"a.d\"],[\".\"]"));
    }

}
