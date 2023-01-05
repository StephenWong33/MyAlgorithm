package com.wang33.algorighm.Chapter1int;

/***
 *  @author wangyashuai
 *  @date 2023/1/5 下午3:23
 *
 */
public class SignalNumber {

  /**
   * 题目 ： 输入一个整数数组，数组中只要一个数字出现了一次，而其他数字都出现了3次，请找到只出现了一次的数字， 例如输入的数字是 [0,1,0,1,0,1,100],则只出现一次的数字是100
   * <p>
   * 思路： 利用二进制计算，每位相加之后再对出现次数取余，然后再相加， 注意二进制位次
   * 空间复杂度比较低，没有占用额外的空间
   */

  public int signalNumber(int[] nums) {
    // 有一个数组保存相加之和
    // 对相加之和再取余
    int[] bitSum = new int[32];
    for (int num : nums) {
      for (int i = 0; i < 32; i++) {
        bitSum[i] += (num >> (31 - i)) & 1;
      }
    }
    int result = 0;
    for (int i : bitSum) {
      result = (result << 1) + i % 3;
    }
    return result;
  }


}
