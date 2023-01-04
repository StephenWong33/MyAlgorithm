package com.wang33.algorighm.Chapter1int;

/***
 *  @author wangyashuai
 *  @date 2023/1/4 下午8:14
 *
 */
public class IntegerDivide {
  /**
   * 题目：面试题1 整数除法
   * 输入两个int类型整数，他们进行除法计算并返回商，要求不得使用乘号 * 、除号/以及取余号，当发生溢出时 返回最大的整数值，假设除数不为0，
   * 例如输入15和2，输出15/2的结果，即7
   * 算法解析
   *  题目要求不得使用乘除计算，可以使用减法实现除法，例如，15/2，15每次减去2，减去7个2后，余数是1 ，因此15/2的商是7
   *  但是有一个问题，如果被除数很大，但是除数很小，例如 2的31次方/1 需要 执行2的31次方次，时间复杂度是O(n),需要进行优化
   *  优化
   *  将上面的算法稍作调整，当被除数大于除数，则判断被除数是否大于除数的2倍，如果是，则判断是否大于除数的4倍，8倍等，被除数最多大于除数的2的k次方倍
   *  将被除数-除数的2的k次方倍，然后将剩余的被除数重复上述步骤，时间复杂度是O(logN)
   *  上面的讨论都假设 除数和被除数都是正数，如果有负号，可以先调整为正数，然后再进行运算，最后再调整商的正负号
   *  将负数转化为整数，存在溢出的问题，负数的最大值为2的-31次方，整数的最大值为2的，因为负数的最大值不能转化为正数，所以需要全部转化为负数进行计算
   *  最后只有一种情况会导致溢出，(2的-31次方)/(-1)
   *
   *  重点
   *  1. 优化算法的复杂度 从O(n)优化到O(logn)
   *  2. 考虑正负号
   *  3. 数据溢出情况
   */

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    int divide = divide(-2147483648, 1);
    long end = System.currentTimeMillis();
    System.out.println(end-start );
    System.out.println(divide);
  }

  public static int divide(int dividend,int divisor){

    // 处理整数溢出情况
    if(dividend == Integer.MIN_VALUE && divisor == -1){
      return  Integer.MAX_VALUE;
    }
    int negative =0;
    if(dividend > 0){
      dividend=-dividend;
      negative+=1;
    }
    if(divisor > 0){
      divisor=-divisor;
      negative +=1;
    }
    // 将除数和被除数转化为正数
    int result = divideCore(dividend,divisor);
    // 修改符号
    return negative == 1 ? -result : result;
  }

  private static int divideCore(int dividend,int divisor){
    int result =0;
    while (dividend <= divisor){
      int value = divisor;
      int quotient = 1;
      // 模拟除法
      while (dividend <= value+value && value >= Integer.MIN_VALUE>>1){
        quotient+=quotient;
        value+=value;
      }
      result+=quotient;
      dividend -=value;
    }
    return result;
  }

}
