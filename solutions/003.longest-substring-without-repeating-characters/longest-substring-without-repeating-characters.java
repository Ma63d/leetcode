public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 1) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 1;
        map.put(s.charAt(0),0);
        for(int i = 1;i < s.length();i++){
            if(map.containsKey(s.charAt(i))){
                int startIndex = i - map.size();
                int lastIndex = map.get(s.charAt(i));
                for(int j = startIndex;j <= lastIndex;j++){
                    map.remove(s.charAt(j));
                }
                map.put(s.charAt(i),i);
            }else {
                map.put(s.charAt(i),i);
                if(map.size() > maxLen){
                    maxLen = map.size();
                }
            }
        }
        return maxLen;
    }
}