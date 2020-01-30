package com.abu.algo.common.search;

/**
 * 深度优先搜索解决炸弹人问题
 *
 * @author iwang
 * @since 2020/1/14
 */
public class BombDFS {

    int line, column;   //迷宫行数和列数
    char [][]maze;   //迷宫情况
    int [][]book;   //迷宫走位情况
    int max = 0;
    Node maxNode = null;
    int [][]next = {{0,1},{1,0},{0,-1},{-1,0}};//对应下一步尝试位置右下左上

    public static void main(String[] args) {
        char[][] maze = {{'#','#','#','#','#','#','#','#','#','#','#','#','#'},
                         {'#','G','G','.','G','G','G','#','G','G','G','.','#'},
                         {'#','#','#','.','#','G','#','G','#','G','#','G','#'},
                         {'#','.','.','.','.','.','.','.','#','.','.','G','#'},
                         {'#','G','#','.','#','#','#','.','#','G','#','G','#'},
                         {'#','G','G','.','G','G','G','.','#','.','G','G','#'},
                         {'#','G','#','.','#','G','#','.','#','.','#','.','#'},
                         {'#','#','G','.','.','.','G','.','.','.','.','.','#'},
                         {'#','G','#','.','#','G','#','#','#','.','#','G','#'},
                         {'#','.','.','.','G','#','G','G','G','.','G','G','#'},
                         {'#','G','#','.','#','G','#','G','#','.','#','G','#'},
                         {'#','G','G','.','G','G','G','#','G','.','G','G','#'},
                         {'#','#','#','#','#','#','#','#','#','#','#','#','#'}};
        BombDFS bombDFS = new BombDFS(13, 13, maze);

        Node startNode = new Node(3,3);
        bombDFS.book[3][3]=1;               //起点标记为已走过

        bombDFS.dfs(startNode);
        System.out.print("炸的最多的位置是:");
        System.out.println(bombDFS.maxNode.x+":"+bombDFS.maxNode.y);
        System.out.print("炸的最多的数量是:");
        System.out.println(bombDFS.max);
    }

    public BombDFS(int line, int column, char[][] maze){
        this.line = line;
        this.column = column;
        this.maze = maze;
        this.book = new int[line][column];
    }

    public void dfs(Node node){

        int count = bomb(node.x, node.y);
        if(count > max){
            this.max = count;
            this.maxNode = node;
        }

        Node nextNode;
        int nextx, nexty;
        for(int i=0;i<=3;i++){
            nextx = node.x + next[i][0];
            nexty = node.y + next[i][1];

            // 判断越界情况
            if(nextx<1 || nextx>line-2 || nexty<1 || nexty>column-2){
                continue;
            }

            // 判断该点是否为平地并且没走过
            if(maze[nextx][nexty]=='.' && book[nextx][nexty]==0){
                book[nextx][nexty]=1;
                nextNode = new Node(nextx, nexty);
                dfs(nextNode);
            }
        }
    }

    /**
     * 返回当前点能够炸到的气球总数
     * @return
     */
    public int bomb(int x, int y){
        int result,i,j;
        result = 0;

        //right
        i = x; j = y;
        while(maze[i][j]!='#'){
            if(maze[i][j]=='G'){
                result++;
            }
            j++;
        }
        //down
        i = x; j = y;
        while(maze[i][j]!='#'){
            if(maze[i][j]=='G'){
                result++;
            }
            i++;
        }
        //left
        i = x; j = y;
        while(maze[i][j]!='#'){
            if(maze[i][j]=='G'){
                result++;
            }
            j--;
        }
        //up
        i = x; j = y;
        while(maze[i][j]!='#'){
            if(maze[i][j]=='G'){
                result++;
            }
            i--;
        }
        return result;
    }
}
