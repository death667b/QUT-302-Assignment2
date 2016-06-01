/**
 * 
 */
package asgn2Tests;

import static org.junit.Assert.*;

import asgn2Aircraft.A380;
import asgn2Passengers.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author user
 *
 */
public class BusinessTests {

	private A380 aircraftA380, aircraftA380Full, aircraftA380Partial, aircraftErrors;
	private First partialFirst, fullFirst;
	private Business bizPassenger, partialBusiness, fullBusiness;
	private Premium partialPremium, fullPremium;
	private Economy partialEconomy, fullEconomy;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Create an Aircraft and a single unassigned Passenger.
		aircraftA380 = new A380("EmptyFlightCode", 123);
		bizPassenger = new Business(50, 123);

		// Create an Aircraft with a capacity of 2 seats in each class. Create and assign a single Passenger for each class. This Aircraft is partially full.
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
	 * Test method for {@link asgn2Passengers.Business#noSeatsMsg()}.
	 */
	@Test
	public void testNoSeatsMsg() throws PassengerException {
		assertEquals("No seats available in Business", partialBusiness.noSeatsMsg());
	}

	/**
	 * Test method for {@link asgn2Passengers.Business#upgrade()}.
	 */
	@Test
	public void testUpgradePass() {
		partialBusiness.upgrade();
		assertEquals("", partialBusiness.getPassID());
	}

	@Test
	public void testUpgradeFail() {
		partialBusiness.upgrade();
	}

	/**
	 * Test method for {@link asgn2Passengers.Business#Business(int, int)}.
	 */
	@Test
	public void testBusinessIntInt() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Passengers.Business#Business()}.
	 */
	@Test
	public void testBusiness() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#Passenger(int, int)}.
	 */
	@Test
	public void testPassengerIntInt() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#Passenger()}.
	 */
	@Test
	public void testPassenger() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#cancelSeat(int)}.
	 */
	@Test
	public void testCancelSeat() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#confirmSeat(int, int)}.
	 */
	@Test
	public void testConfirmSeat() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#flyPassenger(int)}.
	 */
	@Test
	public void testFlyPassenger() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#getBookingTime()}.
	 */
	@Test
	public void testGetBookingTime() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#getConfirmationTime()}.
	 */
	@Test
	public void testGetConfirmationTime() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#getDepartureTime()}.
	 */
	@Test
	public void testGetDepartureTime() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#getEnterQueueTime()}.
	 */
	@Test
	public void testGetEnterQueueTime() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#getExitQueueTime()}.
	 */
	@Test
	public void testGetExitQueueTime() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#getPassID()}.
	 */
	@Test
	public void testGetPassID() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#isConfirmed()}.
	 */
	@Test
	public void testIsConfirmed() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#isFlown()}.
	 */
	@Test
	public void testIsFlown() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#isNew()}.
	 */
	@Test
	public void testIsNew() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#isQueued()}.
	 */
	@Test
	public void testIsQueued() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#isRefused()}.
	 */
	@Test
	public void testIsRefused() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#queuePassenger(int, int)}.
	 */
	@Test
	public void testQueuePassenger() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#refusePassenger(int)}.
	 */
	@Test
	public void testRefusePassenger() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#toString()}.
	 */
	@Test
	public void testToString() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#wasConfirmed()}.
	 */
	@Test
	public void testWasConfirmed() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#wasQueued()}.
	 */
	@Test
	public void testWasQueued() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#copyPassengerState(asgn2Passengers.Passenger)}.
	 */
	@Test
	public void testCopyPassengerState() {
		fail("Not yet implemented"); // TODO
	}

}
