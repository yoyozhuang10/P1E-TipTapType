import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Create a settings menu where the user can toggle game difficulty
 * User can start the game by pressing space
 * 
 * @author Yoyo 
 * 
 */
public class Settings extends World
{

    /**
     * Constructor for objects of class Settings.
     * 
     */
    //Button variables
    EasyButton eb = new EasyButton();
    MediumButton mb = new MediumButton();
    HardButton hb = new HardButton();
    
    //Label variables
    Label current;
    Label message = new Label ("Press Space to Begin", 30);

    public Settings()
    {    
        // Create a new world with 800x450 cells with a cell size of 1x1 pixels.
        super(800, 450, 1); 
        
        //Show current difficulty
        current = new Label("Current difficulty: " + currentDifficulty(), 40);
        addObject(current, getWidth() / 2, getHeight() - 100);
        
        //Add instructions to settings page
        Label select = new Label("Please select your level of difficulty", 40);
        addObject(select, getWidth() / 2, 100);
        
        //Add difficulty toggle buttons
        addObject(eb, getWidth() / 4, 200);
        addObject(mb, getWidth() / 2, 200);
        addObject(hb, getWidth() / 4 * 3, 200);
        
        //Add labels to buttons
        Label easy = new Label("Easy", 40);
        addObject(easy, getWidth() / 4, 300);
        
        Label medium = new Label("Medium", 40);
        addObject(medium, getWidth() / 2, 300);
        
        Label hard = new Label("Hard", 40);
        addObject(hard, getWidth() / 4 * 3, 300);
        
        //Add message telling user how to continue
        addObject(message, getWidth()/2, getHeight()/2+200);
    }
    
    //Returns the current difficulty level
    public String currentDifficulty(){
        if(Game.difficulty == 1){
            return "Easy";
        } else if (Game.difficulty == 2){
            return "Medium";
        } else {
            return "Hard";
        }
    }
    
    //Changes the difficulty level based on the button the user presses
    public void act(){
        if(Greenfoot.mousePressed(eb)){
            SoundEffects.clickSound();
            Game.difficulty = 1;
            current.setValue("Current difficulty: Easy");
        } else if (Greenfoot.mousePressed(mb)){
            SoundEffects.clickSound();
            Game.difficulty = 2;
            current.setValue("Current difficulty: Medium");
        } else if (Greenfoot.mousePressed(hb)){
            SoundEffects.clickSound();
            Game.difficulty = 3;
            current.setValue("Current difficulty: Hard");
        }
        
        //Go to game once user presses space
        if("space".equals(Greenfoot.getKey())){
            Countdown cd = new Countdown();
            Greenfoot.setWorld(cd);
        }
    }
}
