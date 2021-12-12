class Solution {
    public int fixedPoint(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int index = -1;
        while(l <= r){
            int m = l + (r-l) / 2;
            if(arr[m] == m){
                index = m;
                break;
            }
            if(arr[m] > m){
                r = m -1;
            } else {
                l = m + 1;
            }
        }
        
        while(index > 0 && arr[index-1] == index -1){
            index --;
        }
        
        return index;
    }
}
