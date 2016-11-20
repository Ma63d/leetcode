# -*- coding:utf-8 -*-


# Determine whether an integer is a palindrome. Do this without extra space.
#
# click to show spoilers.
#
# Some hints:
#
# Could negative integers be palindromes? (ie, -1)
#
# If you are thinking of converting the integer to string, note the restriction of using extra space.
#
# You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
#
# There is a more generic way of solving this problem.


public class Solution {
    public boolean isPalindrome(int x) {
        double xx = x;
        if(xx < 0){
            return false;
        }
        if(xx< 10){
            return true;
        }
        int length = 2;double oneWith0 = 100;
        while(xx >= oneWith0){
            oneWith0 *= 10;
            length++;
        }
        oneWith0 /= 10;
        double startMod = 1;
        for(int i = 1;i <= length/2;i++){
            double endMod = oneWith0 / startMod;
            int numStart = (int)((xx % (10*startMod)) / startMod);
            int numEnd = (int)((xx % (10*endMod)) / endMod);
            if(numStart != numEnd){
                return false;
            }
            startMod *= 10;
        }
        return true;

    }
}
