package com.wang33.algorighm.Chatper2Array;

/***
 *  @author wangyashuai
 *  @date 2023/1/30 上午10:40
 *
 */
public class l13sumRegion {

  /**
   * 二维子矩阵之和： 从(r1,c1)到(r2,c2) 之间的子数组之和
   *
   * 解析：
   * 暴力解法，遍历二维数组，时间复杂度是O(mn)
   * 可以分成4块，用加法替代，
   * sum(r2,c2)-sum(r1-1,c2)-sum(r2-1,c1)+sum(r1,c1)
   *
   * 其中每块的之和等于sum(i-1,j) + rowSum
   */
  int[][] sums;
  public l13sumRegion(int[][] matrix) {
    if(matrix.length == 0  || matrix[0].length == 0){
      return;
    }
    sums = new int[matrix.length+1][matrix[0].length+1];
    for(int i=0;i<matrix.length;i++){
      int rowSum=0;
      for(int j=0;j<matrix[i].length;j++){
        rowSum=rowSum+matrix[i][j];
        sums[i+1][j+1] = sums[i][j+1]+rowSum;
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return sums[row2+1][col2+1] -sums[row1][col2+1] - sums[row2+1][col1] + sums[row1][col1];
  }



}
