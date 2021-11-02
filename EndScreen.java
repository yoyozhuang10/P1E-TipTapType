import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends World
{

    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        Label end = new Label("Game Over", 60);
        addObject(end, getWidth() / 2, getHeight() / 2 - 50);
        
        Label score = new Label("Score: " + " 3", 40);
        addObject(score, getWidth() / 2, getHeight() / 2);
        
        Label highScore = new Label("High score: " + "6", 40);
        addObject(highScore, getWidth() / 2, getHeight() / 2 + 50);
        
        StartButton sb = new StartButton();
        addObject(sb, getWidth() / 2, getHeight() / 2 + 100);
    }
}
