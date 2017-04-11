import java.util.*;

public class vor_main
{
	public int obsInput;
	public static int interRadial;
	public static int desiredRadial;
	public static int diffAngle;
	public static int deflection;
	public static String bearing;
	public static boolean toFrom;
	public static String direction;
	public static String signal;
	
	static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args)
	{
		System.out.println("+-----------------------------------------------------+");
		System.out.println("|-Hello and welcome to your own personal VOR program!-|");
		System.out.println("|----------------Created by Team Cleave---------------|");
		System.out.println("|------------------------ICS414-----------------------|");
		System.out.println("+-----------------------------------------------------+");
		System.out.println();
		
		mainLoop();
	}
	
	public static void mainLoop() {
		setInterRadial();				//Set the Intercepted Radial
		setDesiredRadial();				//Set the Desired Radial
		setDeflection();				//Set the Deflection Angle
		setToFrom();					//Set the To/From
		setSignal();					//Set the Signal
		
		if(signal.equals("BAD")) {
			System.out.println("The Signal is: " + getSignal());
		} else {
			System.out.println("The Signal is: " + getSignal() +
							   "\nThe Station is: " + Math.abs(deflection) + 
							   " degrees to the " + bearing +
							   "\nMoving: " + direction + " the station");
		}
		programLoop();					//Check whether to loop program
	}

	public static void setInterRadial() {
		boolean validInput = false;

		while(!validInput) {
			System.out.println("Welcome pilot!");
			System.out.println("What is the station's intercepted radial?");
			interRadial = userInput.nextInt();
			if(interRadial <= 359) {
				validInput = true;
			} else {
				System.out.println("Invalid radial! ");
				System.out.println("Please enter a correct radial up to 359.");
			}
		}
		System.out.println("The intercepted radial is set to: " + getInterRadial());	
	}
	
	/*
	 * Same method without console input, instead parameter input for testing.
	 */
	public static void setInterRadial(int input) {
		boolean validInput = false;

		while(!validInput) {
			System.out.println("Welcome pilot!");
			System.out.println("What is the station's intercepted radial?");
			if(input <= 359) {
				interRadial = input;
				validInput = true;
			} else {
				System.out.println("Invalid radial!");
				System.out.println("Please enter a correct radial up to 359.");
				break;
			}
		}
		System.out.println("The intercepted radial is set to: " + getInterRadial());	
	}
	
	public static int getInterRadial() {
		return interRadial;
	}
		
	public static void setDesiredRadial() {
		boolean validInput = false;
		while(!validInput) {
			System.out.println("What is the desired radial?");
			desiredRadial = userInput.nextInt();
			if(desiredRadial <= 359 && desiredRadial >= 0) {
				validInput = true;
			} else {
				System.out.println("Invalid radial! ");
				System.out.println("Please enter a radial between 0-359");
			}
		}
		System.out.println("The desired radial is set to: " + getDesiredRadial());	
	}
	
	/*
	 * Same method without console input, instead parameter input for testing.
	 */
	public static void setDesiredRadial(int input) {
		boolean validInput = false;
		while(!validInput) {
			System.out.println("What is the desired radial?");
			if(input <= 359 && input >= 0) {
				desiredRadial = input;
				validInput = true;
			} else {
				System.out.println("Invalid radial! ");
				System.out.println("Please enter a radial between 0-359");
				break;
			}
		}
		System.out.println("The desired radial is set to: " + getDesiredRadial());	
	}
	
	public static int getDesiredRadial() {
		return desiredRadial;
	}
	
	public static void setToFrom() {
		boolean validInput = false;
		String decision;
		while(!validInput) {
			System.out.println("Is the plane moving in the direction of the station?");
			System.out.println("Please enter 'yes' or 'no'.");
			try {
				decision = userInput.next();
				if (decision.equalsIgnoreCase("yes") || decision.equalsIgnoreCase("no")) {
					if (decision.equalsIgnoreCase("yes")) {
						toFrom = true;
					}
					if (decision.equalsIgnoreCase("no")) {
						toFrom = false;
					}
					validInput = true;
				} else {
					System.out.println("Invalid response! Please enter 'yes' or 'no'.");
					setToFrom();
				}
			} catch (InputMismatchException er) {
				System.out.println("Please enter a valid response string!");
				userInput.next();
			}
		}
		System.out.println("The direction towards the station is set to: " + getToFrom());
		setDirection();
	}
	
	public static void setToFrom(String input) {
		boolean validInput = false;
		String decision;
		while(!validInput) {
			System.out.println("Is the plane moving in the direction of the station?");
			System.out.println("Please enter 'yes' or 'no'.");
			try {
				decision = input;
				if (decision.equalsIgnoreCase("yes") || decision.equalsIgnoreCase("no")) {
					if (decision.equalsIgnoreCase("yes")) {
						toFrom = true;
					}
					if (decision.equalsIgnoreCase("no")) {
						toFrom = false;
					}
					validInput = true;
				} else {
					System.out.println("Invalid response! Please enter 'yes' or 'no'.");
					break;
				}
			} catch (InputMismatchException er) {
				System.out.println("Please enter a valid response string!");
				userInput.next();
			}
		}
		System.out.println("The direction towards the station is set to: " + getToFrom());
	}
	
	public static boolean getToFrom() {
		return toFrom;
	}
	
	public static void setDeflection() {
		diffAngle = interRadial - desiredRadial;
		
		/*
		 * Determine the deflection angle based on the difference
		 * between intercepted radial and desired radial.
		 */
		if(diffAngle > 180) {
			deflection = diffAngle - 360;
		}
		else if(diffAngle < -180) {
			deflection = diffAngle + 360;
		} else {
			deflection = diffAngle;
		}
		
		/*
		 * Determine which direction LEFT or Right, the station is
		 * based on the calculated deflection angle.
		 */
		
		if(deflection >= 0) {
			bearing = "Right";
		} else {
			bearing = "Left";
		}
	}
	
	public static int getDeflection() {
		return deflection;
	}
	
	public static String getBearing() {
		System.out.println("The bearing direction is: " + bearing);
		return bearing;
	}
	
	public static void setDirection() {
		if(Math.abs(deflection) == 90) {
			direction = "ABEAM";
		} else if(Math.abs(deflection) < 90) {
			direction = "TO";
		} else {
			direction = "FROM";
		}
	}
	
	public static String getDirection() {
		return direction;
	}
	
	public static void setSignal() {
		if(interRadial >= 0) {
			if(Math.abs(deflection) >=89 && Math.abs(deflection) <= 91) {
				//Checking for +-1 degree from 90 degree abeam the station
				signal = "BAD";
			} else {
				signal = "GOOD";
			}
		} else {
			//If intercepted radial is negative, the signal is bad to begin with.
			signal = "BAD";
		}
	}
	
	public static String getSignal() {
		return signal;
	}
	
	public static void programLoop() {
		String decision;
		System.out.println("Would you like to input a new intercepted radial?");
		System.out.println("Please enter 'yes' or 'no'.");
		try {
			decision = userInput.next();
			if(decision.equalsIgnoreCase("yes")) {
				mainLoop();
			}
			else if (decision.equalsIgnoreCase("no")) {
				System.out.println("Exitting Program!");
			}
			else {
				System.out.println("Invalid response! Please enter 'yes' or 'no'.");
				programLoop();
			}
		} catch (InputMismatchException er) {
			System.out.println("Please enter a valid response string!");
			userInput.next();
		}
	}
}
