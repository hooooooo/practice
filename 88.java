class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // copy m to back
        for(int i = m - 1; i>=0; i--){
            nums1[n + i] = nums1[i];
        }
        
        int mIndex = n;
        int nIndex = 0;
        for(int i = 0; i<m+n; i++){
            if(mIndex == m + n){
                nums1[i] = nums2[nIndex++];
            } else if(nIndex == n){
                nums1[i] = nums1[mIndex++];
            } else {
             if(nums1[mIndex] < nums2[nIndex]){
                  nums1[i] = nums1[mIndex++];
             }  else {
                  nums1[i] = nums2[nIndex++];
             }                
          }            
        }        
    }
}
