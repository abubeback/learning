package com.abu.algo.common.cardgame;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by iwang on 11/20/2019
 */
public class CardGame {

    private Integer[] poker = {1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,6,7,8,9,10,11,12,13,20,20};

    public Queue<Integer> shuffleDesk() {
        Random random = new Random();

        for(int i = 0;i<100;i++){
            int indexFirst = random.nextInt(54);
            int indexSecond = random.nextInt(54);
            if(indexFirst != indexSecond){
                int valueFirst = poker[indexFirst];
                int valueSecond = poker[indexSecond];
                poker[indexFirst] = valueSecond;
                poker[indexSecond] = valueFirst;
            }
        }

        Queue<Integer> cardQueue = new LinkedBlockingQueue<>(54);
        for(int card : poker){
            cardQueue.add(card);
        }
        return cardQueue;
    }

    public void print(Queue<Integer> cards){
        for(int card: cards){
            System.out.print(card+",");
        }
    }

}
