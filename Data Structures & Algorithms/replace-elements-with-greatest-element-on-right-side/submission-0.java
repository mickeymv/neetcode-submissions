class Solution {
    public int[] replaceElements(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            int greater = arr[i+1];
            arr[i]=greater;
            for(int j=i+1;j<arr.length;j++) {
                if(arr[j]>greater) {
                    greater = arr[j];
                    arr[i]=greater;
                }
            }
        }
        arr[arr.length-1]=-1;
        return arr;
    }
}