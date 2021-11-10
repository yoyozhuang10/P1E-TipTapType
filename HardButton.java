import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Hard difficulty button actor
 * 
 * @author Jayden
 * @version 2021.11.08
 */
public class HardButton extends Button
{
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
        if(Greenfoot.isKeyDown("space"))
        {
            fadeOut(idle);
        }
    }
}
