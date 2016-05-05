
/**
 * 
 * This class stores data about Seat: its reservation status, class type, seat type and seat position
 * @author fpt8352
 *
 */
/**
 * @author jzhu
 *
 */
public class Seat {
	
	private boolean isReserved;
	private boolean isFirstClass;
	private SeatType seatType;
	private SeatPosition seatPosition;
	
	public Seat(boolean isReserved, boolean isFirstClass, SeatType seatType, SeatPosition seatPosition){
		
		this.isReserved = isReserved;
		this.isFirstClass = isFirstClass;
		this.seatType = seatType;
		this.seatPosition = seatPosition;
	}
	
	public SeatPosition getSeatPosition() {
		return seatPosition;
	}

	public void setSeatPosition(SeatPosition seatPosition) {
		this.seatPosition = seatPosition;
	}
	
	public void setIsReserved(boolean isReserved){
		this.isReserved = isReserved;
	}
	
	public boolean getIsReserved(){
		return this.isReserved;
	}
	
	public void setSeatType(SeatType st){
		this.seatType = st;
	}
	
	public SeatType getType(){
		return this.seatType;
	}
	
	/*A toString method that returns a seat representation in 2D array */
	public String toString(){
		
		String str1 = isReserved() ? "X" : "";
		
		return "[" + str1 + "]";
	}
	
	public boolean isReserved() {
		
		return this.isReserved;
	}
	
	public boolean isFirstClass(){
		return this.isFirstClass;
	}
	
	 /**
	  * a longer text description of the Seat. The format looks like: Economy class MIDDLE seat at: 9D is not reserved.
	  * 
	  **/
	
	public String SeatDescription(){
		
		String str = isFirstClass()?"First class":"Economy class";
		
		return str + this.getType() + "seat at: " + " is " + this.getIsReserved();
	}

}
