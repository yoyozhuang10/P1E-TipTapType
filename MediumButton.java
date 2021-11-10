import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Medium difficulty button actor
 * 
 * @author Jayden
 * @version 2021.11.08
 */
public class MediumButton extends Button
{
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
