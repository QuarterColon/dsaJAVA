public class BinarySearch {
    public static void main(String[] args) {

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
