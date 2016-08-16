package com.github.emailtohl.algorithm.backtracking;

/**
 * N 皇后
 * 
 * @author HeLei
 *
 */
public class Queen {
	int n;// 一共有n个皇后
	int[] x;// 存放各个皇后摆放的位置
	long num = 0L;// 存储有几种解

	public Queen(int n) {
		this.n = n;
		x = new int[n + 1];// 为了和问题保持一致，不用数组的第一项x[0]
		for (int i = 0; i <= n; i++)
			x[i] = 0;
	}

	public void queen(int k) {// k用于描述第几个皇后，一共有n个皇后
		if (k > n) {// 如果满足问题的解，就结束递归
			num++;
			System.out.println("找到第  " + num + " 种方案");
			for (int i = 1; i <= n; i++)
				System.out.println("x[" + i + "]: " + x[i]);
			// System.exit(0);// 如果找到一个方案，就行了，退出程序
			return;
		}

		int test = 1;// 测试从1到n列的每一个位置，确定第k个皇后摆放的位置
		while (test <= n) {
			if (isRight(k, test)) {// 如果通过了测试，就递归查找下一个皇后应该摆放的位置
				x[k] = test;
				queen(k + 1);
			}
			test++;// 如果下一层没有找到合适的位置而返回，则回溯，test增加一向下找，直到有合适的位置
		} // end while
	}

	boolean isRight(int k, int test) {// 该方法用于检测该位置是否冲突，如果冲突就返回true
		for (int a = 1; a < k; a++) // 对于当前第k个皇后来说，如果摆放在第test列，测试前面第1到k-1个皇后与之是否冲突
			if ((test == x[a]) || (Math.abs(test - x[a]) == Math.abs(k - a)))
				return false;
		return true;
	}
}
