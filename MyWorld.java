import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.util.*;
import greenfoot.GreenfootImage;

/**
 * World where user begins typing.
 * 
 * @author Carl Wang
 * @version 2021.10.29
 */
public class MyWorld extends World
{
    ArrayList<String> wordList = new ArrayList<String>();
    Label text;
    boolean kDown;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld() throws InterruptedException
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        extractWords(); // Extracts list of words from words.txt --> ArrayList
    }
    
    public void act()
    {
        // To run once after being x key pressed down once
        if (kDown != Greenfoot.isKeyDown("k"))
        {
            kDown = !kDown;
            if (kDown)
            {
                if (numberOfObjects() == 0) // Empty world
                {
                    text = new Label(wordList.get(rand()), 75);
                    addObject(text, getWidth()/2, getHeight()/2);
                }  
                else // Remove existing text to replace
                {
                    removeObject(text);
                    text = new Label(wordList.get(rand()), 75);
                    addObject(text, getWidth()/2, getHeight()/2);
                }
            }
        }
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
            System.out.println("Something went wrong, MyWorld.java");
        }
    }
    
    public int rand()
    {
        return Greenfoot.getRandomNumber(wordList.size());
    }
}
