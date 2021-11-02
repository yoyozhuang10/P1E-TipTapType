import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.io.*; // File reading
import java.util.Scanner; // File reading

/**
 * Write a description of class Game here.
 * 
 * @author Carl
 * @version 2021.11.01
 */
public class Game extends World
{
    ArrayList<String> wordList = new ArrayList<String>(); // Stores words from words.txt
    Label text; // Displays the word from ArrayList
    Label score; //Displays score of words
    
    //Timer variables
    int totalTime = 5;
    SimpleTimer t = new SimpleTimer();
    Counter c = new Counter();
    
    boolean kDown; // Boolean to prevent isKeyDown() from running multiple times
    Label displayTyped; // Label used to display what the user typed
    Stack<String> typed = new Stack<String>(); // Stores data on what user typed
    String word; // The word the user has to type, from words.txt
    
    /**
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
    }
    
    /**
     * Generates a random number between 0 -> ArrayList size. 
     * To be only used with wordList
     * 
     */
    public int rand()
    {
        return Greenfoot.getRandomNumber(wordList.size());
    }
    
    /**
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
            s = " ";
            typed.push(s);
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
        
        //if escape pressed, end game
    }
}
