# -*- coding:utf-8 -*-


# There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
#
#
#
# You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
#
#
#
# Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
#
#
#
# Note:
# The solution is guaranteed to be unique.


public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, sum = 0, start = 0;
        for (int i = 0; i < gas.length; ++i){
            total += (gas[i] - cost[i]);
            if (sum < 0){ //发现油箱空了，从下一个站点尝试
                sum = (gas[i] - cost[i]);
                start = i;
            }
            else
                sum += (gas[i] - cost[i]);
        }
        return total < 0 ? -1 : start;
    }
}
