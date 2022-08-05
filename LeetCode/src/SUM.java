import java.lang.reflect.Array;

public class SUM {
    public static void main(String[] args){
        int[] arr={2,3,4};
        int[] ans= new int[2];
        ans=twoSum(arr,6);
        System.out.println(ans[0]+""+ans[1]);
    }
    static int[] twoSum(int[] numbers,int target){
        int arr[]=new int[2];
        int l=0,h=numbers.length-1;
        while(l<h){
            if(numbers[l]+numbers[h]==target) {
                arr[0] =l+1;arr[1]=h+1;

                return arr;
            }

            if(numbers[l]+numbers[h]<target){
                l++;
            }
            if(numbers[l]+numbers[h]>target){
                h--;
            }
        }
        arr[0]=0;arr[1]=0;
        return arr;
    }
}
