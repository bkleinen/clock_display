import greenfoot.*;

/**
 * MyKara is a subclass of Kara. Therefore, it inherits all methods of Kara: <p>
 * 
 * <i>MyKara ist eine Unterklasse von Kara. Sie erbt damit alle Methoden der Klasse Kara:</i> <p>
 * 
 * Actions:     move(), turnLeft(), turnRight(), putLeaf(), removeLeaf() <b>
 * Sensors:     onLeaf(), treeFront(), treeLeft(), treeRight(), mushroomFront()
 */
public class MyKara extends Kara{
    ClockDisplay clockDisplay;

    public void setClockDisplay(ClockDisplay clockDisplay){
        this.clockDisplay = clockDisplay;
    }

    public void showTextRight(String text){
        getWorld().showText(text,getX()+1,getY());
    }

    public void showTextBelow(String text){
        getWorld().showText(text,getX(),getY()+2);
    }

    public void flip(int count){
        turnRight();turnRight();
        while (!treeFront()){
            showTextRight("");
            removeLeaf();
            move();
        }
        showTextRight("");
        removeLeaf();
    }

    public void timeTick(){
        int value = increment(Lines.minuteX,5);
        showTextBelow(""+value);
        if (value == 0){
            goHome();
            value = increment(Lines.hourX,1);
            showTextBelow(value == 0 ? "12": ""+value);
            if (value == 0){
                goHome();
                value = increment(Lines.apX,1,"pm");
                showTextBelow(value==1?"pm":"am");
            }
        }
        goHome();
    }

    public int increment(int x, int step){
        return increment(x,step, null);}

    public int increment(int x, int step, String label){
        int count = 0;
        move(x-1);
        turnLeft();
        while(!treeFront() && onLeaf()){
            count = count + step;
            move();
        }
        if (treeFront()){
            if (onLeaf()){
                //overflow!!
                count = count + step;
                showTextRight(""+count);
                flip(count);
                return 0;
            }
        } 
        putLeaf();
        count = count + step;
        showTextRight(label == null ? ""+count : label);
        goDown();
        return count;
    }
    public void goDown(){
        turnRight();turnRight();
        while(!treeFront()) move();
    }
    public void goHome(){
        turnRight();
        while(!treeFront())
            move();
        turnRight();turnRight();
    }

    /**
     * In the 'act()' method you can write your program for Kara <br>
     * <i>In der Methode 'act()' koennen die Befehle fuer Kara programmiert werden</i>
     */
    public void act() 
    {
        timeTick();
    }  

    public void setTime(int hour, int minute){
        int pm = (hour > 11) ? 1: 0;
        hour = hour % 12;
        putLine(Lines.hourX-1,hour);
        showTextBelow(hour==0?"12":""+hour);
        goHome();
        putLine(Lines.minuteX-1,minute/5);
        showTextBelow(""+minute);
        goHome();
        putLine(Lines.apX-1,pm);
        showTextBelow(pm == 1 ? "pm":"am");
        goHome();
    }
    public void putLine(int x,int n){
        move(x);
        turnLeft();
        for (int i=0;i<n-1;i++){
            putLeaf();move();
        }putLeaf();
        goDown();
        
    }
}
