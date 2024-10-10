/**
* the Station class represents the station of the red line, train and passengers can get into or out of the station
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

public class Station {

	public Queue<Rider> northBoundRiders;
	public Queue<Rider> southBoundRiders;
	public Queue<Train> northBoundTrains;
	public Queue<Train> southBoundTrains;
	public String stationName;
	
	/**
	 * To construct a new station which has a determined name
	 * @param name: the given name to a new station
	 * O(1)
	 */
	public Station(String name) {
		stationName = name;
		northBoundRiders = new Queue<Rider>(20);
		southBoundRiders = new Queue<Rider>(20);
		northBoundTrains = new Queue<Train>(20);
		southBoundTrains = new Queue<Train>(20);
	}
	
	/**
	 * to add a rider to the waiting queue based on their direction
	 * @param r: the rider entering this station
	 * @return boolean: whether the rider get into a correct station
	 * O(1)
	 */
	public boolean addRider(Rider r) { 
		if(r.starting.equals(stationName)) {
			if(r.goingNorth()) {
				northBoundRiders.enqueue(r);
			}else {
				southBoundRiders.enqueue(r);
			}
			return true;
		}
		return false;
	}
	
	/**
	 * to add a train to a waiting queue based on train's direction, and passenger disembarking
	 * @param t: the train getting into this station
	 * @return String: to return the string represents disembarking passengers from this train in this station
	 * O(n)
	 */
	public String addTrain(Train t) {
		String output = "";
		String disembark;
		t.current = stationName;
		disembark = t.disembarkPassengers();
		if(!disembark.equals("")){
			output = stationName + " Disembarking Passengers:\n" + disembark;
		}
		if(!t.goingNorth()) {
			southBoundTrains.enqueue(t);
		}else {
			northBoundTrains.enqueue(t);
		}
		return output;
	}
	
	/**
	 * the southbound train board to the next station
	 * @return Train: update train's information and board train to the next station
	 * O(1)
	 */
	public Train southBoardTrain() {
		Train t = southBoundTrains.front();
		if(t != null) {
			southBoundTrains.dequeue();
			while(t.hasSpaceForPassengers() && southBoundRiders.size()!=0) {
				t.addPassenger(southBoundRiders.front());
				southBoundRiders.dequeue();
			}
			return t;
		}
		return null;
	}
	
	/**
	 * the northBound Train board to the next staion
	 * @return Train: update train's information and board to the next station
	 * O(1)
	 */
	public Train northBoardTrain() {
		Train t = northBoundTrains.front();
		if(t != null) {
			northBoundTrains.dequeue();
			while(t.hasSpaceForPassengers() && northBoundRiders.size()!=0) {
				t.addPassenger(northBoundRiders.front());
				northBoundRiders.dequeue();
			}
			return t;
		}
		
		return null;
	}
	
	/**
	 * to change the northBound train direction to southBound
	 * O(1)
	 */
	public void moveTrainNorthToSouth() {
		Train t = northBoundTrains.front();
		t.direction = 1;
		northBoundTrains.dequeue();
		southBoundTrains.enqueue(t);
	}
	
	/**
	 * to change the southBound train direction to northBound
	 * O(1)
	 */
	public void moveTrainSouthToNorth() {
		Train t = southBoundTrains.front();
		t.direction = 0;
		southBoundTrains.dequeue();
		northBoundTrains.enqueue(t);
	}
	
	@Override
	/**
	 * to return the string representing the current information of the station
	 * O(1)
	 */
	public String toString() {
		return "Stataion: "+stationName+"\n"+northBoundTrains.size()+" north-bound trains waiting \n"
				+southBoundTrains.size()+" south-bound trains waiting  \n"+northBoundRiders.size()+
				" north-Bound passengers waiting \n"+southBoundRiders.size()+" south-Bound passengers waiting \n\n";
	}
	
	/**
	 * to return the name of this station
	 * @return String: the String of the name of this station
	 * O(1)
	 */
	public String stationName() {
		return stationName;
	}
	
	@Override
	/**
	 * to check whether two station are the same station
	 */
	public boolean equals(Object o) {
		Station other = (Station) o;
		return other.stationName == stationName;
	}
}
