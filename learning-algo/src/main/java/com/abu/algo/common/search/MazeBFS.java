package com.abu.algo.common.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 迷宫广度优先算法，遍历最短到达目的地路径长度
 * 从起点出发，按照右下左上的顺序尝试下1步，直到到达终点
 * 迷宫大小为5行4列，0为空位，1为障碍物
 * 起点为11，终点为43
 * 0 0 1 0
 * 0 0 0 0
 * 0 0 1 0
 * 0 1 0 0
 * 0 0 0 1
 * result:7
 *
 * @author iwang
 * @since 2020/1/5
 */
public class MazeBFS {

    int line, column;   //迷宫行数和列数
    int [][]maze;   //迷宫情况
    int [][]book;   //迷宫走位情况
    int startx, starty, endx, endy; //起点和终点坐标
    int min = 999;
    int [][]next = {{0,1},{1,0},{0,-1},{-1,0}};//对应下一步尝试位置右下左上
    Queue<Node> queue = new LinkedList<>(); //队列扩充遍历到的所有节点

    public static void main(String[] args) {

        int[][] maze = {{0,0,1,0},{0,0,0,0},{0,0,1,0},{0,1,0,0},{0,0,0,1}};
        MazeBFS mazeBFS = new MazeBFS(5, 4, maze);
        mazeBFS.init(0,0,3,2);

        //mazeDFS.printMaze();
        Node startNode = new Node(0,0,0,null);
        mazeBFS.queue.offer(startNode);     //起点添加至队列中
        mazeBFS.book[0][0]=1;               //起点标记为已走过
        mazeBFS.bfs();
        System.out.println(mazeBFS.min);
    }

    public MazeBFS(int line, int column, int[][] maze){
        this.line = line;
        this.column = column;
        this.maze = maze;
        this.book = new int[line][column];
    }

    public void init(int startx, int starty, int endx, int endy){
        this.startx = startx;
        this.starty = starty;
        this.endx = endx;
        this.endy = endy;
    }

    public void bfs(){

        while(queue.peek() != null){

            Node node = queue.peek();

            // 判断到达终点的情况，返回
            if(node.x==endx && node.y==endy){
                System.out.println("找到终点,距离:"+node.step);
                min = node.step;
                printBook();
                break;
            }

            int nextx, nexty;
            // 枚举4个方向的走法
            Node nextNode;
            for(int i=0;i<=3;i++){
                nextx = node.x + next[i][0];
                nexty = node.y + next[i][1];

                // 判断越界情况
                if(nextx<0 || nextx>line-1 || nexty<0 || nexty>column-1){
                    continue;
                }

                // 判断该点是否为障碍物或者在历史路径中
                if(maze[nextx][nexty]==0 && book[nextx][nexty]==0){
                    book[nextx][nexty]=1;
                    nextNode = new Node(nextx, nexty, node.step+1, node);
                    queue.offer(nextNode);
                }
            }
            queue.poll();
        }


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

