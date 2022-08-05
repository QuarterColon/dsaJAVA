import java.net.StandardSocketOptions;
import java.sql.SQLOutput;

public class equation {
    public static void main(String[] args) {
        int arr[][]={
                {1,3},
                {2,0},
                {5,10},
                {6,-10}
        };
        System.out.println(findMaxValueOfEquation(arr,1));;

    }
    public static int findMaxValueOfEquation(int[][] points, int k) {
        int max=Integer.MIN_VALUE;
        for(int i=1;i<=points.length;i++){
            for(int j=i+1;j<=points.length;j++){
                if (Math.abs(points[i-1][0]-points[j-1][0])<=k){
                    int sum=points[i-1][1]+points[j-1][1]+Math.abs(points[i-1][0]-points[j-1][0]);
                    if (sum>max)
                        max=sum;

                }
            }
        }
        return max;

    }
}
