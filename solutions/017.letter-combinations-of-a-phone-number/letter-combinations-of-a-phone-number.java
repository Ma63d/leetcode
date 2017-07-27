public class Solution {
    char[][] dictionary;
    List<String> result;
    public void _solve(String digits,String curStr) {
        if(digits.length() != 0){
            int c = digits.charAt(0) - '2';
            if(c > 7 || c < 0){
                _solve(digits.substring(1),curStr);
                return;
            }
            for(int i = 0,l = dictionary[c].length; i < l; i++){
                _solve(digits.substring(1), curStr+dictionary[c][i]);
            }
        }else {
            if(!curStr.equals("")){
                result.add(curStr);
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<String>();
        dictionary = new char[8][];
        dictionary[0] = new char[]{'a','b','c'};
        dictionary[1] = new char[]{'d','e','f'};
        dictionary[2] = new char[]{'g','h','i'};
        dictionary[3] = new char[]{'j','k','l'};
        dictionary[4] = new char[]{'m','n','o'};
        dictionary[5] = new char[]{'p','q','r','s'};
        dictionary[6] = new char[]{'t','u','v'};
        dictionary[7] = new char[]{'w','x','y','z'};
        _solve(digits,"");
        return result;
        
        
        // List result = new ArrayList();
        // List lastResult = result;
        // for(int i = 0;i < digits.length();i++){
        //     int num = digits.charAt(i) - '0';
        //     List charArr = new ArrayList();
        //     switch(num){
        //         case 2:
        //             charArr.add("a");charArr.add("b");charArr.add("c");
        //             break;
        //         case 3:
        //             charArr.add("d");charArr.add("e");charArr.add("f");
        //             break;
        //         case 4:
        //             charArr.add("g");charArr.add("h");charArr.add("i");
        //             break;
        //         case 5:
        //             charArr.add("j");charArr.add("k");charArr.add("l");
        //             break;
        //         case 6:
        //             charArr.add("m");charArr.add("n");charArr.add("o");
        //             break;
        //         case 7:
        //             charArr.add("p");charArr.add("q");charArr.add("r");charArr.add("s");
        //             break;
        //         case 8:
        //             charArr.add("t");charArr.add("u");charArr.add("v");
        //             break;
        //         case 9:
        //             charArr.add("w");charArr.add("x");charArr.add("y");charArr.add("z");
        //             break;
        //         default:
        //             return new ArrayList();
        //     }
        //     if(i == 0){
        //         result.addAll(charArr);
        //     }else{
        //         lastResult = result;
        //         result = new ArrayList();
        //         for(int j = 0;j < lastResult.size();j++){
        //             String curStr = (String)lastResult.get(j);
        //             result.add(curStr + charArr.get(0));
        //         }
        //         for(int j= 0;j < lastResult.size();j++) {
        //             String curStr = (String)lastResult.get(j);
        //             for (int k = 1; k < charArr.size(); k++) {
        //                 result.add(curStr+charArr.get(k));
        //             }
        //         }
        //     }
        // }
        // return result;
    }
}