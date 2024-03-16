package org.ashish.maze_generator_solver.display;

import org.ashish.maze_generator_solver.Main;
import org.ashish.maze_generator_solver.constant.Constants;

import javax.swing.*;
import java.awt.*;

public class Window {
    JFrame frame;
    Main main;

    public Window(Main mainParam) {
        this.main = mainParam;
        init();
    }

    private void init(){
        if(this.frame == null){
            this.frame = new JFrame();
        }

        this.frame.setTitle("Maze-Generator-Solver");

        this.frame.setPreferredSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        this.frame.setMaximumSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        this.frame.setMinimumSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);

        this.frame.setVisible(true);

        this.frame.add(this.main);
        this.frame.pack();
    }


}
