import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Plays a short countdown before the game starts
 * 
 * @author Yoyo
 * @version 2021.11.08
 */
public class Countdown extends World
{
    boolean acted = false;
    /**
     * Constructor for objects of class Countdown.
     * 
     */
    //Countdown variables
    double counter = 3.99;
    double milliCounter = 350.0;
    Label count;
    
    public Countdown()
    {    
        // Create a new world with 800x450 cells with a cell size of 1x1 pixels.
        super(800, 450, 1); 
        setBackground(new GreenfootImage("gamebackgroundsmall.png"));
        
        //Add counter label to screen
        count = new Label((int)counter, 60);
        addObject(count, getWidth() / 2, getHeight() / 2);
    }
    
    public void act()
    {
        // Run if statement once
        if (!acted)
        {
            acted = true;
            countdown();
        }
    }

    //Counts down from 3 before game starts
    public void countdown(){
        for (int i = 3; i > 0; i--)
        {
            count.setValue(i);
            SoundEffects.countdown();
            Greenfoot.delay(60);
        }
        count.setValue("GO!");
        SoundEffects.go();
        Greenfoot.delay(30);
        switchWorld();
    }

    // Switch the world after countdown
    public void switchWorld()
    {
        Game g = new Game();
        // Reset Everything
        Game.score = -1; // Score, set to -1 since updateScore() increases score by 1
        Game.updateScore(); // Scoreboard
        Typing.clearTyped(); // What user didn't finish typing
        Greenfoot.setWorld(g);
    }
}
