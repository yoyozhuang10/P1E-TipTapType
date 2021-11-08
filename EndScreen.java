import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author Yoyo
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
        Label gameOver = new Label("Game Over!\nPress Space to play", 75);
        Label score = new Label("Score: " + Game.score, 50);
        Label highScore = new Label("High Score: " + Game.highScore, 50);
        addObject(gameOver, x, y-100);
        addObject(score, x, y+50);
        addObject(highScore, x, y+150);
        
        //Add statistic labels
        Label wpm = new Label("Words per minute: " + Game.score * 2, 20);
        addObject(wpm, 100, 100);
 
    }
    
    public void act()
    {
        if ("space".equals(Greenfoot.getKey()))
        {
            Game game = new Game();
            // Reset everything to prevent bugs
            Game.score = -1; // Score, set to -1 since updateScore() increases score by 1
            Game.updateScore(); // Update the scoreboard to reflect the reset
            Typing.clearTyped(); // Clear what user didn't finish typing
            Greenfoot.setWorld(game);
        }
    }
}
