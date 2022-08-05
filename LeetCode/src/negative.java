public class negative {
    public static void main(String[] args) {
        int[][] arr= {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };
        System.out.println(countNegatives(arr));
        }

    static int countNegatives(int[][] grid){
        int r=0,c=grid[0].length-1,s=0;
        while(r<grid.length && c>=0){
            if(grid[r][c]<0){
                s+=grid.length-r;
                c--;
            }
            else{
                r++;
            }
        }
        return s;
    }
}
