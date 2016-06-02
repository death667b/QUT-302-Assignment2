/**
 * 
 * This file is part of the AircraftSimulator Project, written as 
 * part of the assessment for CAB302, semester 1, 2016. 
 * 
 */
package asgn2Simulators;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JRadioButton;

import asgn2Aircraft.AircraftException;
import asgn2Passengers.PassengerException;

/**
 * Class to operate the simulation, taking parameters and utility methods from the Simulator
 * to control the available resources, and using Log to provide a record of operation. 
 * 
 * @author hogan
 *
 */ 
public class SimulationRunner {
	/**
	 * Main program for the simulation 
	 * 
	 * @param args Arguments to the simulation - 
	 * see {@link asgn2Simulators.SimulationRunner#printErrorAndExit()}
	 */
	public static void main(String[] args) {
		
		if (args.length == 0 || args.length == 10) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUISimulator simGUI = new GUISimulator("Aircraft booking simulator");
	
						if (args.length == 0) { 
							simGUI.displayDefaultsValues();
						} else if (args.length == 10){
							simGUI.setDefaultsValues(args);
						}
						
						JButton startButton = simGUI.getStartButton();
						JButton showSummaryButton = simGUI.getShowSummaryButton();
						JRadioButton radioDisplayText = simGUI.getRadioDisplay();
						JRadioButton radioDisplayGraph = simGUI.getRadioGraph();
						
						startButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								startSim(simGUI.getStartingValues(), simGUI);
								
							}
						});
						
						showSummaryButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								simGUI.activateSummaryScreen();
							}
						});
						
						radioDisplayText.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								simGUI.activateTextPanel();
							}
						});
						
						radioDisplayGraph.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								simGUI.activateGraphPanel();
							}
						});

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	
	private static void startSim(String[] args, GUISimulator simGUI){
		final int NUM_ARGS = 10; 
		Simulator s = null; 
		Log l = null; 
		
		try {
			switch (args.length) {
				case NUM_ARGS: {
					s = createSimulatorUsingArgs(args); 
					break;
				}
				case 0: {
					s = new Simulator(); 
					
					break;
				}
				default: {
					printErrorAndExit(); 
				}
			}
			l = new Log();
		} catch (SimulationException | IOException e1) {
			e1.printStackTrace();
			System.exit(-1);
		}
	
		//Run the simulation 
		SimulationRunner sr = new SimulationRunner(s,l);
		try {
			sr.runSimulation(simGUI);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		} 
	}

	
	/**
	 * Helper to process args for Simulator  
	 * 
	 * @param args Command line arguments (see usage message) 
	 * @return new <code>Simulator</code> from the arguments 
	 * @throws SimulationException if invalid arguments. 
	 * See {@link asgn2Simulators.Simulator#Simulator(int, int, double, double, double, double, double, double, double)}
	 */
	private static Simulator createSimulatorUsingArgs(String[] args) throws SimulationException {
		int seed = Integer.parseInt(args[0]);
		int maxQueueSize = Integer.parseInt(args[1]);
		double meanBookings = Double.parseDouble(args[2]);
		double sdBookings = Double.parseDouble(args[3]);
		double firstProb = Double.parseDouble(args[4]);
		double businessProb = Double.parseDouble(args[5]);
		double premiumProb = Double.parseDouble(args[6]);
		double economyProb = Double.parseDouble(args[7]);
		double cancelProb = Double.parseDouble(args[8]);
		return new Simulator(seed,maxQueueSize,meanBookings,sdBookings,firstProb,businessProb,
						  premiumProb,economyProb,cancelProb);	
	}
	
	/**
	 *  Helper to generate usage message 
	 */
	private static void printErrorAndExit() {
		String str = "Usage: java asgn2Simulators.SimulationRunner [SIM Args]\n";
		str += "SIM Args: seed maxQueueSize meanBookings sdBookings "; 
		str += "firstProb businessProb premiumProb economyProb cancelProb\n";
		str += "If no arguments, default values are used\n";
		System.err.println(str);
		System.exit(-1);
	}
	
	
	private Simulator sim;
	private Log log; 

	/**
	 * Constructor just does initialisation 
	 * 
	 * @param sim <code>Simulator</code> containing simulation parameters
	 * @param log <code>Log</code> object supporting record of operation 
	 */
	public SimulationRunner(Simulator sim, Log log) {
		this.sim = sim;
		this.log = log;
	}

	/**
	 * Method to run the simulation from start to finish. 
	 * Exceptions are propagated upwards as necessary 
	 * @param simGUI 
	 * 
	 * @throws AircraftException See methods from {@link asgn2Simulators.Simulator} 
	 * @throws PassengerException See methods from {@link asgn2Simulators.Simulator} 
	 * @throws SimulationException See methods from {@link asgn2Simulators.Simulator} 
	 * @throws IOException on logging failures See methods from {@link asgn2Simulators.Log} 

	 */
	public void runSimulation(GUISimulator simGUI) throws AircraftException, PassengerException, SimulationException, IOException {
		
		simGUI.clearTextScrollPanel();
		this.sim.createSchedule();
		this.log.initialEntry(this.sim);
		displayInitialEnttry(simGUI);

		//Main simulation loop 
		for (int time=0; time<=Constants.DURATION; time++) {
			this.sim.resetStatus(time); 
			this.sim.rebookCancelledPassengers(time); 
			this.sim.generateAndHandleBookings(time);
			this.sim.processNewCancellations(time);
			if (time >= Constants.FIRST_FLIGHT) {
				this.sim.processUpgrades(time);
				this.sim.processQueue(time);
				this.sim.flyPassengers(time);
				this.sim.updateTotalCounts(time); 
				this.log.logFlightEntries(time, sim);
			} else {
				this.sim.processQueue(time);
			}
			//Log progress 
			this.log.logQREntries(time, sim);
			this.log.logEntry(time,this.sim);
			displayDailyLogs(simGUI, time);
		}
		this.sim.finaliseQueuedAndCancelledPassengers(Constants.DURATION); 
		this.log.logQREntries(Constants.DURATION, sim);
		this.log.finalise(this.sim);
		displayFinalLog(simGUI);
	}
	
	private void displayInitialEnttry(GUISimulator simGUI) throws SimulationException{
		String setText = "";
		setText = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		setText += ": Start of Simulation\n";
		setText += sim.toString() + "\n";
		setText += sim.getFlights(Constants.FIRST_FLIGHT).initialState();
		
		simGUI.textScrollPanel(true, setText);
	}
	
	private void displayDailyLogs(GUISimulator simGUI, int time) throws SimulationException{
		boolean flying = (time >= Constants.FIRST_FLIGHT);
		simGUI.textScrollPanel(true, sim.getSummary(time, flying));
	}

	private void displayFinalLog(GUISimulator simGUI){
		String setText = "\n";
		setText += new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		setText += ": End of Simulation\n";
		setText += sim.finalState();
		
		simGUI.textScrollPanel(true, setText);
	}
	
}


