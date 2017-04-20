package hackerrank;

import java.util.Scanner;

public class BasketballGame {
	public static void main(String[] args) {

			Scanner s = new Scanner(System.in);
			int t = s.nextInt();

			for (int test = 0; test < t; test++) {
				int xhoop = s.nextInt();
				int yhoop = s.nextInt();

				int Xc = s.nextInt();
				int Yc = s.nextInt();
				int Sc = s.nextInt();

				int[] X = new int[5];
				int[] Y = new int[5];
				int[] S = new int[5];
				double min = 1000000000;
				for (int i = 0; i < 5; i++) {
					X[i] = s.nextInt();
					Y[i] = s.nextInt();
					S[i] = s.nextInt();

					if (X[i] >= Xc && X[i] <= xhoop)

						min = Math.min(min, time(X[i], Y[i], xhoop, yhoop, S[i]));
				}
				double time_caroline = time(Xc, Yc, xhoop, yhoop, Sc);
				if (min < time_caroline) {
					System.out.println("NO");
				} else {
					System.out.println("YES");
				}


				System.out.println(time(0, 0, 5, 0, 1));

			}
	}
	public static double time(int Xc, int Yc,int  xhoop,int yhoop,int Sc) {
		return 1;
	}
}

