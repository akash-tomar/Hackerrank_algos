package hackerrank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Kruskal_ReallySpecialSubtree {
	static class Edge {
		int a;
		int b;
		int weight;
		public Edge(int a, int b, int w) {
			this.a =a;
			this.b=b;
			this.weight=w;
		}
		public int weight() {
			return this.weight;
		}
	}
	static class Node {
		Node parent;
		boolean visited;
		public Node() {
			parent=null;
			visited=false;
		}
	}

	public static boolean isCyclic(ArrayList<ArrayList<Integer>> adjacencyList,HashMap<Integer, Node> newmap,int nodes) {
		//		Node n = newmap.get(node);
		//		n.visited=true;
		//		ArrayList<Integer> list = adjacencyList.get(node);

		for(int j=1;j<=nodes;j++) {
			Node n = newmap.get(j);
			ArrayList<Integer> list = adjacencyList.get(j);
			if(!n.visited) {
				n.visited=true;
				for(int i=0;i<list.size();i++) {
					Node current_node = newmap.get(list.get(i));
					if(current_node.visited) {
						if(n.parent != current_node) {
							return true;
						}
					} else {
						current_node.visited=true;
						current_node.parent=n;
					}
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int nodes = s.nextInt();
		int edges = s.nextInt();
		ArrayList<Edge> edgelist = new ArrayList<>();
		ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
		for(int i=0;i<nodes;i++) {
			adjacencyList.add(new ArrayList<Integer>());
		}
		HashMap<Integer,Node> map = new HashMap<>();
		for(int m=0;m<edges;m++) {
			int a = s.nextInt();
			int b = s.nextInt();
			int w = s.nextInt();
			Edge e = new Edge(a,b,w);
			edgelist.add(e);
			boolean flag=false;
			if(!map.containsKey(a)) {
				map.put(a, new Node());
				ArrayList<Integer> list = new ArrayList<>();
				adjacencyList.add(a,list);
				flag=true;
			}
			if(!map.containsKey(b)) {
				map.put(a, new Node());
				ArrayList<Integer> list = new ArrayList<>();
				adjacencyList.add(b,list);
				flag=true;
			}
			if(flag) {
				adjacencyList.get(a).add(b);
				adjacencyList.get(b).add(a);
			}
		}
		edgelist.sort(Comparator.comparing(Edge::weight));
		int index = 0;
		ArrayList<ArrayList<Integer>> newadjacencyList = new ArrayList<>();
		for(int i=0;i<nodes;i++) {
			newadjacencyList.add(new ArrayList<Integer>());
		}
		HashMap<Integer,Node> newmap = new HashMap<>();
		int[] ans = new int[nodes-1];
		int index_ans = 0; 
		while(index_ans<ans.length) {
			Edge e = edgelist.get(index);
			index++;
			int a = e.a;
			int b = e.b;
			boolean flag = false;
			if(!newmap.containsKey(a)) {
				newmap.put(a, new Node());
				ArrayList<Integer> list = new ArrayList<>();
				newadjacencyList.add(a,list);
				flag=true;
			}
			if(!newmap.containsKey(b)) {
				newmap.put(a, new Node());
				ArrayList<Integer> list = new ArrayList<>();
				newadjacencyList.add(b,list);
				flag=true;
			}
			if(flag) {
				newadjacencyList.get(a).add(b);
				newadjacencyList.get(b).add(a);
			}
			for(int i=1;i<=nodes;i++) {
				Node n = map.get(i);
				n.parent=null;
				n.visited=false;
				map.put(i, n);
			}
			if(isCyclic(newadjacencyList, newmap, nodes)) {
				newadjacencyList.remove(a);
				newadjacencyList.remove(b);
			} else{
				ans[index_ans]=e.weight;
				index_ans++;
			}
		}
		int ansans = 0;
		for(int ij :ans) {
			ansans+=ij;
		}
		System.out.println(ansans);
	}

}
