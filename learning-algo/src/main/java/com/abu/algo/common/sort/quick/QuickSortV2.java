package com.abu.algo.common.sort.quick;

/**
 * Created by zhewawan on 2019/12/22.
 * quick sort 啊哈算法版本, 比较好理解,
 * 两个指针往中间走，当右指针指向的数小于参照物，则暂停，左指针指向的数大于参照物，则暂停，两指针的数交换，直到两个指针碰头，交换参照物和该数，递归对参照物两边进行排序。
 */
public class QuickSortV2 {

    public static void main(String[] args) {
        int[] test = new int[]{9, 7, 5, 3, 1};
        quickSort(test, 0, test.length - 1);
        print(test);
    }

    /**
     * 快速排序方法
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static void quickSort(int[] array, int start, int end) {
        if (start >= end || array.length == 1) {
            return;
        }

        // 取start 为 pivot参照
        int pivot = start;
        int i = start;
        int j = end;
        int temp = array[pivot];

        while (i < j) {
            //从右往左找到比基准小的数，先移，可能移动完后i=j
            while(array[j]>=temp && i<j){
                j--;
            }
            //从左往右找到比基准大的数
            while(array[i]<=temp && i<j){
                i++;
            }

            if(i<j)//指针还没碰头的情况
                swap(array, i, j);
        }

        // when i == j，碰头的情况
        swap(array, pivot, i);

        quickSort(array, start, i-1);
        quickSort(array, i+1, end);
    }

    /**
     * 交换数组内两个元素
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void print(int[] array){
        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
