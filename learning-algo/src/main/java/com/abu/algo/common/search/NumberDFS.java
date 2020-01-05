package com.abu.algo.common.search;

/**
 * ???+???=???
 * ?为1到9的数组，且不可重复，找到所有使等式成立的组合
 *
 * @author iwang
 * @since 2019/12/30
 */
public class NumberDFS {
    int count = 9;
    int book[];     //数组保存index位置的数字是否还在手上，在手上则为默认值0
    int numbers[];    //数组保存index位置箱子放置的数字

    public NumberDFS(){
        book = new int[count];
        numbers = new int[count];
    }

    public static void main(String[] args) {
        NumberDFS numberDFS = new NumberDFS();
        numberDFS.dfs(0);
    }

    // depth first search method
    public void dfs(int step){

        if(step==9){
            if(numbers[0]*100+numbers[1]*10+numbers[2]+numbers[3]*100+numbers[4]*10+numbers[5]==
               numbers[6]*100+numbers[7]*10+numbers[8]){
                this.print();
            }
            return;
        }

        for(int i=0;i<count;i++){
            if(book[i]==0){
                numbers[step] = i+1;
                book[i] = 1;
                dfs(step+1);
                book[i] = 0;
            }
        }
    }

    private void print(){
        System.out.printf("%d%d%d+%d%d%d=%d%d%d",
                          numbers[0],numbers[1],numbers[2],
                          numbers[3],numbers[4],numbers[5],
                          numbers[6],numbers[7],numbers[8]);
        System.out.println();
    }
}
