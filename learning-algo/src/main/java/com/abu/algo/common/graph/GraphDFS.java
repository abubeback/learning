package com.abu.algo.common.graph;

/**
 * 图的深度优先搜索(遍历)
 * DFS = depth first search
 * 首先构建图的邻接矩阵(图的邻接矩阵存储法)
 * 然后通过深度优先搜索的方式（递归），遍历所有节点
 * 1-2 1-3 1-5 2-4 3-5
 *
 * 邻接矩阵
 * 0 1 2 3 4 5
 * 1 0 1 1 -11
 * 2 1 0 -11 -1
 * 3 1 -10 -11
 * 4 -11 -10 -1
 * 5 1 -11-1 0
 *
 * @author iwang
 * @since 2020/1/28
 */
public class GraphDFS {

    int size;   //节点数量
    int sum = 0;    //经过节点总数
    int [][]graph;  //邻接矩阵, graph[x][y]=1代表x联通y;0代表自己连自己;-1代表不连通
    int []book;   //节点已遍历矩阵，初始化为0，走过设为1


    public static void main(String[] args) {
        int [][]graph = {{0,1,2,3,4,5},
                         {1,0,1,1,-1,1},
                         {2,1,0,-1,1,-1},
                         {3,1,-1,0,-1,1},
                         {4,-1,1,-1,0,-1},
                         {5,1,-1,1,-1,0}};

        GraphDFS graphDFS = new GraphDFS(5, graph);
        graphDFS.book[1]=1;
        graphDFS.dfs(1);
    }

    public GraphDFS(int size, int [][]graph){
        this.size = size;
        this.graph = graph;
        this.book = new int[size+1];
    }

    /**
     * 递归传入当前节点index
     * @param current
     */
    public void dfs(int current){
        System.out.print(current+" ");
        sum++;
        if(sum==size){
            System.out.println();
            System.out.println("遍历所有节点完成");
            return;
        }

        for(int i=1;i<=size;i++){
            if(graph[current][i]==1 && book[i]==0){
                book[i]=1;
                dfs(i);
            }
        }
    }
}
