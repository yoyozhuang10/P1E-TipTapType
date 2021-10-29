import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        Label l = new Label("TYPERACER", 60);
        addObject(l, 300, 100);
        
        Label m = new Label("Press space to start", 30);
        addObject(m, 300, 150);
        
        System.out.println("HELLO");
    }
}
