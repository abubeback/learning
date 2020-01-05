package com.abu.algo.common.sort.insertion;

/*
 * @author iwang
 * @since 11/27/2019
 *
 * 插入排序
 * 初始index0 为包含1个元素的数组，循环从index1开始, 不断扩展这个排序好的数组, 每次扩充1个元素 如从小到大排列
 * 扩充逻辑,
 * 从i(init=1)开始, 将i暂存, 将i-1/i-2/...元素与i比较, 比array[i]大则右移1格, 直到array[i-n]<=array[i], 则将array[i] 放置到该空位
 * <p>
 *
 * 改进算法
 * https://blog.csdn.net/qq_42857603/article/details/81605124
 */
public class InsertionSort {

    public static int[] sort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int size = array.length;
        for (int i = 1; i < size; i++) {
            int tmp = array[i];
            int j = i - 1;                //开始比较的index,直到0
            while (j >= 0 && array[j] > tmp) {//当比到最左边或者遇到比temp小的数据时，结束循环
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
        return array;
    }

    public static void print(int[] array) {
        for (int i : array) {
            System.out.print(i + ",");
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{9, 7, 5, 3, 1};
        int[] result = insertionSort(test);
        for (int i : result) {
            System.out.print(i + ",");
        }
    }

    public static int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
}
