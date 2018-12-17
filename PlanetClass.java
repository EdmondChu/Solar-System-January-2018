/*Planet Class
Programmed By: Edmond Chu Jan 9, 2018
this program allows to user to create and rotate planets*/

//Import Statements
import hsa.Console;
import java.awt.*;

//Class Start
public class PlanetClass implements Runnable
{
    //Variable Declaration
    protected int xOrbit, yOrbit, rOrbit, tFullOrbit, pRadius, uTime;
    protected boolean oConfirm;
    protected double xCordP, yCordP, displayYear = 2 * Math.PI;
    protected Color pC = new Color (0, 0, 0);
    static protected Console c;
    protected String planet;
    protected Color brown = new Color (51, 30, 3);

    //Constructor: center X orbit, center yOrbit, radius of orbit, # of prints per circle, console, color, planet radius, delay time
    public PlanetClass (int xOrbit, int yOrbit, int rOrbit, int tFullOrbit, Console c, Color pC, int pRadius, int uTime, boolean oConfirm, String planet)
    {
	this.xOrbit = xOrbit;
	this.yOrbit = yOrbit;
	this.rOrbit = rOrbit;
	this.tFullOrbit = tFullOrbit;
	this.c = c;
	this.pC = pC;
	this.pRadius = pRadius;
	this.uTime = uTime;
	this.oConfirm = oConfirm;
	this.planet = planet;
    }


    //multiplyObject Method
    public void multiplyObject (int numOfCircles, int oRadius, int xOrbit, int yOrbit)
    {
	double rAngle, radiusC, tempAngle = 2 * (Math.PI);
	Color oLine = new Color (40, 46, 56);

	rAngle = (2 * Math.PI) / numOfCircles;
	radiusC = oRadius * Math.sin (rAngle / 2);
	
	if (planet.equalsIgnoreCase ("asteroid"))
	    tempAngle = (2 * Math.PI) * Math.random ();

	//Checking for orbit line input
	if (oConfirm == true)
	{
	    while (true)
	    {
		//Orbit Lines
		c.setColor (oLine);
		c.drawOval (xOrbit - rOrbit, yOrbit - rOrbit, 2 * rOrbit, 2 * rOrbit);

		//Rotating Planets
		rotateObject (xOrbit, yOrbit, oRadius, tempAngle, radiusC);
		tempAngle -= rAngle;
		displayYear += rAngle;
	    }
	}
	else
	{
	    while (true)
	    {
		//Rotating Planets
		rotateObject (xOrbit, yOrbit, oRadius, tempAngle, radiusC);
		tempAngle -= rAngle;
		displayYear += rAngle;
	    }
	}
    }


    //rotateObject Method
    public void rotateObject (int xOCord, int yOCord, int rOLength, double rotationAngle, double radius)
    {
	double xLength, yLength;
	Color r = new Color ((int) (255 * Math.random ()) + 1, (int) (255 * Math.random ()) + 1, (int) (255 * Math.random ()) + 1);

	//Solving for Coordinates of the Planets
	xLength = rOLength * Math.cos (rotationAngle);
	yLength = rOLength * Math.sin (rotationAngle);
	xCordP = xOCord + xLength - pRadius;
	yCordP = yOCord + yLength - pRadius;

	//Drawing Planet Method
	drawCircle ((int) (Math.round (xCordP)), (int) (Math.round (yCordP)), Math.round (radius), r);
    }


    //drawCircle Method
    public void drawCircle (int xCircle, int yCircle, double r, Color random)
    {
	//Drawing Planet
	c.setColor (pC);
	c.fillOval (xCircle, yCircle, 2 * pRadius, 2 * pRadius);

	//Details for Specific Planets
	if (planet.equalsIgnoreCase ("mercury"))
	{
	    c.setColor (Color.black);
	    c.fillOval (xCircle + 2, yCircle + 2, 1, 1);
	    c.fillOval (xCircle + 4, yCircle + 4, 2, 2);
	}
	else if (planet.equalsIgnoreCase ("venus"))
	{
	    c.setColor (Color.orange);
	    c.fillOval (xCircle + 2, yCircle + 2, 2, 2);
	    c.fillOval (xCircle + 5, yCircle + 4, 2, 2);
	    c.setColor (Color.yellow);
	    c.fillOval (xCircle + 6, yCircle + 6, 1, 2);
	    c.setColor (Color.red);
	    c.fillOval (xCircle + 9, yCircle + 6, 3, 5);
	}
	else if (planet.equalsIgnoreCase ("earth"))
	{
	    c.setColor (Color.green);
	    c.fillOval (xCircle + 4, yCircle + 2, 6, 6);
	    c.fillOval (xCircle + 10, yCircle + 6, 3, 2);
	    c.fillOval (xCircle + 13, yCircle + 5, 2, 3);
	}
	else if (planet.equalsIgnoreCase ("mars"))
	{
	    c.setColor (Color.black);
	    c.fillOval (xCircle + 2, yCircle + 2, 1, 1);
	    c.fillOval (xCircle + 4, yCircle + 4, 2, 2);
	}
	else if (planet.equalsIgnoreCase ("jupiter"))
	{
	    c.setColor (Color.orange);
	    c.fillOval (xCircle + 17, yCircle + 17, 5, 5);
	    c.fillOval (xCircle + 6, yCircle + 6, 6, 6);
	    c.fillOval (xCircle + 12, yCircle + 24, 6, 5);
	    c.setColor (Color.red);
	    c.fillOval (xCircle + 11, yCircle + 15, 10, 10);
	    c.fillOval (xCircle + 5, yCircle + 6, 2, 2);
	    c.fillOval (xCircle + 6, yCircle + 3, 6, 6);
	    c.fillOval (xCircle + 12, yCircle + 12, 6, 5);
	    c.fillOval (xCircle + 18, yCircle + 5, 6, 6);
	}
	else if (planet.equalsIgnoreCase ("saturn"))
	{
	    c.setColor (brown);
	    c.fillRect (xCircle - 3, yCircle + 12, 34, 5);
	}
	else if (planet.equalsIgnoreCase ("uranus"))
	{
	    c.setColor (Color.gray);
	    c.drawOval (xCircle + 6, yCircle + 6, 12, 12);
	    c.drawOval (xCircle + 4, yCircle + 3, 2, 4);
	    c.drawOval (xCircle + 10, yCircle + 10, 3, 4);

	}

	//Redrawing Background
	delay (uTime);
	if (planet.equalsIgnoreCase ("saturn"))
	{
	    c.setColor (Color.black);
	    c.fillRect (xCircle - 3, yCircle + 12, 34, 5);
	}
	c.setColor (Color.black);
	c.fillOval (xCircle, yCircle, 2 * pRadius, 2 * pRadius);
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


    //geXCord Method
    public int getXCord ()
    {
	return (int) xCordP;
    }


    //getYCord Method
    public int getYCord ()
    {
	return (int) yCordP;
    }


    //getPRadius Method
    public int getPRadius ()
    {
	return pRadius;
    }


    //getYear Method
    public int getYear ()
    {
	return (int) (displayYear / (2 * Math.PI));
    }


    //run Method
    public void run ()
    {
	multiplyObject (tFullOrbit, rOrbit, xOrbit, yOrbit);
    }
}




