
public class sqrt {
    public static void main(String[] args) {
        int a =2147395599;
        System.out.println(mySqrt(a));
    }

    static int mySqrt(int x) {
        if (x == 1)
            return x;


        int mid = 0, s = 1, e = x / 2;
        while (s <= e) {
            mid = s + (e - s) / 2;
            if ((long) mid * mid == x)
                return mid;
            else if ((long) mid * mid< x)
                s = mid + 1;

            else
                e = mid - 1;

        }
        return e;
    }
}

