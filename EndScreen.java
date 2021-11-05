import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author Yoyo, Carl
 * @version 2021.11.05
 */
public class EndScreen extends World
{
    int gameScore = Game.getScore();
    int gameHighScore = Game.highScore;
    
    /**
     * @author Yoyo, Carl
     * 
     * Constructor for objects of class EndScreen.
     * 
     */
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        Label end = new Label("Game Over", 60);
        addObject(end, getWidth() / 2, getHeight() / 2 - 50);
        
        Label score = new Label("Score: " + gameScore, 40);
        addObject(score, getWidth() / 2, getHeight() / 2);
        
        Label highScore = new Label("High score: " + gameHighScore, 40);
        addObject(highScore, getWidth() / 2, getHeight() / 2 + 50);
        
        StartButton sb = new StartButton();
        addObject(sb, getWidth() / 2, getHeight() / 2 + 100);
    }
}
