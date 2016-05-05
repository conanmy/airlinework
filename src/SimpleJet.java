
public class SimpleJet extends Airline {
	
	public SimpleJet(String airline) {
		super(airline);
	}


	public Seat reserveFirstClass(Flight flight, SeatType seatType){
		SeatMap sm = flight.getSeatMap();
		
		if(sm.queryAvailableFirstClassSeat(seatType) != null){
			Seat result = sm.queryAvailableFirstClassSeat(seatType);
			result.setIsReserved(true);
			return result;
		}
		else if(sm.queryAvailableFirstClassSeat() != null){
			Seat result2 = sm.queryAvailableFirstClassSeat();
			result2.setIsReserved(true);
			return result2;
		}
		else if(sm.queryAvailableEconomySeat(SeatType.AISLE) != null){
			Seat targetSeat = sm.queryAvailableEconomySeat(SeatType.AISLE);
			if(sm.getLeft(targetSeat) != null && sm.getLeft(targetSeat).getIsReserved() == false){
				sm.getLeft(targetSeat).setIsReserved(true);
				targetSeat.setIsReserved(true);
				return targetSeat;
			}
			if(sm.getRight(targetSeat) != null && sm.getRight(targetSeat).getIsReserved() == false){
				sm.getRight(targetSeat).setIsReserved(true);
				targetSeat.setIsReserved(true);
				return targetSeat;
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
			Seat result2 = sm.queryAvailableFirstClassSeat();
			result2.setIsReserved(true);
			return result2;
		}
		return null;
	}

}
