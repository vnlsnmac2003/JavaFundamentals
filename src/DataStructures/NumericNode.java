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
public class NumericNode {
    
    private int value;
    private NumericNode leftNode;
    private NumericNode rightNode;
    
    public NumericNode(int value){
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NumericNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(NumericNode leftNode) {
        this.leftNode = leftNode;
    }

    public NumericNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(NumericNode rightNode) {
        this.rightNode = rightNode;
    }
    
    
}
