package class01;
//一行行对过 正确
public class Code07_MaxSumInTree {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int v){
            value = v;
        }
    }
    //从头到叶,最大路径和
    public static int process2(Node x){
        if(x.left == null && x.right == null){
            return x.value;
        }

        int next = Integer.MIN_VALUE;
        if(x.left != null){
            next = process2(x.left);
        }
        if(x.right != null){
            next = Math.max(next,process2(x.right));
        }
        return x.value+next;
    }

    //任意节点到任意节点。只能往下，最大路径和
    public static int maxSum2(Node head){
        if(head == null){
            return 0;
        }
        return f2(head).allTreeMaxSum;
    }
    public static class Info{
        public int allTreeMaxSum;
        public int fromHeadMaxSum;
        public Info(int all, int from){
            allTreeMaxSum = all;
            fromHeadMaxSum = from;
        }
    }
    public static Info f2(Node x){
        if(x == null){
            return null;
        }
        Info left = f2(x.left);
        Info right = f2(x.right);

        int p1 = Integer.MIN_VALUE;
        if(left != null){
            p1 = left.allTreeMaxSum;
        }
        int p2 = Integer.MIN_VALUE;
        if(right != null){
            p2 = right.allTreeMaxSum;
        }
        int p3 = x.value;
        int p4 = Integer.MIN_VALUE;
        if(left != null){
            p4 = left.fromHeadMaxSum + x.value;
        }
        int p5 = Integer.MIN_VALUE;
        if(right != null){
            p5 = right.fromHeadMaxSum + x.value;
        }
        int allTreeMaxSum = Math.max(Math.max(p1,Math.max(p2,p3)),Math.max(p4,p5));
        int fromHeadMaxSum = Math.max(p3,Math.max(p4,p5));
        return new Info(allTreeMaxSum,fromHeadMaxSum);
    }

    //从任意节点出发 到任意节点的最大路径和
    public static Info f3(Node x){
        if(x == null){
            return null;
        }
        Info left = f3(x.left);
        Info right = f3(x.right);

        int p1 = Integer.MIN_VALUE;
        if(left != null){
            p1 = left.allTreeMaxSum;
        }
        int p2 = Integer.MIN_VALUE;
        if(right != null){
            p2 = right.allTreeMaxSum;
        }
        int p3 = x.value;
        int p4 = Integer.MIN_VALUE;
        if(left != null){
            p4 = left.fromHeadMaxSum + x.value;
        }
        int p5 = Integer.MIN_VALUE;
        if(right != null){
            p5 = right.fromHeadMaxSum + x.value;
        }
        int p6 = Integer.MIN_VALUE;
        if(left != null && right != null){
            p6 = left.fromHeadMaxSum + right.fromHeadMaxSum + x.value;
        }
        int allTreeMaxSum = Math.max(Math.max(p1,Math.max(p2,p3)),Math.max(Math.max(p4,p5),p6));
        int fromHeadMaxSum = Math.max(p3,Math.max(p4,p5));
        return new Info(allTreeMaxSum,fromHeadMaxSum);
    }

    //从任意节点出发 到叶子节点 最大路径和
    public static int max = Integer.MIN_VALUE;
    public static int bigShuai(Node head){
        if(head.left== null && head .right == null){
            max = Math.max(max,head.value);
        }
        int nextMax = Integer.MIN_VALUE;
        if(head.left != null){
            nextMax = bigShuai(head.left);

        }
        if(head.right != null ){
            nextMax = Math.max(nextMax,bigShuai(head.right));
        }
        int ans = head.value + nextMax;
        max = Math.max(max,ans);
        return ans;
    }
}
