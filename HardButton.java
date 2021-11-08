import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HardButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HardButton extends Button

{
    /**
     * Act - do whatever the HardButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage idle = new GreenfootImage("hardidle.png");
    GreenfootImage clicked = new GreenfootImage("hardclicked.png");
    
    public HardButton()
    {
        idle.scale(160,45);
        clicked.scale(160,45);
        setImage(idle);
    }
        
    
    public void act()
    {
        mouseInteract(idle, clicked);        
        mouseHovering();
    }
}
