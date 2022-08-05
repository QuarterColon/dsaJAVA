public class coin {
    public static void main(String[] args){
        int a=2147483647;
        System.out.println(arrangeCoins(a));
    }
    static int arrangeCoins(int n){
        int sum=0,i=1;
        while((long)sum<n){
            sum+=i;
            if((long)sum<=n)
            i++;
            if(i<0)
                System.out.println(i);
        }
        System.out.println(i);
        return(i-1);
    }
}
