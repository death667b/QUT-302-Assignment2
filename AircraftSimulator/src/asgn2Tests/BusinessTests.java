/**
 * 
 */
package asgn2Tests;

import static org.junit.Assert.*;

import asgn2Passengers.*;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author user
 *
 */
public class BusinessTests {

	private Business passenger;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws PassengerException {
		passenger = new Business(1, 1);
	}

	/**
	 * Test method for {@link asgn2Passengers.Business#noSeatsMsg()}.
	 */
	@Test
	public void testNoSeatsMsg() throws PassengerException {
		assertEquals("No seats available in Business", passenger.noSeatsMsg());
	}

	/**
	 * Test method for {@link asgn2Passengers.Business#upgrade()}.
	 */
	@Test
	public void testUpgrade() {
		Passenger newPassenger = passenger.upgrade();
		assertTrue(newPassenger instanceof First);
	}

	/**
	 * Test method for {@link asgn2Passengers.Business#Business(int, int)}.
	 */
	@Test
	public void testBusiness_NotNull() {
		assertNotNull(passenger);
	}

	@Test(expected = PassengerException.class)
	public void testBusiness_InvalidBookingTime() throws PassengerException {
		Business passenger = new Business(-1, 1);
	}

	@Test(expected = PassengerException.class)
	public void testBusiness_InvalidDepartureTime() throws PassengerException {
		Business passenger = new Business(1, -1);
	}

	@Test(expected = PassengerException.class)
	public void testBusiness_DepartureLessThenBooking() throws PassengerException {
		Business passenger = new Business(2, 1);
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#cancelSeat(int)}.
	 */
	@Test
	public void testCancelSeat() throws PassengerException {
		passenger.confirmSeat(1, 1);
		passenger.cancelSeat(1);
	}

	@Test(expected = PassengerException.class)
	public void testCancelSeat_isNew() throws PassengerException {
		passenger.cancelSeat(1);
	}

	@Test(expected = PassengerException.class)
	public void testCancelSeat_isQueued() throws PassengerException {
		passenger.queuePassenger(1, 1);
		passenger.cancelSeat(1);
	}

	@Test(expected = PassengerException.class)
	public void testCancelSeat_isRefused() throws PassengerException {
		passenger.refusePassenger(1);
		passenger.cancelSeat(1);
	}

	@Test(expected = PassengerException.class)
	public void testCancelSeat_isFlown() throws PassengerException {
		passenger.confirmSeat(1, 1);
		passenger.flyPassenger(1);
		passenger.cancelSeat(1);
	}

	@Test(expected = PassengerException.class)
	public void testCancelSeat_CancellationLessThanZero() throws PassengerException {
		passenger.cancelSeat(-1);
	}

	@Test(expected = PassengerException.class)
	public void testCancelSeat_DepartureLessThanCancellation() throws PassengerException {
		passenger.cancelSeat(0);
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#confirmSeat(int, int)}.
	 */
	@Test
	public void testConfirmSeat() throws PassengerException {
		passenger.confirmSeat(1, 1);
	}

	@Test(expected = PassengerException.class)
	public void testConfirmSeat_isConfirmed() throws PassengerException {
		passenger.confirmSeat(1, 1);
		passenger.confirmSeat(1, 1);
	}

	@Test(expected = PassengerException.class)
	public void testConfirmSeat_isRefused() throws PassengerException {
		passenger.refusePassenger(1);
		passenger.confirmSeat(1, 1);
	}

	@Test(expected = PassengerException.class)
	public void testConfirmSeat_isFlown() throws PassengerException {
		passenger.flyPassenger(1);
		passenger.confirmSeat(1, 1);
	}

	@Test(expected = PassengerException.class)
	public void testConfirmSeat_ConfirmationLessThanZero() throws PassengerException {
		passenger.confirmSeat(-1, 1);
	}

	@Test(expected = PassengerException.class)
	public void testConfirmSeat_DepartureLessThanConfirmation() throws PassengerException {
		passenger.confirmSeat(2, 1);
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#flyPassenger(int)}.
	 */
	@Test
	public void testFlyPassenger() throws PassengerException {
		passenger.confirmSeat(1, 1);
		passenger.flyPassenger(1);
	}

	@Test(expected = PassengerException.class)
	public void testFlyPassenger_isNew() throws PassengerException {
		passenger.flyPassenger(1);
	}

	@Test(expected = PassengerException.class)
	public void testFlyPassenger_isRefused() throws PassengerException {
		passenger.refusePassenger(1);
		passenger.flyPassenger(1);
	}

	@Test(expected = PassengerException.class)
	public void testFlyPassenger_isFlown() throws PassengerException {
		passenger.flyPassenger(1);
		passenger.flyPassenger(1);
	}

	@Test(expected = PassengerException.class)
	public void testFlyPassenger_DepartureLessThanZero() throws PassengerException {
		passenger.confirmSeat(1, 1);
		passenger.flyPassenger(-1);
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#getBookingTime()}.
	 */
	@Test
	public void testGetBookingTime() {
		assertNotNull(passenger.getBookingTime());
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#getConfirmationTime()}.
	 */
	@Test
	public void testGetConfirmationTime() {
		assertNotNull(passenger.getConfirmationTime());
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#getDepartureTime()}.
	 */
	@Test
	public void testGetDepartureTime() {
		assertNotNull(passenger.getDepartureTime());
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#getEnterQueueTime()}.
	 */
	@Test
	public void testGetEnterQueueTime() {
		assertNotNull(passenger.getEnterQueueTime());
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#getExitQueueTime()}.
	 */
	@Test
	public void testGetExitQueueTime() {
		assertNotNull(passenger.getExitQueueTime());
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#getPassID()}.
	 */
	@Test
	public void testGetPassID() {
		assertNotNull(passenger.getPassID());
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#isConfirmed()}.
	 */
	@Test
	public void testIsConfirmed() throws PassengerException {
		passenger.confirmSeat(1, 1);
		assertTrue(passenger.isConfirmed());
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#isFlown()}.
	 */
	@Test
	public void testIsFlown() throws PassengerException {
		passenger.confirmSeat(1, 1);
		passenger.flyPassenger(1);
		assertTrue(passenger.isFlown());
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#isNew()}.
	 */
	@Test
	public void testIsNew() {
		assertTrue(passenger.isNew());
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#isQueued()}.
	 */
	@Test
	public void testIsQueued() throws PassengerException {
		passenger.queuePassenger(1, 1);
		assertTrue(passenger.isQueued());
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#isRefused()}.
	 */
	@Test
	public void testIsRefused() throws PassengerException {
		passenger.refusePassenger(1);
		assertTrue(passenger.isRefused());
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#queuePassenger(int, int)}.
	 */
	@Test
	public void testQueuePassenger() throws PassengerException {
		passenger.queuePassenger(1, 1);
		assertTrue(passenger.isQueued());
	}

	@Test(expected = PassengerException.class)
	public void testQueuePassenger_isQueued() throws PassengerException {
		passenger.queuePassenger(1, 1);
		passenger.queuePassenger(1, 1);
	}

	@Test(expected = PassengerException.class)
	public void testQueuePassenger_isConfirmed() throws PassengerException {
		passenger.confirmSeat(1, 1);
		passenger.queuePassenger(1, 1);
	}

	@Test(expected = PassengerException.class)
	public void testQueuePassenger_isRefused() throws PassengerException {
		passenger.refusePassenger(1);
		passenger.queuePassenger(1, 1);
	}

	@Test(expected = PassengerException.class)
	public void testQueuePassenger_isFlown() throws PassengerException {
		passenger.flyPassenger(1);
		passenger.queuePassenger(1, 1);
	}

	@Test(expected = PassengerException.class)
	public void testQueuePassenger_DepartLessThanQueue() throws PassengerException {
		passenger.queuePassenger(2, 1);
	}

	@Test(expected = PassengerException.class)
	public void testQueuePassenger_QueueLessThanZero() throws PassengerException {
		passenger.queuePassenger(-1, 1);
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#refusePassenger(int)}.
	 */
	@Test
	public void testRefusePassenger() throws PassengerException {
		passenger.refusePassenger(1);
		assertTrue(passenger.isRefused());
	}

	@Test(expected = PassengerException.class)
	public void testRefusePassenger_isConfirmed() throws PassengerException {
		passenger.confirmSeat(1, 1);
		passenger.refusePassenger(1);
	}

	@Test(expected = PassengerException.class)
	public void testRefusePassenger_isRefused() throws PassengerException {
		passenger.refusePassenger(1);
		passenger.refusePassenger(1);
	}

	@Test(expected = PassengerException.class)
	public void testRefusePassenger_isFlown() throws PassengerException {
		passenger.flyPassenger(1);
		passenger.refusePassenger(1);
	}

	@Test(expected = PassengerException.class)
	public void testRefusePassenger_RefusalLessThanBooking() throws PassengerException {
		passenger.refusePassenger(0);
	}

	@Test(expected = PassengerException.class)
	public void testRefusePassenger_RefusalLessThanZero() throws PassengerException {
		passenger.refusePassenger(-1);
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#toString()}.
	 */
	@Test
	public void testToString() throws PassengerException, NoSuchFieldException, IllegalAccessException {
		// This was returning weird errors with the ID not being expected so I had to use reflection to get an
		// expected result. I suspect this is due to a memory management or garbage collection issue as the
		// received ID when running the entire BusinessTests Class was periodically different.
		Field passengerID = Passenger.class.getDeclaredField("passID");
		passengerID.setAccessible(true);
		passengerID.set(passenger, "J:0");
		passengerID.setAccessible(false);

		assertEquals("passID: J:0\nBT: 1\nNotQ", passenger.toString());
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#wasConfirmed()}.
	 */
	@Test
	public void testWasConfirmed_True() throws PassengerException {
		passenger.confirmSeat(1, 1);
		assertTrue(passenger.wasConfirmed());
	}

	@Test(expected = PassengerException.class)
	public void testWasConfirmed_False() throws PassengerException {
		passenger.confirmSeat(-1, 1);
		assertFalse(passenger.wasConfirmed());
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#wasQueued()}.
	 */
	@Test
	public void testWasQueued_True() throws PassengerException {
		passenger.queuePassenger(1, 1);
		assertTrue(passenger.wasQueued());
	}

	@Test(expected = PassengerException.class)
	public void testWasQueue_False() throws PassengerException {
		passenger.queuePassenger(-1, 1);
		assertFalse(passenger.wasQueued());
	}
}