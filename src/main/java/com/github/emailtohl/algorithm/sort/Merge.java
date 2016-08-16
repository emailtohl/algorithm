package com.github.emailtohl.algorithm.sort;

/**
 * 归并排序
 * @author helei
 *
 */
public class Merge {
	/**
	 * 归并排序需要额外的一个存储空间
	 */
	int[] temp;
	/**
	 * 对arr[a]~arr[p]和arr[p]~arr[b]的数组进行归并
	 * @param arr 数组
	 * @param a 左下标
	 * @param p 右下标
	 * @param b 分割的下标
	 */
	void merge(int[] arr, int a, int p, int b) {
		int i = a, j = p + 1, k = a;
		// 哪个小就先放入缓存区
		while (i <= p && j <= b) {
			if (arr[i] < arr[j]) {
				temp[k] = arr[i];
				i++;
			} else {
				temp[k] = arr[j];
				j++;
			}
			k++;
		}
		// 将剩下的部分再放入缓存区
		while (i <= p) {
			temp[k] = arr[i];
			i++;
			k++;
		}
		// 将剩下的部分再放入缓存区
		while (j <= b) {
			temp[k] = arr[j];
			j++;
			k++;
		}
		// 把缓存区的数据复制回到原数组
		for (i = a; i <= b; i++) {
			arr[i] = temp[i];
		}
	}
	/**
	 * 排序的入口
	 * 
	 * @param arr 数组
	 * @param a 左下标
	 * @param b 右下标
	 */
	void sort(int[] arr, int a, int b) {
		if (temp == null) {
			temp = new int[arr.length];
		}
		if (a >= b) {
			return;
		}
		int p = (a + b) / 2;
		sort(arr, a, p);
		sort(arr, p + 1, b);
		merge(arr, a, p, b);
	}
}
