package org.ashish.maze_generator_solver.entity.definition.grid;

import org.ashish.maze_generator_solver.constant.Constants;
import org.ashish.maze_generator_solver.entity.handler.MainEntityHandler;
import org.ashish.maze_generator_solver.model.GameBaseObjectCore;

import java.awt.*;

public class Node extends GameBaseObjectCore {

    public static Node[][] nodes = new Node[Constants.MAX_ROWS][Constants.MAX_COLS];

    public enum NodeType{
        start,
        end,
        path,
        block,
        none
    }
    private NodeType nodeType = NodeType.none;
    public Node(int xPos, int yPos) {
        super(xPos, yPos);

        //additional properties
        this.setSizeWidth(Constants.NODE_SIZE);
        this.setSizeHeight(Constants.NODE_SIZE);
        this.setHitBox(new Rectangle(this.getxPos(), this.getyPos(), this.getSizeWidth(), this.getSizeHeight()));
        this.setName("Node : Row : " + this.getRow() + " Col : " + this.getCol());
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        nodeColorScheme();
        g.setColor(this.getColor());
        if(this.getNodeType() == NodeType.none){
            g.drawRect(this.getxPos(), this.getyPos(), this.getSizeWidth(), this.getSizeHeight());
        }else {
            g.fillRect(this.getxPos(), this.getyPos(), this.getSizeWidth(), this.getSizeHeight());
        }

        //hitbox
        //g.setColor(Color.RED);
        //g.drawRect(this.getHitBox().x, this.getHitBox().y, this.getHitBox().width, this.getHitBox().height);

    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    private void nodeColorScheme(){
        switch (nodeType){
            case start -> this.setColor(Color.ORANGE);
            case block -> this.setColor(Color.RED);
            case path -> this.setColor(Color.MAGENTA);
            case end -> this.setColor(Color.GREEN);
            case none -> this.setColor(Color.WHITE); //this.setColor(new Color(51, 51, 51));
        }
    }

    public static void CreateNodeGrid(){
        for(int i = 0; i < Constants.MAX_ROWS; i++){
            for(int j = 0; j < Constants.MAX_COLS; j++){
                var tempNode = new Node(j * Constants.NODE_OFFSET, i * Constants.NODE_OFFSET);

                tempNode.setRow(i);
                tempNode.setCol(j);
                tempNode.setNodeType(NodeType.none);

                if(i == 0 && j == 0){
                    tempNode.setNodeType(NodeType.start);
                }

                if(i == Constants.MAX_ROWS-1 && j == Constants.MAX_COLS-1){
                    tempNode.setNodeType(NodeType.end);
                }
                Node.nodes[i][j] = tempNode;
                MainEntityHandler.AddObjectToList(Node.nodes[i][j]);
            }
        }
    }
}
