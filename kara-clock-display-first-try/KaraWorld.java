import greenfoot.*;

/**
 * This class creates a world for Kara. It contains settings for height and 
 * width of the world and initializes the Actors.
 * 
 * @author Marco Jakob (majakob@gmx.ch)
 * @version 1.3 (2012-07-04)
 */
public class KaraWorld extends World 
{   
    private static final int WORLD_WIDTH = 20;  // Number of horizontal cells
    private static final int WORLD_HEIGHT = 20
    ;  // Number of vertical cells

    private static final int CELL_SIZE = 28; // Size of one cell

    /**
     * Creates a world for Kara.
     */
    public KaraWorld() 
    {
        // Create the new world
        super(WORLD_WIDTH, WORLD_HEIGHT, CELL_SIZE);

        setPaintOrder(Kara.class, Tree.class, Mushroom.class, Leaf.class);
        Greenfoot.setSpeed(40);

        // Initialize actors
        //fullClock();
        //someMinutes();
        trees();
        prepare();
    }

    /**
     * Prepare the world, i.e. create all initial actors.
     * 
     * Hint:
     * First create and position all Actors with the mouse in the world.
     * Then right-click on the world and choose 'Save the World'. This will
     * automatically generate the content of this method.
     */
    private void trees(){
        Tree tree = new Tree();
        addObject(tree,5,18);
        Tree tree2 = new Tree();
        addObject(tree2,10,18);
        Tree tree3 = new Tree();
        addObject(tree3,15,18);
        Tree tree4 = new Tree();
        addObject(tree4,5,6);
        Tree tree5 = new Tree();
        addObject(tree5,10,6);
        Tree tree6 = new Tree();
        addObject(tree6,15,16);
        showText("12",Lines.hourX,19);
        showText("0",Lines.minuteX,19);
        showText("am",Lines.apX,19);
    }
    private void someMinutes(){
        Leaf leaf;
        for (int minute = 0;  minute < 10;minute++){
            leaf = new Leaf();
            addObject(leaf,Lines.minuteX,Lines.bottomLine-minute);
        }
    }
    private void fullClock() 
    {
        Leaf leaf;

        for (int hour = 0;  hour < 12;hour++){
            leaf = new Leaf();
            addObject(leaf,Lines.hourX,Lines.bottomLine-hour);
        }

        for (int minute = 0;  minute < 12;minute++){
            leaf = new Leaf();
            addObject(leaf,Lines.minuteX,Lines.bottomLine-minute);
        }

        for (int ap = 0; ap <1; ap++){
            leaf = new Leaf();
            addObject(leaf,Lines.apX,Lines.bottomLine-ap);
        }

    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        MyKara myKara = new MyKara();
        addObject(myKara,1,17);

        ClockDisplay clockDisplay = new ClockDisplay(myKara);
        addObject(clockDisplay,17,5);
        clockDisplay.setLocation(17,2);

        myKara.setClockDisplay(clockDisplay);
        Tree tree = new Tree();
        addObject(tree,0,17);
        Leaf leaf = new Leaf();
        addObject(leaf,15,17);
        //showText("pm",17,17);
        removeObject(leaf);
    }
}
