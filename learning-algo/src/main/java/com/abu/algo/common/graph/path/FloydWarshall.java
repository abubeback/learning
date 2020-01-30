package com.abu.algo.common.graph.path;

import com.abu.algo.common.graph.AirBFS;

/**
 * Floyd-Warshall 算法, 运用动态规划思想的Floyd算法，计算最短路矩阵
 * 核心算法5行，时间复杂度为O(N3)
 * 在对时间复杂度不是太敏感的情况下，可以用来计算指定两点的最短路
 *
 * 4个城市, 8条有向路径, -1为不通, 连通矩阵如下:
 * 0 1 2 3 4
 * 1 0 2 6 4
 * 2 - 0 3 -
 * 3 7 - 0 1
 * 4 5 - 120
 *
 * @author iwang
 * @since 2020/1/30
 */
public class FloydWarshall {

    int city;
    int [][]graph;

    public static void main(String[] args) {
        int [][]graph = {{0,1,2,3,4},
                         {1,0,2,6,4},
                         {2,999,0,3,999},
                         {3,7,999,0,1},
                         {4,5,999,12,0}};

        FloydWarshall algo = new FloydWarshall(4, graph);
        algo.run();
        algo.print();
    }

    public FloydWarshall(int city, int [][]graph){
        this.city = city;
        this.graph = graph;
    }

    public void run(){
        for(int k=1;k<=city;k++){
            for(int i=1;i<=city;i++){
                for(int j=1;j<=city;j++){
                    if(graph[i][k]<999 && graph[k][j]<999 && (graph[i][k]+graph[k][j]<graph[i][j])){
                        graph[i][j] = graph[i][k]+graph[k][j];
                    }
                }
            }
        }
    }

    public void print(){
        for(int i=1;i<=city;i++){
            for(int j=1;j<=city;j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }
}
