package com.wang33.algorighm.Chatper2Array;

/***
 *  @author wangyashuai
 *  @date 2023/1/7 下午1:18
 *
 */
public class l8MinSubArrayLength {

  /**
   *
   * 题目
   * 输入一个含有n个正整数的数组和一个正整数target，找出该数组中满足其和>=target的最小长度的连续子数组
   *解析
   * 通过左右两个指针确定子数组，数组中都是正整数，可以通过移动双指针实现，
   * 记录子数组之和，如果和小于target则向右移动，如果大于target则向左移动
   *
   */

  public int minSubArrayLen(int target,int[] nums){
    int sum=0;
    int left=0;
    int minLength=Integer.MAX_VALUE;
    for(int right=0;right<nums.length;right++){
      sum=sum+nums[right];
      while (left <=right && sum >=target){
        minLength=Math.min(minLength,right-left+1);
        sum=sum-nums[left++];
      }
    }
    return minLength== Integer.MAX_VALUE?0:minLength;
  }
}
