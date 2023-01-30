package com.wang33.algorighm.Chatper2Array;

/***
 *  @author wangyashuai
 *  @date 2023/1/30 上午10:09
 *
 */
public class l12PivotIndex {
  /**
   * 左右两边子数组的和相等
   *
   * 从头累加数组中的每个元素，可以算出左边数组之和，求出数组的总和，然后减去，左边的数组之和就是右边的组数之和，
   *
   */

  public int pivotIndex(int[] nums) {

    // 先求出数组的总和
    int total=0;
    for (int num : nums) {
      total = total + num;
    }
    // 然后再遍历数组，寻找左右两边子数组之和相等的下标
    int sum=0;
    for (int i=0;i<nums.length;i++) {
      sum = sum+ nums[i];
      if(sum - nums[i] ==  total - sum){
        return i;
      }
    }
    return -1;
  }


}
