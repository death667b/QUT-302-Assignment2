/**
 * 
 * This file is part of the AircraftSimulator Project, written as 
 * part of the assessment for CAB302, semester 1, 2016. 
 * 
 */
package asgn2Aircraft;


import java.util.ArrayList;
import java.util.List;

import asgn2Passengers.*;
import asgn2Simulators.Log;

/**
 * The <code>Aircraft</code> class provides facilities for modelling a commercial jet 
 * aircraft with multiple travel classes. New aircraft types are created by explicitly 
 * extending this class and providing the necessary configuration information. 
 * 
 * In particular, <code>Aircraft</code> maintains a collection of currently booked passengers, 
 * those with a Confirmed seat on the flight. Queueing and Refused bookings are handled by the 
 * main {@link asgn2Simulators.Simulator} class. 
 *   
 * The class maintains a variety of constraints on passengers, bookings and movement 
 * between travel classes, and relies heavily on the asgn2Passengers hierarchy. Reports are 
 * also provided for logging and graphical display. 
 * 
 * @author hogan
 *
 */
public abstract class Aircraft {

	protected int firstCapacity;
	protected int businessCapacity;
	protected int premiumCapacity;
	protected int economyCapacity;
	protected int capacity;
		
	protected int numFirst;
	protected int numBusiness;
	protected int numPremium; 
	protected int numEconomy; 

	protected String flightCode;
	protected String type; 
	protected int departureTime; 
	protected String status;
	protected List<Passenger> seats;

	/**
	 * Constructor sets flight info and the basic size parameters. 
	 * 
	 * @param flightCode <code>String</code> containing flight ID 
	 * @param departureTime <code>int</code> scheduled departure time
	 * @param first <code>int</code> capacity of First Class 
	 * @param business <code>int</code> capacity of Business Class 
	 * @param premium <code>int</code> capacity of Premium Economy Class 
	 * @param economy <code>int</code> capacity of Economy Class 
	 * @throws AircraftException if isNull(flightCode) OR (departureTime <=0) OR ({first,business,premium,economy} <0)
	 */
	public Aircraft(String flightCode,int departureTime, int first, int business, int premium, int economy) throws AircraftException {
		
		if (flightCode != null && flightCode.trim().length() > 0) this.flightCode = flightCode;
		else throw new AircraftException("Flight code can not be blank.");
		
		if (departureTime > 0) this.departureTime = departureTime;
		else throw new AircraftException("Departure time needs greater than zero.");
		
		if (first >= 0) this.firstCapacity = first;
		else throw new AircraftException("Capacity of First Class must be greater than 0.");
		
		if (business >= 0) this.businessCapacity = business;
		else throw new AircraftException("Capacity of Business Class must be greater than 0.");
		
		if (premium >= 0) this.premiumCapacity = premium;
		else throw new AircraftException("Capacity of Premium Class must be greater than 0.");
		
		if (economy >= 0) this.economyCapacity = economy;
		else throw new AircraftException("Capacity of Economy Class must be greater than 0.");
		
		this.capacity = this.firstCapacity + this.businessCapacity + 
				this.premiumCapacity + this.economyCapacity;
		
		this.status = "";
		
		seats = new ArrayList<Passenger>(); 
	}
	
	/**
	 * Method to remove passenger from the aircraft - passenger must have a confirmed 
	 * seat prior to entry to this method.   
	 *
	 * @param p <code>Passenger</code> to be removed from the aircraft 
	 * @param cancellationTime <code>int</code> time operation performed 
	 * @throws PassengerException if <code>Passenger</code> is not Confirmed OR cancellationTime 
	 * is invalid. See {@link asgn2Passengers.Passenger#cancelSeat(int)}
	 * @throws AircraftException if <code>Passenger</code> is not recorded in aircraft seating 
	 */
	public void cancelBooking(Passenger p,int cancellationTime) throws PassengerException, AircraftException {
		if (!hasPassenger(p)) throw new AircraftException("Passenger needs to exist on the plane before it can be cancelled.");

		p.cancelSeat(cancellationTime);
		this.status += Log.setPassengerMsg(p,"C","N");
		changeAircraftSeatingCount(p, false);
		this.seats.remove(p);
	}

	/**
	 * Method to add a Passenger to the aircraft seating. 
	 * Precondition is a test that a seat is available in the required fare class
	 * 
	 * @param p <code>Passenger</code> to be added to the aircraft 
	 * @param confirmationTime <code>int</code> time operation performed 
	 * @throws PassengerException if <code>Passenger</code> is in incorrect state 
	 * OR confirmationTime OR departureTime is invalid. See {@link asgn2Passengers.Passenger#confirmSeat(int, int)}
	 * @throws AircraftException if no seats available in <code>Passenger</code> fare class. 
	 */
	public void confirmBooking(Passenger p,int confirmationTime) throws AircraftException, PassengerException {
		if (!seatsAvailable(p)) throw new AircraftException(noSeatsAvailableMsg(p));
		p.confirmSeat(confirmationTime, this.departureTime);
		changeAircraftSeatingCount(p, true);
		this.seats.add(p);
		String currentState = p.isNew() ? "N" : "Q";
		this.status += Log.setPassengerMsg(p,currentState,"C");
	}
	
	/**
	 * State dump intended for use in logging the final state of the aircraft. (Supplied) 
	 * 
	 * @return <code>String</code> containing dump of final aircraft state 
	 */
	public String finalState() {
		String str = aircraftIDString() + " Pass: " + this.seats.size() + "\n";
		for (Passenger p : this.seats) {
			str += p.toString() + "\n";
		}
		return str + "\n";
	}
	
	/**
	 * Simple status showing whether aircraft is empty
	 * 
	 * @return <code>boolean</code> true if aircraft empty; false otherwise 
	 */
	public boolean flightEmpty() {
		if (numFirst + numBusiness + numPremium + numEconomy == 0) return true;
		else return false;
	}
	
	/**
	 * Simple status showing whether aircraft is full
	 * 
	 * @return <code>boolean</code> true if aircraft full; false otherwise 
	 */
	public boolean flightFull() {
		if (numFirst + numBusiness + numPremium + numEconomy == capacity) return true;
		else return false;
	}
	
	/**
	 * Method to finalise the aircraft seating on departure. 
	 * Effect is to change the state of each passenger to Flown. 
	 * departureTime parameter allows for rescheduling 
	 * 
	 * @param departureTime <code>int</code> actual departureTime from simulation  
	 * @throws PassengerException if <code>Passenger</code> is in incorrect state 
	 * See {@link asgn2Passengers.Passenger#flyPassenger(int)}. 
	 */
	public void flyPassengers(int departureTime) throws PassengerException { 
		for(Passenger p : this.seats){
			p.flyPassenger(departureTime);
			this.status += Log.setPassengerMsg(p,"C","F");
		}
	}
	
	/**
	 * Method to return an {@link asgn2Aircraft.Bookings} object containing the Confirmed 
	 * booking status for this aircraft. 
	 * 
	 * @return <code>Bookings</code> object containing the status.  
	 */
	public Bookings getBookings() {
		int availableSeats = this.capacity - getNumPassengers();
		
		Bookings booking = new Bookings(
				this.numFirst, this.numBusiness, this.numPremium, this.numEconomy, getNumPassengers() , availableSeats);

		return booking;
	}
	
	/**
	 * Simple getter for number of confirmed Business Class passengers
	 * 
	 * @return <code>int</code> number of Business Class passengers 
	 */
	public int getNumBusiness() {
		return numBusiness;
	}
	
	
	/**
	 * Simple getter for number of confirmed Economy passengers
	 * 
	 * @return <code>int</code> number of Economy Class passengers 
	 */
	public int getNumEconomy() {
		return numEconomy;
	}

	/**
	 * Simple getter for number of confirmed First Class passengers
	 * 
	 * @return <code>int</code> number of First Class passengers 
	 */
	public int getNumFirst() {
		return numFirst;
	}

	/**
	 * Simple getter for the total number of confirmed passengers 
	 * 
	 * @return <code>int</code> number of Confirmed passengers 
	 */
	public int getNumPassengers() {
		return this.seats.size();
	}
	
	/**
	 * Simple getter for number of confirmed Premium Economy passengers
	 * 
	 * @return <code>int</code> number of Premium Economy Class passengers
	 */
	public int getNumPremium() {
		return numPremium;
	}
	
	/**
	 * Method to return an {@link java.util.List} object containing a copy of 
	 * the list of passengers on this aircraft. 
	 * 
	 * @return <code>List<Passenger></code> object containing the passengers.  
	 */
	public List<Passenger> getPassengers() {
		List<Passenger> seatsCopy = new ArrayList<Passenger>();

		seatsCopy.addAll(seats);
		
		return seatsCopy;
	}
	
	/**
	 * Method used to provide the current status of the aircraft for logging. (Supplied) 
	 * Uses private status <code>String</code>, set whenever a transition occurs. 
	 *  
	 * @return <code>String</code> containing current aircraft state 
	 */
	public String getStatus(int time) {
		String str = time +"::"
		+ this.seats.size() + "::"
		+ "F:" + this.numFirst + "::J:" + this.numBusiness 
		+ "::P:" + this.numPremium + "::Y:" + this.numEconomy; 
		str += this.status;
		this.status="";
		return str+"\n";
	}
	
	/**
	 * Simple boolean to check whether a passenger is included on the aircraft 
	 * 
	 * @param p <code>Passenger</code> whose presence we are checking
	 * @return <code>boolean</code> true if isConfirmed(p); false otherwise 
	 */
	public boolean hasPassenger(Passenger p) {
		return this.seats.contains(p);
	}
	

	/**
	 * State dump intended for logging the aircraft parameters (Supplied) 
	 * 
	 * @return <code>String</code> containing dump of initial aircraft parameters 
	 */ 
	public String initialState() {
		return aircraftIDString() + " Capacity: " + this.capacity 
				+ " [F: " 
				+ this.firstCapacity + " J: " + this.businessCapacity 
				+ " P: " + this.premiumCapacity + " Y: " + this.economyCapacity
				+ "]";
	}
	
	/**
	 * Given a Passenger, method determines whether there are seats available in that 
	 * fare class. 
	 *   
	 * @param p <code>Passenger</code> to be Confirmed
	 * @return <code>boolean</code> true if seats in Class(p); false otherwise
	 */
	public boolean seatsAvailable(Passenger p) {	
		if (p instanceof First) {
			if (numFirst < firstCapacity) return true;
		} else if (p instanceof Business) {
			if (numBusiness < businessCapacity) return true;
		} else if (p instanceof Premium) {
			if (numPremium < premiumCapacity) return true;
		} else  if (p instanceof Economy){
			if (numEconomy < economyCapacity) return true;
		}
		
		return false;
	}

	/* 
	 * (non-Javadoc) (Supplied) 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return aircraftIDString() + " Count: " + this.seats.size() 
				+ " [F: " + numFirst
				+ " J: " + numBusiness 
				+ " P: " + numPremium 
				+ " Y: " + numEconomy 
			    + "]";
	}


	/**
	 * Method to upgrade Passengers to try to fill the aircraft seating. 
	 * Called at departureTime. Works through the aircraft fare classes in 
	 * descending order of status. No upgrades are possible from First, so 
	 * we consider Business passengers (upgrading if there is space in First), 
	 * then Premium, upgrading to fill spaces already available and those created 
	 * by upgrades to First), and then finally, we do the same for Economy, upgrading 
	 * where possible to Premium.  
	 */
	public void upgradeBookings() { 
		List<Passenger> passengerList = getPassengers();
		
		/*
		 * 1. Test if there is space to upgrade
		 * 2. Filter the type of passenger and upgrade if true
		 * 3. Re-test for space after each upgrade, break if full.
		 */	
		
		if (this.numFirst < this.firstCapacity){
			for (Passenger oldP : passengerList) {
				 if (oldP instanceof Business){
					 Passenger newP = oldP.upgrade();
					 this.seats.remove(oldP);
					 this.seats.add(newP);
					 this.numBusiness--;
					 this.numFirst++;
				 }
				 
				 if (this.numFirst >= this.firstCapacity){
					 break;
				 }
			}
		}
		
		if (this.numBusiness < this.businessCapacity){
			for (Passenger oldP : passengerList) {
				 if (oldP instanceof Premium){
					 Passenger newP = oldP.upgrade();
					 this.seats.remove(oldP);
					 this.seats.add(newP);
					 this.numPremium--;
					 this.numBusiness++;
				 }
				 
				 if (this.numBusiness >= this.businessCapacity){
					 break;
				 }
			}
		}
		
		if (this.numPremium < this.premiumCapacity){
			for (Passenger oldP : passengerList) {
				 if (oldP instanceof Economy){
					 Passenger newP = oldP.upgrade();
					 this.seats.remove(oldP);
					 this.seats.add(newP);
					 this.numEconomy--;
					 this.numPremium++;
				 }
				 
				 if (this.numPremium >= this.premiumCapacity){
					 break;
				 }
			}
		}
	}
	

	/**
	 * Simple String method for the Aircraft ID 
	 * 
	 * @return <code>String</code> containing the Aircraft ID 
	 */
	private String aircraftIDString() {
		return this.type + ":" + this.flightCode + ":" + this.departureTime;
	}


	//Various private helper methods to check arguments and throw exceptions, to increment 
	//or decrement counts based on the class of the Passenger, and to get the number of seats 
	//available in a particular class


	//Used in the exception thrown when we can't confirm a passenger 
	/** 
	 * Helper method with error messages for failed bookings
	 * @param p Passenger seeking a confirmed seat
	 * @return msg string failure reason 
	 */
	private String noSeatsAvailableMsg(Passenger p) {
		String msg = "";
		return msg + p.noSeatsMsg(); 
	}
	
	/**
	 * Determine the type of Passenger and this increment that class of seat 
	 * 
	 * @param p Passenger object that is being tested
	 * @param addPassenger boolean True to add seat, False to remove seat
	 */
	private void changeAircraftSeatingCount(Passenger p, boolean addPassenger) {
		if (p instanceof First) {
			this.numFirst = addPassenger ? this.numFirst + 1 : this.numFirst - 1;
		} else if (p instanceof Business) {
			this.numBusiness = addPassenger ? this.numBusiness + 1 : this.numBusiness - 1;	
		} else if (p instanceof Premium) {
			this.numPremium = addPassenger ? this.numPremium + 1 : this.numPremium - 1;
		} else {
			this.numEconomy = addPassenger ? this.numEconomy + 1 : this.numEconomy - 1;
		}
	}
}
