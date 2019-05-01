/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.GraphTraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
    public enum State {visited, unvisited}
    
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
    
    public boolean allAdjacentNodesVisted(GraphMatrix maze){
        boolean verdict = true;
        for(int[] nodePos : adjacentNodesPositions)
        {
            GraphNode node = maze.getNode(nodePos[0], nodePos[1]);
            if(node.getState() == State.unvisited)
            {
                verdict = false;
                break;
            }
        }
        return verdict;
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
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof GraphNode){
            GraphNode nodeObj = (GraphNode) obj;
            if(!(nodeObj.x == this.x &&
               nodeObj.y == this.y &&
               nodeObj.state == this.state &&
               nodeObj.value.equals(this.value)))
                return false;
            
            List<int[]> objAdjList = Arrays.asList(nodeObj.adjacentNodesPositions);
            List<int[]> thisAdjList = Arrays.asList(this.adjacentNodesPositions);
            if(objAdjList.size() != thisAdjList.size())
                return false;
            
            boolean contains = false;
            for(int[] thisAdjNode : thisAdjList){
                contains = false;
                for(int[] objAdjNode : objAdjList){
                    if((thisAdjNode[0] == objAdjNode[0]) && (thisAdjNode[0] == objAdjNode[0]))
                        contains = true;
                }
            }
            return contains;
        }
        return false;
    }
}
