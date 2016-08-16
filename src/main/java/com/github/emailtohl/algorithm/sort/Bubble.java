package com.github.emailtohl.algorithm.sort;
/**
 * 冒泡排序
 * @author HeLei
 */
public class Bubble {
	void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	void sort(int[] arr) {
		for (int j = arr.length - 1; j > 0; j--) {
			for (int i = 0; i < j; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
		}
	}
}
