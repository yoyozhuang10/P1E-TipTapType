import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World where user presses space to start the game
 * 
 * @author Carl, Jayden
 * @version 2021.11.05
 */
public class MainMenu extends World
{
    // Variables that contain "centre data"
    int x = getWidth()/2;
    int y = getHeight()/2;

    // Background animation
    static GreenfootImage[] arr = new GreenfootImage[100];
    boolean animation = false;
    
    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu()
    {    
        // Create a new world with 800x450 cells with a cell size of 1x1 pixels.
        super(800, 450, 1);   
        createImages();
    }
    
    public void act()
    {
        // Play the opening animation once
        if (!animation)
        {
            playAnimation();
            addObject();
            SoundEffects.playMusic();
            animation = true;
        }
    }

    /**
     * @author Carl
     * 
     * Creates an array of GreenfootImages to be used for background animation
     */
    public static void createImages()
    {
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = new GreenfootImage("main (" + (i+1) + ").png");
        }
    }

    /**
     * @author Carl
     * 
     * Plays the animation (forward animation)
     */
    public void playAnimation()
    {
        for (int i = 0; i < arr.length; i++)
        {
            Greenfoot.delay(1); // Prevents animation from being played instantly
            setBackground(arr[i]);
        }
    }
    
    /**
     * @author Carl, Jayden
     * 
     * Adds the play button and title screen
     */
    public void addObject()
    {
        Title title = new Title();
        addObject(title, x, 150);
        
        PlayButton play = new PlayButton();
        addObject(play, x, 300);
    }
}
