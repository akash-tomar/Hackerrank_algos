package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TorqueAndDevelopment {

//	public static void travsereGraph(int[] visitied_matrices,ArrayList<ArrayList<Integer>> adjacency_list,int node) {
//		if(visitied_matrices[node]==1) {
//			return;
//		} else {
//			visitied_matrices[node]=1;
//		}
//		ArrayList<Integer> neighbours = adjacency_list.get(node);
//		for(int node_:neighbours) {
//			travsereGraph(visitied_matrices, adjacency_list, node_);
//		}
//	}

	public static long getComponents(int[] visitied_matrices,ArrayList<ArrayList<Integer>> adjacency_list,int cost_library,int cost_road) {
		long ans=0;
		for(int i=1;i<visitied_matrices.length;i++) {
			if(visitied_matrices[i]==0) {
				Pair edges = traverseForEdges(visitied_matrices, adjacency_list, i,new Pair(),new HashMap<String,Boolean>());
				if(cost_library<cost_road) {
					ans+=edges.nodes*cost_library;
				} else if(cost_library>cost_road) {
					ans+=(edges.nodes-1)*cost_road;
					ans+=cost_library;
				} else {
					int cost1 = edges.nodes*cost_library;
					int cost2 = (edges.nodes-1)*cost_road;
					cost2+=cost_library;
					ans+=Math.min(cost1, cost2);
				}
			}
		}
		return ans;
	}

	public static class Pair {
		int nodes;
		int edges;
		public Pair() {
			nodes=0;
			edges=0;
		}
	}


	public static Pair traverseForEdges(int[] visitied_matrices,ArrayList<ArrayList<Integer>> adjacency_list,int node,Pair p,HashMap<String,Boolean> map) {
		if(visitied_matrices[node]==1) {
			return p;
		} else {
			visitied_matrices[node]=1;
			p.nodes++;
		}
		ArrayList<Integer> neighbours = adjacency_list.get(node);
		for(int node_:neighbours) {
			if(!map.containsKey(node+""+node_)) {
				map.put(node+""+node_, true);
				map.put(node_+""+node,true);
				p.edges++;
			}
			traverseForEdges(visitied_matrices, adjacency_list, node_,p,map);
		}
		return p;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for(int a0 = 0; a0 < q; a0++){
			int n = in.nextInt();
			int m = in.nextInt();
			int cost_library = in.nextInt();
			int cost_road = in.nextInt();
			ArrayList<ArrayList<Integer>> adjacency_list = new ArrayList<>();
			for(int i=0;i<n+1;i++) {
				adjacency_list.add(new ArrayList<>());
			}
			for(int a1 = 0; a1 < m; a1++){
				int city_1 = in.nextInt();
				int city_2 = in.nextInt();
				adjacency_list.get(city_1).add(city_2);
				adjacency_list.get(city_2).add(city_1);
			}
			long ans = getComponents(new int[n+1], adjacency_list,cost_library,cost_road);
			
//			for(int component : components) {
//				Pair edges = traverseForEdges(new int[n+1], adjacency_list, component, new Pair(),new HashMap<String,Boolean>());
////				System.out.println(cost_library+" "+cost_road);
//				if(cost_library<cost_road) {
//					ans+=edges.nodes*cost_library;
//				} else if(cost_library>cost_road) {
//					ans+=(edges.nodes-1)*cost_road;
//					ans+=cost_library;
//				} else {
//					int cost1 = edges.nodes*cost_library;
//					int cost2 = (edges.nodes-1)*cost_road;
//					cost2+=cost_library;
//					ans+=Math.min(cost1, cost2);
//				}
//			}
			System.out.println(ans);
		}
	}

}
