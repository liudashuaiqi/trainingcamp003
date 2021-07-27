package class01;
//其他部分一行一行代码对过 正确
public class Code03_ParenthesesDeep {
    //判断括号字符串是否有效
    public static boolean isValid(char[] str) {
        if(str == null || str.length ==0){
            return false;
        }
        int count = 0;
        for(int i = 0;i < str.length;i++){
            if(str[i] != '(' &&str[i] !=')'){
                return false;
            }
            count += str[i] =='('? 1:-1;
            if(count < 0){
                return false;
            }
        }
        return count == 0;
    }
    //括号的最大嵌套深度
    public static int deep(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] str = s.toCharArray();
        if(!isValid(str)){
            return 0;
        }
        int maxDeep = 0;
        int count = 0;
        for(int i = 0;i < str.length;i++){
            if(str[i] == '('){
                maxDeep = Math.max(maxDeep,++count);
            }else if(str[i] == ')'){
                count--;
            }
        }
        return maxDeep;
    }
    //leetcode 测试正确
    public static int maxLength(String s) {
        if(s == null || s.length() < 2){
            return 0;
        }
        char[] str = s.toCharArray();
        int[] dp = new int[s.length()];
        int pre = 0;
        int ans = 0;
        for(int i = 1;i < s.length();i++){
            if(str[i] == ')'){
                pre = i - dp[i-1] -1;
                if(pre >= 0 && str[pre] == '('){
                    dp[i] = dp[i-1] + 2 + (pre-1 >= 0 ? dp[pre-1] : 0);//左这里没加括号 交了半天都是wa
                }
            }
            ans = Math.max(ans,dp[i]);
        }

        return ans;
    }
    public static void main(String[] args){

        System.out.println(maxLength("(()"));

        String test = "((()))";
        System.out.println(deep(test));
    }
}
