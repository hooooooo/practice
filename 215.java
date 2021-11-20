class Solution {
    
    private void swap(int[] nums, int l, int r){
        if(l == r){
            return;
        }
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
    private int partition(int[] nums, int k, int l, int r){
        int s = nums[k-1];
        swap(nums, k-1, r);
        int index = l;
        for(int i = l; i< r; i++){
            if(nums[i] >= s){
                swap(nums, i, index++);
            }
        }
        swap(nums, r, index);
        return index;
    }
    
    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length  - 1;
        while(true){
            int index = partition(nums, k, l, r);
            if(index == k - 1){
                return nums[index];
            }
            if(index > k - 1){
                r = index - 1;
            } else {
                l = index + 1;
            }
        }
        
    }
}
