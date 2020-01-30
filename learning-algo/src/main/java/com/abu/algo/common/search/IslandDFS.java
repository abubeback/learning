package com.abu.algo.common.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 海岛深度优先搜索，着陆并且染色为-1
 * 降落至指定位置，并染色
 *
 * @author iwang
 * @since 2020/1/14
 *
 */
public class IslandDFS {

    int line, column;   //海岛行数和列数
    int [][]island;     //海岛情况, 0为海洋；>0为陆地
    int [][]book;       //海岛走位情况
    int count = 0;
    int [][]next = {{0,1},{1,0},{0,-1},{-1,0}};//对应下一步尝试位置右下左上

    public static void main(String[] args) {
        int[][] island = {{1, 2, 1, 0, 0, 0, 0, 0, 2, 3},
                          {3, 0, 2, 0, 1, 2, 1, 0, 1, 2},
                          {4, 0, 1, 0, 1, 2, 3, 2, 0, 1},
                          {3, 2, 0, 0, 0, 1, 2, 4, 0, 0},
                          {0, 0, 0, 0, 0, 0, 1, 5, 3, 0},
                          {0, 1, 2, 1, 0, 1, 5, 4, 3, 0},
                          {0, 1, 2, 3, 1, 3, 6, 2, 1, 0},
                          {0, 0, 3, 4, 8, 9, 7, 5, 0, 0},
                          {0, 0, 0, 3, 7, 8, 6, 0, 1, 2},
                          {0, 0, 0, 0, 0, 0, 0, 0, 1, 0}};
        IslandDFS islandBFS = new IslandDFS(10, 10, island);

        Node startNode = new Node(5,7);
        if(island[5][7]>0){
            islandBFS.count++;
            islandBFS.book[5][7]=1;
            islandBFS.dfs(startNode, -1);
        }else{
            System.out.println("直接落水");
        }

        System.out.print("陆地大小为:");
        System.out.println(islandBFS.count);
    }

    public IslandDFS(int line, int column, int[][] island){
        this.line = line;
        this.column = column;
        this.island = island;
        this.book = new int[line][column];
    }

    /**
     * depth first search
     */
    public void dfs(Node node, int color){

        int nextx, nexty;
        Node nextNode;

        //染色
        island[node.x][node.y]=color;

        for(int i=0;i<=3;i++){
            nextx = node.x + next[i][0];
            nexty = node.y + next[i][1];

            // 判断越界情况
            if(nextx<0 || nextx>line-1 || nexty<0 || nexty>column-1){
                continue;
            }

            // 判断是否为陆地且没走过
            if(island[nextx][nexty]>0 && book[nextx][nexty]==0){
                book[nextx][nexty]=1;
                count++;
                nextNode = new Node(nextx, nexty);
                dfs(nextNode, color);
            }
        }
    }
}
