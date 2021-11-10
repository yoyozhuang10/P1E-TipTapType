import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Show instructions to user before they play the game
 * 
 * @author Yoyo
 * @version 2021.11.10
 */
public class HowToPlay extends World
{
    public HowToPlay()
    {    
        // Create a new world with 800x450 cells with a cell size of 1x1 pixels.
        super(800, 450, 1); 
        
        // Set background
        GreenfootImage background = new GreenfootImage("instructions.png");
        background.scale(800,450);
        setBackground(background);
       
        // Tell user how to continue
        Label rule5 = new Label("Press space to continue", 25);
        addObject(rule5, getWidth() / 2, 425);
         
        String trap = Greenfoot.getKey(); // To prevent bug from happening 
    }
    
    public void act(){
        //Go to game once user presses space
        if("space".equals(Greenfoot.getKey())){
            Greenfoot.setWorld(new Settings());
        }
    }
}
