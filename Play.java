import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Background
{
    /**
     * Act - do whatever the Play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage idle = new GreenfootImage("play_idle.png");
    GreenfootImage clicked = new GreenfootImage("play_clicked.png");
    private int buttonWidth = 200;
    private int buttonHeight = 60;
    
    public Play()
    {
        idle.scale(buttonWidth, buttonHeight);
        clicked.scale(buttonWidth, buttonHeight);
        setImage(idle);
    }
    
    public void start()
    {

        if(Greenfoot.mousePressed(this))
        {
            this.setLocation(250, 302);
            setImage(clicked);
            Greenfoot.delay(2);
            reverseBackground();
            
            Greenfoot.setWorld(new TypingWorld());
        }
        else
        {
            setImage(idle);
            this.setLocation(250, 300);
        }
    }
    
    public void act()
    {
        start();
    }
}
