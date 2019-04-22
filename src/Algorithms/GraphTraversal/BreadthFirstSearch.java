/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.GraphTraversal;

import Algorithms.GraphTraversal.GraphNode.State;
import static Algorithms.GraphTraversal.MazeReader.getGraphMatrixFromFile;
import java.util.Arrays;

/**
 *
 * @author Personal
 */
public class BreadthFirstSearch {
    
    public static void main (String args[]){
        GraphMatrix matrix = getGraphMatrixFromFile();
        matrix.setRoute(getQuickestRoute(matrix));
        matrix.printMatrix();
    }
    
    /**
     * Gets the quickest route from 'S' to 'E' using the Breadth First Search technique
     * @param maze
     * @return the quickest route from 'S' node to 'E' node
     */
    public static int[][] getQuickestRoute(GraphMatrix maze)
    {
        int[][] route = null;
        if(maze != null)
        {
            route = new int[1][2];
            route[0][0] = maze.getStartNode().getX();
            route[0][1] = maze.getStartNode().getY();
            
            for(int i = 0; i<route.length; i++)
            {
                GraphNode nextNode = maze.getNode(route[i][0], route[i][1]);
                if(nextNode.getState() == State.visited)
                    continue;
                nextNode.setState(State.visited);
                int [][] adjacentNodeList = new int[0][];
                for(int[] nodeXY : nextNode.getAdjacentNodesPositions())
                {
                    if(maze.getNode(nodeXY[0], nodeXY[1]).getState() == State.unvisited)
                    {
                        adjacentNodeList = Arrays.copyOf(adjacentNodeList, adjacentNodeList.length+1);
                        adjacentNodeList[adjacentNodeList.length-1] = new int[]{nodeXY[0],nodeXY[1]};
                    }
                }
                if(adjacentNodeList.length > 0)
                {
                    int startPosition = route.length;
                    int routeArrayLength = startPosition + adjacentNodeList.length;
                    
                    route = Arrays.copyOf(route, routeArrayLength);
                    for(int j = 0; j<adjacentNodeList.length; j++)
                    {
                        route[startPosition+j] = new int[] {adjacentNodeList[j][0], adjacentNodeList[j][1]};
                        if(maze.getNodeValue(route[startPosition+j][0], route[startPosition+j][1]).equals("E"))
                        {
                            maze.getNode(route[startPosition+j][0], route[startPosition+j][1]).setState(State.visited);
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
     * @param array
     * @return a route from 'E' node to 'S' node
     */
    public static int[][] getRouteFromArray(int[][] array)
    {
        int[][] route = new int[1][2];
        route[0][0] = array[array.length-1][0];
        route[0][1] = array[array.length-1][1];
        
        int[] currentNode = route[0];
        for(int i = array.length-2; i>=0; i--)
        {
            if(array[i][0] == currentNode[0])//check current and compared node have same x value 
            { 
                if(((currentNode[1] - 1) == array[i][1]) || ((currentNode[1] + 1) == array[i][1])) //if node is above or below it
                {
                    route = Arrays.copyOf(route, route.length+1);//copy into route array
                    currentNode = array[i];
                    route[route.length-1] = currentNode;
                }
            }
            else if(array[i][1] == currentNode[1])
            {
                if(((currentNode[0] - 1) == array[i][0]) || ((currentNode[0] + 1) == array[i][0])) //if node is left or right of it
                {
                    route = Arrays.copyOf(route, route.length+1);//copy into route array
                    currentNode = array[i];
                    route[route.length-1] = currentNode;
                }
            }
        }
        
        return reverseArray(route);
    }
    
    /**
     * reverses the array given
     * @param route
     * @return a reversed 2D array
     */
    public static int[][] reverseArray(int[][] route)
    {
        int[][] orderedRoute = new int[route.length][]; //
        int counter = 0;
        for(int i=route.length - 1; i>=0; i--)
        {
            orderedRoute[counter] = route[i];
            counter++;
        }
        
        return orderedRoute;
    }
    
//    public static void addNodeToRoute(int[][] route, int[] array, int[] currentNode){
//        route = Arrays.copyOf(route, route.length+1);//copy into route array
//        currentNode = array;
//        route[route.length-1] = currentNode;
//    }
}
