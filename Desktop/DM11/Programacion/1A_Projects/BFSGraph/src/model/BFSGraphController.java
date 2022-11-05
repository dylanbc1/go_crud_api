package model;

import java.util.ArrayList;

public class BFSGraphController<V> {

    public Graph<V> graph;

    public BFSGraphController(){
         graph = new Graph<>();
    }

    public boolean insertNode(V value){
        if(graph.exists(value)!=null){
            return false;
        } else {
            GraphNode<V> node = new GraphNode<V>(value);
            return graph.insertNode(node);
        }
    }

    public boolean addAdjacency(V value1, V value2){
        if(graph.exists(value1)!=null && graph.exists(value2)!=null){
            GraphNode<V> node1 = graph.exists(value1);
            GraphNode<V> node2 = graph.exists(value2);

            if(graph.adjacencyExists(node1, node2)){
                return false;
            }

            graph.addAdjacency(node1, node2);
            return true;
        }
        return false;
    }

    public boolean stronglyConnectedBFS(){
        for (int i = 0; i < graph.graphNodes.size(); i++) {
            graph.BFS(i);
            if(!graph.verifyBlack()){
                return false;
            }
        }
        return true;
    }

    public boolean clear(){
        return graph.clear();
    }
}
