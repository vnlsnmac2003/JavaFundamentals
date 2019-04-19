/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.GraphTraversal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
/**
 *
 * @author Personal
 */
public class MazeReader {
    
    static File mazeFile;
    static JFileChooser fileSelector = new JFileChooser();
    
    /**
     * Reads a maze file selected by JFile Chooser provided. Reads file and creates a GraphMatrix 
     * @return GraphMatrix of maze provided
     */
    public static GraphMatrix getGraphMatrixFromFile()
    {
        GraphNode[][] graph = null;
        GraphMatrix graphMatrix = null;
        int startNodeX = 0;
        int startNodeY = 0;
        int endNodeX = 0;
        int endNodeY = 0;
        if(JFileChooser.APPROVE_OPTION == fileSelector.showOpenDialog(null))
        {
            mazeFile = fileSelector.getSelectedFile();
            BufferedReader fileReader;
            try 
            {
                fileReader = new BufferedReader(new FileReader(mazeFile));
                String line;
                int counter = 0;
                int matrixNoOfYs = 0;
                int matrixNoOfXs = 0;
                int matrixRowCounter = 0;
                try {
                    while((line = fileReader.readLine()) != null)
                    {
                        switch (counter) 
                        {
                            case 0:
                                matrixNoOfYs = Integer.parseInt(line.split(" ")[0]);
                                matrixNoOfXs = Integer.parseInt(line.split(" ")[1]);
                                break;
                            case 1:
                                startNodeX = Integer.parseInt(line.split(" ")[1]);
                                startNodeY = Integer.parseInt(line.split(" ")[0]);
                                break;
                            case 2:
                                endNodeX = Integer.parseInt(line.split(" ")[1]);
                                endNodeY = Integer.parseInt(line.split(" ")[0]);
                                graph = new GraphNode[matrixNoOfXs][matrixNoOfYs];
                                break;
                            default:
                                if(graph != null)
                                {
                                    for(int y=0; y<matrixNoOfYs; y++)
                                    {
                                        String nodeValue;
                                        if(matrixRowCounter == startNodeX && y == startNodeY)
                                        {
                                            nodeValue = "S";
                                        }
                                        else if(matrixRowCounter == endNodeX && y == endNodeY)
                                        {
                                            nodeValue = "E";
                                        }
                                        else
                                        {
                                            nodeValue = line.split(" ")[y];
                                        }
                                        GraphNode currentNode = new GraphNode(matrixRowCounter,y,nodeValue);
                                        graph[matrixRowCounter][y] = currentNode;
                                    }
                                    matrixRowCounter++;
                                }
                                break;
                        }
                        counter++;
                    }
                    graphMatrix = (graph != null) ? new GraphMatrix(graph,startNodeX,startNodeY,endNodeX,endNodeY) : graphMatrix;
                } 
                catch (IOException ex) 
                {
                    ex.printStackTrace();
                }
            } 
            catch (FileNotFoundException ex) 
            {
                ex.printStackTrace();
            }
        }
        return graphMatrix;          
    }
    
}
