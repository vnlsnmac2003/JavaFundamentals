/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.GraphTraversal;


/**
 *
 * @author Personal
 */
public class GraphNode {
    
    private final int x;
    private final int y;
    private int[][] adjacentNodesPositions;
    private String value;
    private State state;
    enum State {visited, unvisited}
    
    public GraphNode(int x, int y, String value){
        this.x = x;
        this.y = y;
        this.value = value;
        this.state = State.unvisited;
    }
    
    /**
     * Sets all nodes adjacent to node
     * @param adjacentNodes 
     */
    public void setAdjacentNodesPositions(int[][] adjacentNodes){
        this.adjacentNodesPositions = adjacentNodes;
    }
    
    /**
     * Gets all adjacent nodes
     * @return list of adjacent node coordinates
     */
    public int[][] getAdjacentNodesPositions(){
        return adjacentNodesPositions;
    }
    
    public String getValue(){
        return value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    
    
}
