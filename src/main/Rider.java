/**
* the Rider class is to construct a rider get ting into the simulation
* 
* Known Bugs: <None>
*
* @author Nana Li 
* <kejiali@brandeis.edu> 
* <Oct, 17th, 2022> 
6
* COSI 21A PA1
*/
package main;

public class Rider {
	String id;
	String starting;
	String destination;
	int direction;

	/**
	 * to construct a new rider with given id, given starting station, and given destination station
	 * @param riderID: the given id
	 * @param startingStation: the given starting station
	 * @param destinationStation: the given destination station
	 * O(1)
	 */
	public Rider(String riderID, String startingStation, String destinationStation) {
		this.id = riderID;
		this.starting = startingStation;
		this.destination = destinationStation;
		this.direction  = 1;
	}
	
	/**
	 * to return the starting station of the rider
	 * @return String: the rider's starting station
	 * O(1)
	 */
	public String getStarting() {
		return starting;
	}
	
	/**
	 * to return the destination station of the rider
	 * @return String: the rider's destination station
	 * O(1)
	 */
	public String getDestination() {
		return destination;
	}
	
	/**
	 * to return the rider's id
	 * @return String: the rider's id
	 * O(1)
	 */
	public String getRiderID() {
		return id;
	}
	
	/**
	 * to check whether the rider going north
	 * @return boolean: true if the rider going north
	 * O(1)
	 */
	public boolean goingNorth() {	
		return direction == 0;
	}
	
	/**
	 * to change the direction of rider's direction
	 * O(1)
	 */
	public void swapDirection() {
		if(direction == 0) {
			direction =1;
		}else {
			direction = 0;
		}
	}
	
	@Override
	/**
	 * to return the String of rider's id
	 * O(1)
	 */
	public String toString() {
		return id;
	}
	
	@Override
	/**
	 * to check whether the rider is equal to another rider
	 * O(1)
	 */
	public boolean equals(Object s) {
		return this.toString().equals(s.toString());
	}
}
