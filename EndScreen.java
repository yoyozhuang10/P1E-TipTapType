import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Endscreen world
 * 
 * @author Yoyo, Jayden
 * @version 2021.11.05
 */
public class EndScreen extends World
{
    int x = getWidth()/2; 
    int y = getHeight()/2;
    
    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    public EndScreen()
    {    
        // Create a new world with 800x450 cells with a cell size of 1x1 pixels.
        super(800, 450, 1); 
        setBackground(new GreenfootImage("endbackgroundsmall.png"));
        
        //Add score labels
        Label gameOver = new Label("Game Over!", 75);
        Label gameOver2 = new Label("Press Space to play again", 40);
        Label score = new Label("Score: " + Game.score, 50);
        Label highScore = new Label("High Score: " + Game.highScore, 50);
        addObject(gameOver, x, 100);
        addObject(gameOver2, x, 160);
        addObject(score, x, y+50);
        addObject(highScore, x, y+150);
        
        //Add statistic labels
        Label wpm = new Label("Words per minute: " + Game.score * 2, 25);
        addObject(wpm, 130, 40);
 
    }
    
    //Play again if user presses key
    public void act()
    {
        if ("space".equals(Greenfoot.getKey()))
        {
            Countdown cd = new Countdown();
            Greenfoot.setWorld(cd);
        }
    }
}
