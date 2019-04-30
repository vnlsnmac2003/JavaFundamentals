/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 *
 * @author Personal
 */
public class BinarySearchTree {

   

    /**
     * Rules:
     * - No duplicates are allowed 
     */
    
    NumericNode root;
    
    public BinarySearchTree(){}
    
    public NumericNode getRoot()
    {
        return root;
    }
    
    public void addNode(NumericNode node)
    {
        if(root == null)
            root = node;
        else
        {
            NumericNode currentNode = root;
            while(true)
            {
                if(node.getValue() < currentNode.getValue())
                {
                    if(currentNode.getLeftNode() == null)
                    {
                        currentNode.setLeftNode(node);
                        return;
                    }
                    else 
                    {
                        currentNode = currentNode.getLeftNode();
                    }
                }
                else if(node.getValue() > currentNode.getValue())
                {
                    if(currentNode.getRightNode() == null)
                    {
                        currentNode.setRightNode(node);
                        return;
                    }
                    else
                    {
                        currentNode = currentNode.getRightNode();
                    }
                }
            }
        }
    }
    
    public void printNode(NumericNode node)
    {
        System.out.println("Node value: "+node.getValue());
    }
    
    public void inOrderTraversal(NumericNode node)
    {
        if(node != null)
        {
            //System.out.println("Running traversal method on Left Child: "+ ((node.getLeftNode() == null) ? null : node.getLeftNode().getValue()));
            inOrderTraversal(node.getLeftNode());
            printNode(node);
            //System.out.println("Running traversal method on Right Child: "+ ((node.getRightNode() == null) ? null : node.getRightNode().getValue()));
            inOrderTraversal(node.getRightNode());
        }
    }
    
    public void preOrderTraversal(NumericNode node)
    {
        if(node != null)
        {
            printNode(node);
            //System.out.println("Running traversal method on Left Child: "+ ((node.getLeftNode() == null) ? null : node.getLeftNode().getValue()));
            preOrderTraversal(node.getLeftNode());
            //System.out.println("Running traversal method on Right Child: "+ ((node.getRightNode() == null) ? null : node.getRightNode().getValue()));
            preOrderTraversal(node.getRightNode());
        }
    }
    
    public void postOrderTraversal(NumericNode node)
    {
        if(node != null)
        {
            //System.out.println("Running traversal method on Left Child: "+ ((node.getLeftNode() == null) ? null : node.getLeftNode().getValue()));
            postOrderTraversal(node.getLeftNode());
            //System.out.println("Running traversal method on Right Child: "+ ((node.getRightNode() == null) ? null : node.getRightNode().getValue()));
            postOrderTraversal(node.getRightNode());
            printNode(node);
        }
    }
    
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        
        tree.addNode(new NumericNode(1));
        tree.addNode(new NumericNode(10));
        tree.addNode(new NumericNode(9));
        tree.addNode(new NumericNode(6));
        tree.addNode(new NumericNode(15));
        tree.addNode(new NumericNode(3));
        
        System.out.println("IN ORDER TRAVERSAL");
        tree.inOrderTraversal(tree.getRoot());
        System.out.println("");
        System.out.println("PRE ORDER TRAVERSAL");
        tree.preOrderTraversal(tree.getRoot());
        System.out.println("");
        System.out.println("POST ORDER TRAVERSAL");
        tree.postOrderTraversal(tree.getRoot());
    }
}
