import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.io.*; // File reading
import java.util.Scanner; // File reading

/**
 * Write a description of class Game here.
 * 
 * @author Carl, Yoyo
 * @version 2021.11.01
 */
public class Game extends World
{
    ArrayList<String> wordList = new ArrayList<String>(); // Stores words from words.txt
    
    //Word difficulty arrays
    ArrayList<String> easyList = new ArrayList<String>();
    ArrayList<String> mediumList = new ArrayList<String>();
    ArrayList<String> hardList = new ArrayList<String>();
    
    Label text; // Displays the word from ArrayList
    
    //Score variables
    public static int score;
    public static int highScore = 0;
    Label currentScore;
    
    //Difficulty variables
    public static int difficulty = 1;
    
    //Timer variables
    int totalTime = 10;
    SimpleTimer t = new SimpleTimer();
    Counter c = new Counter();
    
    boolean kDown; // Boolean to prevent isKeyDown() from running multiple times
    Label displayTyped; // Label used to display what the user typed
    Stack<String> typed = new Stack<String>(); // Stores data on what user typed
    String word; // The word the user has to type, from words.txt
    
    /**
     * @author Carl, Yoyo
     * 
     * Constructor for objects of class Game.
     * Run when the game starts
     */
    public Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 450, 1); 
        extractWords(); // Gets the words from txt and stores in ArrayList
        sortWords(wordList); //Divides them based on difficulty
        displayWord(); // Displays first word for the user to see
        
        // Create a timer and start it
        addObject(c, 100, 100);
        t.mark();
        
        // Create a score label
        currentScore = new Label(score, 30);
        addObject(currentScore, 500, 100);
    }
    
    /**
     * @author Carl
     * 
     * Generates a random number between 0 -> ArrayList size. 
     * To be only used with wordList
     */
    public int rand()
    {
        return Greenfoot.getRandomNumber(wordList.size());
    }
    
    /**
     * @author Carl
     * 
     * Reads word.txt and stores data into a data structure (ArrayList)
     */
    public void extractWords()
    {
        try
        {
            File file = new File("Words.txt"); // Where words are stored
            Scanner scanner = new Scanner(file); // To extract words
            
            while (scanner.hasNextLine())
            {
                wordList.add(scanner.nextLine()); // .txt -> ArrayList
            }
            
            scanner.close(); // Destroys scanner
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Something went wrong, MyWorld.java, file reading");
        }
    }
    
    //Sort words in an array list based on length
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
     * @author Carl
     * 
     * Creates the string (what user typed) by gathering/reversing the data stored in stack
     */
    public String createString(Stack<String> stack)
    {
        String output = "";
        Stack<String> methodStack = new Stack<String>();
        for (String s : stack)
        {
            methodStack.push(s);
        }
        for (String s : methodStack)
        {
            output += s;
        }
        return output;
    }
    
    /**
     * @author Carl
     * 
     * Clears what user typed
     */
    public void clearTyped()
    {
        while(!typed.isEmpty())
        {
            typed.pop();
        }
    }
    
    public String selectWord(){
        if(difficulty == 1){
            return easyList.get(Greenfoot.getRandomNumber(easyList.size()));
        } else {
            int probability = Greenfoot.getRandomNumber(10);
            if(difficulty == 2){
                if(probability < 4){
                    return easyList.get(Greenfoot.getRandomNumber(easyList.size()));
                } else {
                    return mediumList.get(Greenfoot.getRandomNumber(mediumList.size()));
                }
            } else {
                if(probability < 2){
                    return easyList.get(Greenfoot.getRandomNumber(easyList.size()));
                } else if (probability < 4){
                    return mediumList.get(Greenfoot.getRandomNumber(mediumList.size()));
                } else {
                    return hardList.get(Greenfoot.getRandomNumber(hardList.size()));
                }
            }
        }
    }
    
    /**
     * @author Carl
     * 
     * Displays the word the user will type
     */
    public void displayWord()
    {
        if (numberOfObjects() == 0) // Empty world, there is no label
        {
            word = selectWord();
            text = new Label(word, 75);
            addObject(text, getWidth()/2, 100);
        }  
        else // Remove existing text to replace
        {
            removeObject(text);
            word = selectWord();
            text = new Label(word, 75);
            addObject(text, getWidth()/2, 100);
        }
    }

    /**
     * @author Yoyo, Carl
     * 
     * Returns the user's score
     */
    public static int getScore(){
        int output = score;
        score = 0; // Resets score
        return output;
    }
    
    /**
     * @author Carl
     * 
     * Calculates the high score
     */
    public static void calculateHighScore()
    {
        if (score > highScore)
        {
            highScore = score;
        }
    }
    
    /**
     * @author Carl, Yoyo
     * 
     * Base of operations for displaying typed text on stage
     */
    public void showTyped(String s)
    {
        if (s.equals("backspace")) // Clears last character on string or wipe the string
        {
            if (Greenfoot.isKeyDown("control")) // Emulating Ctrl + backspace
            {
                clearTyped();
            }
            else 
            {
                typed.pop();
            }
        }
        else if (s.equals("space"))
        {
            //Piece together word that the player typed
            String fullWord = "";
            for(String ss : typed){
                fullWord = ss + word;
            }
            
            //Add to score if the typed word is correct
            if(word.equals(fullWord)){
                score++;
            }
        }
        else if // Ignore following undesired inputs
        (
            s.equals("enter") || s.equals("control") ||
            s.equals("shift") || s.equals("caps lock") ||
            s.equals("tab") || s.equals("alt") ||
            s.equals("alt graph") || s.equals("windows") ||
            s.equals("escape")
        )
        {
            // Do nothing
        }
        else // Append newly typed into string to be dispalyed
        {
            typed.push(s);
        }
        

        if (numberOfObjects() == 0) // Empty world, there is no label
        {
            String typedString = createString(typed);
            displayTyped = new Label(typedString, 75);
            addObject(displayTyped, getWidth()/2, getHeight()/2);
        }  
        else // Remove existing text to replace
        {
            String typedString = createString(typed);
            removeObject(displayTyped);
            displayTyped = new Label(typedString, 75);
            addObject(displayTyped, getWidth()/2, getHeight()/2);
        }
    }
    
    /**
     * @author Carl, Yoyo
     * 
     * What will loop on game run
     */
    public void act()
    {
        //Update timer value on screen
        c.setValue(totalTime - (t.millisElapsed()/1000));
        //End game when timer reaches 0
        if(c.getValue()<= 0){
            calculateHighScore();
            EndScreen es = new EndScreen();
            Greenfoot.setWorld(es);
        }
        
        //Update score
        currentScore.setValue(score);
        
        // To run once after being "x" key pressed down once
        if (kDown != Greenfoot.isKeyDown("space") || kDown != Greenfoot.isKeyDown("enter"))
        {
            kDown = !kDown;
            if (kDown)
            {
                displayWord(); // Displays a word for user to type
                clearTyped();
            }
        }
        
        try // Prevents NullPointerException from occuring
        {
            String keyPress = Greenfoot.getKey(); // Used to store keypresses
            if (!keyPress.equals(null)) // Key on keyboard has been pressed
            {
                showTyped(keyPress);
            }
        }
        catch (Exception NullPointerException){} // Error shoudln't happen...
    }
}
