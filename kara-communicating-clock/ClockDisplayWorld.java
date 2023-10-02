import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClockDisplayWorld extends World {

    private static final int WORLD_WIDTH = 20;  // Number of horizontal cells
    private static final int WORLD_HEIGHT = 20;  // Number of vertical cells
    private static final int SPEED = 40;
    private static final int CELL_SIZE = 28; // Size of one cell

    /**
     * Creates a world for Kara.
     */
    public ClockDisplayWorld() 
    {
        // Create the new world
        super(WORLD_WIDTH, WORLD_HEIGHT, CELL_SIZE);
        Greenfoot.setSpeed(SPEED);
        setPaintOrder(Kara.class, Tree.class, Mushroom.class, Leaf.class);
        initClockDisplay();
        Greenfoot.setSpeed(40);
        prepare();

    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

    }

    private void  initClockDisplay(){
        DigitDisplayKara ampm, hours, minutesTens, minutesOnes;
        minutesOnes = new DigitDisplayKara(10, 1);
        addObject(minutesOnes,9,14);
        showText(":",7,17);
        minutesTens = new DigitDisplayKara(6,2);
        addObject(minutesTens,8,14);
        hours = new DigitDisplay12Kara(12,-5);
        addObject(hours,6,14);
        ampm = new AMPMDisplayKara(2,0);
        addObject(ampm,11,14);

        ClockDisplayKara clockDisplayKara = new ClockDisplayKara();
        addObject(clockDisplayKara,12,15);
        clockDisplayKara.turnLeft();
        clockDisplayKara.turnLeft();
        Tree tree = new Tree();
        addObject(tree,13,15);

    }

}
