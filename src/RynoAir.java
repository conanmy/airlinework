public class RynoAir extends Airline{
	
	
	public RynoAir(String airline) {
		super(airline);
	}


	public Seat reserveFirstClass(Flight flight, SeatType seatType){
		SeatMap sm = flight.getSeatMap();
		
		Seat queryResult = sm.queryAvailableFirstClassSeat(seatType);
		if(queryResult != null){
			queryResult.setIsReserved(true);
			return queryResult;
		}
		else{
			Seat[][] seats = sm.getSeats();

			int i;
			int j;
			
			for(i = 0; i < seats.length; i++){
				Boolean isAnyReserved = false;
				for(j = 0; j < seats[i].length; j++){
					if(seats[i][j].isReserved()){
						isAnyReserved = true; 
					}
				}
				if(isAnyReserved == false){
					for(j = 0; j < seats[i].length; j++){
						seats[i][j].setIsReserved(true);
					}
					return seats[i][0];
				}
			}
		}
		return null;
	}

	public Seat reserveEconomyClass(Flight flight, SeatType seatType){
		SeatMap sm = flight.getSeatMap();
		Seat queryResult = sm.queryAvailableEconomySeat(seatType);
		if(queryResult != null){
			queryResult.setIsReserved(true);
			return queryResult;
		}
		else if(sm.queryAvailableFirstClassSeat() != null){
			Seat queryResult2 = sm.queryAvailableFirstClassSeat();
			queryResult2.setIsReserved(true);
			return queryResult2;
		}
		return null;
	}
}
