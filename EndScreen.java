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
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        Label gameOver = new Label("Game Over!\nPress Space to play", 75);
        Label score = new Label("Score: " + Game.score, 50);
        Label highScore = new Label("High Score: " + Game.highScore, 50);
        addObject(gameOver, x, y-100);
        addObject(score, x, y+50);
        addObject(highScore, x, y+150);
    }
    
    public void act()
    {
        if ("space".equals(Greenfoot.getKey()))
        {
            Game game = new Game();
            // Reset Everything
            Game.score = -1; // Score, set to -1 since updateScore() increases score by 1
            Game.updateScore(); // Scoreboard
            Typing.clearTyped(); // What user didn't finish typing
            Greenfoot.setWorld(game);
        }
    }
}
