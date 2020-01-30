package com.abu.algo.common.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 图的广度优先搜索(遍历)
 * BFS = breadth first search
 * 首先构建图的邻接矩阵(图的邻接矩阵存储法)
 * 然后通过广度优先搜索的方式（循环，队列），遍历所有节点
 *
 * @author iwang
 * @since 2020/1/28
 */
public class GraphBFS {

    int size;   //节点数量
    int sum = 0;    //经过节点总数
    int [][]graph;  //邻接矩阵, graph[x][y]=1代表x联通y;0代表自己连自己;-1代表不连通
    int []book;   //节点已遍历矩阵，初始化为0，走过设为1
    Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        int [][]graph = {{0,1,2,3,4,5},
                         {1,0,1,1,-1,1},
                         {2,1,0,-1,1,-1},
                         {3,1,-1,0,-1,1},
                         {4,-1,1,-1,0,-1},
                         {5,1,-1,1,-1,0}};

        GraphBFS graphBFS = new GraphBFS(5, graph);
        graphBFS.q.add(1);
        graphBFS.book[1]=1;

        while(graphBFS.q.peek() != null){
            Integer curr = graphBFS.q.peek();

            graphBFS.bfs(curr);
            graphBFS.q.poll();
        }
    }

    public GraphBFS(int size, int [][]graph){
        this.size = size;
        this.graph = graph;
        this.book = new int[size+1];
    }

    public void bfs(int current){
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
                q.add(i);
            }
        }
    }
}
