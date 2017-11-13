import java.util.Scanner;

public class Main {
    //I assumed that * is wall, . is empty space, X is beginning, @ is finish
    private static String getPathFromArray(Cell[][] arr,Point begin, Point finish ){
        StringBuilder sb = new StringBuilder();
        int i,j;
        i=finish.getI();
        j=finish.getJ();
        while(i!=begin.getI()||j!=begin.getJ()){
            int cameFrom = arr[i][j].getCameFrom();
            i-=di[cameFrom];
            j-=dj[cameFrom];
            switch (cameFrom){
                case 0:
                    sb.append("Down\n");
                case 1:
                    sb.append("Up\n");
                case 2:
                    sb.append("Right\n");
                case 3:
                    sb.append("Left\n");
            }
        }
        String[] moves = new String(sb).split("\n");
        sb = new StringBuilder();
        for(int p=moves.length-1;p>=0;p--){
            sb.append(moves[i]);
            sb.append("\n");
        }
        return new String(sb);
    }
    private static final int[] di ={0,0,1,-1},dj={1,-1,0,0};
    private static String findPath(char[][] arr) throws RuntimeException{

        StringBuilder sb =  new StringBuilder();
        Point begin = null, finish= null;
        int n = arr.length, m = arr[0].length;
        Cell[][] a =  new Cell[n+2][m+2];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                a[i][j]=new Cell(-1);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]=='*')a[i+1][1+j].setCameAt(-1);
                else if(arr[i][j]=='.')a[1+i][j+1].setCameAt(0);
                else if(arr[i][j]=='X'){
                    a[i+1][j+1].setCameAt(1);
                    if(begin==null){
                        begin = new Point(i+1,j+1);
                    }
                    else{
                        throw new RuntimeException("Input has more than one begin point");
                    }
                }
                else if(arr[i][j]=='@'){
                    a[i+1][j+1].setCameAt(0);
                    if(finish==null){
                        finish=new Point(i+1,j+1);
                    }
                    else{
                        throw new RuntimeException("Input has more than one finish point");
                    }
                }
            }
        }
        if(begin==null)throw new RuntimeException("Input doesn't contain start point");
        if(finish==null)throw new RuntimeException("Input doesn't contain finish point");
        Point[][] queue = new Point[n*m][2];

        int head=0,tail=1;
        queue[0][0]=begin;
        queue[0][0]=null;
        while(head<tail){
            Point temp=queue[head++][0];
            if(temp.equals(finish)){
                //return getPathFromArray(a);
            }
            int i = temp.getI(),j=temp.getJ();
            for(int p=0;i<di.length;p++){
                int tI=i+di[p];
                int tJ=j+dj[p];
                if(a[tI][tJ].getCameAt()!=-1){
                    queue[tail][0]=new Point(tI,tJ);
                    queue[tail][1]=temp;
                    tail++;
                    a[tI][tJ].setCameAt(a[i][j].getCameAt()+1);
                    a[tI][tJ].setCameFrom(p);
            }
        }
        throw new RuntimeException("Couldn't find the path out");
        }
        return getPathFromArray(a,begin,finish);
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n,m;
        n = in.nextInt();
        m=in.nextInt();
        char[][] lab = new char[n][m];
        for(int i=0;i<n;i++){
            lab[i]=in.next("\n").toCharArray();
        }
        System.out.println(findPath(lab));
    }
}
