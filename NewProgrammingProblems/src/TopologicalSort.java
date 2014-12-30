import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


 class DirectedGraphNode {
     int label;
     ArrayList<DirectedGraphNode> neighbors;
     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 };
 
public class TopologicalSort {

	
	
	public ArrayList<DirectedGraphNode> topSortBFS(ArrayList<DirectedGraphNode> graph) {
		if(graph==null||graph.size()<2) return graph;

		HashMap<DirectedGraphNode, Set<DirectedGraphNode>> inverted = new HashMap<DirectedGraphNode,Set<DirectedGraphNode>>();
		for(DirectedGraphNode node: graph){
			for(DirectedGraphNode neighbor: node.neighbors){
				if(inverted.containsKey(neighbor)){
					inverted.get(neighbor).add(node);
				}else{
					Set<DirectedGraphNode> incomingNodes = new HashSet<DirectedGraphNode>();
					incomingNodes.add(node);
					inverted.put(neighbor, incomingNodes);
				}
			}
		}
		LinkedList<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
		for(DirectedGraphNode node: graph){
			if(!inverted.containsKey(node)){
				queue.offer(node);
			}
		}
		ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
		
		while(!queue.isEmpty()){
			DirectedGraphNode cur = queue.poll();
			res.add(cur);
			for(DirectedGraphNode neighbor: cur.neighbors){
				if(inverted.containsKey(neighbor)){
					inverted.get(neighbor).remove(cur);
					if(inverted.get(neighbor).isEmpty()){
						queue.offer(neighbor);
						inverted.remove(neighbor);
					}
				}
			}
		}
		return res;
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
