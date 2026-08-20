class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        int last1= nums[0];
        arr2.add(nums[1]);
        int last2 = nums[1];
        int [] result = new int [n];
        for(int i=2; i<n; i++){
            if(last1>last2){
                arr1.add(nums[i]);
                last1 = nums[i];
            }
            else if(last1<last2){
                arr2.add(nums[i]);
                last2 = nums[i];
            }
        }
        Integer[] array1 = arr1.toArray(new Integer[0]);
        Integer[] array2 = arr2.toArray(new Integer[0]);
        for(int i=0; i<array1.length; i++){
            result[i]= array1[i];
        }
        for(int i=0; i<array2.length; i++){
            result[i+array1.length] = array2[i];
        }
        return result;
    }
}