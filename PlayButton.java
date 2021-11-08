import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayButton extends Actor
{
    /**
     * Act - do whatever the PlayButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage clicked = new GreenfootImage("play_clicked.png");
    GreenfootImage idle = new GreenfootImage("play_idle.png");
    
    public PlayButton()
    {
        idle.scale(220,60);
        clicked.scale(210,60);
        
        setImage(idle);
    }
    
    public void act()
    {
        mouseClick();        
        mouseHover();
    }
    
    public void mouseClick()
    {
        if(Greenfoot.mousePressed(this))
        {
            setImage(clicked);
            setLocation(getX(), getY() + 5);
            Greenfoot.delay(4);
            setLocation(getX(), getY() - 5);
            Typing.clearTyped();
            Greenfoot.setWorld(new Settings());
        }
        else
        {
            setImage(idle);
        }
    }
    
    public void mouseHover()
    {
        if(Greenfoot.mouseMoved(this))
        {
            getImage().scale(220, 65);
        }
        if(Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            getImage().scale(210,60);
        }
    }
}
