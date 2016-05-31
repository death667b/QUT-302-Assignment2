/**
 * 
 */
package asgn2Tests;

import static org.junit.Assert.*;

import asgn2Aircraft.Aircraft;
import asgn2Passengers.Passenger;
import org.junit.Before;
import org.junit.Test;

import asgn2Aircraft.A380;
import asgn2Aircraft.AircraftException;
import asgn2Passengers.Business;
import asgn2Passengers.PassengerException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author user
 *
 */
public class A380Test {
	
	private A380 aircraftA380, aircraftErrors;
	private Business bizPassenger; 
	
	/**
	 * @throws PassengerException
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws AircraftException, PassengerException {
		aircraftA380 = new A380("stringFlightCode", 123);
		bizPassenger = new Business(50, 123);
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
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */

	@Test
	public void testCancelBookingSuccess() throws AircraftException, PassengerException {
		aircraftA380.confirmBooking(bizPassenger, 1);
		aircraftA380.cancelBooking(bizPassenger, 1);
	}

	@Test(expected = AircraftException.class)
	public void testCancelBookingPassengerDoesntExist() throws AircraftException, PassengerException, NoSuchFieldException, IllegalAccessException {
		aircraftA380.confirmBooking(bizPassenger, 1);
		Field reflect = Aircraft.class.getDeclaredField("seats");
		reflect.setAccessible(true);
		List<Passenger> seats = new ArrayList<>();
		reflect.set(aircraftA380, seats);
		reflect.setAccessible(false);
		aircraftA380.cancelBooking(bizPassenger, 1);
	}

	@Test(expected = PassengerException.class)
	public void testCancelBookingPassengerNotConfirmed() throws AircraftException, PassengerException {
		aircraftA380.cancelBooking(bizPassenger, 100);
	}
	
	@Test(expected = PassengerException.class)
	public void testCancelBookingCancellationLessThanZero() throws AircraftException, PassengerException {
		aircraftA380.confirmBooking(bizPassenger, -1);
		aircraftA380.cancelBooking(bizPassenger, 100);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#confirmBooking(asgn2Passengers.Passenger, int)}.
	 */
	@Test
	public void testConfirmBooking() throws AircraftException, PassengerException {
		aircraftA380.confirmBooking(bizPassenger, 1);
	}

	@Test(expected = PassengerException.class)
	public void testConfirmBookingDepartureTimeGreaterThanZero() throws AircraftException, PassengerException, NoSuchFieldException, IllegalAccessException {
		Field reflect = Aircraft.class.getDeclaredField("departureTime");
		reflect.setAccessible(true);
		reflect.set(aircraftA380, -1);
		reflect.setAccessible(false);
		aircraftA380.confirmBooking(bizPassenger, 1);
	}

	@Test(expected = PassengerException.class)
	public void testConfirmBookingConfirmationNotEqualOrGreaterZero() throws AircraftException, PassengerException {
		aircraftA380.confirmBooking(bizPassenger, -1);
	}

	@Test(expected = AircraftException.class)
	public void testConfirmBookingSeatsAvailable() throws NoSuchFieldException, IllegalAccessException, AircraftException, PassengerException {
		Field reflectFirst = Aircraft.class.getDeclaredField("firstCapacity");
		reflectFirst.setAccessible(true);
		reflectFirst.set(aircraftA380, 0);
		reflectFirst.setAccessible(false);
		Field reflectBusiness = Aircraft.class.getDeclaredField("businessCapacity");
		reflectBusiness.setAccessible(true);
		reflectBusiness.set(aircraftA380, 0);
		reflectBusiness.setAccessible(false);
		Field reflectPremium = Aircraft.class.getDeclaredField("premiumCapacity");
		reflectPremium.setAccessible(true);
		reflectPremium.set(aircraftA380, 0);
		reflectPremium.setAccessible(false);
		Field reflectEconomy = Aircraft.class.getDeclaredField("economyCapacity");
		reflectEconomy.setAccessible(true);
		reflectEconomy.set(aircraftA380, 0);
		reflectEconomy.setAccessible(false);
		aircraftA380.confirmBooking(bizPassenger, 1);
	}

	@Test(expected = PassengerException.class)
	public void testConfirmBookingPassengerIncorrectState() throws NoSuchFieldException, IllegalAccessException, AircraftException, PassengerException {
		Field reflectState = Passenger.class.getDeclaredField("newState");
		reflectState.setAccessible(true);
		reflectState.set(bizPassenger, false);
		reflectState.setAccessible(false);
		Field reflectQueue = Passenger.class.getDeclaredField("inQueue");
		reflectQueue.setAccessible(true);
		reflectQueue.set(bizPassenger, false);
		reflectQueue.setAccessible(false);
		aircraftA380.confirmBooking(bizPassenger, 1);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#finalState()}.
	 */
	@Test
	public void testFinalState() {
		assertEquals("A380:stringFlightCode:123 Pass: 0\n\n", aircraftA380.finalState());
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#flightEmpty()}.
	 */
	@Test
	public void testFlightEmpty() {
		assertEquals(true, aircraftA380.flightEmpty());
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
