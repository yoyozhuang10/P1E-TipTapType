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
    GreenfootImage[] arr;
    
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
        if ("s".equals(keyPress))
        {
            print("Creating images...");
            createImages();
        }
        if ("d".equals(keyPress))
        {
            playAnimation();
        }
        if ("f".equals(keyPress))
        {
            print("Playing reverse animation...");
            playReverseAnimation();
        }
        if ("c".equals(keyPress))
        {
            print("Clearing object.");
            arr = null;
        }
    }

    public void createImages()
    {
        arr = new GreenfootImage[100];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = new GreenfootImage("main (" + (i+1) + ").png");
        }
        print("Image array complete.");
    }

    public void playAnimation()
    {
        print("Playing animation...");
        for (int i = 0; i < arr.length; i++)
        {
            Greenfoot.delay(1);
            setBackground(arr[i]);
        }
        print("Animation finished");
    }

    public void playReverseAnimation()
    {
        for (int i = arr.length-1; i >= 0; i--)
        {
            Greenfoot.delay(1);
            setBackground(arr[i]);
        }
        print("Animation finished");
    }

    public void print(String item)
    {
        System.out.println(item);
    }
}
