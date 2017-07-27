public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if(total % 2 == 1){
            return _find(nums1,0,nums2,0,total/2+1);
        }else {
             return (_find(nums1,0,nums2,0,total/2) + _find(nums1,0,nums2,0,total/2+1))/2;
        }
    }
    public double _find(int nums1[],int start1, int nums2[], int start2,int pos){
        if(nums1.length- start1 > nums2.length -start2){
            return _find(nums2,start2,nums1,start1,pos);
        }
        if(start1 == nums1.length){
            return nums2[start2+pos-1];
        }
        if(pos == 1){
            return nums1[start1] > nums2[start2] ? nums2[start2] :nums1[start1];
        }
        int match = Math.min(pos/2,nums1.length - start1);
        if(nums1[start1+match-1] > nums2[start2+match-1]){
            start2 += match;
            pos = pos- match;
        }else if(nums1[start1+match-1] < nums2[start2+match-1]) {
            start1 += match;
            pos = pos- match;
        }else {
             pos = pos - match*2;
             if(pos == 0) return nums1[start1+match-1];
             else {
                 start2 += match;
                 start1 += match;
             }
        }
        
        return _find(nums1,start1,nums2,start2,pos);
    }
}