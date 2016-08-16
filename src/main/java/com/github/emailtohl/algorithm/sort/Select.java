package com.github.emailtohl.algorithm.sort;

/**
 * 选择排序
 * @author HeLei
 */
public class Select {
	void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	void sort(int[] arr) {
		int temp;
		for (int j = arr.length - 1; j > 0; j--) {
			temp = j;
			for (int i = 0; i < j; i++) {
				if (arr[i] > arr[temp])
					temp = i;
			}
			swap(arr, temp, j);
		}
	}
}
