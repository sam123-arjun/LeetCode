class Solution {
    public int findDuplicate(int[] arr) {
        int i = 0;

        while(i < arr.length){
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                swap(arr,i,correct);
            }
            else if (i != correct) {
                    return arr[i];
                

            }
            else{
                i++;
            }
        }

        for(int index = 0; index < arr.length; index++){
            if(arr[index] != index+1){
                return index+1;
            }
            
        }


        return -1;
        
    }

    void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}