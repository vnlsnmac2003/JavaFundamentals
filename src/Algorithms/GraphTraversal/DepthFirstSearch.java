/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.GraphTraversal;

import Algorithms.GraphTraversal.GraphNode.State;
import java.util.LinkedList;

/**
 *
 * @author Personal
 */
public class DepthFirstSearch {
    
    public static LinkedList<GraphNode> getValidRoute(GraphMatrix maze)
    {
        LinkedList<GraphNode> validRoute = new LinkedList<>();
        GraphNode startNode = maze.getStartNode();
        startNode.setState(State.visited);
        validRoute.add(startNode);
        return traverse(validRoute, maze);
    }
    
    public static LinkedList<GraphNode> traverse(LinkedList<GraphNode> validRoute, GraphMatrix maze)
    {
        if(validRoute.getLast().getValue().equals("S"))
        {
            if(validRoute.getLast().allAdjacentNodesVisted(maze))
                throw new IllegalArgumentException("Maze has no valid route within it");
        }
        
        for(int[] adjNodesXY : validRoute.getLast().getAdjacentNodesPositions())
        {
            if(validRoute.getLast().getValue().equals("E"))
                return validRoute;
            
            GraphNode nextNode = maze.getNode(adjNodesXY[0], adjNodesXY[1]);
            if(nextNode.getState() == State.unvisited)
            {
                nextNode.setState(State.visited);
                validRoute.add(nextNode);
                
                if(nextNode.getValue().equals("E"))
                    return validRoute;
                
                while(validRoute.getLast().allAdjacentNodesVisted(maze))
                    validRoute.removeLast();
                
                validRoute = traverse(validRoute,maze);
            }
        }
        return validRoute;
    }
    
    public static void main(String[] args) {
        GraphMatrix maze = MazeReader.getGraphMatrixFromFile();
        LinkedList route = getValidRoute(maze);
        maze.setRoute(route);
        maze.printMatrix();
    }
}
