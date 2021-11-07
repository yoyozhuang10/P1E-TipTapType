import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Quit extends Actor
{
    /**
     * Act - do whatever the Play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage idle = new GreenfootImage("settings_idle.png");
    GreenfootImage clicked = new GreenfootImage("settings_clicked.png");
    private int buttonWidth = 200;
    private int buttonHeight = 60;
    
    public Quit()
    {
        idle.scale(buttonWidth, buttonHeight);
        clicked.scale(buttonWidth, buttonHeight);
        setImage(idle);
    }
    
    public void start()
    {

        if(Greenfoot.mousePressed(this))
        {
            this.setLocation(550, 302);
            setImage(clicked);
            Greenfoot.delay(2);

        }
        else
        {
            setImage(idle);
            this.setLocation(550, 300);
        }
    }
    
    public void act()
    {
        start();
    }
}
