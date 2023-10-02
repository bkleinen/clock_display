import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This subclass can be used to tackle the 12:00pm/am anomality.
 * 
 * @author Barne Kleinen
 */
public class DigitDisplay12Kara extends DigitDisplayKara
{
    public DigitDisplay12Kara(int rollOverLimit, int stepsToNextDigit)
    {
        super(rollOverLimit,stepsToNextDigit);
    }

    protected String getDisplayText(int count){
        if (count == 0) 
            return "12";
        else
            return ""+count;
    }
}
