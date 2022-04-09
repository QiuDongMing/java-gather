package com.qdm.datastruct.lc.dfs;

import java.util.ArrayList;
import java.util.List;

//1 2 3
//1 2 3    1 3 2    2 1 3   2 3 1  3 1 2   3 2 1
public class AllResult {


    public static void main(String[] args) {
         new AllResult().input(new int[]{1,2,3});
    }

    public void  input(int[] nums) {

        dfs(nums, 0 , new ArrayList<>());


    }

    /**
     *
     * @param nums
     * @param len
     * @param res
     */
    private void  dfs(int[] nums, int cur, List<Integer> res) {
        if(res.size() == nums.length) {
            System.out.println("res = " + res);
            return;
        }

        res.add(nums[cur]);
        dfs(nums, cur+1, res);
        res.remove(res.size() - 1);
        dfs(nums, cur+1, res);
    }






}
