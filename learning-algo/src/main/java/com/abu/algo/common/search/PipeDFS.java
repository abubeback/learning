package com.abu.algo.common.search;

/**
 * 水管工游戏，找寻能够联通起点终点的水管路径，水管有2种，可以在当前位置旋转。
 * 弯管: 1:┗/2:┏/3:┓/4:┛ 直管: 5:━/6:┃ 0为障碍物不通
 * 5x4 大小，起点为11，左侧进水；终点为54，右侧出水
 *
 * 5 3 5 3
 * 1 5 3 0
 * 2 3 5 1
 * 6 1 1 5
 * 1 5 5 4
 *
 * @author iwang
 * @since 2020/1/24
 */
public class PipeDFS {

    int line, column;   //迷宫行数和列数
    int [][]pipes;      //迷宫情况
    int [][]book;       //迷宫走位情况
    int flag = 0;       //方案成功flag
    int [][]next = {{0,1},{1,0},{0,-1},{-1,0}};//对应下一步尝试位置右下左上

    public PipeDFS(int line, int column, int[][] pipes){
        this.line = line;
        this.column = column;
        this.pipes = pipes;
        this.book = new int[line][column];
    }

    public static void main(String[] args) {
        int[][] pipes = {{5,3,5,3},
                         {1,5,3,0},
                         {2,3,5,1},
                         {6,1,1,5},
                         {1,5,5,4}};

        PipeDFS pipeDFS = new PipeDFS(5, 4, pipes);

        //从起点开始
        pipeDFS.dfs(0,0,1);

        if(pipeDFS.flag == 1){

        }

    }

    /**
     * x y 为当前节点坐标，front为前1个水管至此的进水方向，1234对应左上右下
     * @param x
     * @param y
     * @param front
     */
    public void dfs(int x, int y, int front){
        //System.out.println(x+":"+y);

        // 到达终点
        if(x==line-1 && y==column){
            flag = 1;
            System.out.println("到达终点，路径如下:");
            printBook();
            return;
        }
        // 越界
        if(x<0 || x>line-1 || y<0 || y>column-1){
            return;
        }
        // 当前路径该节点已使用
        if(book[x][y]==1){
            return;
        }

        book[x][y] = 1;

        // 当前节点为弯管
        if(pipes[x][y]==1||pipes[x][y]==2||pipes[x][y]==3||pipes[x][y]==4){
            if(front == 1){//左进
                dfs(x+1,y,2);//弯管3
                dfs(x-1,y,4);//弯管4
            } else if (front == 2) {//上进
                dfs(x,y+1,1);//弯管1
                dfs(x,y-1,3);//弯管4
            } else if (front == 3) {//右进
                dfs(x-1,y,4);//弯管1
                dfs(x+1,y,2);//弯管2
            } else if (front == 4) {//下进
                dfs(x,y+1,1);//弯管2
                dfs(x,y-1,3);//弯管3
            }
        }

        // 当前节点为直管
        if(pipes[x][y]==5||pipes[x][y]==6){
            if(front == 1){
                dfs(x, y+1, 1);
            } else if (front == 2) {
                dfs(x+1, y, 2);
            } else if (front == 3) {
                dfs(x, y-1, 3);
            } else if (front == 4) {
                dfs(x-1, y, 4);
            }
        }
        book[x][y] = 0;

    }

    public void printBook(){
        for(int i=0;i<line;i++){
            for(int j=0;j<column;j++){
                System.out.print(book[i][j]+",");
            }
            System.out.println();
        }
    }

}
