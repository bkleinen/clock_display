import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * NumberDisplayKara can store a number by putting leaves in a row.
 * 
 * @author Barne Kleinen 
 */

public class DigitDisplayKara extends EnhancedKara
{
    int stepsToNextDigit = 0;
    /**
     * Act - do whatever the NumberDisplayKara wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {

    }
    //
    // this is the modified NumberDisplay Code
    // public class NumberDisplay {
    //
    private int limit;
    // the value is stored by laying down leaves.
    //private int value;

    private String label = null;
    private int zeroValue = 0;

    /**
     * Constructor for objects of class NumberDisplay.
     * Set the limit at which the display rolls over.
     * 
     * as 
     */

    public DigitDisplayKara(int rollOverLimit, int stepsToNextDigit)
    {
        limit = rollOverLimit;
        this.stepsToNextDigit = stepsToNextDigit;

    }

    /**
     * Return the current value.
     */
    public int getValue()
    {
        int count = 0;
        do {

            move();
            if (onLeaf())
                count = countLeaf(count);   
        } while (!treeFront() && onLeaf());

        goHome(count);
        return count;
    }

    /**
     * Return the display value (that is, the current value as a two-digit
     * String. If the value is less than ten, it will be padded with a leading
     * zero).
     */
    public String getDisplayValue()
    {
        int value = getValue();
        if(value < 10) {
            return "0" + value;
        }
        else {
            return "" + value;
        }
    }

    /**
     * Set the value of the display to the new specified value. If the new
     * value is less than zero or over the limit, do nothing.
     */
    public void setValue(int replacementValue)
    {
        int numberOfLeaves = replacementValue;
        if((numberOfLeaves >= 0) && (numberOfLeaves < limit)) {
            //value = replacementValue;
            toTree();
            reset();
            for(int i=0; i< numberOfLeaves;i++){

                move();
                putLeaf();
            }
        }
        goHome(replacementValue);

    }

    /**
     * increment the display value by one, rolling over to zero if the
     * limit is reached.
     */
    public int increment()
    {
        //value = (value + 1) % limit;
        // our storage are the leaves, so we need to count them!
        int count = 0;
        boolean rolledOver = false;
        do {
            move();
            count = countLeaf(count);   
        } while (!treeFront() && onLeaf());

        if (onLeaf()){
            count = reset();
            rolledOver = true;
        } else {
            putLeaf();
            goHome(count);
        }

        if (rolledOver)
            return stepsToNextDigit;
        else
            return 0;
    }

    private int countLeaf(int count){
        count = count+1;
        //showTextRight(label == null ? ""+count : label);
        return count;
    }

    public void toTree(){
        while (!treeFront()) move();
    }

    /**
     * start: facing down at end of line
     * end: facing upwards
     */
    public int reset(){
        turnRight();turnRight();
        while (!karaFront()){
            showTextRight("");
            if (onLeaf()) removeLeaf();
            move();
        }

        int count = zeroValue;
        finish(count);
        return count;
    }

    private void goHome(int count){
        turnRight();turnRight();
        while(!karaFront()) move();
        finish(count);
    }

    private void finish(int count){
        turnRight();turnRight();
        showTextBelow(getDisplayText(count));
    }

    protected String getDisplayText(int count){
        return ""+count;
    }

    /*
     * this is a bit more than the plain Kara stuff, 
     * but basically just this Kara's part of the 
     * World setup!
     */

    /**
     * this method is called by the greenfoot system
     * when this Kara(Actor) is added to the world
     */
    public void addedToWorld(World world){
        initDisplay(world);
    }

    public void initDisplay(World world){
        turnLeft();

        int x = getX();
        int y = getY();
        Tree bottomTree = new Tree();
        world.addObject(bottomTree,x,y+2);
        Tree topTree = new Tree();
        world.addObject(topTree,x,y-limit);
        showTextBelow(getDisplayText(zeroValue));
    }

    // some helpers
    private void showTextRight(String text){
        getWorld().showText(text,getX()+1,getY());
    }

    private void showTextBelow(String text){
        getWorld().showText(text,getX(),getY()+3);
    }

}

