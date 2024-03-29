/**
 * Java class contains methods that deals with game sccores
 * 
 * @author Yoyo, Carl
 * @version 2021.11.06
 */
public class Score  
{
    /**
     * @author Yoyo, Carl
     * 
     * Returns the user's score
     */
    public static int getScore(){
        int output = Game.score;
        Game.score = 0; // Resets score
        return output;
    }
    
    /**
     * @author Carl
     * 
     * Calculates and sets the high score
     */
    public static void calculateHighScore()
    {
        if (Game.score > Game.highScore)
        {
            Game.highScore = Game.score;
        }
    }
}
