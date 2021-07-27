package class01;
//一行一行代码对过 正确
public class Code02_NeedParentheses {
    public static boolean valid(String s) {
        char[] str = s.toCharArray();
        int count = 0;
        for(int i = 0;i < str.length;i++){
            count += str[i] == '('? 1:-1;
            if(count < 0){
                return false;
            }
        }
        return count == 0;
    }
    //跟左的写法不太一样
    public static int needParentheses(String s) {
        char[] str = s.toCharArray();
        int count = 0;
        int need = 0;
        for(int i= 0;i < str.length;i++){
            if(str[i] == '('){
                count++;
            }else if(str[i] == ')'){
                count--;
            }
            if(count < 0){
                need++;
                count = 0;
            }
        }
        return count + need;
    }
}
