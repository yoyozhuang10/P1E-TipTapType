import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Endscreen world
 * 
 * @author Yoyo, Jayden
 * @version 2021.11.05
 */
public class EndScreen extends World
{
    int x = getWidth()/2; 
    int y = getHeight()/2;
    
    /**
     * Constructor for objects of class EndScreen.
     * 
     */

    // Label variables
    Label wpm;
    Label errors;
    Label accuracyPercent;

    public EndScreen()
    {    
        // Create a new world with 800x450 cells with a cell size of 1x1 pixels.
        super(800, 450, 1); 
        GreenfootImage background = new GreenfootImage("endbackground2.png");
        background.scale(800,450);
        setBackground(background);
        
        // Add score labels
        Label gameOver = new Label("Game Over!", 75);
        Label gameOver2 = new Label("Press Space to play again", 40);
        Label score = new Label("Score: " + Game.score, 50);
        Label highScore = new Label("High Score: " + Game.highScore, 50);
        addObject(gameOver, x, 100);
        addObject(gameOver2, x, 160);
        addObject(score, x, y+50);
        addObject(highScore, x, y+150);
        
        //Add statistic labels
        wpm = new Label("Words per minute: " + Game.score * 2, 25);
        addObject(wpm, 130, 40);
        
        Label errors = new Label("Mistakes: " + Game.mistakes, 25);
        addObject(errors, 130, 60);
        
        accuracyPercent = new Label("Accuracy: ", 25);
        calculateAccuracy();
        addObject(accuracyPercent, 130, 80);
 
    }
    
    /**
     * @author - Yoyo
     * 
     * Organises words based on length into different array lists
     * @param arr - An array list of words meant to be sorted
     */
    public void act()
    {
        if ("space".equals(Greenfoot.getKey()))
        {
            Countdown cd = new Countdown();
            Greenfoot.setWorld(cd);
        }
    }
    
    /**
     * @author - Yoyo
     * 
     * Calculates the percent accuracy of the player based on characters
     * they got correct
     */
    public void calculateAccuracy(){
        if(Game.typedChars <= 0 || Game.typedChars <= Game.mistakes){
            accuracyPercent.setValue("Accuracy: " + 0.00 + "%");
        } else {
            double accuracy = 100.00 - (double)((double)Game.mistakes/(double)Game.typedChars)*100.00;
            double roundedAccuracy = Math.round(accuracy*100)/100;
            accuracyPercent.setValue("Accuracy: " + roundedAccuracy + "%");
        }
    }
}
