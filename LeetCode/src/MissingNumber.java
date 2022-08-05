import javax.naming.PartialResultException;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {5,3,0, 2,1};
        System.out.println(missingNumber(arr));
    }

    static public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i]<nums.length && nums[i] != i) {
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }else{
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }
        return nums.length;
    }
}

