package com.abu.algo.common.graph;

/**
 * 路经城市的最短路径
 * 5个城市，8条线路，求1-5的最短路径，有向图case
 * 起点/终点/路程
 * 1 2 2
 * 1 5 10
 * 2 3 3
 * 2 5 7
 * 3 1 4
 * 3 4 4
 * 4 5 5
 * 5 3 3
 *
 * @author iwang
 * @since 2020/1/28
 */
public class CityDFS {
    int size;       //节点数量
    int [][]graph;  //邻接矩阵, graph[x][y]=1代表x联通y;0代表自己连自己;-1代表不连通
    int []book;   //节点已遍历矩阵，初始化为0，走过设为1
    int min = 999;


    public static void main(String[] args) {
        int [][]graph = {{0,1,2,3,4,5},
                         {1,0,2,-1,-1,10},
                         {2,-1,0,3,-1,7},
                         {3,4,-1,0,4,-1},
                         {4,-1,-1,-1,0,5},
                         {5,-1,-1,3,-1,0}};

        CityDFS cityDFS = new CityDFS(5, graph);
        cityDFS.book[1]=1;
        cityDFS.dfs(1, 0);
        System.out.println("最短路径为:"+cityDFS.min);
    }

    public CityDFS(int size, int [][]graph){
        this.size = size;
        this.graph = graph;
        this.book = new int[size+1];
    }

    /**
     * 递归传入当前城市编号
     * @param current
     * @param distance 到达cufrrent已行总路程
     */
    public void dfs(int current,int distance){
        //System.out.print(current+" ");
        if(current==5){
            //System.out.println();
            System.out.println("到达终点,距离为:"+distance);
            if(distance<min){
                min = distance;
            }
            return;
        }

        for(int i=1;i<=size;i++){
            if(graph[current][i]>0 && book[i]==0){
                book[i]=1;
                dfs(i, distance+graph[current][i]);
                book[i]=0;
            }
        }
    }
}
