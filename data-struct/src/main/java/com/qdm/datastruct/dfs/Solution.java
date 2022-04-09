package com.qdm.datastruct.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

   public static List<List<Integer>>  result =  new ArrayList();

    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
    }


    public static  List<List<Integer>> permute(int[] nums) {
        boolean[] invited = new boolean[nums.length];
        for(int i=0;i<nums.length;i++) {
            invited[i] = false;
        }

        List<Integer> res =  new ArrayList();
        permuteDfs(nums, 0, invited, res);
        System.out.println("result = " + result);
        return  result;

    }


    public static void permuteDfs(int[] nums, int level, boolean[] invited, List<Integer> res) {
        if(level == nums.length) {
            List<Integer> re = new ArrayList<>(res.size());
            re.addAll(res);
            result.add(re);
            System.out.println("result 2= " + result);
            return;
        }

        for(int i=0; i < nums.length; i++) {
            Integer data = nums[i];
            if(!invited[i]) {
                res.add(data);
                invited[i] =  true;
                permuteDfs(nums, level+1, invited, res);
                invited[i] = false;
                res.remove(data);
            }
        }
    }







}