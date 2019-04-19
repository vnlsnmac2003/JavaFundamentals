/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.GraphTraversal;

import java.util.ArrayList;
/**
 *
 * @author Personal
 */
public class GraphMatrix {
    GraphNode[][] matrix;
    int startNodeX;
    int startNodeY;
    int endNodeX;
    int endNodeY;
    
public GraphMatrix(GraphNode[][] matrix, int startNodeX, int startNodeY, int endNodeX, int endNodeY)
{
    this.matrix = matrix;
    this.startNodeX = startNodeX;
    this.startNodeY = startNodeY;
    this.endNodeX = endNodeX;
    this.endNodeY = endNodeY;
    setAllAdjacentNodes(matrix);
}

    /**
     * Gets Nodes that are in important areas i.e. at corners and endings to aid in faster searching. 
     * Unimportant nodes will be nodes along a path.
     * @return
     */
    public ArrayList<GraphNode> getImportantNodes()
{
    ArrayList<GraphNode>  importantNodes = new ArrayList<>();
    
    for(int x=0; x<matrix.length; x++)
    {
        for(int y=0; y<matrix[x].length; y++)
        {
            if(!matrix[x][y].getValue().equals("1")) 
            {
                if((!(!matrix[x][y-1].getValue().equals("1") && !matrix[x][y+1].getValue().equals("1"))) &&
                (!(!matrix[x-1][y].getValue().equals("1") && !matrix[x+1][y].getValue().equals("1"))))
                {
                    GraphNode node = new GraphNode(y,x,matrix[x][y].getValue());
                    importantNodes.add(node);
//                    System.out.println("Node Spotted at X: "+ x +" & Y: "+y+" - NO SIDE TOP BOTTOM AND "
//                            + "PATHS"); 
                }
            }
        }
    }
    return importantNodes;
}  

public GraphNode getNode(int x, int y)
{
    return matrix[x][y];
}

public String getNodeValue(int x, int y)
{
    return matrix[x][y].getValue();
}

public void setNodeValue(int x, int y, String value)
{
    matrix[x][y].setValue(value);
}
/**
 * Sets all the adjacent node coordinates of every node not a wall i.e. nodes with value: 'E','0' & 'S'.
 * @param matrix 
 */
public void setAllAdjacentNodes(GraphNode[][] matrix)
    {
        for(int x=0; x<matrix.length; x++)
        {
            for(int y=0; y<matrix[x].length; y++)
            {
                if(!matrix[x][y].getValue().equals("1")) 
                {
                    try
                    {
                        int counter = 0;
                        int[] west = null, east = null, south = null, north = null;
                        if(!matrix[x - 1][y].getValue().equals("1"))
                        {
                            //System.out.println("X: "+matrix[x][y].getX()+" Y: "+matrix[x][y].getY()+" Qualifies!");
                            north = new int[2];
                            north[0] = x - 1; //x value
                            north[1] = y; //y value
                            counter++;
                        }
                        if(!matrix[x + 1][y].getValue().equals("1"))
                        {
                            //System.out.println("X: "+matrix[x][y].getX()+" Y: "+matrix[x][y].getY()+" Qualifies!");
                            south = new int[2];
                            south[0] = x + 1; //x value
                            south[1] = y; //y value
                            counter++;
                        }
                        if(!matrix[x][y - 1].getValue().equals("1"))
                        {
                            //System.out.println("X: "+matrix[x][y].getX()+" Y: "+matrix[x][y].getY()+" Qualifies!");
                            west = new int[2];
                            west[0] = x; //x value
                            west[1] = y - 1; //y value
                            counter++;
                        }
                        if(!matrix[x][y + 1].getValue().equals("1"))
                        {
                            //System.out.println("X: "+matrix[x][y].getX()+" Y: "+matrix[x][y].getY()+" Qualifies!");
                            east = new int[2];
                            east[0] = x; //x value
                            east[1] = y + 1; //y value
                            counter++;
                        }
                        if(counter > 0)
                        {
                            int[][] adjacentNodes = new int[counter][2];
                            for(int i=0; i<counter; i++)
                            {
                                if(west != null)
                                {
                                    adjacentNodes[i] = west;
                                    west = null;
                                }
                                else if(east != null)
                                {
                                    adjacentNodes[i] = east;
                                    east = null;
                                }
                                else if(south != null)
                                {
                                    adjacentNodes[i] = south;
                                    south = null;
                                }
                                else if(north != null)
                                {
                                    adjacentNodes[i] = north;
                                    north = null;
                                }
                            }
                            //System.out.println("Adjacent Nodes for X: "+matrix[x][y].getX()+" Y: "+matrix[x][y].getY()+" - "+Arrays.toString(adjacentNodes));
                            matrix[x][y].setAdjacentNodesPositions(adjacentNodes);
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException | NullPointerException ex){ }
                }
            }
        }
    }

    public GraphNode getStartNode()
    {
        return matrix[startNodeX][startNodeY];
    }
    
    public GraphNode getEndNode()
    {
        return matrix[endNodeX][endNodeY];
    }
    
    /**
     * Prints the matrix grid
     */
    public void printMatrix(){
        for(GraphNode[] row : matrix)
        {
            String mazeRow = "";
            for(GraphNode cell : row)
            {
                mazeRow += cell.getValue();
            }
            System.out.println(mazeRow);
        }
    }
    
    /**
     * Sets the value of the route nodes from 'S' to 'E' (excluding them) with the letter 'X'
     * @param list 
     */
    public void setRoute(int[][] list)
    {
        for(int i=0; i<list.length; i++)
        {
            if( (i == 0) || (i == list.length-1) ) //skip beginning and end nodes
                continue;
            setNodeValue(list[i][0], list[i][1], "X");
        }
        
    }
}

