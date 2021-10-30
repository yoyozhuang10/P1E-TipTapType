import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World that simulates the typing experience
 * 
 * @author Carl
 * @version 2021.10.30
 */
public class Typing extends World
{
    Label displayTyped;
    Stack<String> typed = new Stack<String>();
    
    /**
     * Constructor for objects of class Tester.
     * 
     */
    public Typing()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
    }
    
    public void act()
    {
        String keyPress = Greenfoot.getKey();
        try // Prevents NullPointerException from occuring
        {
            if (!keyPress.equals(null)) // Key on keyboard has been pressed
            {
                showTyped(keyPress);
            }
        }
        catch (Exception NullPointerException){}
    }

    /**
     * Base of operations for displaying typed text on stage
     * 
     */
    public void showTyped(String s)
    {
        if (s.equals("space")) // Prevents the literal word "space" from showing up
        {
            s = " ";
            typed.push(s);
        }
        else if (s.equals("backspace")) // Clears last character on string
        {
            if (Greenfoot.isKeyDown("control")) // Emulating Ctrl + backspace
            {
                while(!typed.isEmpty())
                {
                    typed.pop();
                }
            }
            else 
            {
                typed.pop();
            }
        }
        else if // Ignore following undesired inputs
        (
            s.equals("enter") || s.equals("control") ||
            s.equals("shift") || s.equals("caps lock") ||
            s.equals("tab") || s.equals("alt") ||
            s.equals("alt graph") || s.equals("windows")
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
            print("string: " + s);
            String typedString = createString(typed);
            displayTyped = new Label(typedString, 75);
            addObject(displayTyped, getWidth()/2, getHeight()/2);
        }  
        else // Remove existing text to replace
        {
            print("string: " + s);
            String typedString = createString(typed);
            removeObject(displayTyped);
            displayTyped = new Label(typedString, 75);
            addObject(displayTyped, getWidth()/2, getHeight()/2);
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
     * Debugging purposes
     * 
     */
    public void print(String s)
    {
        System.out.println(s);
    }
}
