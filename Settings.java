import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Settings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Settings extends World
{

    /**
     * Constructor for objects of class Settings.
     * 
     */
    public Settings()
    {    
        // Create a new world with 800x450 cells with a cell size of 1x1 pixels.
        super(800, 450, 1); 
        
        Label select = new Label("Please select your level of difficulty", 40);
        addObject(select, getWidth() / 2, 100);
        
        EasyButton eb = new EasyButton();
        addObject(eb, getWidth() / 4, 200);
        
        MediumButton mb = new MediumButton();
        addObject(mb, getWidth() / 2, 200);
        
        HardButton hb = new HardButton();
        addObject(hb, getWidth() / 4 * 3, 200);
        
        Label easy = new Label("Easy", 40);
        addObject(easy, getWidth() / 4, 300);
        
        Label medium = new Label("Medium", 40);
        addObject(medium, getWidth() / 2, 300);
        
        Label hard = new Label("Hard", 40);
        addObject(hard, getWidth() / 4 * 3, 300);
    }
    
    public void setDifficulty(){
        
    }
}
