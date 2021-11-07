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
        // Create a new world with 800x450 cells with a cell size of 1x1 pixels.
        super(800, 450, 1);
        
        Label start = new Label ("Press Space to Start", 75);
        addObject(start, x, y);
        
        SoundEffects.playMusic();
    }
    
    public void act()
    {
        String keyPress = Greenfoot.getKey();
        if ("space".equals(keyPress)) // If user presses space, start the game
        {
            Settings s = new Settings();
            Typing.clearTyped();
            Greenfoot.setWorld(s);
        }
    }
}
