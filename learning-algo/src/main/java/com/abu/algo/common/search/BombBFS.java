package com.abu.algo.common.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先搜索解决炸弹人问题
 * 主角在可达的位置放置炸弹，找出放置炸弹能炸最多人的位置
 * 可行动区域为12x12的区域，周围为墙体: #墙;G气球;.空地
 *
 * @author iwang
 * @since 2020/1/13
 */
public class BombBFS {

    int line, column;   //迷宫行数和列数
    char [][]maze;   //迷宫情况
    int [][]book;   //迷宫走位情况
    int max = 0;
    Node maxNode = null;
    int [][]next = {{0,1},{1,0},{0,-1},{-1,0}};//对应下一步尝试位置右下左上
    Queue<Node> queue = new LinkedList<>(); //队列扩充遍历到的所有节点

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
        BombBFS bombBFS = new BombBFS(13, 13, maze);

        Node startNode = new Node(3,3);
        bombBFS.queue.offer(startNode);     //起点添加至队列中
        bombBFS.book[3][3]=1;               //起点标记为已走过
        bombBFS.max = bombBFS.bomb(3,3);    //初始化起始节点count为max
        bombBFS.maxNode = startNode;              //初始化起始节点为maxNode

        bombBFS.bfs();
        System.out.print("炸的最多的位置是:");
        System.out.println(bombBFS.maxNode.x+":"+bombBFS.maxNode.y);
        System.out.print("炸的最多的数量是:");
        System.out.println(bombBFS.max);
    }

    public BombBFS(int line, int column, char[][] maze){
        this.line = line;
        this.column = column;
        this.maze = maze;
        this.book = new int[line][column];
    }

    public void bfs(){

        while(queue.peek() != null){
            Node node = queue.peek();
            int nextx, nexty, count;
            // 枚举4个方向的走法
            Node nextNode;
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
                    queue.offer(nextNode);
                    // 更新max
                    count = this.bomb(nextx, nexty);
                    if(count > this.max){
                        this.max = count;
                        this.maxNode = nextNode;
                    }

                }
            }
            queue.poll();
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

    public void printMaze(){
        for(int i=0;i<line;i++){
            for(int j=0;j<column;j++){
                System.out.print(maze[i][j]+",");
            }
            System.out.println();
        }
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