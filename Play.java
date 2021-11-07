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
    GreenfootImage idleHover = new GreenfootImage("play_idle.png");
    GreenfootImage clicked = new GreenfootImage("play_clicked.png");
    private int buttonWidth = 200;
    private int buttonHeight = 60;
    
    public Play()
    {
        idle.scale(buttonWidth, buttonHeight);
        idleHover.scale(buttonWidth + 10, buttonHeight + 5);
        clicked.scale(buttonWidth, buttonHeight);
        setImage(idle);
    }
    
    public void start()
    {
        /** 
         * Method to detect if button is pressed. 
         */
        
        if(Greenfoot.mousePressed(this))
        {
            this.setLocation(250, 302);
            setImage(clicked);
            Greenfoot.delay(1);
            
            //System.out.print("Hi");
            
            Greenfoot.setWorld(new TypingWorld());
        }
        else
        {
            setImage(idle);
            this.setLocation(250, 300);
        }
        
        mouseHover();
    }
    
    public void mouseHover()
    {
        if(Greenfoot.mouseMoved(this))
        {
            setImage(idleHover);
        }
        else if(Greenfoot.mouseMoved(null))
        {
            setImage(idle);
        }
    }
    
    public void act()
    {
        start();
    }
}
