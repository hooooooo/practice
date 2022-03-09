class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        char arr[] = s.toCharArray();
        int size = arr.length;
        int index = 0;
        // left to right
        int count = 0;
        for(int i = 0; i<size; i++){
            if(arr[i] == '(') {
                count++;   
                arr[index++] = arr[i];
            } else if(arr[i] == ')') {
                if(count > 0){
                    count--;
                    arr[index++] = arr[i];
                }
            } else {
                arr[index++] = arr[i];
            }
        }
        
        size = index;
        index = size - 1;
        count = 0;
        for(int i = size - 1; i>= 0; i--){
            if(arr[i] == ')') {
                count++;   
                arr[index--] = arr[i];
            } else if(arr[i] == '(') {
                if(count > 0){
                    count--;
                    arr[index--] = arr[i];
                }
            } else {
                arr[index--] = arr[i];
            }
        }
        
        for(int i = index+1; i<= size -1; i++){
            sb.append(arr[i]);
        }
        return sb.toString();
        
    }
}
