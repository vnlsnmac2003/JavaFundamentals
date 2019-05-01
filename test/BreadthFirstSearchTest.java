/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Algorithms.GraphTraversal.BreadthFirstSearch;
import Algorithms.GraphTraversal.BreadthFirstSearchNormal;
import Algorithms.GraphTraversal.DepthFirstSearch;
import Algorithms.GraphTraversal.GraphMatrix;
import Algorithms.GraphTraversal.GraphNode;
import Algorithms.GraphTraversal.GraphNode.State;
import static Algorithms.GraphTraversal.MazeReader.getGraphMatrixFromFile;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Personal
 */
public class BreadthFirstSearchTest {
    
    public static GraphMatrix maze;
    
    public BreadthFirstSearchTest(){
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        maze = getGraphMatrixFromFile();
    }
    
    @After
    public void tearDown() {
    }

    
//     TODO add test methods here.
//     The methods must be annotated with annotation @Test. For example:
    
     @Test
     public void validRouteBFS() {
         
         int[][] quickestRoute = {{1,1},{1,2},{1,3},{2,3},{3,3},{4,3}};
         Assert.assertArrayEquals(quickestRoute, BreadthFirstSearch.getQuickestRoute(maze));
     }
     
     @Test
     public void validRouteBFSNormal() {
         //W,E,S,N
         ArrayList<GraphNode> quickestRoute = new ArrayList<>();
         
         GraphNode startNode = new GraphNode(1,1,"S");
         startNode.setAdjacentNodesPositions(new int[][]{{1,2},{2,1}});
         startNode.setState(State.visited);
         
         GraphNode node2 = new GraphNode(1,2,"0");
         node2.setAdjacentNodesPositions(new int[][]{{1,1},{1,3}});
         node2.setState(State.visited);
         
         GraphNode node3 = new GraphNode(1,3,"0");
         node3.setAdjacentNodesPositions(new int[][]{{1,2},{2,3}});
         node3.setState(State.visited);
         
         GraphNode node4 = new GraphNode(2,3,"0");
         node4.setAdjacentNodesPositions(new int[][]{{3,3},{1,3}});
         node4.setState(State.visited);
         
         GraphNode node5 = new GraphNode(3,3,"0");
         node5.setAdjacentNodesPositions(new int[][]{{4,3},{2,3}});
         node5.setState(State.visited);
         
         GraphNode endNode = new GraphNode(4,3,"E");
         endNode.setAdjacentNodesPositions(new int[][]{{3,3}});
         endNode.setState(State.visited);
         
         quickestRoute.add(startNode);
         quickestRoute.add(node2);
         quickestRoute.add(node3);
         quickestRoute.add(node4);
         quickestRoute.add(node5);
         quickestRoute.add(endNode);
         
         Assert.assertEquals(quickestRoute, BreadthFirstSearchNormal.getQuickestRoute(maze));
     }
     
     @Test
     public void validRouteDFS() {
         //W,E,S,N
         ArrayList<GraphNode> validRoute = new ArrayList<>();
         
         GraphNode startNode = new GraphNode(1,1,"S");
         startNode.setAdjacentNodesPositions(new int[][]{{1,2},{2,1}});
         startNode.setState(State.visited);
         
         GraphNode node2 = new GraphNode(1,2,"0");
         node2.setAdjacentNodesPositions(new int[][]{{1,1},{1,3}});
         node2.setState(State.visited);
         
         GraphNode node3 = new GraphNode(1,3,"0");
         node3.setAdjacentNodesPositions(new int[][]{{1,2},{2,3}});
         node3.setState(State.visited);
         
         GraphNode node4 = new GraphNode(2,3,"0");
         node4.setAdjacentNodesPositions(new int[][]{{3,3},{1,3}});
         node4.setState(State.visited);
         
         GraphNode node5 = new GraphNode(3,3,"0");
         node5.setAdjacentNodesPositions(new int[][]{{4,3},{2,3}});
         node5.setState(State.visited);
         
         GraphNode endNode = new GraphNode(4,3,"E");
         endNode.setAdjacentNodesPositions(new int[][]{{3,3}});
         endNode.setState(State.visited);
         
         validRoute.add(startNode);
         validRoute.add(node2);
         validRoute.add(node3);
         validRoute.add(node4);
         validRoute.add(node5);
         validRoute.add(endNode);
         
         Assert.assertEquals(validRoute, DepthFirstSearch.getValidRoute(maze));
     }
}
