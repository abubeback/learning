package com.abu.algo.common.graph;

import com.abu.algo.common.search.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 最少转机-图的广度优先遍历
 * 通过广度优先遍历，确认城市1-城市5的最少转机次数(航班次数)
 *
 * @author iwang
 * @since 2020/1/28
 */
public class AirBFS {
    int size;       //城市数量, 双向连通
    int sum;
    int [][]graph;  //邻接矩阵, graph[x][y]=1代表x联通y;0代表自己连自己;-1代表不连通
    int []book;   //节点已遍历矩阵，初始化为0，走过设为1
    Queue<TravelNode> q = new LinkedList<>();

    public static void main(String[] args) {
        int [][]graph = {{0,1,2,3,4,5},
                         {1,0,1,1,-1,-1},
                         {2,1,0,1,1,-1},
                         {3,1,1,0,1,1},
                         {4,-1,1,1,0,1},
                         {5,-1,-1,1,1,0}};

        AirBFS airBFS = new AirBFS(5, graph);

        airBFS.q.add(new TravelNode(1, 0));
        airBFS.book[1]=1;

        while(airBFS.q.peek() != null){
            TravelNode curr = airBFS.q.peek();

            airBFS.bfs(curr);
            airBFS.q.poll();
        }
    }

    public AirBFS(int size, int [][]graph){
        this.size = size;
        this.graph = graph;
        this.book = new int[size+1];
    }

    public void bfs(TravelNode current){
        System.out.print(current.city+" ");

        sum++;
        if(sum==size){
            System.out.println();
            System.out.println("遍历所有节点完成");
            return;
        }

        int transfer = 0;
        for(int i=1;i<=size;i++){
            if(graph[current.city][i]==1 && book[i]==0){
                book[i]=1;
                transfer = current.transfer+1;
                q.add(new TravelNode(i, transfer));

                if(i==5){
                    System.out.println("飞到终点5了,转机了"+transfer+"次");
                }
            }
        }
    }

}

class TravelNode {
    int city;       //城市index
    int transfer;   //转机次数

    TravelNode(){}

    TravelNode(int city, int transfer){
        this.city = city;
        this.transfer = transfer;
    }
}
