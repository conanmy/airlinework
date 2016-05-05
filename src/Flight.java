/**
* this Flight class stores flight info and a SeatMap object
*
**/ 
public class Flight {
	
	private SeatMap seatMap;
	private String departure;
	private String arrival;
	private String departureTime;
	private String flightNum;
	
	public Flight(SeatMap seatMap, String departure,String arrival,String departureTime,String flightNum){
		
		this.seatMap = seatMap;
		this.departure = departure;
		this.arrival = arrival;
		this.departureTime = departureTime;
		this.flightNum = flightNum;
	}
	
	public String getDeparture(){
		return this.departure;
	}
	
	public String getArrival(){
		return this.arrival;
	}
	
	public String getDepartureTime(){
		return this.departureTime;
	}
	
	public String getFlightNum(){
		return this.flightNum;
	}
	
	
	public SeatMap getSeatMap(){
		return this.seatMap;
	}
	
	public String toString(){
		return "Flight: " + this.getFlightNum() + " from: " + this.getDeparture() + " to:" + this.getArrival() + " departing: " + this.getDepartureTime();
	}


}
