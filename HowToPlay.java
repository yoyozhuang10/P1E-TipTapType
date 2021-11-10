import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Show instructions to user before they play the game
 * 
 * @author Yoyo
 * @version 2021.11.10
 */
public class HowToPlay extends World
{

    /**
     * Constructor for objects of class HowToPlay.
     * 
     */
    public HowToPlay()
    {    
        // Create a new world with 800x450 cells with a cell size of 1x1 pixels.
        super(800, 450, 1); 
        
        // Set background
        GreenfootImage background = new GreenfootImage("instructions.png");
        background.scale(800,450);
        setBackground(background);
        
        // Display instructions
        /**
         * 
        Label instructions = new Label("Instructions", 60);
        addObject(instructions, getWidth() / 2, 80);
       
        Label rule1 = new Label("1) A random word will pop up on screen", 40);
        addObject(rule1, getWidth() / 2, 140);
        
        Label rule2 = new Label("2) You will have to type as many words as \n possible within 30 seconds", 40);
        addObject(rule2, getWidth() / 2, 200);
        
        Label rule3 = new Label("3) Words will automatically submit, no need \n to press space", 40);
        addObject(rule3, getWidth() / 2, 280);
        
        Label rule4 = new Label("4) HAVE FUN!!!", 40);
        addObject(rule4, getWidth() / 2, 340);
        */
       
        Label rule5 = new Label("Press space to continue", 25);
        addObject(rule5, getWidth() / 2, 425);
         
        
        
    }
    
    public void act(){
        //Go to game once user presses space
        if("space".equals(Greenfoot.getKey())){
            Settings s = new Settings();
            Greenfoot.setWorld(s);
        }
    }
}
