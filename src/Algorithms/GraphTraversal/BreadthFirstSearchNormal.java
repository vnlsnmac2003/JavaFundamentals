/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.GraphTraversal;

import Algorithms.GraphTraversal.GraphNode.State;
import static Algorithms.GraphTraversal.MazeReader.getGraphMatrixFromFile;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Personal
 */
public class BreadthFirstSearchNormal {
    
      
    public static void main (String args[]){
        GraphMatrix matrix = getGraphMatrixFromFile();
        matrix.setRoute(getQuickestRoute(matrix));
        matrix.printMatrix();
    }
    
    /**
     * Gets the quickest route from 'S' to 'E' using the Breadth First Search technique
     * @param maze - maze matrix with start and end point
     * @return the quickest route from 'S' node to 'E' node Or null if a null maze is given
     */
    public static ArrayList<GraphNode> getQuickestRoute(GraphMatrix maze)
    {
        ArrayList<GraphNode> route = null;
        
        if(maze != null)
        {
            route = new ArrayList<>();
            //get start node and add to route list
            GraphNode startNode = maze.getStartNode();
            route.add(startNode);
            //iterate through node/s in route list that hasn't been visited
            
            for(int i = 0; i<route.size(); i++)
            {
                GraphNode nextNode = route.get(i);
                if(nextNode.getState() == State.visited)
                    continue;
                nextNode.setState(State.visited);
                //Add all adjacent nodes that haven't been visited
                for(int[] adjNodePos: nextNode.getAdjacentNodesPositions())
                {
                    GraphNode adjNode = maze.getNode(adjNodePos[0], adjNodePos[1]);
                    if(adjNode.getState() == State.unvisited)
                    {
                        route.add(adjNode);
                        if(adjNode.getValue().equals("E"))
                        {
                            adjNode.setState(State.visited);
                            return getRouteFromArray(route);
                        }
                    }
                }
            }
        }
        return route;
    }
    
    /**
     * Gets a direct route from the end point to the start point selecting from a list of path nodes given in an array
     * Does this by starting from the last node and checking the list for nodes next to it in any direction. It does this
     * till it reaches the start node and returns the route found
     * @param array - array containing a valid route 
     * @return a route from 'E' node to 'S' node
     */
    public static ArrayList<GraphNode> getRouteFromArray(ArrayList<GraphNode> array)
    {
        ArrayList<GraphNode> route = new ArrayList<>();
        GraphNode currentNode = array.get(array.size()-1);
        route.add(currentNode);
        
        for(int i = array.size()-2; i>=0; i--)
        {
            if(array.get(i).getX() == currentNode.getX())//check current and compared node have same x value 
            { 
                if(((currentNode.getY() - 1) == array.get(i).getY()) || ((currentNode.getY() + 1) == array.get(i).getY())) //if node is above or below it
                {
                    currentNode = array.get(i);
                    route.add(currentNode);//copy into route array
                    
                }
            }
            else if(array.get(i).getY() == currentNode.getY())
            {
                if(((currentNode.getX() - 1) == array.get(i).getX()) || ((currentNode.getX() + 1) == array.get(i).getX())) //if node is left or right of it
                {
                    currentNode = array.get(i);
                    route.add(currentNode);//copy into route array
                }
            }
        }
        
        Collections.reverse(route);
        
        return route;
    }
    
}
