import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author Jayden 
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
        
    }  

    //Plays button animation and changes world
    public void mouseInteract(GreenfootImage idle, GreenfootImage clicked)
    {
        if(Greenfoot.mousePressed(this))
        {
            setImage(clicked);
            setLocation(getX(), getY() + 5);
            Greenfoot.delay(1);
            setLocation(getX(), getY() - 5);
            Greenfoot.setWorld(new Settings());
        }
        else
        {
            setImage(idle);
        }
    }
    
    //Scales the button when hovering over for more interactivity
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
    
    //Fades out the button when method is called
    public void fadeOut(GreenfootImage idle)
    {
        getImage().setTransparency(255);
        int i = 255;
        GreenfootImage img = idle;
        while(i > 0)
        {
            idle.setTransparency(i);
            setImage(idle);
            i--;
        }
    }
}
