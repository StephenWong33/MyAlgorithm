package com.wang33.algorighm.Chatper2Array;

import java.util.HashMap;

/***
 *  @author wangyashuai
 *  @date 2023/1/30 上午9:01
 *
 */
public class l10SubarraySum {

  /**
   * 给定一个整数数组和一个整数k，请找到该数组中和为k的连续子数组的个数
   *
   *
   * 解析
   * 1 不可以使用双指针，因为双指针的使用是有条件的，必须正整数才可以使用，因为两个指针确定一个子数组，向右移动左指针，子数组变小，和变小，
   * 向右移动右指针，子数组变大，和变大，
   * 2 暴力解法，长度为n的子数组中，有n2个子数组，求数组之和为O(n),总体时间复杂度为O(n3)
   * 3 预处理方法，遍历数组，如果数组的下标为i，那么下标和为Si，下标j，从0到j的子数组之和为Sj，那么i到j之间的子数组之和为 S(i-j)
   *  变种，如果求和为k的子数组，那么从0到i的子数组之和为sum，求和为 sum-k 的子数组的个数即可
   *  可以使用哈希表来存储，key为sum-k的值，value为sum-k的个数
   */
  public static void main(String[] args) {
    int[] nums = {1,1,1};
    int k=2;
    int i = subarraySum(nums, k);
    System.out.println(i);
  }


  public static int subarraySum(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    map.put(0,1);
    int count=0;
    int sum=0;
    for (int num : nums) {
      sum=sum+num;
      count = count+ map.getOrDefault(sum-k,0);
      map.put(sum,map.getOrDefault(sum,0)+1);
    }
    return count;
  }




}
