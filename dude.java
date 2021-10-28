import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class dude here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class dude extends Actor
{
    /**
     * Act - do whatever the dude wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("w"))
        {
            askInput();
        }
    }
    public void askInput()
    {
        boolean correct = true;
        String answer = Greenfoot.ask("Type 'Yes': ");
        String reply = " ";
        if(!answer.equals("Yes"))
        {
            correct = false;
        }
        
        if(correct == false)
        {
            reply = "wrong";
        }
        else
        {
            reply = "right";
        }
        
        System.out.println(answer + " is " + reply + "!");
        
    }
}
