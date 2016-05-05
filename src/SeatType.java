/**
 * This enum SeatType stores the type of the seats: AISLE, MIDDLE, WINDOW
 *
 **/
public enum SeatType {
	
	AISLE, MIDDLE, WINDOW;
	//---------------------------------------------------------------------------------------
	/**
	 * returns a string with a single character, representing the type of seat. 
	 * 
	 **/
	public String toString(){
		String abbrv = this.name().substring(0,1);
		return abbrv;
	}
}
