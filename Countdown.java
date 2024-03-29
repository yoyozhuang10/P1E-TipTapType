import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Plays a short countdown before the game starts
 * 
 * @author Yoyo, Carl
 * @version 2021.11.08
 */
public class Countdown extends World
{
    boolean acted = false;

    //Countdown variables
    double counter = 3.99;
    double milliCounter = 350.0;
    Label count;
    
    /**
     * @author - Yoyo, Jayden
     * 
     * Creates a world with for the countdown
     */
    public Countdown()
    {    
        // Create a new world with 800x450 cells with a cell size of 1x1 pixels.
        super(800, 450, 1); 
        
        //Define and resize backgrounds
        GreenfootImage background = new GreenfootImage("countdownbackground2.png");
        background.scale(800,450);
        setBackground(background);
        
        //Add counter label to screen
        count = new Label((int)counter, 60);
        addObject(count, getWidth() / 2, getHeight() / 2);
    }
    
    /**
     * @author - Carl
     * 
     * Executes countdown once
     */
    public void act()
    {
        // Run if statement once
        if (!acted)
        {
            acted = true;
            countdown();
        }
    }

    /**
     * @author - Carl, Yoyo
     * 
     * Displays a 3, 2, 1, Start! countdown, plays music too
     */
    public void countdown(){
        // Displaying 3, 2, 1
        for (int i = 3; i > 0; i--)
        {
            count.setValue(i);
            SoundEffects.countdown();
            Greenfoot.delay(60);
        }
        
        // Displaying Go
        count.setValue("GO!");
        SoundEffects.go();
        
        // Changes background so that the square holding the numbers is gone
        GreenfootImage go = new GreenfootImage("background2.png");
        go.scale(800,450);
        setBackground(go);
        
        Greenfoot.delay(30);
        switchWorld();
    }

    /**
     * @author - Yoyo
     * 
     * Switch world to game world after countdown plays    
     */
    public void switchWorld()
    {
        Game g = new Game();
        // Reset Everything
        Game.score = -1; // Score, set to -1 since updateScore() increases score by 1
        Game.mistakes = 0; // Set mistakes to 0
        Game.typedChars = 0;
        Game.updateScore(); // Scoreboard
        Game.shownWords.clear(); // Resets shown words
        Typing.clearTyped(); // What user didn't finish typing
        Greenfoot.setWorld(g);
    }
}
