package class01;

import java.util.Scanner;
//牛客已测试 正确 感觉左的代码有错
public class Code04_ColorLeftRight {
    //爱奇艺笔试题 红和绿 牛客
    // RGRGR -> RRRGG
    //求左侧G的数量和右侧R的数量
    public static int minPaint(String s) {
        if(s == null || s.length() < 2){
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int rAll = 0;
        for(int i = 0;i < N;i++){
            rAll += str[i] == 'R'? 1:0;
        }
        int ans = rAll;
        int left = 0;
        for(int i = 0;i < N;i++){
            rAll -= str[i] == 'R'?1:0;
            left += str[i] == 'G'?1:0;
            ans = Math.min(ans,left+rAll);
        }

        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(minPaint(s));
    }
}
