import greenfoot.*;

/**
 * Class handles sound effects
 * 
 * @author Carl, Yoyo
 * @version 2021.11.06
 */
public class SoundEffects  
{ 
    /**
     * @author Yoyo
     * 
     * Plays a race sound during the countdown screen
     */
    public static void countdown()
    {
        GreenfootSound sfxRace = new GreenfootSound("Countdown.mp3");
        sfxRace.setVolume(25);
        sfxRace.play();
    }

    /**
     * @author Carl
     * 
     * Plays the "go" sound effect after countdown
     */
    public static void go()
    {
        GreenfootSound sfxRace = new GreenfootSound("Go.mp3");
        sfxRace.setVolume(25);
        sfxRace.play();
    }
    
    /**
     * @author Yoyo
     * 
     * Plays a click sound when a button is clicked
     */
    public static void clickSound()
    {
        GreenfootSound sfxClick = new GreenfootSound("Click.mp3");
        sfxClick.setVolume(50);
        sfxClick.play();
    }
    
    /**
     * @author Carl
     * 
     * Plays a keyboard sound when a key is pressed
     */
    public static void keyPressSound()
    {
        GreenfootSound sfxKeyPress = new GreenfootSound("Keypress.mp3");
        sfxKeyPress.play();
    }
    
    /**
     * @author Carl
     * 
     * Plays a ding sfx when the user types the word correctly
     */
    public static void dingSound()
    {
        GreenfootSound sfxDing = new GreenfootSound("Ding.mp3");
        sfxDing.setVolume(50);
        sfxDing.play();
    }
    
    /**
     * @author Carl
     * 
     * Plays music in the background. Music in background is determined
     * by a random number generator
     */
    public static void playMusic()
    {
        String song = "Track " + rand() + ".mp3"; 
        GreenfootSound track = new GreenfootSound(song);
        track.playLoop();
        track.setVolume(50);
    }

    /**
     * @author - Carl
     * 
     * Generates a random number between 1 --> 3 inclusive
     * @return - A random number
     */
    public static int rand()
    {
        return Greenfoot.getRandomNumber(3) + 1;
    }
}
