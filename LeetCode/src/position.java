public class position {
    public static void main(String[] args){

    }
    public static int[] searchRange(int[] nums, int target) {
        int[] arr={-1,-1};
        int start=search(nums,target,true);
        int end=search(nums,target,false);
        arr[0]=start;
        arr[1]=end;
        return arr;
    }
    static int search(int[] nums,int target,boolean index){
        int start=0,ans=-1;
        int end=nums.length-1;

        while(start<=end) {


            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            }
            else if (nums[mid] > target) {
                end = mid - 1;
            }
            else {
                ans=mid;
                if(index) {
                    end = mid - 1;
                }
                else{
                    start=mid+1;
                }
            }
        }
        return ans;
    }
}
