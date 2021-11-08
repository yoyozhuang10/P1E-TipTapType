import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Plays a short countdown before the game starts
 * 
 * @author Yoyo
 * @version (a version number or a date)
 */
public class Countdown extends World
{
    double counter = 4.0;
    double milliCounter = 400.0;
    Label count;
    /**
     * Constructor for objects of class Countdown.
     * 
     */
    public Countdown()
    {    
        // Create a new world with 800x450 cells with a cell size of 1x1 pixels.
        super(800, 450, 1); 
        setBackground(new GreenfootImage("gamebackgroundsmall.png"));
        
        count = new Label((int)counter, 60);
        addObject(count, getWidth() / 2, getHeight() / 2);
    }
    
    public void act(){
        milliCounter--;
        if(milliCounter <= counter * 100){
            counter--;
            count.setValue((int)counter);
        }
        
        if(counter < 1){
            count.setValue("Start!");
        }
        
        if(counter < 0){
            Game g = new Game();
            // Reset Everything
            Game.score = -1; // Score, set to -1 since updateScore() increases score by 1
            Game.updateScore(); // Scoreboard
            Typing.clearTyped(); // What user didn't finish typing
            Greenfoot.setWorld(g);
        }
    }
}
