/**
 * 
 * This file is part of the AircraftSimulator Project, written as 
 * part of the assessment for CAB302, semester 1, 2016. 
 * 
 */
package asgn2Simulators;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Point;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;


/**
 * @author hogan
 *
 */
@SuppressWarnings("serial")
public class GUISimulator extends JFrame implements Runnable {

	private JPanel mainPane;
	private JPanel textPanel;
	private JPanel graphPanel;
	private JPanel summaryPanel;
	private JPanel probabilityPanel;
	private JPanel settingsPanel;
	private JPanel radioPanel;
	private JPanel buttonPanel;
	private JTextField maxQueSizeTextField;
	private JTextField dailyBookingMeanTextField;
	private JTextField minBookingsTextField;
	private JTextField bookingStanDevTextField;
	private JTextField seedTextField;
	private JTextField firstClTextField;
	private JTextField businessClTextField;
	private JTextField premiumClTextField;
	private JTextField economyClTextField;
	private JTextField canellationTextField;
	private JTextArea reportText;
	private JLabel labelDailyBookingMean;
	private JLabel labelMinimumBookings;
	private JLabel labelBookingStandardDevation;
	private JLabel labelFirstCl;
	private JLabel labelBusinessCl;
	private JLabel labelPremiumCl;
	private JLabel labelEconomyCl;
	private JLabel labelCancellation;
	private JLabel labelProbabilityPanelTitle;
	private JLabel labelSettingsPanelTitle;
	private JScrollPane logsScrollPane;
	private JButton startButton;
	private JButton showSummaryButton;
	private JRadioButton radioDisplayText;
	private JRadioButton radioDisplayGraph;
	private final ButtonGroup textOrGraphGroup = new ButtonGroup();
	private JFreeChart chart;
	
	/**
	 * @param arg0
	 * @throws HeadlessException
	 */
	public GUISimulator(String arg0) throws HeadlessException {
		super(arg0);
		drawGUIWindow();
	}
	
	@Override
	public void run() {
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
	
	public void setDataSet(TimeSeriesCollection dataset){
		graphPanel.removeAll();
		chart = createChart(dataset);
		graphPanel.add(new ChartPanel(chart), BorderLayout.CENTER);
		graphPanel.revalidate();
		
	}
	
	public JButton getStartButton(){
		return startButton;
	}
	
	public JButton getShowSummaryButton(){
		return showSummaryButton;
	}
	
	public JRadioButton getRadioDisplay(){
		return radioDisplayText;
	}
	
	public JRadioButton getRadioGraph(){
		return radioDisplayGraph;
	}
	
	public void displayDefaultsValues(){
		seedTextField.setText("" + Constants.DEFAULT_SEED);
		maxQueSizeTextField.setText("" + Constants.DEFAULT_MAX_QUEUE_SIZE);
		dailyBookingMeanTextField.setText("" + Constants.DEFAULT_DAILY_BOOKING_MEAN);
		minBookingsTextField.setText("" + Constants.MINIMUM_BOOKINGS);
		bookingStanDevTextField.setText("" + Constants.DEFAULT_DAILY_BOOKING_SD);
		firstClTextField.setText("" + Constants.DEFAULT_FIRST_PROB);
		businessClTextField.setText("" + Constants.DEFAULT_BUSINESS_PROB);
		premiumClTextField.setText("" + Constants.DEFAULT_PREMIUM_PROB);
		economyClTextField.setText("" + Constants.DEFAULT_ECONOMY_PROB);
		canellationTextField.setText("" + Constants.DEFAULT_CANCELLATION_PROB);
	}
	
	public void setDefaultsValues(String[] args){
		seedTextField.setText("" + args[0]);
		maxQueSizeTextField.setText("" + args[1]);
		dailyBookingMeanTextField.setText("" + args[2]);
		minBookingsTextField.setText("" + Constants.MINIMUM_BOOKINGS);
		bookingStanDevTextField.setText("" + args[3]);
		firstClTextField.setText("" + args[4]);
		businessClTextField.setText("" + args[5]);
		premiumClTextField.setText("" + args[6]);
		economyClTextField.setText("" + args[7]);
		canellationTextField.setText("" + args[8]);
	}
	
	public String[] getStartingValues(){
		String[] args = new String[10];
		
		args[0] = seedTextField.getText();
		args[1] = maxQueSizeTextField.getText();
		args[2] = dailyBookingMeanTextField.getText();
		args[3] = bookingStanDevTextField.getText();
		args[4] = firstClTextField.getText();
		args[5] = businessClTextField.getText();
		args[6] = premiumClTextField.getText();
		args[7] = economyClTextField.getText();
		args[8] = canellationTextField.getText();
		args[9] = "1";
		
		return args;
	}
	
	public void activateSummaryScreen(){
		textPanel.setVisible(false);
		graphPanel.setVisible(false);
		summaryPanel.setVisible(true);
	}
	
	public void activateTextPanel(){
		textPanel.setVisible(true);
		graphPanel.setVisible(false);
		summaryPanel.setVisible(false);
	}
	
	public void activateGraphPanel(){
		textPanel.setVisible(false);
		graphPanel.setVisible(true);
		summaryPanel.setVisible(false);
	}
	
    private JFreeChart createChart(final XYDataset dataset) {
        final JFreeChart result = ChartFactory.createTimeSeriesChart(
            null, "Days", "Passengers", dataset, true, true, false);
        final XYPlot plot = result.getXYPlot();
        ValueAxis domain = plot.getDomainAxis();
        domain.setAutoRange(true);
        ValueAxis range = plot.getRangeAxis();
        range.setAutoRange(true);
        return result;
    }
	
	public void textScrollPanel(boolean status, String text){
		
		if (status) textPanel.add(logsScrollPane);
		else textPanel.remove(logsScrollPane);
		
		reportText.setText(reportText.getText() + text);
	}
	
	public void clearTextScrollPanel(){
		reportText.setText("");
	}
		
	public void drawGUIWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(700, 685));
		setLocation(new Point(400, 10));
		pack();
		setVisible(true);
		mainPane = new JPanel();
		mainPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(mainPane);
		GridBagLayout gbl_mainPane = new GridBagLayout();
		gbl_mainPane.columnWidths = new int[] {30, 180, 110, 30, 180, 110, 30};
		gbl_mainPane.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 44, 10};
		gbl_mainPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_mainPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		mainPane.setLayout(gbl_mainPane);
		
		GridBagConstraints gbc_textAndGraphPanel = new GridBagConstraints();
		gbc_textAndGraphPanel.fill = GridBagConstraints.BOTH;
		gbc_textAndGraphPanel.gridheight = 7;
		gbc_textAndGraphPanel.gridwidth = 7;
		gbc_textAndGraphPanel.insets = new Insets(0, 0, 0, 0);
		gbc_textAndGraphPanel.gridx = 0;
		gbc_textAndGraphPanel.gridy = 0;
		
		
		textPanel = new JPanel();
		textPanel.setBackground(new Color(255, 255, 204));
		mainPane.add(textPanel, gbc_textAndGraphPanel);
		
		summaryPanel = new JPanel();
		summaryPanel.setVisible(false);
		summaryPanel.setBackground(new Color(255, 255, 204));
		mainPane.add(summaryPanel, gbc_textAndGraphPanel);
		
		graphPanel = new JPanel();
		graphPanel.setVisible(false);
		graphPanel.setBackground(new Color(255, 255, 204));
		mainPane.add(graphPanel, gbc_textAndGraphPanel);
			
		reportText = new JTextArea();
		reportText.setColumns(60);
		reportText.setRows(26);
		reportText.setLineWrap(true);
		logsScrollPane = new JScrollPane(reportText);
		logsScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		logsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		textPanel.add(logsScrollPane, BorderLayout.CENTER);
		
		settingsPanel = new JPanel();
		settingsPanel.setBackground(Color.WHITE);
		settingsPanel.setBorder(new LineBorder(Color.GRAY, 2, true));
		GridBagConstraints gbc_settingsPanel = new GridBagConstraints();
		gbc_settingsPanel.ipady = 5;
		gbc_settingsPanel.insets = new Insets(0, 0, 5, 5);
		gbc_settingsPanel.fill = GridBagConstraints.BOTH;
		gbc_settingsPanel.gridx = 1;
		gbc_settingsPanel.gridy = 8;
		gbc_settingsPanel.gridwidth = 2;
		gbc_settingsPanel.gridheight = 6;
		mainPane.add(settingsPanel, gbc_settingsPanel);
		GridBagLayout gbl_settingsPanel = new GridBagLayout();
		gbl_settingsPanel.columnWidths = new int[]{145, 145};
		gbl_settingsPanel.rowHeights = new int[] {0, 14, 0, 0, 0, 0, 0};
		gbl_settingsPanel.columnWeights = new double[]{0.0, 0.0};
		gbl_settingsPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		settingsPanel.setLayout(gbl_settingsPanel);
		
		labelSettingsPanelTitle = new JLabel("Settings");
		labelSettingsPanelTitle.setFont(new Font("Rockwell", Font.BOLD, 16));
		GridBagConstraints gbc_labelSettingsPanelTitle = new GridBagConstraints();
		gbc_labelSettingsPanelTitle.insets = new Insets(0, 0, 5, 5);
		gbc_labelSettingsPanelTitle.gridx = 0;
		gbc_labelSettingsPanelTitle.gridy = 0;
		gbc_labelSettingsPanelTitle.gridwidth = 2;
		settingsPanel.add(labelSettingsPanelTitle, gbc_labelSettingsPanelTitle);
		
		JLabel labelSeed = new JLabel("Seed");
		GridBagConstraints gbc_labelSeed = new GridBagConstraints();
		gbc_labelSeed.anchor = GridBagConstraints.EAST;
		gbc_labelSeed.insets = new Insets(0, 0, 5, 5);
		gbc_labelSeed.gridx = 0;
		gbc_labelSeed.gridy = 1;
		settingsPanel.add(labelSeed, gbc_labelSeed);
		
		seedTextField = new JTextField();
		GridBagConstraints gbc_seedTextField = new GridBagConstraints();
		gbc_seedTextField.anchor = GridBagConstraints.WEST;
		gbc_seedTextField.insets = new Insets(0, 0, 5, 0);
		gbc_seedTextField.gridx = 1;
		gbc_seedTextField.gridy = 1;
		settingsPanel.add(seedTextField, gbc_seedTextField);
		seedTextField.setColumns(10);
		
		JLabel labelMaxQueueSize = new JLabel("Max Queue Size");
		GridBagConstraints gbc_labelMaxQueueSize = new GridBagConstraints();
		gbc_labelMaxQueueSize.anchor = GridBagConstraints.EAST;
		gbc_labelMaxQueueSize.insets = new Insets(0, 0, 5, 5);
		gbc_labelMaxQueueSize.gridx = 0;
		gbc_labelMaxQueueSize.gridy = 2;
		settingsPanel.add(labelMaxQueueSize, gbc_labelMaxQueueSize);
		
		maxQueSizeTextField = new JTextField();
		GridBagConstraints gbc_maxQueSizeTextField = new GridBagConstraints();
		gbc_maxQueSizeTextField.anchor = GridBagConstraints.WEST;
		gbc_maxQueSizeTextField.insets = new Insets(0, 0, 5, 0);
		gbc_maxQueSizeTextField.gridx = 1;
		gbc_maxQueSizeTextField.gridy = 2;
		settingsPanel.add(maxQueSizeTextField, gbc_maxQueSizeTextField);
		maxQueSizeTextField.setColumns(10);
		
		labelDailyBookingMean = new JLabel("Daily Booking Mean");
		GridBagConstraints gbc_labelDailyBookingMean = new GridBagConstraints();
		gbc_labelDailyBookingMean.anchor = GridBagConstraints.EAST;
		gbc_labelDailyBookingMean.insets = new Insets(0, 0, 5, 5);
		gbc_labelDailyBookingMean.gridx = 0;
		gbc_labelDailyBookingMean.gridy = 3;
		settingsPanel.add(labelDailyBookingMean, gbc_labelDailyBookingMean);
		
		dailyBookingMeanTextField = new JTextField();
		GridBagConstraints gbc_dailyBookingMeanTextField = new GridBagConstraints();
		gbc_dailyBookingMeanTextField.anchor = GridBagConstraints.WEST;
		gbc_dailyBookingMeanTextField.insets = new Insets(0, 0, 5, 0);
		gbc_dailyBookingMeanTextField.gridx = 1;
		gbc_dailyBookingMeanTextField.gridy = 3;
		settingsPanel.add(dailyBookingMeanTextField, gbc_dailyBookingMeanTextField);
		dailyBookingMeanTextField.setColumns(10);
		
		labelMinimumBookings = new JLabel("Minimum Bookings");
		GridBagConstraints gbc_labelMinimumBookings = new GridBagConstraints();
		gbc_labelMinimumBookings.anchor = GridBagConstraints.EAST;
		gbc_labelMinimumBookings.insets = new Insets(0, 0, 5, 5);
		gbc_labelMinimumBookings.gridx = 0;
		gbc_labelMinimumBookings.gridy = 4;
		settingsPanel.add(labelMinimumBookings, gbc_labelMinimumBookings);
		
		minBookingsTextField = new JTextField();
		minBookingsTextField.setEditable(false);
		GridBagConstraints gbc_minBookingsTextField = new GridBagConstraints();
		gbc_minBookingsTextField.anchor = GridBagConstraints.WEST;
		gbc_minBookingsTextField.insets = new Insets(0, 0, 5, 0);
		gbc_minBookingsTextField.gridx = 1;
		gbc_minBookingsTextField.gridy = 4;
		settingsPanel.add(minBookingsTextField, gbc_minBookingsTextField);
		minBookingsTextField.setColumns(10);
		
		labelBookingStandardDevation = new JLabel("Booking Standard Devation");
		GridBagConstraints gbc_labelBookingStandardDevation = new GridBagConstraints();
		gbc_labelBookingStandardDevation.anchor = GridBagConstraints.EAST;
		gbc_labelBookingStandardDevation.insets = new Insets(0, 0, 0, 5);
		gbc_labelBookingStandardDevation.gridx = 0;
		gbc_labelBookingStandardDevation.gridy = 5;
		settingsPanel.add(labelBookingStandardDevation, gbc_labelBookingStandardDevation);
		
		bookingStanDevTextField = new JTextField();
		bookingStanDevTextField.setEditable(false);
		GridBagConstraints gbc_bookingStanDevTextField = new GridBagConstraints();
		gbc_bookingStanDevTextField.anchor = GridBagConstraints.WEST;
		gbc_bookingStanDevTextField.gridx = 1;
		gbc_bookingStanDevTextField.gridy = 5;
		settingsPanel.add(bookingStanDevTextField, gbc_bookingStanDevTextField);
		bookingStanDevTextField.setColumns(10);
		
		probabilityPanel = new JPanel();
		probabilityPanel.setBackground(Color.WHITE);
		probabilityPanel.setBorder(new LineBorder(Color.GRAY, 2, true));
		GridBagConstraints gbc_probabilityPanel = new GridBagConstraints();
		gbc_probabilityPanel.ipady = 5;
		gbc_probabilityPanel.gridheight = 6;
		gbc_probabilityPanel.gridwidth = 2;
		gbc_probabilityPanel.insets = new Insets(0, 0, 5, 5);
		gbc_probabilityPanel.fill = GridBagConstraints.BOTH;
		gbc_probabilityPanel.gridx = 4;
		gbc_probabilityPanel.gridy = 8;
		mainPane.add(probabilityPanel, gbc_probabilityPanel);
		GridBagLayout gbl_probabilityPanel = new GridBagLayout();
		gbl_probabilityPanel.columnWidths = new int[]{145, 145};
		gbl_probabilityPanel.rowHeights = new int[] {0, 14, 0, 0, 0, 0, 0};
		gbl_probabilityPanel.columnWeights = new double[]{0.0, 0.0};
		gbl_probabilityPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		probabilityPanel.setLayout(gbl_probabilityPanel);
		
		labelProbabilityPanelTitle = new JLabel("Probabilities");
		labelProbabilityPanelTitle.setFont(new Font("Rockwell", Font.BOLD, 16));
		GridBagConstraints gbc_labelProbabilityPanelTitle = new GridBagConstraints();
		gbc_labelProbabilityPanelTitle.gridwidth = 2;
		gbc_labelProbabilityPanelTitle.insets = new Insets(0, 0, 5, 5);
		gbc_labelProbabilityPanelTitle.gridx = 0;
		gbc_labelProbabilityPanelTitle.gridy = 0;
		probabilityPanel.add(labelProbabilityPanelTitle, gbc_labelProbabilityPanelTitle);
		
		labelFirstCl = new JLabel("First Class");
		GridBagConstraints gbc_labelFirstCl = new GridBagConstraints();
		gbc_labelFirstCl.insets = new Insets(0, 0, 5, 5);
		gbc_labelFirstCl.anchor = GridBagConstraints.NORTHEAST;
		gbc_labelFirstCl.gridx = 0;
		gbc_labelFirstCl.gridy = 1;
		probabilityPanel.add(labelFirstCl, gbc_labelFirstCl);
		
		firstClTextField = new JTextField();
		GridBagConstraints gbc_firstClTextField = new GridBagConstraints();
		gbc_firstClTextField.anchor = GridBagConstraints.WEST;
		gbc_firstClTextField.insets = new Insets(0, 0, 5, 0);
		gbc_firstClTextField.gridx = 1;
		gbc_firstClTextField.gridy = 1;
		probabilityPanel.add(firstClTextField, gbc_firstClTextField);
		firstClTextField.setColumns(10);
		
		labelBusinessCl = new JLabel("Business Class");
		GridBagConstraints gbc_labelBusinessCl = new GridBagConstraints();
		gbc_labelBusinessCl.anchor = GridBagConstraints.EAST;
		gbc_labelBusinessCl.insets = new Insets(0, 0, 5, 5);
		gbc_labelBusinessCl.gridx = 0;
		gbc_labelBusinessCl.gridy = 2;
		probabilityPanel.add(labelBusinessCl, gbc_labelBusinessCl);
		
		businessClTextField = new JTextField();
		GridBagConstraints gbc_businessClTextField = new GridBagConstraints();
		gbc_businessClTextField.anchor = GridBagConstraints.WEST;
		gbc_businessClTextField.insets = new Insets(0, 0, 5, 0);
		gbc_businessClTextField.gridx = 1;
		gbc_businessClTextField.gridy = 2;
		probabilityPanel.add(businessClTextField, gbc_businessClTextField);
		businessClTextField.setColumns(10);
		
		labelPremiumCl = new JLabel("Premium Class\r\n");
		GridBagConstraints gbc_labelPremiumCl = new GridBagConstraints();
		gbc_labelPremiumCl.anchor = GridBagConstraints.EAST;
		gbc_labelPremiumCl.insets = new Insets(0, 0, 5, 5);
		gbc_labelPremiumCl.gridx = 0;
		gbc_labelPremiumCl.gridy = 3;
		probabilityPanel.add(labelPremiumCl, gbc_labelPremiumCl);
		
		premiumClTextField = new JTextField();
		GridBagConstraints gbc_premiumClTextField = new GridBagConstraints();
		gbc_premiumClTextField.anchor = GridBagConstraints.WEST;
		gbc_premiumClTextField.insets = new Insets(0, 0, 5, 0);
		gbc_premiumClTextField.gridx = 1;
		gbc_premiumClTextField.gridy = 3;
		probabilityPanel.add(premiumClTextField, gbc_premiumClTextField);
		premiumClTextField.setColumns(10);
		
		labelEconomyCl = new JLabel("Economy Class");
		GridBagConstraints gbc_labelEconomyCl = new GridBagConstraints();
		gbc_labelEconomyCl.anchor = GridBagConstraints.EAST;
		gbc_labelEconomyCl.insets = new Insets(0, 0, 5, 5);
		gbc_labelEconomyCl.gridx = 0;
		gbc_labelEconomyCl.gridy = 4;
		probabilityPanel.add(labelEconomyCl, gbc_labelEconomyCl);
		
		economyClTextField = new JTextField();
		GridBagConstraints gbc_economyClTextField = new GridBagConstraints();
		gbc_economyClTextField.anchor = GridBagConstraints.WEST;
		gbc_economyClTextField.insets = new Insets(0, 0, 5, 0);
		gbc_economyClTextField.gridx = 1;
		gbc_economyClTextField.gridy = 4;
		probabilityPanel.add(economyClTextField, gbc_economyClTextField);
		economyClTextField.setColumns(10);
		
		labelCancellation = new JLabel("Cancellation");
		GridBagConstraints gbc_labelCancellation = new GridBagConstraints();
		gbc_labelCancellation.anchor = GridBagConstraints.EAST;
		gbc_labelCancellation.insets = new Insets(0, 0, 0, 5);
		gbc_labelCancellation.gridx = 0;
		gbc_labelCancellation.gridy = 5;
		probabilityPanel.add(labelCancellation, gbc_labelCancellation);
		
		canellationTextField = new JTextField();
		GridBagConstraints gbc_canellationTextField = new GridBagConstraints();
		gbc_canellationTextField.anchor = GridBagConstraints.WEST;
		gbc_canellationTextField.gridx = 1;
		gbc_canellationTextField.gridy = 5;
		probabilityPanel.add(canellationTextField, gbc_canellationTextField);
		canellationTextField.setColumns(10);
		
		buttonPanel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 14;
		mainPane.add(buttonPanel, gbc_panel);
		
		startButton = new JButton("Start Sim");
		startButton.setHorizontalAlignment(SwingConstants.LEFT);
		buttonPanel.add(startButton);
		startButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		startButton.setForeground(Color.BLACK);
		startButton.setBackground(Color.GREEN);
		
		showSummaryButton = new JButton("Show Summary");
		showSummaryButton.setHorizontalAlignment(SwingConstants.RIGHT);
		buttonPanel.add(showSummaryButton);
		showSummaryButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		
		radioPanel = new JPanel();
		FlowLayout fl_radioPanel = (FlowLayout) radioPanel.getLayout();
		fl_radioPanel.setAlignment(FlowLayout.LEFT);
		fl_radioPanel.setVgap(2);
		fl_radioPanel.setHgap(2);
		GridBagConstraints gbc_radioPanel = new GridBagConstraints();
		gbc_radioPanel.anchor = GridBagConstraints.LINE_START;
		gbc_radioPanel.gridx = 4;
		gbc_radioPanel.gridy = 14;
		mainPane.add(radioPanel, gbc_radioPanel);
		
		radioDisplayText = new JRadioButton("Text Report");
		textOrGraphGroup.add(radioDisplayText);
		radioDisplayText.setSelected(true);
		radioDisplayText.setVerticalAlignment(SwingConstants.BOTTOM);
		radioPanel.add(radioDisplayText);
		
		radioDisplayGraph = new JRadioButton("Graph");
		textOrGraphGroup.add(radioDisplayGraph);
		radioDisplayGraph.setVerticalAlignment(SwingConstants.BOTTOM);
		radioPanel.add(radioDisplayGraph);
	}
}
