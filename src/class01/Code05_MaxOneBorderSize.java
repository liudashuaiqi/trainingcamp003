package class01;

import java.util.Scanner;
//牛客已经测试正确
//边界都是1的最大正方形大小
public class Code05_MaxOneBorderSize {
    public static void setBorderMap(int[][] m,int[][] right,int[][] down){
        int N = m.length;
        int M = m[0].length;
        //生成down数组
        for(int j = 0;j < M;j++){
            down[N-1][j] = m[N-1][j];
        }
        for(int i = N-2; i >=0 ;i--){
            for(int j = 0;j < M;j++){
                down[i][j] = m[i][j] == 0? 0: down[i+1][j]+1;
            }
        }
        //生成right数组
        for(int i = 0;i < N;i++){
            right[i][M-1] = m[i][M-1];
        }
        for(int j = M-2;j>=0;j--){
            for(int i = 0;i < N;i++){
                right[i][j] = m[i][j] == 0? 0:right[i][j+1]+1;
            }
        }

    }
    public static int getMaxSize(int[][] m){
        int N = m.length;
        int M = m[0].length;
        int[][] right = new int[m.length][m[0].length];
        int[][] down = new int[m.length][m[0].length];

        setBorderMap(m,right,down);

        for(int size= Math.min(N,M);size>=1;size--){
            if(hasSizeOfBorder(m,size,right,down)){
                return size;
            }
        }
        return 0;
    }
    public static boolean hasSizeOfBorder(int[][] m,int size,int[][] right,int[][] down){
        int N = m.length;
        int M = m[0].length;

        for(int i = 0;i < M-size-1;i++){
            for(int j = 0;j < N-size-1;j++){
                if(right[i][j] >= size&& right[i+size-1][j] >= size &&
                        down[i][j+size-1] >=size&& down[i][j] >= size){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] m = new int[n][n];
        for(int i = 0;i < n;i++){
            for(int j=0;j < n;j++){
                m[i][j] = sc.nextInt();
            }
        }
        System.out.println(getMaxSize(m));
    }
}
