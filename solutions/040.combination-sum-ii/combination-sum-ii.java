public class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        Arrays.sort(candidates);
        result = new ArrayList<List<Integer>>();
        solve(candidates,new ArrayList<Integer>(),0,target);
        return result;
    }
    public void solve (int[] candidates, List<Integer>cur,int start,int target) {
        if(target == 0){
            List<Integer> curResult = new ArrayList<Integer>(cur);
            result.add(curResult);
            return;
        }
        for(int i = start;i < candidates.length;i++){
            if(i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            if(candidates[i] <= target){
                cur.add(candidates[i]);
                solve(candidates,cur,i+1,target-candidates[i]);
                cur.remove(cur.size()-1);
            }
        }
    }
    
    
    // HashSet x = new HashSet();
    // public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    //     Arrays.sort(candidates);
    //     dfs(candidates,0,target,new ArrayList<Integer>());
    //     Iterator it = this.x.iterator();
    //     while(it.hasNext()){
    //         this.result.add((List)(it.next()));
    //     }
    //     return this.result;
    // }
    // public void dfs(int[] candidates,int start,int target,List<Integer> lastResult){
    //     if(target == 0){
    //         List<Integer> curResult = new ArrayList<Integer>(lastResult);
    //         x.add(curResult);
    //     }else{
    //         for(int i = start; i < candidates.length;i++){
    //             if(target >= candidates[i]){
    //                 lastResult.add(candidates[i]);
    //                 dfs(candidates,i+1,target - candidates[i],lastResult);
    //                 lastResult.remove(lastResult.size()-1);
    //             }else{
    //                 break;
    //             }
    //         }
    //     }
    // }
}