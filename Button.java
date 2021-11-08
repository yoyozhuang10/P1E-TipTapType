import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }  
    public void mouseInteract(GreenfootImage idle, GreenfootImage clicked)
    {
        if(Greenfoot.mousePressed(this))
        {
            setImage(clicked);
            setLocation(getX(), getY() + 5);
            Greenfoot.delay(2);
            setLocation(getX(), getY() - 5);
            Greenfoot.setWorld(new Settings());
        }
        else
        {
            setImage(idle);
        }
    }
    
    public void mouseHovering()
    {
        if(Greenfoot.mouseMoved(this))
        {
            getImage().scale(170, 50);
        }
        if(Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            getImage().scale(160,45);
        }
    }
}
