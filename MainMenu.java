import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Here, the user has the option to start a new game or not
 * 
 * @author Carl
 * @version 2021.11.05
 */
public class MainMenu extends World
{
    // Variables that contain "centre data"
    int x = getWidth()/2;
    int y = getHeight()/2;
    
    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        Label start = new Label ("Press Space to Start", 75);
        addObject(start, x, y);
        
        Label settings = new Label ("Press S for the Settings", 60);
        addObject(settings, x, y + 100);
        SoundEffects.playMusic();
    }
    
    public void act()
    {
        String keyPress = Greenfoot.getKey();
        if ("space".equals(keyPress)) // If user presses space, start the game
        {
            Game g = new Game();
            Typing.clearTyped(); // What user didn't finish typing
            Game.score = -1; // Score, set to -1 since updateScore() increases score by 1
            Game.updateScore(); // Scoreboard
            Greenfoot.setWorld(g);
        } else if ("s".equals(keyPress)){
            Settings s = new Settings();
            Typing.clearTyped();
            Greenfoot.setWorld(s);
        }
    }
}
