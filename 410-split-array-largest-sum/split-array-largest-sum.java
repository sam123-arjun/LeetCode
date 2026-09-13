class Solution {
    public int splitArray(int[] nums, int k) {
              int start = 0;
        int end = 0;

        for(int i=0; i < nums.length; i++){
            start = Math.max(start,nums[i]);
            end += nums[i];  
        }

        // binary search
        while(start < end){
            // try for the middle for potential ans
            int mid = start + (end - start)/2;

            // claculate how many piceces you can divide these max sum
            int sum = 0;
            int pices = 1;
            for(int num : nums){
                if(sum + num > mid){
                    // you cannot this in this subarray , make new one
                    // say you add this num in new subarray, then sum = num
                     sum = num;
                     pices++;
                }else{
                    sum += num;

                }
            }

            if(pices > k){
                start = mid +1;

            }else{
                end = mid;

            }

        }

        return end; // here start == end
        
    }
}