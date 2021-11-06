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
    GreenfootImage[] background = new GreenfootImage[193];
    SimpleTimer animation = new SimpleTimer();
    int imageIndex = 1;
    boolean started = false;
    
    
    
    public Background()
    {
            for(int i = 0; i < 193; i++)
            {
                background[i] = new GreenfootImage("main (" + (i + 1) + ").png");
            }
            setImage(background[0]); 
            
            animation.mark();
            
            
            

    }
    
    public void animateBackground()
    {
        
        if(animation.millisElapsed() < 50)
        {
            return;
        }
        animation.mark();
        
        setImage(background[imageIndex]);
                
        imageIndex = (imageIndex + 1) % background.length;
        
        
    }
    
    public void act()
    {
        animateBackground();
    }
}
