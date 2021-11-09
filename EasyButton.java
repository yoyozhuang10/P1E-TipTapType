import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Easy difficulty button actor
 * 
 * @author Jayden
 * @version 2021.11.08
 */
public class EasyButton extends Button
{
    GreenfootImage idle = new GreenfootImage("easyidle.png");
    GreenfootImage clicked = new GreenfootImage("easyclicked.png");
    
    public EasyButton()
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
