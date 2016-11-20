# -*- coding:utf-8 -*-


# Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
#
# You may assume that the intervals were initially sorted according to their start times.
#
#
# Example 1:
# Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
#
#
#
# Example 2:
# Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
#
#
#
# This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        int i = 0;
        boolean added = false;
        for(;i < intervals.size();i++){
            Interval cur = intervals.get(i);
            if(cur.end < newInterval.start){
                result.add(cur);
            }else if(cur.start <= newInterval.start && cur.end < newInterval.end  ){
                //后面的情况里 cur.end >= newInterval.start
                newInterval.start = cur.start;
            }else if(cur.start <= newInterval.start && newInterval.end <= cur.end){
                added = true;
                for(;i < intervals.size();i++) result.add(intervals.get(i));
                break;
            }else if(cur.start > newInterval.start && newInterval.end > cur.end){
                continue;
            }else if(cur.start > newInterval.start && newInterval.end <= cur.end && newInterval.end >= cur.start){
                newInterval.end = cur.end;
            }else{
                result.add(newInterval);
                added = true;
                for(;i < intervals.size();i++) result.add(intervals.get(i));
                break;
            }
        }
        if(!added){
            result.add(newInterval);
        }
        return result;
    }
}
