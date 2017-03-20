import java.util.*;

public class vor_main
{
	public static int obsInput;
	public static String direction;
	public static int planeLat;
	public static int planeLon;
	public static int stationLat;
	public static int stationLon;
	public static String toFrom;
	public static String signal;
	public static String quadrant;

	public static void main(String[] args)
	{
		System.out.println("+-----------------------------------------------------+");
		System.out.println("|-Hello and welcome to your own personal VOR program!-|");
		System.out.println("|----------------Created by Team Cleave---------------|");
		System.out.println("|------------------------ICS414-----------------------|");
		System.out.println("+-----------------------------------------------------+");
		System.out.println();
		
		vor_main();
	}

	private static void vor_main()
	{
		setOBS();
		setDirection();
		setPlaneLat();
		setPlaneLon();
		setStationLat();
		setStationLon();
		signalStrength(planeLat, planeLon, stationLat, stationLon);
		
		System.out.println("Plane Latitude: " + planeLat);
		System.out.println("Plane Longitude: " + planeLon);
		System.out.println("Station Latitude: " + stationLat);
		System.out.println("Station Longitude: " + stationLon);
		toFrom(planeLat, planeLon, stationLat, stationLon);
		quadrant(planeLat, planeLon, stationLat, stationLon);
	}

	//Sets the radial of the aircraft in which to move
	public static void setOBS()
	{
		Scanner reader = new Scanner(System.in);
		boolean obsBoolean = false;

		while(obsBoolean == false)
		{
			try {
				System.out.print("Please enter a value for the OBS: ");
				obsInput = reader.nextInt();
				if (obsInput <= 360 && obsInput >= 0)
				{
					obsBoolean = true;
				}
				else
				{
					System.out.println("Please enter a valid radial integer!");
					System.out.println("Valid OBS is between 0-360 degrees");
					obsBoolean = false;
				}
			}
			catch (InputMismatchException er)
			{
				System.out.println("Please enter an integer value!");
				reader.next();
			}
		}

		System.out.println("The OBS is set to: " + obsInput);
	}

	//Gets the radial of the aircraft in which to move
	public int getOBS()
	{
		return (obsInput);
	}

	public static void setDirection()
	{
		Scanner reader = new Scanner(System.in);
		boolean dirBoolean = false;
		while(dirBoolean == false)
		{
			System.out.print("Please enter the direction of the aircraft: ");
			direction = reader.nextLine();
			if (direction.equalsIgnoreCase("North") ||
				direction.equalsIgnoreCase("South") ||
				direction.equalsIgnoreCase("East") ||
				direction.equalsIgnoreCase("West"))
			{
				dirBoolean = true;
			}
			else
			{
				System.out.println("Please enter a valid direction!");
				System.out.println("North, West, East, South");
				System.out.println("-West or -East");
				dirBoolean = false;
			}
		}
		System.out.println("The direction is set to: " + direction);
	}

	public String getDirection()
	{
		return (direction);
	}

	public static void setPlaneLat()
	{
		Random generate = new Random();
		planeLat = generate.nextInt(180) - 90;
	}

	public int getPlaneLat()
	{
		return (planeLat);
	}

	public static void setPlaneLon()
	{
		Random generate = new Random();
		planeLon = generate.nextInt(360) - 180;

	}

	public int getPlaneLon()
	{
		return (planeLon);
	}

	public static void setStationLat()
	{
		Random generate = new Random();
		stationLat = generate.nextInt(180) - 90;

	}

	public int getStationLat()
	{
		return (stationLat);
	}

	public static void setStationLon()
	{
		Random generate = new Random();
		stationLon = generate.nextInt(360) - 180;
	}

	public int getStationLon()
	{
		return (stationLon);
	}

	public static void toFrom(int pLat, int pLon, int sLat, int sLon)
	{
		if (direction.equalsIgnoreCase("North") || direction.equalsIgnoreCase("South"))
		{
			if (pLon == sLon)
			{
				//Direct 90 degree radial from the station
				toFrom = "ERROR the aircraft is abeam the station.";
			}
			else if (pLat < sLat)
			{
				if (direction.equalsIgnoreCase("North"))
				{
					toFrom = "TO";
				}
				else if (direction.equalsIgnoreCase("South"))
				{
					toFrom = "FROM";
				}
			}
			else if (pLat > sLat)
			{
				if (direction.equalsIgnoreCase("North"))
				{
					toFrom = "FROM";
				}
				else if (direction.equalsIgnoreCase("South"))
				{
					toFrom = "TO";
				}
			}
		}
		else
		{
			if (pLon < sLon)
			{
				if (direction.equalsIgnoreCase("East"))
				{
					toFrom = "TO";
				}
				else if (direction.equalsIgnoreCase("West"))
				{
					toFrom = "FROM";
				}
			}
			else if (pLon > sLon)
			{
				if (direction.equalsIgnoreCase("East"))
				{
					toFrom = "FROM";
				}
				else if (direction.equalsIgnoreCase("West"))
				{
					toFrom = "TO";
				}
			}
			else
			{
				toFrom = "FROM";
			}
		}
		
		System.out.println("The aircraft is currently moving " + toFrom + " the station");
	}

	public static void signalStrength(int pLat, int pLon, int sLat, int sLon)
	{
		if (pLat != sLat && pLon != sLon)
		{
			signal = "GOOD";
		}
		else if (pLat == sLat || pLon == sLon)
		{
			//Check if aircraft is abeam the station
			signal = "BAD abeam";
		}
		else
		{
			//Aircraft is directly above the station
			signal = "BAD";
		}
		
		System.out.println("The station signal is currently: " +  signal);
	}
	
	public static void quadrant(int pLat, int pLon, int sLat, int sLon)
	{
		if (pLon < sLon)
		{
			if (pLat == sLat)
			{
				quadrant = "LEFT DIRECT";
			}
			else if (pLat < sLat)
			{
				//Bottom Right
				quadrant = "LEFT TO";
			}
			else if (pLat > sLat) 
			{
				quadrant = "LEFT FROM";
			}
		}
		else if (pLon > sLon)
		{
			if (pLat == sLat)
			{
				quadrant = "RIGHT DIRECT";
			}
			else if (pLat > sLat)
			{
				quadrant = "RIGHT FROM";
			}
			else if (pLat < sLat)
			{
				quadrant = "RIGHT TO";
			}
		}
		System.out.println("The aircraft is currently in quadrant: " + quadrant);
	}
	
	public static void calcAngle()
	{
		//calculate deflection angle
	}
}
