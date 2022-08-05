import java.util.Arrays;

public class Sort {
    public static void main(String[] args){
        int[] arr= {5,4,3,2,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    static void selectionSort(int[] arr){
        int max;
        for(int i=0;i<arr.length;i++){
            max=0;
            for(int j=0;j<=arr.length-i-1;j++){
                if(arr[max]<arr[j]){
                    max=j;
                }
            }
            int temp=arr[max];
            arr[max]=arr[arr.length-i-1];
            arr[arr.length-i-1]=temp;
        }
    }
    static void bubbleSort(int[] arr){
        boolean swap=false;
        for(int i=0;i<arr.length;i++){
            swap=false;
            for (int j=1;j<arr.length-i;j++){
                if(arr[j]<arr[j-1]){
                    int temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                    swap=true;
                }
            }
            if(!swap)
                break;
        }
    }
    static void insertionSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }else {
                    break;
                }
            }
        }
    }
    static void cyclicSort(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct= arr[i]-1;
            if(arr[correct]!=arr[i]){
                int temp=arr[correct];
                arr[correct]=arr[i];
                arr[i]=temp;
            }else{
                i++;
            }
        }
    }
    static int[] mergeSort(int[] arr){
        if (arr.length==1){
            return arr;
        }
        int mid = arr.length/2;
        int[] left=mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right=mergeSort(Arrays.copyOfRange(arr,mid+1,arr.length));

        return merge(left,right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] mix=new int[first.length+second.length];
        int i=0;int j=0;int k=0;
        while(i < first.length && j< second.length){
            if(first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
            }
        while (i<first.length){
            mix[k]=first[j];
            j++;
            k++;
        }
        while (j<second.length){
            mix[k]=second[j];
            j++;
            k++;
        }
        return mix;
    }
    static void quickSort(int[] nums,int lo,int hi ){
        if(lo>=hi){
            return;
        }
        int s=lo;
        int e=hi;
        int m=s+(e-s)/2;
        int pivot = nums[m];

        while(s<=e) {
            while (nums[s] < pivot) {
                s++;
            }
            while (nums[e] > pivot) {
                e--;
            }
            if (s <=e ) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }
        quickSort(nums,lo,e);
        quickSort(nums,s,hi);

    }
}
