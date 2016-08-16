package com.github.emailtohl.algorithm.sort;

import java.util.Date;
import java.util.Random;

import org.junit.Test;

public class InsertTest {

	@Test
	public void testSort() {
		int length = 100;
		Random r = new Random();
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = r.nextInt(100);
		}
		Insert is = new Insert();
		long start = new Date().getTime();
		is.sort(arr);
		long stop = new Date().getTime();
		System.out.println(stop - start);
		for (int i = 0; i < length; i++) {
			System.out.print(arr[i] + " , ");
		}
	}

}
