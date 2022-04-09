package com.qdm.datastruct.lc.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class SubsetsSolution {

    public static void main(String[] args) {
        SubsetsSolution solution = new SubsetsSolution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println("subsets = " + subsets);
    }

    List<List<Integer>> res = new ArrayList();
    List<Integer> target = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return res;
    }

    private void dfs(int cur,int[] nums) {
        if(cur == nums.length) {
            System.out.println("target = " + target);
            res.add(new ArrayList<>(target));
            return;
        }
        target.add(nums[cur]);
        dfs(cur+1, nums);
        target.remove(target.size()-1);
        dfs(cur + 1, nums);
    }






}
