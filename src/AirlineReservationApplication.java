import java.util.Scanner;

public class AirlineReservationApplication {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to the Airline reservation system!");
		
		Airline rynoAir = new RynoAir("Ryno");
		Airline simpleJet = new SimpleJet("Simple Jet");
		System.out.println("Which airline are you with? 1 for RynoAir, 2 for SimpleJet.\n");
		int inputAirlineCode = keyboard.nextInt();
		Airline chosenAirline = null;
		if(inputAirlineCode == 1){
			chosenAirline = rynoAir;
		}
		else if(inputAirlineCode == 2){
			chosenAirline = simpleJet;
		}
		else{
			System.out.println("Error");
		}
		
		Flight NZ298 = new Flight(new BoeingSeatMap(), "Auckland International Airport", "Beijing International Airport", "23:00h", "NZ298");
		Flight CA331 = new Flight(new AirBusSeatMap(), "Beijing International Airport", "Auckland International Airport", "21:00h", "CA331");
		// NZ298.getSeatMap().reserveAllFirstClass();
		// CA331.getSeatMap().reserveAllEconomy();
		
		System.out.println("Which flight would you like to reserve a seat on? 1 for " + NZ298.getFlightNum() + " 2 for " + CA331.getFlightNum() + ".\n");
		int inputFlightCode = keyboard.nextInt();
		Flight chosenFlight = null;
		if(inputFlightCode == 1){
			chosenFlight = NZ298;
		}
		else if(inputFlightCode == 2){
			chosenFlight = CA331;
		}
		else{
			System.out.println("Error");
		}
		
		boolean done = false;
		do{
			System.out.println(chosenFlight);
			System.out.println(chosenFlight.getSeatMap().toString());
			
			System.out.println("What class would you like? 1 for first class, 2 for economy.\n");
			int classCode = keyboard.nextInt();
			
			System.out.println("Which type of seat would you like? 1 for aisle, 2 for window, 3 for middle.\n");
			int typeCode = keyboard.nextInt();
			SeatType targetType = null;
			if(typeCode == 1){
				targetType = SeatType.AISLE;
			}
			else if(typeCode == 2){
				targetType = SeatType.WINDOW;
			}
			else if(typeCode == 3){
				targetType = SeatType.MIDDLE;
			}
			
			if(classCode == 1){
				Seat seatResult = chosenAirline.reserveFirstClass(chosenFlight, targetType);
				if(seatResult != null){
					System.out.println("Reserved seat " + seatResult.getSeatPosition().toString() + ".\n");
					if (quitOrNot(keyboard) == true){
						done = true;
						keyboard.close();
					}
				}
				else{
					System.out.println("Not available. Please try again.\n");
				}
			}else if(classCode == 2){
				Seat seatResult = chosenAirline.reserveEconomyClass(chosenFlight, targetType);
				if(seatResult != null){
					System.out.println("Reserved seat " + seatResult.getSeatPosition().toString() + ".\n");
					if (quitOrNot(keyboard) == true){
						done = true;
						keyboard.close();
					}
				}
				else{
					System.out.println("Not available. Please try again.\n");
				}
			}
			
		}while(!done);
	}
	
	private static Boolean quitOrNot(Scanner keyboard){
		System.out.println("Do you want to do stop booking ? 1 for stop, 2 for continue.\n");
		int code = keyboard.nextInt();
		Boolean quit = null;
		if(code == 1){
			quit = true;
			return quit;
		}
		else if(code == 2){
			quit = false;
			return quit;
		}
		else{
			return quitOrNot(keyboard);
		}
	}

}
