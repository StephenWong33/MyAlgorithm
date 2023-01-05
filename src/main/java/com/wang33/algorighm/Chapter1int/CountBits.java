package com.wang33.algorighm.Chapter1int;

/***
 *  @author wangyashuai
 *  @date 2023/1/5 上午11:24
 *
 */
public class CountBits {
  /**
   * 题目: 输入一个非负数n，请计算0到n之间每个数字的二进制形式中1的个数，并输出一个数组，例如输入的n为4，由于0、1、2、3、4的
   * 二进制形式中1的个数分别为 0，,1，,1，,2 ，1 因此输出数组为【0，,1，,1，,2，,1】
   *
   * 解法1
   * 直观的解法是 转化成求每个数字二进制中1的个数， i&(i-1) 是一种比较高效的做法，运行原理是，如果i的最右边是1 ，那么i-1 最右边是0
   * 可以消除最右边的1，如果最右边是0，那么i-1 会消耗i最右侧的1，变成0，右边的其他位变成1，i&(i-1)结果，会消耗最右边的1。
   * 时间复杂度是O(kn)
   * 解法2
   * i 比i&(i-1)多一个1，所以可以从缓存中获取 result[i] = result[i&(i-1)] +1
   * 解法3
   * 利用奇数和偶数的关系， i为偶数时，和i/2 中1的个数相同，i为奇数时，i比i/2中 1 的个数多1个
   */

  public  int[] countBits1(int n){
    int[] result = new int[n + 1];
    for(int i=0;i<=n;i++){
      int j=i;
      while (j !=0){
        result[i]++;
        j=j&(j-1);
      }
    }
    return result;
  }

  public  int[] countBits2(int n){
    int[] result = new int[n + 1];
    for(int i =1;i<=n;i++){
      result[i]=result[i&(i-1)] +1;
    }
    return  result;
  }

  public int[] countBits3(int n){
    int[] result = new int[n + 1];
    for (int i=1;i<=n;i++){
      result[i] =result[i>>1] + (i&1);
    }
    return  result;
  }







}
