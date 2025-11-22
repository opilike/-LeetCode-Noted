class Solution {
    public int largestPerimeter(int[] nums) {
      // 先排列好，由小到大  
      Arrays.sort(nums);   // 跟 java.util.Array.sort(nums) 一樣
        int l = 0;
        // 抓最長邊開始做，從nums.length-1開始做，注意i>=2才能檢查三個邊!
       // 接著判斷三角形的狀況。
        for (int i=nums.length-1; i>=2; i--){
            if(nums[i-2]+nums[i-1] > nums[i]){
                l = nums[i-2] + nums[i-1] + nums[i];
                break;
            }
        }return l;
    }
}
