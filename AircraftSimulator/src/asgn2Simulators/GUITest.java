package asgn2Simulators;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class GUITest extends JFrame {

	private JPanel mainPane;
	private JTextField maxQueSizeTextField;
	private JTextField dailyBookingMeanTextField;
	private JTextField minBookingsTextField;
	private JTextField bookingStanDevTextField;
	private JTextField seedTextField;
	private JLabel labelDailyBookingMean;
	private JLabel labelMinimumBookings;
	private JLabel labelBookingStandardDevation;
	private JLabel labelFirstCl;
	private JLabel labelBusinessCl;
	private JLabel labelPremiumCl;
	private JLabel labelEconomyCl;
	private JLabel labelCancellation;
	private JTextField firstClTextField;
	private JTextField businessClTextField;
	private JTextField premiumClTextField;
	private JTextField economyClTextField;
	private JTextField canellationTextField;
	private JPanel textAndGraphPanel;
	private JButton startButton;
	private JPanel probabilityPanel;
	private JLabel labelProbabilityPanelTitle;
	private JPanel settingsPanel;
	private JLabel labelSettingsPanelTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUITest frame = new GUITest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUITest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		mainPane = new JPanel();
		mainPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(mainPane);
		GridBagLayout gbl_mainPane = new GridBagLayout();
		gbl_mainPane.columnWidths = new int[] {30, 180, 110, 30, 180, 110, 30};
		gbl_mainPane.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 44, 10};
		gbl_mainPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_mainPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		mainPane.setLayout(gbl_mainPane);
		
		textAndGraphPanel = new JPanel();
		textAndGraphPanel.setBackground(new Color(255, 255, 204));
		GridBagConstraints gbc_textAndGraphPanel = new GridBagConstraints();
		gbc_textAndGraphPanel.fill = GridBagConstraints.BOTH;
		gbc_textAndGraphPanel.gridheight = 7;
		gbc_textAndGraphPanel.gridwidth = 7;
		gbc_textAndGraphPanel.insets = new Insets(0, 0, 5, 0);
		gbc_textAndGraphPanel.gridx = 0;
		gbc_textAndGraphPanel.gridy = 0;
		mainPane.add(textAndGraphPanel, gbc_textAndGraphPanel);
		
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
		
		startButton = new JButton("Start Sim");
		startButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		startButton.setForeground(Color.BLACK);
		startButton.setBackground(Color.GREEN);
		GridBagConstraints gbc_startButton = new GridBagConstraints();
		gbc_startButton.insets = new Insets(0, 0, 0, 5);
		gbc_startButton.gridx = 1;
		gbc_startButton.gridy = 14;
		mainPane.add(startButton, gbc_startButton);
	}

}
