package com.qdm.datastruct.huisu;

/**
 * 背包问题
 *     给定n种物品和一背包。物品i的重量是wi，其价值为pi，背包的容量为C。问应如何选择装入背包的物品，使得装入背包中物品的总价值最大?
 *     分析：问题是n个物品中选择部分物品，可知，问题的解空间是子集树。比如物品数目n=3时，其解空间树如下图，边为1代表选择该物品，边为0代表不选择该物品。
 *     使用x[i]表示物品i是否放入背包，x[i]=0表示不放，x[i]=1表示放入。回溯搜索过程，如果来到了叶子节点，表示一条搜索路径结束，如果该路径上存在更优的解，
 *     则保存下来。如果不是叶子节点，是中点的节点（如B），就遍历其子节点（D和E），如果子节点满足剪枝条件，就继续回溯搜索子节点。
 *
 *
 *
 *
 *
 */
public class PackageSolution {

    private static final  int N = 3;                  //物品数量
    private static final  int C = 16;                 //背包容量
    private static final  int w[] = {10,8,5};         //每个物品的重量
    private static final  int v[] = {5,4,1};          //每个物品的价值
    private static final  int x[] = {0,0,0};          //x[i]=1代表物品i放入背包，0代表不放入
    private static   int curW = 0;               //当前放入背包的物品总重量
    private static   int curV = 0;               //当前放入背包的物品总价值

    private static  int BestVal = 0;            //最优解，当前的最大价值
    private static final int BestX[] = new int[3];   //最优解；BestX[i]=1代表物品i放入背包，0代表不放入


    public static void main(String[] args) {

        backtrack(0);

        System.out.println("最优值(最大价值) = " + BestVal);

        System.out.println("最优解:");
        for(int i=0;i<N;i++) {
            System.out.printf("%d=%d" + ((i==N-1) ? "" : ", "), i, BestX[i]);
        }

    }


    //t=0 to N-1
    private static void backtrack(int t) {

        if (t > N - 1) {
            //如果找到了一个更优的解
            if (curV > BestVal) {
                //保存更优的值和解
                BestVal = curV;
                for (int i = 0; i < N; ++i) {
                    BestX[i] = x[i];
                }
            }
        } else {
            //遍历当前节点的子节点：0 不放入背包，1放入背包
            for (int i = 0; i <= 1; i++) {
                x[t] = i;

                //不放入背包
                if (i == 0) {
                    backtrack(t + 1);
                } else  { //放入背包
                    //约束条件：放的下
                    if ((curW + w[t]) <= C) {
                        curW += w[t];
                        curV += v[t];
                        backtrack(t + 1);
                        curW -= w[t];
                        curV -= v[t];
                    }
                }
            }
        }

    }







}
