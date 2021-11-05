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
    Label text; // Displays the word from ArrayList
    
    //Score variables
    public static int score;
    Label currentScore;
    
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
     * 
     */
    public Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        extractWords(); // Gets the words from txt and stores in ArrayList
        displayWord();
        
        //Create a timer and start it
        addObject(c, 100, 100);
        t.mark();
        
        //Create a score label
        currentScore = new Label(score, 30);
        addObject(currentScore, 500, 100);
    }
    
    /**
     * @author Carl
     * 
     * Generates a random number between 0 -> ArrayList size. 
     * To be only used with wordList
     * 
     */
    public int rand()
    {
        return Greenfoot.getRandomNumber(wordList.size());
    }
    
    /**
     * @author Carl
     * 
     * Reads word.txt and stores data into a data structure (ArrayList)
     * 
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
    
    /**
     * @author Carl
     * 
     * Creates the string by gathering the data stored in stack
     * 
     */
    public String createString(Stack<String> stack)
    {
        String output = "";
        Stack<String> methodStack = new Stack<String>();
        for (String s: stack)
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
     * @author Carl, Yoyo
     * 
     * Base of operations for displaying typed text on stage
     * 
     */
    public void showTyped(String s)
    {
        if (s.equals("backspace")) // Clears last character on string
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
                fullWord = ss + fullWord;
            }
            
            //Add to score if the typed word is correct
            if(word.contains(fullWord)){
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
     * @author Carl
     * 
     * Clears what user typed
     * 
     */
    public void clearTyped()
    {
        while(!typed.isEmpty())
        {
            typed.pop();
        }
    }
    
    /**
     * @author Carl
     * 
     * Displays the word the user will type
     * 
     */
    public void displayWord()
    {
        if (numberOfObjects() == 0) // Empty world, there is no label
        {
            word = wordList.get(rand());
            text = new Label(word, 75);
            addObject(text, getWidth()/2, 100);
        }  
        else // Remove existing text to replace
        {
            removeObject(text);
            word = wordList.get(rand());
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
     * @author Carl, Yoyo
     * 
     * What will loop on game run
     * 
     */
    public void act()
    {
        //Update timer value on screen
        c.setValue(totalTime - (t.millisElapsed()/1000));
        //End game when timer reaches 0
        if(c.getValue()<= 0){
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