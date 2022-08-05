public class GCD {
    public static void main(String[] args) {
        int[] arr={3,6};
        System.out.println(isGoodArray(arr));
    }

    static boolean isGoodArray(int[] nums) {
        boolean ans = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (gcd(nums[i], nums[j]) == 1) {
                    ans = true;
                    break;
                }
            }


        }
        return ans;
    }

    static int gcd(int a, int b) {
        int x, y, r=0;

        if (a > b) {
            x = a;
            y = b;
        } else {
            x = b;
            y = a;
        }
        while (x % y != 0) {
            r = x % y;
            x = y;
            y = r;
        }
        return r;
    }
}
