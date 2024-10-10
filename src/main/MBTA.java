/**
* the MBTA class is to construct a simulation of redline train
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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MBTA {

	public static final int SOUTHBOUND = 1;
	public static final int NORTHBOUND = 0;
	
	static final int TIMES = 6;
	static Railway r;
	
	public static void main(String[] args) throws FileNotFoundException {
		r = new Railway();
		initStations("./redLine.txt");
		initTrains("./trains.txt");
		initRiders("./riders.txt");
		runSimulation();
	}
	
	/**
	 * to run a simulation for determined times
	 */
	public static void runSimulation() {
		for(int i = 1; i<=TIMES; i++) {
			System.out.println("Simulation: "+i+"\n\n");
			System.out.println(r.simulate());
		}
	}
	
	/**
	 * to initiate the trains running in this simulation, grab information from an existing file
	 * @param trainsFile: the file contains information of trains running in the simulation
	 * @throws FileNotFoundException
	 * O(n)
	 */
	public static void initTrains(String trainsFile) throws FileNotFoundException {
		Scanner input = new Scanner(new File(trainsFile));
		while (input.hasNextLine()) {
			String cur = input.nextLine();
			Scanner n = new Scanner(input.nextLine());
			int d = n.nextInt();
			r.addTrain(new Train(cur, d));
		}
		
	}
	
	/**
	 * to initiate the riders riding in this simulation, grab information from an existing file
	 * @param ridersFile: the file contains information of riders riding in the simulation
	 * @throws FileNotFoundException
	 * O(n)
	 */
	public static void initRiders(String ridersFile) throws FileNotFoundException {
		Scanner input = new Scanner(new File(ridersFile));
		while (input.hasNextLine()) {
			String id = input.nextLine();
			String start = input.nextLine();
			String destination = input.nextLine();
			r.addRider(new Rider(id, start, destination));;
		}
	}
	
	/**
	 * to initiate the stations of the redline will be used in the simulation
	 * @param stationsFile: the file contains information of stations of redLine will be used in the simulation
	 * @throws FileNotFoundException
	 * O(n)
	 */
	public static void initStations(String stationsFile) throws FileNotFoundException {
		Scanner input = new Scanner(new File(stationsFile));
		while (input.hasNextLine()) {
			String station = input.nextLine();
			r.addStation(new Station(station));;
		}
	}
}
