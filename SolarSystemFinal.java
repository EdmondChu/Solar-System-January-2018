/*Solar System Display
Programmed By: Edmond Chu Jan 9,2018
This program displays all the planets in the solar system*/
//Import Statements
import hsa.Console;
import java.awt.*;
import javax.swing.*;

public class SolarSystemFinal
{
    public static void main (String[] args)
    {
	//Variable Declaration
	int centerX = 600, centerY = 350, confirmInput, yearb4 = 0, year;
	boolean orbitC = false;
	Color solarFlare = new Color (232, 77, 25);

	//User Input
	confirmInput = JOptionPane.showConfirmDialog (null, "Would you like to see the orbit lines?", "Solar System.exe", JOptionPane.YES_NO_CANCEL_OPTION);
	if (confirmInput == 0)
	    orbitC = true;
	else if (confirmInput == 1)
	    orbitC = false;
	else
	    System.exit (0);

	//Display Console
	Console c = new Console (35, 150);

	//BackGround
	c.setColor (Color.black);
	c.fillRect (0, 0, c.maxx (), c.maxy ());

	//Sun
	c.setColor (Color.yellow);
	c.fillOval (centerX - 31, centerY - 31, 62, 62);
	c.setColor (Color.orange);
	c.fillOval (centerX - 29, centerY - 29, 58, 58);
	c.setColor (Color.yellow);
	c.fillOval (centerX - 27, centerY - 27, 54, 54);
	c.setColor (Color.orange);
	c.fillOval (centerX - 25, centerY - 25, 50, 50);
	c.setColor (solarFlare);
	c.drawArc (centerX - 40, centerY - 40, 75, 200, 60, 70);
	c.drawArc (centerX - 8, centerY - 45, 30, 80, 242, 70);
	c.setColor (Color.black);
	c.fillOval (centerX - 25, centerY - 23, 6, 3);
	c.fillOval (centerX + 11, centerY - 27, 6, 3);
	c.fillOval (centerX + 12, centerY + 23, 6, 3);
	c.fillOval (centerX - 3, centerY + 27, 6, 3);

	//Stars
	StarsClass star[] = new StarsClass [75];
	Thread starT[] = new Thread [75];
	for (int k = 0 ; k < star.length ; k++)
	{
	    star [k] = new StarsClass (c, (int) (10 * Math.random () + 140));
	    starT [k] = new Thread (star [k]);
	    starT [k].start ();
	}

	//Declaring all planet type variables
	PlanetClass p[] = new PlanetClass [8];
	Thread planetT[] = new Thread [8];
	Color planetC[] = new Color [8];
	String planetName[] = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
	int ColorPC[] [] = {{169, 255, 0, 172, 255, 234, 50, 8}, {169, 69, 0, 99, 127, 188, 175, 62}, {169, 0, 255, 10, 80, 72, 229, 124}};
	int radOrbitPlanet[] = {45, 75, 110, 145, 222, 275, 320, 360};
	int reprintPlanet[] = {66, 138, 192, 230, 1200, 2683, 3500, 5050};
	int planetRadius[] = {4, 7, 8, 5, 17, 14, 12, 11};
	int planetDelayTime[] = {20, 28, 41, 57, 69, 60, 76, 87};

	//Displaying Planets
	for (int planetCount = 0 ; planetCount < 8 ; planetCount++)
	{
	    planetC [planetCount] = new Color (ColorPC [0] [planetCount], ColorPC [1] [planetCount], ColorPC [2] [planetCount]);
	    p [planetCount] = new PlanetClass (600, 350, radOrbitPlanet [planetCount], reprintPlanet [planetCount], c, planetC [planetCount], planetRadius [planetCount], planetDelayTime [planetCount], orbitC, planetName [planetCount]);
	    planetT [planetCount] = new Thread (p [planetCount]);
	    planetT [planetCount].start ();
	}

	//Declaring all moon type variables
	MoonClass m[] = new MoonClass [13];
	Thread moonT[] = new Thread [13];
	int moonOrbitRadius[] = {12, 9, 13, 21, 23, 26, 29, 20, 23, 15, 18, 16, 18};
	int moonDelayTime[] = {30, 38, 60, 35, 60, 85, 40, 30, 65, 70, 30, 50, 25};
	Color moonC[] = new Color [13];
	int ColorMC[] [] = {{74, 128, 128, 117, 117, 117, 117, 89, 89, 61, 61, 160, 160}, {76, 128, 128, 10, 10, 10, 10, 122, 122, 81, 81, 79, 79}, {79, 128, 128, 106, 106, 106, 106, 219, 219, 23, 23, 32, 32}};

	//Initializing Moon Colors
	for (int moons = 0 ; moons < 13 ; moons++)
	    moonC [moons] = new Color (ColorMC [0] [moons], ColorMC [1] [moons], ColorMC [2] [moons]);

	//Displaying Earth Moon
	m [0] = new MoonClass (p [2], moonDelayTime [0], c, moonC [0], moonOrbitRadius [0], orbitC);

	//Displaying Mars Moons
	for (int marsM = 1 ; marsM < 3 ; marsM++)
	    m [marsM] = new MoonClass (p [3], moonDelayTime [marsM], c, moonC [marsM], moonOrbitRadius [marsM], orbitC);

	//Displaying Jupiter Moons
	for (int jupM = 3 ; jupM < 7 ; jupM++)
	    m [jupM] = new MoonClass (p [4], moonDelayTime [jupM], c, moonC [jupM], moonOrbitRadius [jupM], orbitC);

	//Displaying Saturn Moons
	for (int satM = 7 ; satM < 9 ; satM++)
	    m [satM] = new MoonClass (p [5], moonDelayTime [satM], c, moonC [satM], moonOrbitRadius [satM], orbitC);

	//Displaying Uranus Moons
	for (int urnM = 9 ; urnM < 11 ; urnM++)
	    m [urnM] = new MoonClass (p [6], moonDelayTime [urnM], c, moonC [urnM], moonOrbitRadius [urnM], orbitC);

	//Displaying Neptune Moons
	for (int nepM = 11 ; nepM < m.length ; nepM++)
	    m [nepM] = new MoonClass (p [7], moonDelayTime [nepM], c, moonC [nepM], moonOrbitRadius [nepM], orbitC);

	//Threading Moons
	for (int tMoon = 0 ; tMoon < m.length ; tMoon++)
	{
	    moonT [tMoon] = new Thread (m [tMoon]);
	    moonT [tMoon].start ();
	}

	//Asteroid Belt
	Color asteroidC = new Color (105, 105, 105);
	PlanetClass Asteroid[] = new PlanetClass [75];
	Thread ast[] = new Thread [75];
	for (int i = 0 ; i < Asteroid.length ; i++)
	{
	    Asteroid [i] = new PlanetClass (centerX, centerY, (int) (10 * Math.random ()) + 170, (int) (200 * Math.random ()) + 100, c, asteroidC, (int) (2 * Math.random ()) + 1, (int) (20 * Math.random () + 33), false, "asteroid");
	    ast [i] = new Thread (Asteroid [i]);
	    ast [i].start ();
	}

	//Earth Year Display
	while (true)
	{
	    year = p [2].getYear ();
	    if (year != yearb4)
	    {
		c.setColor (Color.black);
		c.fillRect (c.maxx () - 100, 0, 150, 20);
		for (int j = 0 ; j < 10000 ; j++)
		    ;
		c.setColor (Color.white);
		c.drawString ("Earth Year: " + year, c.maxx () - 100, 20);
		yearb4 = year;
	    }
	}
    }
}


