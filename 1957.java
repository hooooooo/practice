class Solution {
    public String makeFancyString(String s) {
        char[] arr = s.toCharArray();
        char[] result = new char[arr.length];
        if(arr.length < 3){
            return s;
        }
        char[]last = new char[2];
        result[0] = last[0] = arr[0];
        result[1] = last[1] = arr[1];
        int index = 2;
        for(int i = 2; i<arr.length; i++){
            if(result[index - 1] == result[index - 2] && result[index - 1] == arr[i]){
                continue;
            }
            result[index++] = arr[i];
        }
        return new String(result, 0, index);
    }
}
