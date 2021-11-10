import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This button is used to prevent an annoying bug found when testing.
 * What happened was that greenfoot was making the first added object
 * in the world Settings invisible. 
 * 
 * This TrapButton is made so that it would be the first added object,
 * therefore being invisible, to allow the essential buttons to be visible
 * when adding them to the world Settings
 * 
 * Code here is redundant to the program, only to fix a bug
 * 
 * @author Carl
 * @version 2021.11.10
 */
public class TrapButton extends Button
{
    GreenfootImage idle = new GreenfootImage("TrapButton.png");
    GreenfootImage clicked = idle;
    
    public TrapButton()
    {
        idle.scale(160,45);
        clicked.scale(160,45);
        setImage(idle);
    }
        
    public void act()
    {
        mouseInteract(idle, clicked);        
        mouseHovering();
        if(Greenfoot.isKeyDown("space"))
        {
            fadeOut(idle);
        }
    }
}
