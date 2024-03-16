package org.ashish.maze_generator_solver;

import org.ashish.maze_generator_solver.constant.Constants;
import org.ashish.maze_generator_solver.display.Window;
import org.ashish.maze_generator_solver.entity.definition.grid.Node;
import org.ashish.maze_generator_solver.entity.handler.MainEntityHandler;

import java.awt.*;

public class Main extends Canvas implements Runnable {
    //Thread
    private Thread thread;

    //Window
    private Window window;
    private boolean isRunning = false;

    //Handler
    private MainEntityHandler mainEntityHandler;

    public Main(){
        init();
    }

    public static void main(String[] args) {
        //System.out.println("Hello world!");
        new Main();
    }

    private void init(){
        //Window
        if(this.window == null){
            this.window = new Window(this);
        }


        //Thread
        if(this.thread == null){
            this.thread = new Thread(this, "Additional_Thread_1");
        }

        //Handler
        if(this.mainEntityHandler == null){
            this.mainEntityHandler = new MainEntityHandler();
        }

        Node.CreateNodeGrid();

        this.start();

    }

    private synchronized void start(){
        if(this.isRunning){
            return;
        }

        if(this.thread != null){
            this.thread.start();
        }
        this.isRunning = true;
    }

    private synchronized void stop(){
        if(!this.isRunning){
            return;
        }

        if(this.thread != null){
            try{
                this.thread.join();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        this.isRunning = false;
    }

    @Override
    public void run(){
        mainLoop();
    }

    private void mainLoop(){
        //1. get last loop time and last fps time
        long lastLoopTime = System.nanoTime();
        long lastFPSTime = 0;

        while(this.isRunning){
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;

            double delta = updateLength / ((double) Constants.OPTIMAL_TIME);

            lastFPSTime += updateLength;
            if (lastFPSTime >= 1000000000) {
                lastFPSTime = 0;
            }

            // Update game logic based on delta
            tick();

            // Repaint or render the game
            render();



            try {
                // Sleep to maintain frame rate
                long gameTime = (lastLoopTime - System.nanoTime() + Constants.OPTIMAL_TIME) / 1000000;
                Thread.sleep(gameTime);
            } catch (Exception e) {
                // Handle exceptions
                this.isRunning = false;
            }
        }
        stop();
    }

    private void tick(){
        //additional tick calls go here
        if(this.mainEntityHandler != null){
            this.mainEntityHandler.tick();
        }
    }

    private void render(){
        var bs = this.getBufferStrategy();

        if(bs == null){
            this.createBufferStrategy(03);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        //g.setColor(new Color(88, 24, 69));
        g.fillRect(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

        //additional render calls go here
        if(this.mainEntityHandler != null){
            this.mainEntityHandler.render(g);
        }


        bs.show();
        g.dispose();
    }


}