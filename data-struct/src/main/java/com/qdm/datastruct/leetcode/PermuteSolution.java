package com.qdm.datastruct.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class PermuteSolution {



    public static void main(String[] args) {
        PermuteSolution solution = new PermuteSolution();
        int num[] = {1, 2, 3, 4};
        List<List<Integer>> permute = solution.permute(num);

        System.out.println("JSON = " + JSON.toJSONString(permute));

    }

    public List<List<Integer>> permute(int[] nums) {
        Map<List<Integer>, List<List<Integer>>> cache = new HashMap();
        List<Integer> cus = new ArrayList();

        List<List<Integer>> initList = new ArrayList();
        List<Integer> cusList = new ArrayList();
        cusList.add(nums[0]);
        initList.add(cusList);
        cache.put(cusList, initList);

        for(int i=1; i< nums.length; i++) {
            cus.add(nums[i-1]);
            List<List<Integer>> preListRes = cache.get(cus);
            List<List<Integer>> res =  new ArrayList();
            for (List<Integer> listP : preListRes) {
                for (int j = 0; j <= listP.size() ; j++) {
                    List<Integer> cur = new ArrayList<>(listP);
                    cur.add(j, nums[i]);
                    res.add(cur);
                }

            }
            List<Integer> listNew = new ArrayList<>(cus);
            listNew.add(nums[i]);
            cache.put(listNew, res);
        }

        cus.add(nums[nums.length - 1]);
        return cache.get(cus);
    }

//    private List<List<Integer>> permute(List<Integer> preList) {
//        List<List<Integer>> preListRes = cache.get(preList);
//
//        List<List<Integer>> res = new ArrayList();
//        if(preList.size() == 1) {
//            List<Integer> cusList = new ArrayList();
//            cusList.add(preList.get(0));
//            res.add(cusList);
//            cache.put(preList, res);
//            return res;
//        }
//        return preListRes;
//
//    }



}
