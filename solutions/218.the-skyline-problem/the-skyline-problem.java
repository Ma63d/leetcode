public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> points = new ArrayList<>();
        
        Queue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare (Integer a, Integer b){
                return b-a;
            }
        });
        for(int i = 0;i < buildings.length;i++){
            int[] cur = buildings[i];
            points.add(new int[]{cur[0],cur[2]});
            points.add(new int[]{cur[1],-cur[2]});
        }
        Collections.sort(points,new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return (a[0] - b[0]) == 0 ? -(a[1]-b[1]):a[0] - b[0];
            }    
        });
        pq.offer(0);
        int last = 0;
        for(int[] cur: points){
            if(cur[1] > 0){
                pq.offer(cur[1]);
            }else{
                pq.remove(-cur[1]);
            }
            if(pq.peek() != last){
                last = pq.peek();
                result.add(new int[]{cur[0],last});
            }
        }
        return result;
    }
}