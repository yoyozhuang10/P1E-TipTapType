import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class for the play button in main menu
 * 
 * @author Jayden
 * @version 2021.11.08
 */
public class PlayButton extends Actor
{
    /**
     * Act - do whatever the PlayButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    //Clicked and idle versions of play button
    GreenfootImage clicked = new GreenfootImage("play_clicked.png");
    GreenfootImage idle = new GreenfootImage("play_idle.png");
    
    //Scale both to size
    public PlayButton()
    {
        idle.scale(220,60);
        clicked.scale(220,60);
        
        setImage(idle);
    }
    
    public void act()
    {
        mouseClick();        
        mouseHover();
    }
    
    //Plays animations and sound effects when button is clicked
    public void mouseClick()
    {
        if(Greenfoot.mousePressed(this))
        {
            SoundEffects.clickSound();
            setImage(clicked);
            setLocation(getX(), getY() + 5);
            Greenfoot.delay(1);
            setImage(idle);
            setLocation(getX(), getY() - 5);
            Typing.clearTyped();
            Greenfoot.setWorld(new Settings());
        }
        else
        {
            setImage(idle);
        }
    }
    
    //Hover animation
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
