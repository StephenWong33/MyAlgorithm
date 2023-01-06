package com.wang33.algorighm.Chatper2Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/***
 *  @author wangyashuai
 *  @date 2023/1/6 下午5:14
 *
 */
public class l2ThreeSum {

  /***
   * 题目：输入一个数组，如何找到数组中所有和为0的3个数字的三元组，返回的值中不得包含重复的三元组，
   *
   * 解析
   * 1 题目中没有说明数组是有序的，因此不能直接使用双指针
   * 2 3个数字之和，可以先固定一个数字，求其他两个数字之和
   * 3 要求不能有重复解，需要剔除重读的数字
   */
  public List<List<Integer>> threeSum(int[] nums) {
    LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
    if (nums.length >= 3) {
      Arrays.sort(nums);
      int i = 0;
      while (i < nums.length - 2) {
        twoSum(i, nums, result);
        // 去掉重复的结果
        int tmp = nums[i];
        while ( i < nums.length && tmp == nums[i] ) {
          i++;
        }
      }
    }
    return result;
  }

  // 两数之和
  private void twoSum(int i, int[] nums, List<List<Integer>> result) {
    int j=i+1;
    int k =nums.length-1;
    while (j<k){
      if(nums[i]+nums[j]+nums[k]==0){
        result.add(Arrays.asList(nums[i],nums[j],nums[k]));
        // 去掉重复的结果
        int tmp = nums[j];
        while (j<k && nums[j] == tmp){
          j++;
        }
      }else if(nums[i]+nums[j]+nums[k]>0){
        k--;
      }else {
        j++;
      }
    }
  }


}
