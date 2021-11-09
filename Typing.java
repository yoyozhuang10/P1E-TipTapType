import greenfoot.*;

/**
 * Class contains methods that deal with anything involving typing for the game
 * 
 * @author Carl
 * @version 2021.11.05
 */
public class Typing  
{
    private static Stack<String> typed = new Stack<String>(); // Stack contains what user typed

    /**
     * @author Carl
     * 
     * Clears what user typed
     */
    public static void clearTyped()
    {
        while(!typed.isEmpty())
        {
            typed.pop();
        }
    }
    
    /**
     * @author Carl, Yoyo
     * 
     * Base of operations for displaying typed text on stage
     */
    public static String type(String s)
    {
        if (s.equals("backspace")) // User choosing to delete something
        {
            Game.mistakes++;
            Game.typedChars--;
            if (Greenfoot.isKeyDown("control")) // Emulating Ctrl + backspace
            {
                for(String str : typed){
                    Game.mistakes++;
                    Game.typedChars--;
                }
                Game.mistakes--; //Remove extra mistake added
                Game.typedChars++; //Add the character that was removed
                clearTyped();
            }
            else 
            {
                typed.pop(); // Emulating single backspace press
            }
        }
        else if // Ignore following undesired inputs
        (
            s.equals("enter") || s.equals("control") ||
            s.equals("shift") || s.equals("caps lock") ||
            s.equals("tab") || s.equals("alt") ||
            s.equals("alt graph") || s.equals("windows") ||
            s.equals("escape") || s.equals("space") || s.equals("undefined")
            || s.equals("left") || s.equals("right") || s.equals ("up") ||
            s.equals("down")
        )
        {
            // Do nothing
        }
        else // Append newly typed into string to stack
        {
            Game.typedChars++;
            typed.push(s);
        }
        
        return createString(typed);
    }
        
    /**
     * @author Carl
     * 
     * Creates the string (what user typed) by "gathering"/reversing the data stored in stack
     */
    public static String createString(Stack<String> stack)
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
     * @author - Carl
     * 
     * Method returns what the user currently typed
     */
    public static String getTyped()
    {
        return createString(typed);
    }
}
