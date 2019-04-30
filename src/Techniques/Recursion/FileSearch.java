/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Techniques.Recursion;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 *
 * @author Personal
 */
public class FileSearch {
    
    public static String getFileOrDirectoryPath(){
        String path = "";
        JFileChooser fileSelector = new JFileChooser();
        fileSelector.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        if(JFileChooser.APPROVE_OPTION == fileSelector.showOpenDialog(null))
        {
            path = fileSelector.getSelectedFile().getAbsolutePath();
        }
        else
        {
            throw new IllegalArgumentException("File not selected");
        }
        return path;
    }
    
    
    public static ArrayList<String> printFileContentNames(String fileLocation){
        ArrayList<String> filePaths = new ArrayList<>();
        
        File file = new File(fileLocation);
        if(Files.isRegularFile(file.toPath())){
            //base case
            try {
                filePaths.add(file.getCanonicalPath());
            } catch (IOException ex) {
                System.err.println("Cannot retrieve filepath for invalid file: "+file.getPath());
            }
        }
        else if(Files.isDirectory(file.toPath())){
            for(File f: file.listFiles()){
                try {
                    filePaths.addAll(printFileContentNames(f.getCanonicalPath()));
                } catch (IOException ex) {
                    System.err.println("Cannot retrieve filepath for invalid file/folder: "+file.getPath());
                }
            }
        }
        return filePaths;
    }
    
    public static void main(String[] args){
        printFileContentNames(getFileOrDirectoryPath()).forEach((path) -> {
            System.out.println(path);
        });
    }
}
