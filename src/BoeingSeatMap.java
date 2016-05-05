
public class BoeingSeatMap extends SeatMap{

	/**
	 * a default constructor initializing the number of rows to 10,
	 * the number of columns to 7 and the number of first class rows to 4
	 * 
	 **/
	
	public BoeingSeatMap(){
		
		this.row = 10;
		this.column = 7;
		this.firstClassRow = 4;

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
    			if(seatColumn == 'A' || seatColumn == 'G'){
    				st = SeatType.WINDOW;
    			}
    			else if(seatColumn == 'D'){
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
