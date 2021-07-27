package class02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//三数之和 leetcode测试正确
public class Code06_PrintUniquePairAndTriad {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listSum = new LinkedList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0;i < n-2;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            int left = i+1;
            int right = n-1;
            collection(nums,i,left,right,listSum);
        }
        return listSum;
    }
    public void collection(int[] nums,int i,int left,int right,List<List<Integer>> listSum ){
        int init = left;
        while(left < right){
            if(nums[left]+nums[right]+nums[i]== 0){
                if(!(left > init && nums[left] == nums[left-1])){
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    listSum.add(new LinkedList<Integer>(list));
                }
                left++;
                right--;
            }else if(nums[left]+nums[right]+nums[i]> 0){
                right--;
            }else if(nums[left]+nums[right]+nums[i]< 0){
                left++;
            }
        }
    }
}
