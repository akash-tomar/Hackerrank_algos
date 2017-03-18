package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EvenTree {
	static class Node {
		int data;
		ArrayList<Node> children;
		public Node(int data) {
			this.data=data;
			children = new ArrayList<>();
		}
	}
	static class Pair {
		int edges;
		int node_count;
		boolean yesAddEdgeNow;
		public Pair() {
			edges=0;
			node_count=0;
			yesAddEdgeNow=false;
		}
	}
	static class Tree {
		Node root;
		HashMap<Integer,Boolean> allNodes;
		HashMap<Integer,Node> getNode;
		public Tree() {
			root = new Node(1);
			allNodes = new HashMap<>();
			getNode = new HashMap<>();
			allNodes.put(1, true);
			getNode.put(1, root);
		}
		public void addEdge(int a,int b) {
			Node n = new Node(a);
			getNode.put(a, n);
			getNode.get(b).children.add(n);
		}
	}
	
	public static Pair removeMaxEdges(Node node) {
		if(node.children.size()==0) {
			Pair p = new Pair();
			p.node_count+=1;
			return p;
		}
		Pair ans = new Pair();
		ans.node_count+=1;
		for(int i=0;i<node.children.size();i++) {
			Pair p = removeMaxEdges(node.children.get(i));
			ans.edges+=p.edges;
			ans.node_count+=p.node_count;
			if(p.yesAddEdgeNow) {
				ans.edges+=1;
			}
		}
		if(ans.node_count%2==0) {
			ans.yesAddEdgeNow=true;
			ans.node_count=0;
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		Tree tree = new Tree();
		for(int i=0;i<m;i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			tree.addEdge(a, b);
		}
		System.out.println(removeMaxEdges(tree.root).edges);
	}
}
