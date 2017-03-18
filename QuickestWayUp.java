package hackerrank;

import java.util.HashMap;
import java.util.Scanner;

public class QuickestWayUp {
	static class Pair {
		int data;
		int weight;
		int dice_roll;
		boolean visited;
		public Pair(int data) {
			this.data = data;
			weight = Integer.MAX_VALUE;
			dice_roll = 0;
			visited = false;
		}
	}

	public static void getShortestPath(int current_index,Pair[] game,HashMap<Integer,Integer> ladder, HashMap<Integer,Integer> snakes) {
		if(current_index>=100) {
			return;
		}
		game[current_index-1].visited=true;
		for(int i=1;i<=6;i++) {
			if(current_index+i<=100) {
//				if(!game[current_index+i-1].visited) {
					int ch = current_index+i;
					if(ladder.containsKey(current_index+i)) {
						ch = ladder.get(current_index+i);
					} else if(snakes.containsKey(current_index+i)) {
						ch = snakes.get(current_index+i);
					}
					game[ch-1].dice_roll=game[current_index-1].dice_roll+1;
					int weight = game[ch-1].weight;
					game[ch-1].weight = Math.min(weight, game[current_index-1].weight+i);
					if(ch>current_index && !game[current_index+i-1].visited) {
						getShortestPath(ch, game, ladder, snakes);
					}
//				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int test=0;test<t;test++) {
			int number_of_ladders = s.nextInt();
			HashMap<Integer,Integer> ladder = new HashMap<>();
			HashMap<Integer,Integer> snakes = new HashMap<>();
			for(int i=0;i<number_of_ladders;i++) {
				int a = s.nextInt();
				int b = s.nextInt();
				ladder.put(a, b);
			}

			int number_of_snakes = s.nextInt();
			for(int i=0;i<number_of_snakes;i++) {
				int a = s.nextInt();
				int b = s.nextInt();
				snakes.put(a,b);
			}


			Pair[] game = new Pair[100];
			for(int i=1;i<=100;i++) {
				game[i-1]=new Pair(i);
			}
			game[0].weight=0;
			game[0].visited=true;
			getShortestPath(1, game,ladder,snakes);
			System.out.println(game[99].dice_roll);
		}
	}
}
