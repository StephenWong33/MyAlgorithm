package com.wang33.algorighm.Chatper2Array;

/***
 *  @author wangyashuai
 *  @date 2023/1/7 下午12:52
 *
 */
public class l9SubArrayProduct {

  /**
   * 题目： 给定一个含有n个正整数的数组nums和整数k，请找出该数组内乘积小于k的连续子数组的个数
   * <p>
   * 解密 正数，可以使用双指针
   *
   * 例如
   * nums=[10,5,2,6] k=100
   * 1   10
   * 2   5 5,10
   * 2   2  2,5
   * 3   6  6,2  6,2,5
   *
   *
   */

  public int numSubarrayProductLessThanK(int[] nums, int k) {
    int left = 0;
    long product = 1l;
    int count = 0;
    for (int right = 0; right < nums.length; right++) {
      product = product * nums[right];
      while (left <= right && product >= k) {
        product = product / nums[left++];
      }
      // 每新增一个数，那么就会增加 right - left + 1 个子数组，包括 新增数字，新增数字和前面各个数字组成的子数组
      count += right >= left ? right - left + 1 : 0;
    }
    return count;
  }


}
