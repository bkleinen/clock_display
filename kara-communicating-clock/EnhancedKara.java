import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Defines Methods needed by the Clock Karas
 * 
 * @author Barne Kleinen
 */
public class EnhancedKara extends Kara
{

    public void toTree(){
        while (!treeFront()) move();
    }

    public boolean karaFront() 
    {
        return getObjectInFront(getRotation(), 1, Kara.class) != null;
    }

    public void moveToNext(int steps){
        boolean backwards = steps < 0;
        if (backwards){
            //Greenfoot.setSpeed(20);
            steps = steps*(-1);
            turnRight();
        } else {
            turnLeft();
        }
    
        for (int i=0;i<steps;i++) move();
        if (backwards){
            turnLeft();
        } else {
            turnRight();
        }
    }
}
