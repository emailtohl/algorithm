package com.github.emailtohl.algorithm.hannoi;

import org.junit.Test;

public class HannoiTest {
	@Test
	public void testHannoi() {
		Hannoi h = new Hannoi();
		h.hannoi(8, 'A', 'B', 'C');
	}
}
