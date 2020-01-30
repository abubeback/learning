package com.abu.algo.common.search;

/**
 * 海岛深度优先搜索，遍历并且染色
 * 遍历所有地图，计算海岛数量
 *
 * @author iwang
 * @since 2020/1/14
 *
 * leetcode 200
 *
 */
public class IslandDFSFloodFill {

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
        IslandDFSFloodFill islandBFS = new IslandDFSFloodFill(10, 10, island);

        islandBFS.fill();

        System.out.print("陆地数量为:");
        System.out.println(-islandBFS.count);

        islandBFS.print();
    }

    public IslandDFSFloodFill(int line, int column, int[][] island){
        this.line = line;
        this.column = column;
        this.island = island;
        this.book = new int[line][column];
    }

    public void fill(){
        int i,j;
        for(i=0;i<line;i++){
            for(j=0;j<column;j++){
                if(island[i][j]>0){
                    count--;
                    book[i][j]=1;
                    dfs(new Node(i,j), count);
                }
            }
        }
    }

    public void print(){

        int i,j;
        for(i=0;i<line;i++){
            for(j=0;j<column;j++){
                if(island[i][j]==0){
                    System.out.print("0");
                }
                System.out.print(island[i][j]);
            }
            System.out.println();
        }
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
                nextNode = new Node(nextx, nexty);
                dfs(nextNode, color);
            }
        }
    }
}
