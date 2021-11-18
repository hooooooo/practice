class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null){
            return result;
        }
        int[] arr = new int[nums.length+1];
        for(int n : nums){
            arr[n-1] = 1;
        }
        for(int i = 0; i<nums.length; i++){
            if(arr[i] == 0){
                result.add(i+1);
            }
        }
        return result;
    }
}
