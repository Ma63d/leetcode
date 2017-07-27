public class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        Arrays.sort(candidates);
        result = new ArrayList<List<Integer>>();
        solve(candidates,new ArrayList<Integer>(), 0,target);
        return result;
    }
    public void solve(int[] candidates,List<Integer> cur,int start,int target){
        if(target == 0){
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = start;i < candidates.length;i++){
            if(candidates[i] > target){
                return;
            }
            cur.add(candidates[i]);
            solve(candidates,cur,i,target-candidates[i]);
            cur.remove(cur.size()-1);
        }
    }
    
    
    
    
    
    
    
    
    
    // public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     Arrays.sort(candidates);
    //     dfs(candidates,0,target,new ArrayList<Integer>());
    //     return this.result;
    // }
    // public void dfs(int[] candidates,int start,int target,List<Integer> lastResult){
    //     if(target == 0){
    //         List<Integer> curResult = new ArrayList<Integer>(lastResult);
    //         this.result.add(curResult);
    //     }else{
    //         for(int i = start; i < candidates.length;i++){
    //             if(target >= candidates[i]){
    //                 lastResult.add(candidates[i]);
    //                 dfs(candidates,i,target - candidates[i],lastResult);
    //                 lastResult.remove(lastResult.size()-1);
    //             }else{
    //                 break;
    //             }
    //         }
    //     }
    // }
}