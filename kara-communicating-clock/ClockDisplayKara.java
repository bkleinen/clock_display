import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class ClockDisplayKara here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClockDisplayKara extends EnhancedKara
{
    /**
     * Act - do whatever the ClockDisplayKara wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move();move();move();turnRight();
        incrementNext();
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     * ClockDisplayKara can handle a flexible number of DigitDisplayKaras,
     * it just walks below them and increments the first, and then, if
     * this one rolled over, to the next.
     */
    public void incrementNext(){
        int next = incrementOne();
        if (next == 0){
            goHome();
        }
        else {
            moveToNext(next);
            incrementNext();
        }
    }

    public int incrementOne()
    {
        DigitDisplayKara digitKara = getKaraAbove();
        int next = digitKara.increment();
        return next;
    }

    public void goHome(){
        turnRight();
        toTree();
        turnRight();turnRight();
    }

    public DigitDisplayKara getKaraAbove(){
        List<DigitDisplayKara> objects = getWorld().getObjectsAt(getX(),getY()-1,DigitDisplayKara.class);
        if (objects != null && objects.size() > 0)
            return objects.get(0);

        else 

            return null;

    }
}
