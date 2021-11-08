import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MediumButton here.
 * 
 * @author Jayden
 * @version 2021.11.08
 */
public class MediumButton extends Button
{
    /**
     * Act - do whatever the MediumButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage idle = new GreenfootImage("mediumidle.png");
    GreenfootImage clicked = new GreenfootImage("mediumclicked.png");
    
    public MediumButton()
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
