package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StoryOfATree {
	static class Node {
		int name;
		Node parent;
		boolean visited;
		public Node(int name) {
			this.name = name;
			parent=null;
			visited=false;
		}
	}
	
	public static int makeTreeAndCheckParent(ArrayList<ArrayList<Integer>> adjacencyList,int k,int curent_node,HashMap<Integer, Node> map,int[] parent,int[] child) {
		int count = 0;
		Node parent_node = map.get(curent_node);
		for(int i=0;i<adjacencyList.get(curent_node-1).size();i++) {
			int node = adjacencyList.get(curent_node-1).get(i);
			Node n = map.get(node);
			if(!n.visited) {
				n.parent=parent_node;
				n.visited=true;
				for(int j=0;j<parent.length;j++) {
					if(child[j]==node && parent[j]==parent_node.name) {
						count++;
						break;
					}
				}
				count+=makeTreeAndCheckParent(adjacencyList, k, node, map,parent,child);
			}
		}
		return count;
	}
	
	public static boolean winsOrNot(ArrayList<ArrayList<Integer>> adjacencyList,int k,int root_,HashMap<Integer, Node> map,int[] parent,int[] child) {
		for(int i=1;i<=adjacencyList.size();i++) {
			map.get(i).parent=null;
			map.get(i).visited=false;
		}
		map.get(root_).visited=true;
		if(makeTreeAndCheckParent(adjacencyList, k, root_, map, parent, child)>=k) {
			return true;
		}
		return false;
	}
	
	public static int gcm(int a, int b) {
	    return b == 0 ? a : gcm(b, a % b); // Not bad for one line of code :)
	}

	public static String asFraction(int a, int b) {
	    int gcm = gcm(a, b);
	    return (a / gcm) + "/" + (b / gcm);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int q = s.nextInt();
		for(int test=0;test<q;test++) {
			int n = s.nextInt();
			HashMap<Integer, Node> map = new HashMap<>();
			ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
			for(int i=0;i<n;i++) {
				adjacencyList.add(new ArrayList<Integer>());
			}
			for(int i=0;i<n-1;i++) {
				int a = s.nextInt();
				int b = s.nextInt();
				if(!map.containsKey(a)) {
					map.put(a, new Node(a));
				}
				if(!map.containsKey(b)) {
					map.put(b, new Node(b));
				}
				adjacencyList.get(a-1).add(b);
				adjacencyList.get(b-1).add(a);
			}
			int g = s.nextInt();
			int k = s.nextInt();
			int[] parent = new int[g];
			int[] child = new int[g];
			for(int i=0;i<g;i++) {
				parent[i] = s.nextInt();
				child[i] = s.nextInt();
			}
			int ans = 0;
			for(int i=1;i<=n;i++) {
				if(winsOrNot(adjacencyList, k, i, map, parent, child)) {
					ans++;
				}
			}
			
			String answer = asFraction(ans, n);
			System.out.println(answer);
		}
	}

}
