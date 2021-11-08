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
        if (!animation)
        {
            playAnimation();
            addObject();
            SoundEffects.playMusic();
            animation = true;
        }
    }

    public static void createImages()
    {
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = new GreenfootImage("main (" + (i+1) + ").png");
        }
    }

    public void playAnimation()
    {
        for (int i = 0; i < arr.length; i++)
        {
            Greenfoot.delay(1);
            setBackground(arr[i]);
        }
    }
    
    public void addObject()
    {
        PlayButton play = new PlayButton();
        addObject(play, x, y);
    }

    public void print(String item)
    {
        System.out.println(item);
    }
}
