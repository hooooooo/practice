class Solution {
    private static final int A = 0;
    private static final int B = 1;
    private static final int C = 2;
    
    void swap(int [] arr, int l, int r){
        int t1 = arr[l];
        int t2 = arr[l+1];
        arr[l] = arr[r];
        arr[l+1] = arr[r + 1];
        arr[r] = t1;
        arr[r+1] = t2;
    }
    char getChar(int i){
        if(i == A) {
            return 'a';
        }
        if(i == B) {
            return 'b';
        }
        return 'c';
        
    }
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[]{a, A, b, B, c, C};
        if(arr[0] < arr[2]){
            swap(arr, 0, 2);
        }
        if(arr[0] < arr[4]){
            swap(arr, 0, 4);
        }
        if(arr[2] < arr[4]){
            swap(arr, 2, 4);
        }
        
        // compute holes
        int num_holes = (arr[0]  + 1) / 2;
        
        int hole_size = (arr[2] + arr[4]) / num_holes;
        
        int reminder_count = (arr[2] + arr[4]) % num_holes;
        
        // now arrange
        for(int i = 0; i<num_holes; i++){
            // fill in longest
            int num_a = Math.min(arr[0], 2);
            for(int k = 0; k<num_a; k++){
                sb.append(getChar(arr[1]));
            }
            arr[0] -= num_a;
            
            // fill the hole
            int size = hole_size;
            if(reminder_count-- > 0){
                size ++;
            }
            
            if(arr[2] == 0 && arr[4] == 0){
                break;
            }
            
            // pick from which ever possible
            for(int k = 0; k<size; k++){
                if(arr[2] > 0 && (k % 2 == 0 || arr[4] == 0)){ // take from 2nd
                     sb.append(getChar(arr[3]));
                     arr[2]--;
                } else {
                     sb.append(getChar(arr[5]));
                     arr[4]--;
                }
            }
            
        }
        
        // remove tail
        int i = sb.length() - 3;
        int remove = 0;
        for(;i>=0; i--){
            if(sb.charAt(i) != sb.charAt(i+1) || sb.charAt(i) != sb.charAt(i+2)){
                break;
            }
            remove++;
        }
        
        sb.setLength(sb.length() - remove);        
        return sb.toString();
        
    }
}
