import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * World where the game will occur
 * 
 * @author Carl, Yoyo
 * @version 2021.11.05
 */
public class Game extends World
{
    // Essential Variables
    public static ArrayList<String> wordList = ReadFile.extractWords(); // Stores words from words.txt
    Label displayedWord = new Label ("", 75); // Label that will display the word the user has to type
    Label typedWord = new Label ("", 75); // Label that displays what the user has typed

    // Variables that contain "centre data"
    int x = getWidth()/2; 
    int y = getHeight()/2;

    // Timer variables
    int totalTime = 10;
    SimpleTimer t = new SimpleTimer();
    Counter c = new Counter();

    // Score Variables
    public static int score;
    public static int highScore;
    public static Label currentScore;
    
    /**
     * Constructor for objects of class Game.
     * 
     */
    public Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(displayedWord, x, y+100);
        addObject(typedWord, x, y);
        displayWord();
        
        // Create a timer and start it
        addObject(c, 100, 100);
        t.mark();

        // Create a score label
        currentScore = new Label(score, 30);
        addObject(currentScore, 500, 100);
    }

    /**
     * @author Carl, Yoyo
     */
    public void act()
    {
        updateTimer();
        // Allow the user to type
        try
        {
            String keyPress = Greenfoot.getKey();
            String typed = "";
            if (!keyPress.equals(null)) // The user has typed something
            {
                typed = Typing.type(keyPress);
                showTyped(typed);
            }
        }
        catch (Exception NullPointerException){} // Ignore error to allow the game to run

        if (checkCorrect(displayedWord.getValue(), typedWord.getValue()))
        {
            // User has typed correct word
            updateScore();
            displayWord();
            Typing.clearTyped();
            showTyped(Typing.getTyped());
        }  

        // End game if timer reaches 0
        if (c.getValue() <= 0){
            Score.calculateHighScore();
            EndScreen es = new EndScreen();
            Greenfoot.setWorld(es);
        }
    }

    /**
     * @author - Carl
     * 
     * Generates a random number between 0 -> ArrayList size. 
     * To be only used with wordList
     * @return - A random number
     */
    public int rand()
    {
        return Greenfoot.getRandomNumber(wordList.size());
    }

    /**
     * @author - Carl
     * 
     * Displays/updates the word the user will type
     */
    public void displayWord()
    {
        displayedWord.setValue(wordList.get(rand()));
    }

    /**
     * @author - Carl
     * 
     * Checks if the displayed word matches with what the user has typed
     * @param displayed - The word that is displayed
     * @param typed - The word the user currently have typed
     * @return - True if displayed word matches the currently typed word
     */
    public boolean checkCorrect(String displayed, String typed)
    {
        if (displayed.equals(typed))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * @author - Carl
     * 
     * Method will display/update what the user has currently typed
     * @param item - What the user has currently typed
     */
    public void showTyped(String item)
    {
        typedWord.setValue(item);
    }

    /**
     * @author - Yoyo
     * 
     * Update timer value on screen
     */
    public void updateTimer()
    {
        c.setValue(totalTime - (t.millisElapsed()/1000));
    }

    /**
     * @author Yoyo
     * 
     * Update score label and increases score by 1
     */
    public static void updateScore()
    {
        score++;
        currentScore.setValue(score);
    }
}
