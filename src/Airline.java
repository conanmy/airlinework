
public abstract class Airline {

	private String airline;
	
	public Airline(String airline){
		this.setAirline(airline);
	}
	
	/*
	 * Access and mutator methods for Airline
	 * 
	 */	
	public void setAirline(String airline){
		this.airline = airline;
	}
	
	public String getAirline(){
		return this.airline;
	}
	
	public String toString(){
		return airline + "Airline";
	}
	
	/* 
	 * this class has two abstract methods for reserving first class and economy class
	 */	
	public abstract Seat reserveFirstClass(Flight flight, SeatType seatType);

	
	public abstract Seat reserveEconomyClass(Flight flight, SeatType seatType);

}
