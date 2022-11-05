package model;

import java.util.ArrayList;
import queue.Queue;
import queue.QueueNode;

public class Graph <V>{

    public ArrayList<GraphNode<V>> graphNodes;
    public Queue<GraphNode<V>> queue;

    public Graph(){
        graphNodes = new ArrayList<>();
        queue = new Queue<>();
    }

    public boolean insertNode(GraphNode<V> node){
        this.graphNodes.add(node);
        return true;
    }

    public GraphNode<V> exists(V value){
        if(graphNodes!=null){
            for (GraphNode<V> node: graphNodes) {
                if(node.getValue().equals(value)){
                    return node;
                }
            }
            return null;
        }
        return null;
    }

    public void BFS(int index){
        if(graphNodes.get(index)!=null){
            GraphNode<V> node = graphNodes.get(index);

            for (int i = 0; i < graphNodes.size(); i++) {
                if(!(i==index)){
                    graphNodes.get(i).setColor("W");
                    graphNodes.get(i).setDistance(0);
                    graphNodes.get(i).setPredecessor(null);
                }
            }

            node.setColor("G");
            node.setDistance(0);
            node.setPredecessor(null);

            QueueNode<GraphNode<V>> queueNode = new QueueNode<>(node);
            this.queue.offer(queueNode);

            while (!this.queue.isEmpty()){
                GraphNode<V> auxiliar = this.queue.poll();

                for (GraphNode<V> n :
                        auxiliar.getAdjacency()) {
                    if (n.getColor().equalsIgnoreCase("W")) {
                        n.setColor("G");
                        n.setDistance(auxiliar.getDistance() + 1);
                        n.setPredecessor(auxiliar);
                        QueueNode<GraphNode<V>> queueNode2 = new QueueNode<>(n);
                        this.queue.offer(queueNode2);
                    } // if
                } // for

                auxiliar.setColor("B");
            } // while
        } // if
    }

    public boolean verifyBlack(){
        boolean runFlag = true;

        for (GraphNode<V> node:
             graphNodes) {
            if (!node.getColor().equalsIgnoreCase("B")) {
                runFlag = false;
            }
        } // for

        return runFlag;
    }

    public boolean clear(){
        graphNodes.clear();
        return true;
    }

    public boolean adjacencyExists(GraphNode<V> node, GraphNode<V> node2){
        return node.adjacencyExists(node2);
    }

    public void addAdjacency(GraphNode<V> node, GraphNode<V> node2){
        node.addAdjacency(node2);
    }

    public ArrayList<GraphNode<V>> getGraphNodes() {
        return graphNodes;
    }

    public void setGraphNodes(ArrayList<GraphNode<V>> graphNodes) {
        this.graphNodes = graphNodes;
    }
}
