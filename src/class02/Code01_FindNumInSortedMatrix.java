package class02;
//一行一行对过 正确
public class Code01_FindNumInSortedMatrix {
    public static boolean isContains(int[][] matrix,int K){
        int row = 0;
        int col = matrix[0].length-1;
        while(row < matrix.length && col >=0){
            if(matrix[row][col] == K){
                return true;
            }else if(matrix[row][col] > K){
                col--;
            }else {
                row++;
            }
        }
        return false;
    }
}
