public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        if(s1.equals(s2)) return true;
        int[] s1Map = new int[26];
        for(int i = 0; i < s1.length(); i++){
            s1Map[s1.charAt(i) - 'a']++;
            s1Map[s2.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(s1Map[i] < 0){
                return false;
            } 
        }
        for(int i = 1; i< s1.length(); i++){
            String s1Left = s1.substring(0,i);
            String s1Right = s1.substring(i);
            String s2Right = s2.substring(s2.length()-i);
            String s2Left = s2.substring(0,s2.length()-i);
            if(isScramble(s1Left,s2Right) && isScramble(s1Right,s2Left)){
                return true;
            }else {
                s2Left = s2.substring(0,i);
                s2Right = s2.substring(i);
                if(isScramble(s1Left,s2Left) && isScramble(s1Right,s2Right)){
                    return true;
                }
            }
        }
        return false;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //这种对父结构、子结构、子子结构...都进行了变换的情况,很明显,需要递归的进行处理;
    //以后要形成这种明显的思维定势
    //思路是由于它是因为它是把二叉树的某个层次的节点及其后的节点中的一些进行了前后调换
    //但是调换并不改变字符的数量
    //所以若s1和s2 isScramble 要么是s1的前i个和s2的前i个isScramble且s1和s2剩下的也都isScramble
    //要么就是s1的后i个和s2的前i个isScramble且s1和s2剩下的也都isScramble
    //遍历所有的i遇到成功的,就说明s1和s2 isScramble 反之则false;
    //public boolean isScramble(String s1, String s2) {
        // if(s1.length() != s2.length()){
        //      return false;
        // }else{
        //     if(s1.equals(s2)){
        //         return true;
        //     }else if(s1.length() ==1){
        //         return false;
        //     }
        //     int[] map = new int[58];
        //     for(int i = 0;i < s1.length();i++){
        //         char cur = s1.charAt(i);
        //         map[cur-'A']++;
        //     }
        //     for(int i = 0;i < s2.length();i++){
        //         char cur = s2.charAt(i);
        //         if(--map[cur-'A'] < 0){
        //             return false;
        //         }
        //     }
        //     for(int i = 1;i < s1.length();i++){
        //         if(isScramble(s1.substring(0,i),s2.substring(0,i))){
        //             if(isScramble(s1.substring(i),s2.substring(i))){
        //                 return true;
        //             }
        //         }else if(isScramble(s1.substring(0,i),s2.substring(s2.length()-i))){
        //             if(isScramble(s1.substring(i),s2.substring(0,s2.length()-i))){
        //                 return true;
        //             }
        //         }
        //     }
        //     return false;
        // }
        
        
        
        
        // if(s1.equals(s2)) return true;
        // for(int i = 1;i < s1.length();i++){
        //     String s1Left = s1.substring(0,i);
        //     String s1Right = s1.substring(i);
        //     String s2Right = s2.substring(s2.length()-i);
        //     String s2Left = s2.substring(0,s2.length()-i);
        //     if(isScramble(s1Left,s2Right) && isScramble(s1Right,s2Left)){
        //         return true;
        //     }else {
        //         s2Left = s2.substring(0,i);
        //         s2Right = s2.substring(i);
        //         if(isScramble(s1Left,s2Left) && isScramble(s1Right,s2Right)){
        //             return true;
        //         }
        //     }
        // }
        // return false;
    }
}