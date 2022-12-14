public class RBS {
    public static void main(String[] args) {

    }
    static int search (int[] nums,int target){
        int pivot= findPivot(nums);
        if(pivot== -1){
            return binarySearch(nums,target,0,nums.length-1);
        }
        if(nums[pivot] == target){
            return pivot;
        }
        if(target>=nums[0]){
            return binarySearch(nums,target,0,pivot-1);
        }
        else{
            return binarySearch(nums,target,pivot+1,nums.length-1);
        }
    }
    static int findPivot(int[] arr){
        int start=0;
        int end=arr.length;
        while(start<=end){
            int mid=start+(end-start)/2;
            if (mid<end && arr[mid]>arr[mid+1]) {
                return mid;
            }
            if (mid>start && arr[mid]<arr[mid-1]){
                return mid-1;
            }
           if(arr[mid]==arr[start] && arr[mid]==arr[end]){
               if(arr[start+1]<arr[start]){
                   return start;
               }
               start++;
               if(arr[end-1]>arr[end]){
                   return end-1 ;
               }
               end--;
           }
           else if(arr[mid]>arr[start] || arr[start]==arr[mid] && arr[end]<arr[mid]) {
               start = mid + 1;
           }
               else {
                   end=mid-1;
               }
           }

        return -1;
    }
    static int binarySearch(int arr[],int target,int start, int end){
        while (start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
}
