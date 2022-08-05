public class BS {
    public static void main(String[] args) {

    }
    static int orderAgnostic(int[] arr,int target){
        int start=0;int end=arr.length-1;
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
    static int BSrecursion(int arr[],int target,int s,int e){
        int m=s+(e-s)/2;
        if(arr[m]== target){
            return m;
        }
        if(s>e){
            return -1;
        }


        if(arr[m]<target){
            return BSrecursion(arr,target,m+1,e);
        }

        return BSrecursion(arr,target,s,m-1);

    }
}
