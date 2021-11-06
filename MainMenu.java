import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    Background mainmenu = new Background();
    private int timer = 0;

    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 450, 1); 

        

        addObject(mainmenu, 400, 225);
        
        

        
    }
    
    public void act()
    {
        timer++;
        if(timer == 180)
        {
            removeObject(mainmenu);
            prepare();
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Play play = new Play();
        addObject(play,250,300);
        
        Quit quit = new Quit();
        addObject(quit,550,300);
        
        Title title = new Title();
        addObject(title, 400, 150);
        
    }
}
