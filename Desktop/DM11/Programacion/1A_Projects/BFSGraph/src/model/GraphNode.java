package model;

import java.util.ArrayList;

public class GraphNode<V> {

    public V value;
    public String color;
    public int distance;
    public GraphNode<V> predecessor;
    public ArrayList<GraphNode<V>> adjacency;

    public GraphNode(V value){
        this.value = value;
        this.color = null;
        this.distance = 0;
        this.predecessor = null;
        this.adjacency = new ArrayList<>();
    }

    public void addAdjacency(GraphNode<V> node){
        adjacency.add(node);
    }

    public boolean adjacencyExists(GraphNode<V> node){
        for (GraphNode<V> n:
             adjacency) {
            if(n.equals(node)){
                return true;
            }
        }
        return false;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public ArrayList<GraphNode<V>> getAdjacency() {
        if(adjacency!=null){
            return adjacency;
        } else {
            return null;
        }
    }

    public void setAdjacency(ArrayList<GraphNode<V>> adjacency) {
        this.adjacency = adjacency;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public GraphNode<V> getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(GraphNode<V> predecessor) {
        this.predecessor = predecessor;
    }
}
