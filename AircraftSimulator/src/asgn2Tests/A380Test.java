/**
 * 
 */
package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Aircraft.A380;
import asgn2Aircraft.AircraftException;

/**
 * @author user
 *
 */
public class A380Test {
	
	private A380 aircraftA380, aircraftErrors;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws AircraftException {
		aircraftA380 = new A380("stringFlightCode", 123);
	}

	/**
	 * Test method for {@link asgn2Aircraft.A380#A380(java.lang.String, int)}.
	 */
	@Test
	public void testA380StringInt() {
		fail("Not yet implemented"); // TODO
	}
	


	/**
	 * Test method for {@link asgn2Aircraft.A380#A380(java.lang.String, int, int, int, int, int)}.
	 */
	@Test
	public void testA380StringIntIntIntIntInt() {
		fail("Not yet implemented"); // TODO
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
		assertEquals("A380:stringFlightCode:123 Capacity: 484 [F: 14 J: 64 P: 35 Y: 371]", aircraftA380.initialState());
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
	public void testAircraftNegitiveFirstClassExpectFail() throws AircraftException {
		aircraftErrors = new A380("123", 123, -1, 123, 123, 123);
	}
	
	@Test(expected = AircraftException.class)
	public void testAircraftNegitiveBusinessClassExpectFail() throws AircraftException {
		aircraftErrors = new A380("123", 123, 123, -1, 123, 123);
	}
	
	@Test(expected = AircraftException.class)
	public void testAircraftNegitivePremClassExpectFail() throws AircraftException {
		aircraftErrors = new A380("123", 123, 123, 123, -1, 123);
	}
	
	@Test(expected = AircraftException.class)
	public void testAircraftNegitiveEconClassExpectFail() throws AircraftException {
		aircraftErrors = new A380("123", 123, 123, 123, 123, -1);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#cancelBooking(asgn2Passengers.Passenger, int)}.
	 */
	@Test
	public void testCancelBooking() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#confirmBooking(asgn2Passengers.Passenger, int)}.
	 */
	@Test
	public void testConfirmBooking() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#finalState()}.
	 */
	@Test
	public void testFinalState() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#flightEmpty()}.
	 */
	@Test
	public void testFlightEmpty() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#flightFull()}.
	 */
	@Test
	public void testFlightFull() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#flyPassengers(int)}.
	 */
	@Test
	public void testFlyPassengers() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getBookings()}.
	 */
	@Test
	public void testGetBookings() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getNumBusiness()}.
	 */
	@Test
	public void testGetNumBusiness() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getNumEconomy()}.
	 */
	@Test
	public void testGetNumEconomy() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getNumFirst()}.
	 */
	@Test
	public void testGetNumFirst() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getNumPassengers()}.
	 */
	@Test
	public void testGetNumPassengers() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getNumPremium()}.
	 */
	@Test
	public void testGetNumPremium() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getPassengers()}.
	 */
	@Test
	public void testGetPassengers() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getStatus(int)}.
	 */
	@Test
	public void testGetStatus() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#hasPassenger(asgn2Passengers.Passenger)}.
	 */
	@Test
	public void testHasPassenger() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#initialState()}.
	 */
	@Test
	public void testInitialState() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#seatsAvailable(asgn2Passengers.Passenger)}.
	 */
	@Test
	public void testSeatsAvailable() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#toString()}.
	 */
	@Test
	public void testToString() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#upgradeBookings()}.
	 */
	@Test
	public void testUpgradeBookings() {
		fail("Not yet implemented"); // TODO
	}

}