class Solution {
    public int arraySign(int[] nums) {
        int countOfMinus = 0;
        for(int i : nums){
            if(i == 0){
                return 0;
            }
            if(i < 0){
                countOfMinus++;
            }
        }   
        return (countOfMinus % 2) == 0 ? 1 : -1;
    }
}
