/*Stars Class
Programmed By: Edmond Chu Jan 9, 2018
this program creates glowing/dimming stars around the solar system*/

//Import Statements
import hsa.Console;
import java.awt.*;

//StarsClass
public class StarsClass implements Runnable
{
    //Global Variables
    static private Console c;
    private int rate;

    //Constructor
    public StarsClass (Console c, int rate)
    {
	this.c = c;
	this.rate = rate;
    }


    //drawStars Method
    public void drawStars ()
    {
	int sSize = (int) (3 * Math.random () + 1), xCord = (int) ((c.maxx () - 6) * Math.random () + 3), yCord = (int) ((c.maxy () - 6) * Math.random () + 3), changeS = 1;

	//Sun Overlap Check
	while (xCord > 530 && xCord < 670 && yCord > 280 && yCord < 420)
	{
	    xCord = (int) ((c.maxx () - 6) * Math.random () + 3);
	    yCord = yCord = (int) ((c.maxy () - 6) * Math.random () + 3);
	}

	//Earth Display Overlap Check
	while (xCord > (c.maxx () - 100) && yCord < 20)
	{
	    xCord = (int) ((c.maxx () - 6) * Math.random () + 3);
	    yCord = yCord = (int) ((c.maxy () - 6) * Math.random () + 3);
	}

	//Drawing Stars (Glowing/Dimming)
	while (true)
	{

	    c.setColor (Color.white);
	    c.drawOval (xCord, yCord, sSize, sSize);
	    delay (rate);
	    c.setColor (Color.black);
	    c.drawOval (xCord, yCord, sSize + 1, sSize + 1);

	    if (sSize > 2)
		changeS *= -1;
	    if (sSize < 0)
		changeS *= -1;
	    sSize += changeS;
	}
    }


    //run Method
    public void run ()
    {
	drawStars ();
    }


    //delay Method
    public void delay (int time)
    {
	try
	{
	    Thread.sleep (time);
	}

	catch (InterruptedException e)
	{
	}
    }
}

