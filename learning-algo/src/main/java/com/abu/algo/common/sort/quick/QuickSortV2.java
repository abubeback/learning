package com.abu.algo.common.sort.quick;

/**
 * Created by zhewawan on 2019/12/22.
 * quick sort 啊哈算法版本, 比较好理解,
 * 两个指针往中间走，当右指针指向的数小于参照物，则暂停，左指针指向的数大于参照物，则暂停，两指针的数交换，直到两个指针碰头，交换参照物和该数，递归对参照物两边进行排序。
 *
 */
public class QuickSortV2 {

    public static void main(String[] args) {
        int [] test = new int[]{9,7,5,3,1};
        int [] result = quickSort(test, 0, test.length-1);
        for(int i : result){
            System.out.print(i+",");
        }
    }

    /**
     * 快速排序方法
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int[] quickSort(int[] array, int start, int end) {
        // 取start 为  pivot参照
        int pivot = start;
        int i = start +1;
        int j = end;
        int tmp;

        while(i<=j){

        }

        return array;
    }

    /**
     * 交换数组内两个元素
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
