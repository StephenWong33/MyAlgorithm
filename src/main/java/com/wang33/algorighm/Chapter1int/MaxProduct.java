package com.wang33.algorighm.Chapter1int;

/***
 *  @author wangyashuai
 *  @date 2023/1/5 下午4:20
 *
 */
public class MaxProduct {

  /***
   * 题目： 输入一个字符串数组words，请计算不包含相同字符的两个字符串words[i]和words[j]的长度乘积的最大值
   *假设字符串中只包含小写字母，如果没有不包含相同字符串的一对字符串，返回0，
   *
   *  解析
   *  判断两个字符串 是否含所有相同的字符，可以使用双重循环，暴力解法，但是，时间复杂度比较高
   *  优化1 可以使用哈希表记录26个字母是否出现，如果出现则为true，如果没有出现则为fasle，判断是否有相同字符进行与运算
   *  优化2 字母一共26个，一个int是32位，可以使用一个int表示每一位的true或者false，并且，两个整数进行与运算不为0，则表示不存在相同字符，
   *  比循环26次，效率要高一些
   */
  public int maxProduct1(String[] words) {
    // 将words 放入boolean数组中标记，
    boolean[][] flags = new boolean[words.length ][26];
    for (int i = 0; i < words.length ; i++) {
      for (char ch : words[i].toCharArray()) {
        flags[i][ch - 'a'] = true;
      }
    }
    // 三重循环进行判断，是否存在相同的数组
    int result = 0;
    for (int i = 0; i < words.length ; i++) {
      for (int j = i + 1; j < words.length ; j++) {
        int k = 0;
        for (; k < 26; k++) {
          if (flags[i][k] && flags[j][k]) {
            break;
          }
        }
        if (k == 26) {
          int prod = words[i].length() * words[j].length();
          result = Math.max(result, prod);
        }
      }
    }
    return result;
  }


  public int maxProduct2(String[] words) {
    int[] flags = new int[words.length];
    for (int i = 0; i < words.length ; i++) {
      for (char ch : words[i].toCharArray()) {
        flags[i] |= 1 << (ch - 'a');
      }
    }
    int result = 0;
    for (int i = 0; i < words.length; i++) {
      for (int j = i + 1; j < words.length; j++) {
        if ((flags[i] & flags[j]) == 0) {
          int prod = words[i].length() * words[j].length();
          result = Math.max(prod, result);
        }
      }
    }
    return result;
  }


}
