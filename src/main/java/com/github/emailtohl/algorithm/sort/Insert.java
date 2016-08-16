package com.github.emailtohl.algorithm.sort;
/**
 * 插入排序
 * @author HeLei
 */
public class Insert {
	void sort(int[] arr) {
		int temp;
		for (int j = 1; j < arr.length; j++) {
			temp = arr[j];
			int i = j - 1;
			while (i >= 0 && arr[i] > temp) {
				arr[i + 1] = arr[i];
				i--;
			}
			arr[i + 1] = temp;
		}
	}
}
