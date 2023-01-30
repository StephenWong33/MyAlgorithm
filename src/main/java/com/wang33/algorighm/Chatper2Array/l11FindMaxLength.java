package com.wang33.algorighm.Chatper2Array;

import java.util.HashMap;

/***
 *  @author wangyashuai
 *  @date 2023/1/30 上午9:52
 *
 */
public class l11FindMaxLength {
  /***
   * 给定一个二进制数组nums，找到含有相同数量的0和1的最长连续子数组，并返回该子数组的长度
   *  解析
   *  如果把0变成-1，那么相同个数的0和1的子数组之和为0，
   *  前i个子数组之和为sum，前j个子数组之和也为sum，那么j-i之间的子数组之间的0和1的个数相同，
   *
   *  可以使用哈希表来记录，求最长子数组的长度，所以 key为子数组之和，value为第一个出现的下标。
   */

  public static void main(String[] args) {
    int[] nums = {0,1};

    int maxLength = findMaxLength(nums);
    System.out.println(maxLength);
  }

  public static int findMaxLength(int[] nums) {

    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0,-1);//便于下标相减

    int maxLength=0;
    int sum=0;
    for(int i=0;i<nums.length;i++){
      sum=sum+(nums[i] == 0 ? -1 : 1);
      if(map.containsKey(sum)){
        maxLength = Math.max(maxLength,i-map.get(sum));
      }else {
        map.put(sum,i);
      }
    }
    return maxLength;
  }




}
