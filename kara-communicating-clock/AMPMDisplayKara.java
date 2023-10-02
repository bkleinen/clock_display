
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This subclass can be used to tackle the 12:00pm/am anomality.
 * 
 * @author Barne Kleinen
 */
public class AMPMDisplayKara extends DigitDisplayKara
{
   public AMPMDisplayKara(int rollOverLimit, int stepsToNextDigit)
    {
        super(rollOverLimit,stepsToNextDigit);
    }
    
    protected String getDisplayText(int count){
        return (count == 0) ? "am":"pm";
    }
}
