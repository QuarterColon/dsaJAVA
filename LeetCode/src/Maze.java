import java.util.Arrays;

public class Maze {
    public static void main(String[] args){
        boolean[][] maze={
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        int[][] path=new int[maze.length][maze[0].length];
        Allpath("",maze,path,0,0,1 );

    }
    static int count(int r,int c){
        if (r == 1 || c == 1){
            return 1;
        }
        int left= count(r-1,c);
        int right= count(r,c-1);

        return left+right;
    }
    static void Allpath(String p,boolean[][] maze,int path[][],int r,int c,int step){
        if(r == maze.length-1 && c == maze[0].length-1){
            path[r][c]=step;
            for(int[] arr:path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c]= false;
        path[r][c]=step;
        if (r<maze.length-1){
            Allpath(p+'D',maze,path,r+1,c,step+1);
        }
        if(c<maze[0].length-1){
            Allpath(p+'R',maze,path,r,c+1,step+1);
        }
        if(r>0){
            Allpath(p+'U',maze,path,r-1,c,step+1);
        }
        if(c>0){
            Allpath(p+'L',maze,path,r,c-1,step+1);
        }
        maze[r][c]=true;
        path[r][c]=0;
    }
}
