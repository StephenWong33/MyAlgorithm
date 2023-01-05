package com.wang33.algorighm.Chapter1int;

/***
 *  @author wangyashuai
 *  @date 2023/1/5 上午10:56
 *
 */
public class AddBinary {

/**
 * 题目： 输入两个表示二进制的字符串，请计算他们的和，并以二进制字符串的形式输出，例如，输入的两个二进制字符串分别是11和10，则输出101
 *
 * 1 不可以转化成整数类型 包括int long等，因为题目中没有限制位数，可能会溢出
 * 2. 考察二进制的加法
 * 3. 相加完成后，对结果要进行反转
 */
  public String addBinary(String a,String b){
    StringBuffer result = new StringBuffer();
    int i = a.length() - 1;
    int j =b.length() - 1;
    int carry = 0;
    while (i>=0 || j >=0){
      int digitA = i >=0 ? a.charAt(i--) - '0' :0;
      int digitB = j>=0 ? b.charAt(j--) - '0' : 0;
      int sum = digitA + digitB + carry;
      carry = sum >=2 ? 1 : 0;
      sum = sum >=2 ? sum-2:sum;
      result.append(sum);
    }
    if(carry == 1) result.append(1);
    return result.reverse().toString();
  }
}
