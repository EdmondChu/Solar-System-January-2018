/*Moon Class
Programmed By: Edmond Chu Jan 9, 2018
this class creates moons based off planet objects*/

//Import Statements
import hsa.Console;
import java.awt.*;

//MoonClass
public class MoonClass extends PlanetClass
{
    //Global Variables
    static private Console c;
    private PlanetClass pCurrent;
    private boolean confirmOLine;


    //Constructor
    public MoonClass (PlanetClass pCurrent, int oSpeed, Console c, Color moonC, int oRadius, boolean confirmOLine)
    {
	super (pCurrent.getXCord (), pCurrent.getYCord (), oRadius, 60, c, moonC, 2, oSpeed, confirmOLine,"moon");
	this.c = c;
	this.pCurrent = pCurrent;
	this.confirmOLine = confirmOLine;
    }


    //multiplyObject Method
    public void multiplyObject (int numOfCircles, int oRadius, int xOrbit, int yOrbit)
    {
	int pCurrentRadius = pCurrent.getPRadius (), pXCurrent, pYCurrent;
	double rAngle, radiusC, tempAngle = 2 * (Math.PI);
	Color oLine = new Color (40, 46, 56);

	rAngle = (2 * Math.PI) / numOfCircles;
	radiusC = oRadius * Math.sin (rAngle / 2);

	//Orbit Line Confirmation
	if (confirmOLine)
	{
	    while (true)
	    {
		pXCurrent = pCurrent.getXCord ();
		pYCurrent = pCurrent.getYCord ();

		//Drawing Orbit Lines
		c.setColor (oLine);
		c.drawOval (pXCurrent - rOrbit + pCurrentRadius, pYCurrent - rOrbit + pCurrentRadius, 2 * rOrbit, 2 * rOrbit);

		rotateObject (pXCurrent + pCurrentRadius, pYCurrent + pCurrentRadius, oRadius, tempAngle, radiusC);
		tempAngle -= rAngle;

		//Undrawing Orbit Lines
		c.setColor (Color.black);
		c.drawOval (pXCurrent - rOrbit + pCurrentRadius, pYCurrent - rOrbit + pCurrentRadius, 2 * rOrbit, 2 * rOrbit);

	    }
	}
	else
	{
	    while (true)
	    {
		pXCurrent = pCurrent.getXCord ();
		pYCurrent = pCurrent.getYCord ();
		rotateObject (pXCurrent + pCurrentRadius, pYCurrent + pCurrentRadius, oRadius, tempAngle, radiusC);
		tempAngle -= rAngle;
	    }
	}
    }
}
