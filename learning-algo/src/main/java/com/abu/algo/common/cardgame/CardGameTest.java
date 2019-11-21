package com.abu.algo.common.cardgame;

import java.util.Queue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by iwang on 11/20/2019
 */
public class CardGameTest {

    public static void main(String[] args) {
        CardGame cardGame = new CardGame();
        Queue<Integer> cards = cardGame.shuffleDesk();
        cardGame.print(cards);
        System.out.println();

        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("One round done...GO again!");
            }
        });
        for (int i = 1; i <= 3; i++) {
            Thread t = new Thread(new CyclicWorker(i, barrier, cards));
            t.start();
        }
    }

    static class CyclicWorker implements Runnable {
        private int index;
        private int sum = 0;
        private CyclicBarrier barrier;
        private Queue<Integer> cards;

        public CyclicWorker(int index, CyclicBarrier barrier, Queue<Integer> cards) {
            this.index = index;
            this.barrier = barrier;
            this.cards = cards;
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i <= 10; i++) {

                    if(cards.peek()!=null){
                        int picked = cards.poll();
                        sum += picked;
                        System.out.println("worker-"+index+" pick ["+picked+"] in round["+i+"], sum is "+sum);

                        if(sum>=50){
                            throw new InterruptedException("worker-"+index+" out!");
                        }
                    }
                    barrier.await();
                }
            } catch (BrokenBarrierException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
