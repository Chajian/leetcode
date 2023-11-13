package interview.dp.multiple;


import org.junit.Test;

public class a97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int cur1 =0,cur2 =0;
        for(int i = 0 ; i < s3.length() ;i++){
            if(s1.length()==cur1)
                return s2.substring(cur2).equals(s3.substring(i));
            else if(s2.length()==cur2)
                return s1.substring(cur1).equals(s3.substring(i));

            if(s1.charAt(cur1)!=s3.charAt(i)&&s2.charAt(cur2)!=s3.charAt(i)){
                return false;
            }
            else if(cur2<s2.length()&&s1.charAt(cur1)==s2.charAt(cur2)&&s1.charAt(cur1)==s3.charAt(i)){
                boolean a = isInterleave(s1.substring(cur1+1),s2.substring(cur2),s3.substring(i+1));
                boolean b = isInterleave(s1.substring(cur1),s2.substring(cur2+1),s3.substring(i+1));
                return a||b;
            }
            else if(s1.charAt(cur1)==s3.charAt(i)) {
                cur1++;
            }
            else if(s2.charAt(cur2)==s3.charAt(i)){
                cur2++;
            }
        }
        return cur1==s1.length()&&s2.length()==cur2;
    }

    @Test
    public void test(){
        System.out.println(isInterleave("aabcc","dbbca","aadbbcbcca"));
    }
}
