import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends Actor
{
    /**
     * Act - do whatever the Background wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //GreenfootSound menuMusic = new GreenfootSound("music.mp3");
    GreenfootImage[] background = new GreenfootImage[191];
    
    public Background()
    {
        for(int i = 0; i < 191; i++)
        {
            background[i] = new GreenfootImage("mainmenu" + i + ".gif");
        }
        setImage(background[191]); 
    }
    
    int imageIndex = 0;
    public void animateBackground()
    {
        setImage(background[imageIndex]);
        imageIndex = imageIndex + 1 % background.length;
    }
    
    public void act()
    {
        animateBackground();
    }
}
