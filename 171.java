class Solution {
    public int titleToNumber(String columnTitle) {
        char[] arr = columnTitle.toCharArray();
        int weight = 1;
        int result = 0;
        for(int i = arr.length - 1; i >= 0; i--){
            int value =  1 + (arr[i] - 'A');
            result += value * weight;
            weight *= 26;
        }
        return result;
    }
}
