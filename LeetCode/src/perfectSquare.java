public class perfectSquare {
    public static void main(String[] args){
        int a=89235698;
        System.out.println(isPerfectSquare(a));
    }
    static boolean isPerfectSquare(int num){
        int l=1,m,h=num/2;
        while(l<=h){
            m=l+(h-l)/2;
            if(m*m==num){
                return true;
            }
            if(m*m>num){
                h--;
            }
            if(m*m<num){
                l++;
            }
        }
        return false;
    }
}
