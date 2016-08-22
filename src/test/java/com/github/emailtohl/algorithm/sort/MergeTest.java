package com.github.emailtohl.algorithm.sort;

import java.util.Random;

import org.junit.Test;

public class MergeTest {

	@Test
	public void testSort() {
		int length = 100;
		Random r = new Random();
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = r.nextInt(100);
		}
		Merge mg = new Merge();
		long start = System.currentTimeMillis();
		mg.sort(arr, 0, length - 1);
		long stop = System.currentTimeMillis();
		System.out.println(stop - start);
		for (int i = 0; i < length; i++) {
			System.out.print(arr[i] + " , ");
		}
	}

}
