import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EasyButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    }
}
