import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class TopologicalSortDFS {
    //jun xie's code BEGIN
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
		// write your code here
          ArrayList<DirectedGraphNode> ret = new ArrayList<DirectedGraphNode>();
          if (graph == null || graph.size() == 0)   return ret;
          Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
          Stack<DirectedGraphNode> stack = new Stack<DirectedGraphNode>();
          for (DirectedGraphNode node : graph) {
              if (visited.contains(node))     continue;
              dfs(node, visited, stack);
          }

          while (!stack.isEmpty()) {
              ret.add(stack.pop());
          }

		  return ret;
		}

		public void dfs(DirectedGraphNode node, Set<DirectedGraphNode> visited, Stack<DirectedGraphNode> stack) {
		       if (node == null)       return;
		       visited.add(node);
		      for (DirectedGraphNode neighbor : node.neighbors) {
		             if (visited.contains(neighbor)) continue;
		               dfs(neighbor, visited, stack);
		      }
		       stack.push(node);
		}	
		
	    //jun xie's code END		
		
	
	public void helper(DirectedGraphNode node, Set<DirectedGraphNode> visited, Stack<DirectedGraphNode> stack){
		visited.add(node);
		for(DirectedGraphNode neighbor: node.neighbors){
			if(!visited.contains(neighbor)){
				helper(neighbor, visited, stack);
			}
		}
		stack.push(node);
		
	}
	
	public ArrayList<DirectedGraphNode> topSortDFS(ArrayList<DirectedGraphNode> graph) {
		ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
		if(graph==null||graph.size()==0){
			return res;
		}
		Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
		Stack<DirectedGraphNode> stack = new Stack<DirectedGraphNode>();
		for(DirectedGraphNode node: graph){
			if(!visited.contains(node)){
				helper(node, visited, stack);
			}
		}
		while(!stack.isEmpty()){
			res.add(stack.pop());
		}
		return res;
	}
	
	
	
	public static void main(String[] args) {
		DirectedGraphNode n0 = new DirectedGraphNode(0);
		DirectedGraphNode n1 = new DirectedGraphNode(1);
		DirectedGraphNode n2 = new DirectedGraphNode(2);
		DirectedGraphNode n3 = new DirectedGraphNode(3);
		DirectedGraphNode n4 = new DirectedGraphNode(4);
		DirectedGraphNode n5 = new DirectedGraphNode(5);
		n0.neighbors.add(n1);
		n0.neighbors.add(n2);
		n0.neighbors.add(n3);
		n1.neighbors.add(n4);
		n2.neighbors.add(n4);
		n2.neighbors.add(n5);
		n3.neighbors.add(n4);
		n3.neighbors.add(n5);
		
		ArrayList<DirectedGraphNode> graph = new ArrayList<DirectedGraphNode>();
		graph.add(n0);
		graph.add(n1);
		graph.add(n2);
		graph.add(n3);
		graph.add(n4);
		graph.add(n5);
		
		TopologicalSortDFS sol = new TopologicalSortDFS();
		ArrayList<DirectedGraphNode> res = sol.topSortDFS(graph);
		
		for(DirectedGraphNode n: res){
			System.out.println(n.label);
		}
		
	}

}
