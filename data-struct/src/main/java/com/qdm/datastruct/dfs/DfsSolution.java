package com.qdm.datastruct.dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DfsSolution {


    /**
     * 1、求给定数字的全排
     */
    @Test
    public void getNumberCombination() {
        int[] nums = {1, 2, 3, 4};
        boolean[] visited = {false, false, false, false};
        Stack<Integer> stack = new Stack<>();
        getNumberCombinationDfs(nums, 0, visited, stack);

    }

    /**
     * @param nums    给定的数字
     * @param level   当前的层级
     * @param visited 当前是否已经计算
     * @param res     本次的结果
     *                0                                            0
     *                <p>
     *                1                    1                         2                       3
     *                2             2            3            1           3           1           2
     *                3        3                    2      3                  1    2                1
     */
    private void getNumberCombinationDfs(int[] nums, int level, boolean[] visited, Stack<Integer> res) {
        if (nums.length == level) {
            System.out.println("res = " + res);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int data = nums[i];
            if (!visited[i]) {
                res.push(data);
                visited[i] = true;
                getNumberCombinationDfs(nums, level + 1, visited, res);
                visited[i] = false;
                res.pop();
            }
        }
    }


    @Test
    public void rightIps() {
        String ipStr = "19216801";
        rightIpsDfs(ipStr, 0, 1, new Stack<>());
    }


    private void rightIpsDfs(String ips, int index, int level, Stack<String> res) {
//        System.out.println("res1 = " + res + ", index=" + index +", level=" + level);
        if (level == 5 || index  >= ips.length()) {
            if (level == 5 && index  == ips.length()) {
                System.out.println("res = " + res);
            }
            return;
        }


        for (int i = 1; i < 4; i++) {
            if (index + i > ips.length()) {
                break;
            }
            String n = ips.substring(index, index + i);
            if (Integer.valueOf(n) < 255 &&  (n.equals("0")  || !n.startsWith("0"))) {
                res.push(n);
                rightIpsDfs(ips, index+i, level+1, res);
                res.pop();
            }
        }

    }






}
