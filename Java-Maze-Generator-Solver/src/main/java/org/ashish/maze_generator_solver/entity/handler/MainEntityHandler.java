package org.ashish.maze_generator_solver.entity.handler;

import org.ashish.maze_generator_solver.model.GameBaseObjectCore;

import java.awt.*;
import java.util.ArrayList;

public class MainEntityHandler {
    public static ArrayList<GameBaseObjectCore> allObjectsList = new ArrayList<>();

    public void tick(){
        if(allObjectsList.size() > 0){
            for(int i = 0; i < allObjectsList.size(); i++){
                allObjectsList.get(i).tick();
            }
        }
    }

    public void render(Graphics g){
        if(allObjectsList.size() > 0){
            for(int i = 0; i < allObjectsList.size(); i++){
                allObjectsList.get(i).render(g);
            }
        }
    }

    public static void AddObjectToList(GameBaseObjectCore tempObj){
        if(!allObjectsList.contains(tempObj)){
            allObjectsList.add(tempObj);
        }
    }

    public static void RemoveObjectFromList(GameBaseObjectCore tempObj){
        if(allObjectsList.contains(tempObj)){
            allObjectsList.remove(tempObj);
        }
    }
}
