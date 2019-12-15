package com.abu.algo.common.sort.insertion;

import java.util.Arrays;

/**
 * Created by zhewawan on 2019/12/1.
 * 归并排序
 * D&C, divide & conquer, 递归向下，将数组拆成数量接近的两组，底层组合2个小数组为大数组
 */
public class MergeSort {

    public static void main(String[] args) {
        int [] test = new int[]{9,7,5,3,1};
        int [] result = mergeSort(test);
        for(int i : result){
            System.out.print(i+",");
        }
    }

    public static int[] mergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }
    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return result
     * 3个数组都从index0开始, 比较left0和right0, 取到更小的数的数列赋值给result并且index+1
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }
}
