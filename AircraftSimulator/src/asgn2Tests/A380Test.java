/**
 * 
 */
package asgn2Tests;

import static org.junit.Assert.*;

import asgn2Passengers.*;
import org.junit.Before;
import org.junit.Test;

import asgn2Aircraft.A380;
import asgn2Aircraft.AircraftException;

import java.util.List;
import java.util.Objects;

/**
 * @author user
 *
 */
public class A380Test {
	
	private A380 aircraftA380, aircraftA380Full, aircraftA380Partial, aircraftErrors;
	private First partialFirst, fullFirst;
	private Business bizPassenger, partialBusiness, fullBusiness;
	private Premium partialPremium, fullPremium;
	private Economy partialEconomy, fullEconomy;

	/**
	 * @throws PassengerException
	 */
	@Before
	public void setUp() throws AircraftException, PassengerException {
		// Create an Aircraft and a single unassigned Passenger.
		aircraftA380 = new A380("EmptyFlightCode", 123);
		bizPassenger = new Business(50, 123);

		// Create an Aircraft with a capacity of 1 seat in each class. Create and assign a single Passenger for each class. This Aircraft is partially full.
		aircraftA380Partial = new A380("PartialFlightCode", 1, 2, 2, 2, 2);
		partialFirst = new First(1, 1);
		aircraftA380Partial.confirmBooking(partialFirst, 1);
		partialBusiness = new Business(1, 1);
		aircraftA380Partial.confirmBooking(partialBusiness, 1);
		partialPremium = new Premium(1, 1);
		aircraftA380Partial.confirmBooking(partialPremium, 1);
		partialEconomy = new Economy(1, 1);
		aircraftA380Partial.confirmBooking(partialEconomy, 1);

		// Create an Aircraft with a capacity of 1 seat in each class. Create and assign a Passenger for each of those seats. This Aircraft is full.
		aircraftA380Full = new A380("FullFlightCode", 1, 1, 1, 1, 1);
		fullFirst = new First(1, 1);
		aircraftA380Full.confirmBooking(fullFirst, 1);
		fullBusiness = new Business(1, 1);
		aircraftA380Full.confirmBooking(fullBusiness, 1);
		fullPremium = new Premium(1, 1);
		aircraftA380Full.confirmBooking(fullPremium, 1);
		fullEconomy = new Economy(1, 1);
		aircraftA380Full.confirmBooking(fullEconomy, 1);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#Aircraft(java.lang.String, int, int, int, int, int)}.
	 */
    @Test
    public void testAircraftBasicNotNull()  {
        assertNotNull(aircraftA380);
    }
    
	@Test
	public void testAircraftGetFlightCode() {
		assertEquals("A380:EmptyFlightCode:123 Capacity: 484 [F: 14 J: 64 P: 35 Y: 371]", aircraftA380.initialState());
	}

	@Test(expected = AircraftException.class)
	public void testAircraftBlankFlightCodeExpectFail() throws AircraftException {
		aircraftErrors = new A380(" ", 123);
	}
	
	@Test(expected = AircraftException.class)
	public void testAircraftNullFlightCodeExpectFail() throws AircraftException {
		aircraftErrors = new A380(null, 123);
	}
	
	@Test(expected = AircraftException.class)
	public void testAircraftZeroDepartTimeExpectFail() throws AircraftException {
		aircraftErrors = new A380("123", 0);
	}
	
	@Test(expected = AircraftException.class)
	public void testAircraftNegativeFirstClassExpectFail() throws AircraftException {
		aircraftErrors = new A380("123", 123, -1, 123, 123, 123);
	}
	
	@Test(expected = AircraftException.class)
	public void testAircraftNegativeBusinessClassExpectFail() throws AircraftException {
		aircraftErrors = new A380("123", 123, 123, -1, 123, 123);
	}
	
	@Test(expected = AircraftException.class)
	public void testAircraftNegativePremiumClassExpectFail() throws AircraftException {
		aircraftErrors = new A380("123", 123, 123, 123, -1, 123);
	}
	
	@Test(expected = AircraftException.class)
	public void testAircraftNegativeEconomyClassExpectFail() throws AircraftException {
		aircraftErrors = new A380("123", 123, 123, 123, 123, -1);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#cancelBooking(asgn2Passengers.Passenger, int)}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */

	@Test
	public void testCancelBooking() throws AircraftException, PassengerException {
		aircraftA380.confirmBooking(bizPassenger, 1);
		aircraftA380.cancelBooking(bizPassenger, 1);
	}

	@Test(expected = AircraftException.class)
	public void testCancelBookingPassengerDoesntExist() throws AircraftException, PassengerException, NoSuchFieldException, IllegalAccessException {
		bizPassenger.confirmSeat(1, 1);
		aircraftA380.cancelBooking(bizPassenger, 1);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#confirmBooking(asgn2Passengers.Passenger, int)}.
	 */
	@Test
	public void testConfirmBooking() throws AircraftException, PassengerException {
		aircraftA380.confirmBooking(bizPassenger, 1);
	}

	@Test(expected = AircraftException.class)
	public void testConfirmBookingNoSeatsAvailable() throws AircraftException, PassengerException {
		aircraftA380Full.confirmBooking(bizPassenger, 1);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#finalState()}.
	 */
	@Test
	public void testFinalState() {
		assertEquals("A380:EmptyFlightCode:123 Pass: 0\n\n", aircraftA380.finalState());
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#flightEmpty()}.
	 */
	@Test
	public void testFlightEmptyTrue() {
		assertTrue(aircraftA380.flightEmpty());
	}

	@Test
	public void testFlightEmptyFalse() throws AircraftException, PassengerException {
		aircraftA380.confirmBooking(bizPassenger, 1);
		assertFalse(aircraftA380.flightEmpty());
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#flightFull()}.
	 */
	@Test
	public void testFlightFullTrue() throws NoSuchFieldException, IllegalAccessException, AircraftException {
		assertTrue(aircraftA380Full.flightFull());
	}

	@Test
	public void testFlightFullFalse() {
		assertFalse(aircraftA380.flightFull());
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#flyPassengers(int)}.
	 */
	@Test
	public void testFlyPassengers() throws PassengerException {
		aircraftA380.flyPassengers(1);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getBookings()}.
	 */
	@Test
	public void testGetBookings() {
		assertNotNull(aircraftA380Full.getBookings());
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getNumBusiness()}.
	 */
	@Test
	public void testGetNumBusiness() {
		assertNotNull(aircraftA380.getNumBusiness());
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getNumEconomy()}.
	 */
	@Test
	public void testGetNumEconomy() {
		assertNotNull(aircraftA380.getNumEconomy());
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getNumFirst()}.
	 */
	@Test
	public void testGetNumFirst() {
		assertNotNull(aircraftA380.getNumFirst());
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getNumPassengers()}.
	 */
	@Test
	public void testGetNumPassengers() {
		assertNotNull(aircraftA380.getNumPassengers());
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getNumPremium()}.
	 */
	@Test
	public void testGetNumPremium() {
		assertNotNull(aircraftA380.getNumPremium());
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getPassengers()}.
	 */
	@Test
	public void testGetPassengers() {
		assertNotNull(aircraftA380.getPassengers());
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getStatus(int)}.
	 */
	@Test
	public void testGetStatus() {
		assertEquals("1::0::F:0::J:0::P:0::Y:0\n", aircraftA380.getStatus(1));
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#hasPassenger(asgn2Passengers.Passenger)}.
	 */
	@Test
	public void testHasPassengerTrue() throws AircraftException, PassengerException {
		aircraftA380.confirmBooking(bizPassenger, 1);
		assertTrue(aircraftA380.hasPassenger(bizPassenger));
	}

	@Test
	public void testHasPassengerFalse() throws AircraftException, PassengerException {
		assertFalse(aircraftA380.hasPassenger(bizPassenger));
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#initialState()}.
	 */
	@Test
	public void testInitialStatePass() {
		assertEquals("A380:FullFlightCode:1 Capacity: 4 [F: 1 J: 1 P: 1 Y: 1]", aircraftA380Full.initialState());
	}

	@Test
	public void testInitialStateFail() {
		assertNotEquals("", aircraftA380Full.initialState());
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#seatsAvailable(asgn2Passengers.Passenger)}.
	 */
	@Test
	public void testSeatsAvailablePass() {
		assertTrue(aircraftA380.seatsAvailable(bizPassenger));
	}

	@Test
	public void testSeatsAvailableFail() {
		assertFalse(aircraftA380Full.seatsAvailable(bizPassenger));
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#toString()}.
	 */
	@Test
	public void testToStringPass() {
		assertEquals("A380:EmptyFlightCode:123 Count: 0 [F: 0 J: 0 P: 0 Y: 0]", aircraftA380.toString());
	}

	@Test
	public void testToStringFail() {
		assertNotEquals("", aircraftA380.toString());
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#upgradeBookings()}.
	 */
	@Test
	public void testUpgradeBookings() {
		aircraftA380Partial.upgradeBookings();
		assertEquals("A380:PartialFlightCode:1 Count: 4 [F: 2 J: 1 P: 1 Y: 0]", aircraftA380Partial.toString());
	}

	@Test
	public void testUpgradeBookingsToFirstPossible() {
		aircraftA380Partial.upgradeBookings();

		// Confirm our old Business Class Passenger is now First Class
		String[] id = partialBusiness.getPassID().split(":");
		List<Passenger> passengerList = aircraftA380Partial.getPassengers();
		for (Passenger passenger : passengerList) {
			if (Objects.equals(passenger.getPassID().split(":")[1], id[1])) {
				assertTrue(passenger instanceof First);
			}
		}
	}

	@Test
	public void testUpgradeBookingsToFirstNotPossible() {
		aircraftA380Full.upgradeBookings();

		// Confirm our old Business Class Passenger is now First Class
		String[] id = fullBusiness.getPassID().split(":");
		List<Passenger> passengerList = aircraftA380Full.getPassengers();
		for (Passenger passenger : passengerList) {
			if (Objects.equals(passenger.getPassID().split(":")[1], id[1])) {
				assertTrue(passenger instanceof Business);
			}
		}
	}

	@Test
	public void testUpgradeBookingsToBusinessPossible() {
		aircraftA380Partial.upgradeBookings();

		// Confirm our old Premium Class Passenger is now Business Class
		String[] id = partialPremium.getPassID().split(":");
		List<Passenger> passengerList = aircraftA380Partial.getPassengers();
		for (Passenger passenger : passengerList) {
			if (Objects.equals(passenger.getPassID().split(":")[1], id[1])) {
				assertTrue(passenger instanceof Business);
			}
		}
	}

	@Test
	public void testUpgradeBookingsToBusinessNotPossible() {
		aircraftA380Full.upgradeBookings();

		// Confirm our old Business Class Passenger is now First Class
		String[] id = fullPremium.getPassID().split(":");
		List<Passenger> passengerList = aircraftA380Full.getPassengers();
		for (Passenger passenger : passengerList) {
			if (Objects.equals(passenger.getPassID().split(":")[1], id[1])) {
				assertTrue(passenger instanceof Premium);
			}
		}
	}

	@Test
	public void testUpgradeBookingsToPremiumPossible() {
		aircraftA380Partial.upgradeBookings();

		// Confirm our old Economy Class Passenger is now Premium Class
		String[] id = partialEconomy.getPassID().split(":");
		List<Passenger> passengerList = aircraftA380Partial.getPassengers();
		for (Passenger passenger : passengerList) {
			if (Objects.equals(passenger.getPassID().split(":")[1], id[1])) {
				assertTrue(passenger instanceof Premium);
			}
		}
	}

	@Test
	public void testUpgradeBookingsToPremiumNotPossible() {
		aircraftA380Full.upgradeBookings();

		// Confirm our old Business Class Passenger is now First Class
		String[] id = fullEconomy.getPassID().split(":");
		List<Passenger> passengerList = aircraftA380Full.getPassengers();
		for (Passenger passenger : passengerList) {
			if (Objects.equals(passenger.getPassID().split(":")[1], id[1])) {
				assertTrue(passenger instanceof Economy);
			}
		}
	}
}