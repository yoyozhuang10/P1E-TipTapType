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
    public static ArrayList<String> wordList = ReadFile.extractWords(); // Stores words from words.txt
    Label displayedWord = new Label ("", 75); // Label that will display the word the user has to type
    Label typedWord = new Label ("", 75); // Label that displays what the user has typed

    // Variables that contain "centre data"
    int x = getWidth()/2; 
    int y = getHeight()/2;
    
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
        //createTimer
        //createScoreLabel
    }

    public void act()
    {
        // Allow the user to type
        try
        {
            String keyPress = Greenfoot.getKey();
            String typed = "";
            if (!keyPress.equals(null))
            {
                typed = Typing.type(keyPress);
                showTyped(typed);
                print(typed);
            }
        }
        catch (Exception NullPointerException){}

        if (checkCorrect(displayedWord.getValue(), typedWord.getValue()))
        {
            // User has typed correct word
            print("Score +1");
            displayWord();
            Typing.clearTyped();
            showTyped(Typing.getTyped());
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
     * Displays the word the user will type
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
     * Method will display what the user has currently typed
     * @param item - What the user has currently typed
     */
    public void showTyped(String item)
    {
        print("1");
        typedWord.setValue(item);
    }

    /**
     * Saves finger pain
     */
    public void print(String item)
    {
        System.out.println(item);
    }
}
