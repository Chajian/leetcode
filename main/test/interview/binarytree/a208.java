package interview.binarytree;

import entity.TreeNode;
import entity.TreeNodeChar;
import entity.Trie;
import org.junit.Test;
import tools.Reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

public class a208 {


    @Test
    public void test() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Reflection<Trie> trieReflection = new Reflection<>();
        trieReflection.executeLeetcode(List.of("","hotdog","hot","hoo","app"),List.of("Trie","insert","search","insert","insert"),new Trie());
    }

}
