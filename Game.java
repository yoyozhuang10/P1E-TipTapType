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

    //Difficulty Variables
    ArrayList<String> easyList = new ArrayList<String>();
    ArrayList<String> mediumList = new ArrayList<String>();
    ArrayList<String> hardList = new ArrayList<String>();
    public static int difficulty = 1;
    
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
        // Create a new world with 800x450 cells with a cell size of 1x1 pixels.
        super(800, 450, 1);
        setBackground(new GreenfootImage("gamebackgroundsmall.png"));
        
        addObject(displayedWord, x, y+100);
        addObject(typedWord, x, y);
        sortWords(wordList);
        displayWord();
        
        // Create a timer and start it
        addObject(c, x-200, y-150);
        t.mark();

        // Create a score label
        currentScore = new Label(score, 30);
        addObject(currentScore, x+200, y-150);
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
                SoundEffects.keyPressSound();
                showTyped(typed);
            }
        }
        catch (Exception NullPointerException){} // Ignore error to allow the game to run

	// Check if user typed the word correctly
        if (checkCorrect(displayedWord.getValue(), typedWord.getValue()))
        {
            // User has typed correct word
            updateScore();
            displayWord(); // Display new word
            Typing.clearTyped();
            showTyped(Typing.getTyped()); // Clear what the user has typed
            SoundEffects.dingSound();
        }  

        // End game if timer reaches 0
        if (c.getValue() <= 0){
            Score.calculateHighScore();
            EndScreen es = new EndScreen();
            Greenfoot.setWorld(es);
        }
    }
    
    /**
     * @author - Yoyo
     * 
     * Organises words based on length into different array lists
     * @param arr - An array list of words meant to be sorted
     */
    public void sortWords(ArrayList<String> arr){
        for(String s : arr){
            if(s.length() <= 5){
                easyList.add(s);
            } else if(s.length() > 5 && s.length() < 8){
                mediumList.add(s);
            } else {
                hardList.add(s);
            }
        }
    }

    /**
     * @author - Yoyo
     * 
     * Displays/updates the word the user will type
     */
    public void displayWord()
    {
        if(difficulty == 1){
            displayedWord.setValue(easyList.get(Greenfoot.getRandomNumber(easyList.size())));
        } else {
            int probability = Greenfoot.getRandomNumber(10);
            if(difficulty == 2){
                if(probability < 4){
                    displayedWord.setValue(easyList.get(Greenfoot.getRandomNumber(easyList.size())));
                } else {
                    displayedWord.setValue(mediumList.get(Greenfoot.getRandomNumber(mediumList.size())));
                }
            } else {
                if(probability < 2){
                    displayedWord.setValue(easyList.get(Greenfoot.getRandomNumber(easyList.size())));
                } else if (probability < 4){
                    displayedWord.setValue(mediumList.get(Greenfoot.getRandomNumber(mediumList.size())));
                } else {
                    displayedWord.setValue(hardList.get(Greenfoot.getRandomNumber(hardList.size())));
                }
            }
        }
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
     * @author - Yoyo
     * 
     * Update score label and increases score by 1
     */
    public static void updateScore()
    {
        score++;
        currentScore.setValue(score);
    }
}
