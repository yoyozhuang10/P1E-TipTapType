import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends Actor
{
    /**
     * Act - do whatever the StartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if (Greenfoot.mouseClicked(this)) 
        {
            try
            {
                World MyWorld = new DisplayWords();
                Greenfoot.setWorld(MyWorld);
            }
            catch (Exception e)
            {
                System.out.println("Something went wrong, StartButton.java");
            }
        }
    }
}
