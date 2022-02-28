class Solution {
    
    
    boolean findDupColor(char[] arr, int startIndex, int[] idx){
        int dupIndex = -1;
        for(int i = startIndex + 1; i<arr.length; i++){
            if(arr[i - 1] == arr[i]){
                if(dupIndex == -1){
                    dupIndex = i - 1;
                    idx[0] = dupIndex;
                }
            } else if(dupIndex > -1 && arr[i] != arr[dupIndex]){
                idx[1] = i-1;
                return true;
            } else if(dupIndex > -1 && i == arr.length -1){
                idx[1] = i;
                return true;
            }
        }
        idx[1] = arr.length -1;
        return dupIndex > -1;        
    }
    
    public int minCost(String colors, int[] neededTime) {
        int startIndex = 0;
        int[] idx = new int[3];
        idx[1] = -1;
        char[] arr = colors.toCharArray();
        int result = 0;
        while(startIndex < arr.length){
            boolean found = findDupColor(arr, startIndex, idx);
            if(found){
                int max = neededTime[idx[0]];
                int indexToSkip = idx[0];
                for(int i = idx[0]; i<= idx[1]; i++){
                    if(neededTime[i] > max){
                        max = neededTime[i];
                        indexToSkip = i;
                    }
                }
                 for(int i = idx[0]; i<= idx[1]; i++){
                    if(i == indexToSkip){
                       continue;
                    }
                    result += neededTime[i];
                }
            }
            startIndex = idx[1] + 1;
        }
        return result;
        
    }
}
