package com.abu.algo.common.search;

/**
 * 卡片存放广度优先存放方式计算
 * n张卡牌编号1-n, 存入1-n个箱子中，求放置组合的数量
 *
 * @author iwang
 * @since 2019/12/30
 *
 */
public class CardDFS {

    int count;
    int book[];     //数组保存index位置的卡牌是否还在手上，在手上则为默认值0
    int cards[];    //数组保存index位置箱子放置的数字

    public CardDFS(int count){
        this.count = count;
        book = new int[count];
        cards = new int[count];
    }

    public static void main(String[] args) {
        int cardCount = 3;
        CardDFS cardDFS = new CardDFS(cardCount);
        cardDFS.dfs(0);
    }

    // depth first search method
    public void dfs(int step){

        if(step==count){
            this.print();
            return;
        }

        for(int i=0;i<count;i++){
            if(book[i]==0){
                cards[step] = i+1;
                book[i] = 1;
                dfs(step+1);
                book[i] = 0;
            }
        }
    }

    private void print(){
        for(int card : cards){
            System.out.print(card+",");
        }
        System.out.println();
    }

}
