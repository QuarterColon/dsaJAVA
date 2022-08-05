public class SearchInMountain {
    public static void main(String[] args) {

    }
    static int search(int[] arr, int target){
        int peak=peakIndexInMountainArray(arr);
        int firstTry= orderAgnostic(arr,target,0,peak);
        if(firstTry!= -1)
            return firstTry;
        return orderAgnostic(arr,target,peak+1,arr.length-1);
    }
    static int orderAgnostic(int[] arr,int target,int start,int end){

        boolean isAsc=false;
        if(arr[start]<arr[end]){
            isAsc=true;
        }
        while(start<end){
            int mid=start+(start-end)/2;
            if(arr[mid]==target){
                return mid;
            }
            if (isAsc){
                if(arr[mid]<target){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
            else{
                if(arr[mid]<target){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
        }
        return -1;
    }
    public static int peakIndexInMountainArray(int[] arr) {
        int start =0;
        int end=arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }
}
