public class solution {
    public static void main(String[] args) {
        int[] arr={2,1};
        System.out.println(firstMissingPositive(arr));

    }

    public static int firstMissingPositive(int[] num) {
        int ans=0;
        int f=0;
        for (int i = 1; i <= num.length; i++) {
            f = 0;
            for (int j = 1; j <= num.length; j++) {
                if (i == num[j - 1]) {
                    f = 1;
                    break;
                }
            }
            ans=i;
            if (f == 0) {

                break;
            }
        }
        if (f==1) {
            ans = ans + 1;
        }
        return ans;
    }
}
