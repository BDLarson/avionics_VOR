import java.util.*;

public class vor_main {
	public static int obsInput;
	public static String toFrom;
	public static boolean north;
	public static boolean west;
	public static boolean east;
	public static boolean south;

	
	public static void main(String[] args) {
		vor_main();
	}
		
	private static void vor_main() {
		System.out.println("Hello and welcome to your own personal VOR program!");
		System.out.print("Please enter a value for the OBS: ");
		Scanner reader = new Scanner(System.in);
		int userInput = reader.nextInt();
		setOBS(userInput);
		System.out.println("The OBS is set to: " + obsInput);
		setDirection();
		
	}
	
	//Sets the radial of the aircraft in which to move
	public static void setOBS(int user_input) {
		obsInput = user_input;
	}
	
	//Gets the radial of the aircraft in which to move
	public int getOBS()
	{
		return (obsInput);
	}
	
	public static void setDirection() {
		
	}
	
	public static String toFrom(int plane, int station) {
		if (plane < station)
		{
			toFrom = "TO";
		}
		else if (plane > station)
		{
			toFrom = "FROM";
		}
		else
		{
			toFrom = "ERROR";
		}
		return toFrom;
	}
	//OBS - Omni Bearing Selector
	//CDI - Course DEviation Indicator
}
