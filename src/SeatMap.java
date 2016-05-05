
/**
 * 
 * This abstract class stores a two-dimensional array of seat objects to be initialized by concrete classes: 
 * BoeingSeatMap and AirBusSeatMap. It has instance variables that store the number of rows and columns of 
 * the matrix, and the number of rows in first class.
 * 
 **/
public abstract class SeatMap {

	protected int column;
	protected int row;
	protected int firstClassRow;
	protected Seat[][] seats;
	
    /**
     * This abstract method will be used by concrete classes to initialize the number of rows and columns
     **/
    public abstract void initialiseSeatMap();
  
    	
	//----------------------------------------------------------------------------------------
	/**
	 * Returns a Seat stored at the [row][column] indices the 2-dimensional seating plan array
	 * If the indices represent an invalid array location, then null is returned.
	 * @param row, an integer specifying the row
	 * @param column, an integer specifying the column
	 * @return the Seat at the specified location
	 * 
	 **/
	//----------------------------------------------------------------------------------------
	public Seat getSeat(int row, char column)
	{
		return seats[row][getColumnInt(column)];
	}
	
	String alphabet = "ABCDEFGHIJKLMN"; // should be final static and put in main application class?
	
	protected char getColumnChar(int column)
	{
		return alphabet.charAt(column);
	}
	
	private int getColumnInt(char column)
	{
		return alphabet.indexOf(column);
	}
	
	public int getLastRow()
	{
		return row;
	}
	
	public char getLastColumn()
	{
		return getColumnChar(column);
	}
	
	public Seat getLeft(Seat seat)
	{
		return seats[seat.getSeatPosition().getRow() - 1][getColumnInt(seat.getSeatPosition().getColumn()) - 1];
	}
	
	public Seat getRight(Seat seat)
	{
		return seats[seat.getSeatPosition().getRow() - 1][getColumnInt(seat.getSeatPosition().getColumn()) + 1];
	}
	
	public Seat queryAvailableEconomySeat(SeatType seatType){
		
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				if(seats[i][j].getType() == seatType && seats[i][j].isFirstClass() != true && seats[i][j].isReserved() == false){
					return seats[i][j];
				}
			}
		} 
		return null; 
	}
	
	public Seat queryAvailableFirstClassSeat(SeatType seatType){
		
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				if(seats[i][j].getType() == seatType && seats[i][j].isFirstClass() == true && seats[i][j].isReserved() == false){
					return seats[i][j];
				}
			}
		}
		
		return null;
	}
	
	public Seat queryAvailableFirstClassSeat(){
		
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				if(seats[i][j].isFirstClass() == true && seats[i][j].isReserved() == false){
					return seats[i][j];
				}
			}
		}
		
		return null;
	}
	
	public Seat[][] getSeats(){
		return this.seats;
	}
	
	public void reserveAllFirstClass(){
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				if(seats[i][j].isFirstClass() == true){
					seats[i][j].setIsReserved(true);
				}
			}
		}
	}
	
	public void reserveAllEconomy(){
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				if(seats[i][j].isFirstClass() == false){
					seats[i][j].setIsReserved(true);
				}
			}
		}
	}
	
	
	//----------------------------------------------------------------------------------------
	/**
	 * 
	 * Returns a string representation of the seating plan, as a grid using the toString methods
	 * for SeatPosition objects
	 * @return a string representing the seat map
	 * 
	 **/
	
	public String toString(){
		
		String str = "";
		
		for(int row = 0; row < seats.length;row++){
			for(int column = 0; column < seats[row].length;column++){
				str+= row + seats[row][column].toString() + " ";
			}
			str+="\n";
		}
		return str;
	}
}

