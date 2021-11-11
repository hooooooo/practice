class Solution {
    public int minStartValue(int[] nums) {
        int min = 0;
        int sum = 0;
        for(int n : nums){
            sum += n;
            min = Math.min(min, sum);
        }
        return Math.max(1, 1 - min);
    }
}
