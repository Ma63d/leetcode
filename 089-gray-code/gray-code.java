# -*- coding:utf-8 -*-


# The gray code is a binary numeral system where two successive values differ in only one bit.
#
# Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
#
# For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
#
# 00 - 0
# 01 - 1
# 11 - 3
# 10 - 2
#
#
# Note:
# For a given n, a gray code sequence is not uniquely defined.
#
# For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
#
# For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.


public class Solution {
    ArrayList<Integer>  result = new ArrayList<Integer>();
    public List<Integer> grayCode(int n) {
        this.result = new ArrayList<Integer>();
        this.result.add(0);
        int[] used = new int[1 << n];
        used[0] = 1;
        generate(1 << n,0,1,used,this.result);
        return this.result;
    }
    public boolean generate(int n,int last,int m,int[] used,ArrayList<Integer> alreadyAdd){
        if(n == m){
            return true;
        }
        for(int i = 0;i < n;i++){
            int bitAtI = (last >> i) % 2;
            int adder = ((bitAtI == 0)?1:-1)*(1 << i);
            if(used[last+adder] == 0){
                alreadyAdd.add(last+adder);
                used[last+adder] = 1;
                if(generate(n,last+adder,m+1,used,alreadyAdd)){
                    return true;
                }
                used[last+adder] = 0;
                alreadyAdd.remove(alreadyAdd.size()-1);
            }
        }
        return false;
    }
    
}
