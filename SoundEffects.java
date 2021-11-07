import greenfoot.*;

/**
 * Class handles sound effects
 * 
 * @author Carl 
 * @version 2021.11.06
 */
public class SoundEffects  
{ 
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
        sfxDing.setVolume(30);
        sfxDing.play();
    }
    
    /**
     * @author Carl
     * 
     * Plays music in the background. Moves from tracks 1-3
     */
    public static void playMusic()
    {
        GreenfootSound t1 = new GreenfootSound("Track 1.mp3");
        GreenfootSound t2 = new GreenfootSound("Track 2.mp3");
        GreenfootSound t3 = new GreenfootSound("Track 3.mp3");
        t1.play();
        t1.setVolume(50);
    }
}
