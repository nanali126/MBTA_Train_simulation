/**
* the Train class is a class representing the train can get through the redLine
* Known Bugs: <None>
*
* @author Nana Li 
* <kejiali@brandeis.edu> 
* <Oct, 17th, 2022> 
6
* COSI 21A PA1
*/
package main;

public class Train {

	public static final int TOTAL_PASSENGERS = 10;
	public Rider[] passengers;
	public int passengerIndex;
	public String current;
	public int direction;
	
	/**
	 * to construct a new train object, which has the current station it need to enter, and the direction
	 * @param currentStation: the station of train's current station
	 * @param direction: the direction of the train, southBound or northBound
	 * O(1)
	 */
	public Train(String currentStation, int direction) {
		this.current = currentStation;
		this.direction = direction;
		this.passengers = new Rider[TOTAL_PASSENGERS];
		passengerIndex = 0;
	}
	
	/**
	 * to check whether the train going north
	 * @return boolean: true if the train going north, false if the train going south
	 * O(1)
	 */
	public boolean goingNorth() {
		return direction == 0;
	}
	
	/**
	 * to change the direction of the train to another
	 * O(1)
	 */
	public void swapDirection() {
		if(direction == 0) {
			direction = 1;
		}else {
			direction = 0;
		}
	}
	
	/**
	 * to return the current passenger information of passengers riding in the train
	 * @return String: the String represents the current passenger's information
	 * O(1)
	 */
	public String currentPassengers() {
		int i = 0;
		String output = "";
		while(passengers[i] != null) {
			output = passengers[i].toString()+", "+current+"\n";
			i++;
		}
		return output;
	}
	
	/**
	 * to add passenger to the train at the correct station
	 * @param r: riders waiting to get into the train
	 * @return boolean: to determine whether the passenger can get into the train at the proper station
	 * O(1) 
	 */
	public boolean addPassenger(Rider r) {
		int a = 0;
		if(r.getStarting().equals(current)) {
			if(r.direction == direction) {
				if(hasSpaceForPassengers()) {
					while(passengers[a] != null) {
						a++;
					}
					passengers[a]=r;
					passengerIndex++;
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * to check whether the train has enough space for new passengers to get in
	 * @return boolean: true if the train has space for new passenger to get in
	 * O(1)
	 */
	public boolean hasSpaceForPassengers() {
		return passengerIndex<10;
	}
	
	/**
	 * to return the string representing disembarking passenger and let them get out of the train
	 * @return String: the string representing disembarking passenger
	 * O(1)
	 */
	public String disembarkPassengers() {
		String disembark = "";
		int a = 0;
		for(int i = 0; i < passengerIndex; i++) {
			while(passengers[a] == null) {
				a++;
			}
			if(passengers[a].getDestination().equals(current)) {
				disembark = disembark + passengers[a].toString() +", "+current+"\n";
				passengers[a] = null;
				passengerIndex--;
			}
			a++;
		}
		return disembark;
	}
	
	/**
	 * to update the current station of the train
	 * @param s: the new station need to be updated
	 * O(1)
	 */
	public void updateStation(String s) {
		this.current = s;
	}
	
	/**
	 * to return the current station of the train
	 * @return String: the current station of the train
	 * O(1)
	 */
	public String getStation() {
		return current;
	}
	
	@Override
	/**
	 * to return the String represents the information of the train
	 */
	public String toString() {
		return this.currentPassengers();
	}
	
	/**
	 * to check whether this train is same with another train
	 */
	public boolean equals(Object o) {
		Train other = (Train) o;
		return this.current.equals(other.getStation()) && this.direction == other.direction;
	}
}
