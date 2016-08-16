package com.github.emailtohl.algorithm.sort;

/**
 * 快速排序
 * @author helei
 */
public class Quick {
	/**
	 * 排序入库方法
	 * @param arr 要排序的数组
	 * @param a 左下标
	 * @param b 右下标
	 */
	void sort(int[] arr, int a, int b) {
		if (a >= b) {
			return;
		}
		int q = exchange(arr, a, b);
		sort(arr, a, q - 1);
		sort(arr, q + 1, b);
	}
	/**
	 * 数组中的交换
	 * @param arr 数组
	 * @param a 交换的下标
	 * @param b 交换的下标
	 */
	void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	/**
	 * 以b下标为枢纽，对数组a~b范围进行交换
	 * @param arr 数组
	 * @param a 左下标
	 * @param b 右下标
	 * @return 枢纽所在位置
	 */
	int exchange(int[] arr, int a, int b) {
		int i = a - 1, j;
		for (j = a; j < b; j++) {
			if (arr[j] <= arr[b]) {
				swap(arr, ++i, j);
			}
		}
		swap(arr, ++i, b);
		return i;
	}
	
}
