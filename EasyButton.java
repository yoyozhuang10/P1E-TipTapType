import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EasyButton here.
 * 
 * @author Jayden
 * @version 2021.11.08
 */
public class EasyButton extends Button
{
    /**
     * Act - do whatever the EasyButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
