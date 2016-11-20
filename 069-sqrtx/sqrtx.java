# -*- coding:utf-8 -*-


# Implement int sqrt(int x).
#
# Compute and return the square root of x.


public class Solution {
    public int mySqrt(int x) {
        int right = x;
        if(x == 0) return 0;
        int left = 1;
        while(left < right){
            int middle = (right + left)/2;
            if(x/middle < middle){
                right = middle-1;
            }else{
                if(left == middle) return (x/right)>=right?right:left;
                left = middle;
            }
        }
        return left;
    }
}
