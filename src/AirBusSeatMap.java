
public class AirBusSeatMap extends SeatMap{

	/**
	 * a default constructor initializing the number of rows to 12,
	 * the number of columns to 9 and the number of first class rows to 6
	 * 
	 **/
	
	public AirBusSeatMap()
	{
		this.column = 9;
		this.row = 12;
		this.firstClassRow = 6;

		this.initialiseSeatMap();
		
	}
	
	public void initialiseSeatMap()
	{
		this.seats = new Seat[row][column];
		for(int i = 1; i <= this.row; i++){
    		for(int j = 1; j <= this.column; j++){
    			
    			Boolean isFirstClass;
    			if(i <= this.firstClassRow){
    				isFirstClass = true;
    			}
    			else{
    				isFirstClass = false;
    			}
    			
    			char seatColumn = this.getColumnChar(j-1);
    			SeatPosition sp = new SeatPosition(i, seatColumn);
    			
    			SeatType st;
    			if(seatColumn == 'A' || seatColumn == 'I'){
    				st = SeatType.WINDOW;
    			}
    			else if(seatColumn == 'B' || seatColumn == 'E' || seatColumn == 'H'){
    				st = SeatType.MIDDLE;
    			}
    			else{
    				st = SeatType.AISLE;
    			}
    			
    			this.seats[i-1][j-1] = new Seat(false, isFirstClass, st, sp);
    		}
    	}
	}
}
