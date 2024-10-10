/**
* the Railway class is to construct a railway of the redLine
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

public class Railway {

	public DoubleLinkedList<Station> railway;
	public String[] stationNames;
	
	/**
	 * to construct a new railway which is a double linked list storing stations
	 * O(1)
	 */
	public Railway() {
		railway = new DoubleLinkedList<Station>();
	}
	
	/**
	 * to add a station to the railway
	 * @param s: the given station need to be added
	 * O(1)
	 */
	public void addStation(Station s) {
		railway.insert(s);
	}
	
	/**
	 * to add a rider into a proper station
	 * @param r: the given rider need to be added into the railway and station
	 * O(n)
	 */
	public void addRider(Rider r) {
		Node<Station> Sta = new Node<Station>();
		this.setRiderDirection(r);
		Sta = railway.getFirst();
		while(!Sta.data.addRider(r)) {
			Sta = Sta.next;
		}
	}
	
	/**
	 * to add a train to a proper station
	 * @param t: the given train need to be added into the railway and station
	 * O(n)
	 */
	public void addTrain(Train t) {
		Node<Station> Sta = new Node<Station>();
		Sta = railway.getFirst();
		while(Sta != null && !Sta.data.stationName.equals(t.current)) {
			Sta= Sta.next;
		}
		Sta.data.addTrain(t);
	}
	
	/**
	 * to set the rider direction based on their starting and destination station in the railway
	 * 
	 * @param r: the rider need to be set the direction
	 * O(n)
	 */
	public void setRiderDirection(Rider r) {
		Node<Station> Sta = new Node<Station>();
		Sta = railway.getFirst();
		r.swapDirection();
		while(!Sta.data.stationName.equals(r.starting)) {
			Sta = Sta.next;
		}
		while(Sta != null) {
			if(Sta.data.stationName.equals(r.destination)) {
				r.swapDirection();
			}
			Sta = Sta.next;
		}
	}
	
	/**
	 * to do a simulation of train board and leave,and the passengers get in and out the train
	 * @return String: the String represents the result of the simulation
	 * O(n)
	 */
	public String simulate() {
		String output = "";
		Node<Station> Sta = new Node<Station>();
		Sta = railway.getFirst();
		Train test = new Train("",0);
		String Test = "";
		String Disembark = "";
		while(Sta != null) {
			Train train;
			if(Sta.next != null && Sta.next.data.northBoundTrains.size()!=0) {
				Test = output;
			}
			if(Sta.equals(railway.getFirst())) {
				if(Sta.data.northBoundTrains.size()!= 0) {
					Sta.data.moveTrainNorthToSouth();
					output = output + Sta.data.toString();
				}else if(Sta.data.southBoundTrains.size()!=0 && !Sta.data.southBoundTrains.front().equals(test)){
					train = Sta.data.southBoardTrain();
					Disembark = Sta.next.data.addTrain(train);
					output = output + Sta.data.toString() + Disembark;
					test = train;
				}else {
					output = output + Sta.data.toString();
				}
			}else if(Sta.equals(railway.tail)) {
				if(Sta.data.southBoundTrains.size() != 0) {
					Sta.data.moveTrainSouthToNorth();
					output = output + Sta.data.toString();
				}else if(Sta.data.northBoundTrains.size()!=0) {
					train = Sta.data.northBoardTrain();
					Disembark = Sta.prev.data.addTrain(train);
					output = Test + Disembark + Sta.prev.data.toString() + Sta.data.toString();
				}else {
					output = output + Sta.data.toString();
				}
			}else {
				if(Sta.data.southBoundTrains.size() != 0 && !Sta.data.southBoundTrains.front().equals(test)) {
					train = Sta.data.southBoardTrain();
					Disembark = Sta.next.data.addTrain(train);
					output = output + Sta.data.toString() + Disembark;
					test = train;
				}else if(Sta.data.northBoundTrains.size() != 0){
					train = Sta.data.northBoardTrain();
					Disembark = Sta.prev.data.addTrain(train);
					output = Test + Disembark + Sta.prev.data.toString() + Sta.data.toString();
				}else {
					output = output + Sta.data.toString();
				}
			}
			Sta = Sta.next;
		}
		return output;
	}
	
	@Override
	/**
	 * to return the string represents the information of the railway
	 * O(1)
	 */
	public String toString() {
		String output = "";
		Node<Station> Sta = railway.getFirst();
		while(Sta != null) {
			output = output + Sta.data.toString();
			Sta = Sta.next;
		}
		return output;
		
		
	}
}
