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
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField firstClTextField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPanel textAndGraphPanel;
	private JButton btnStart;
	private JPanel probabilityPanel;
	private JLabel lblNewLabel;

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
		gbl_mainPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		mainPane.setLayout(gbl_mainPane);
		
		textAndGraphPanel = new JPanel();
		textAndGraphPanel.setBackground(new Color(255, 255, 204));
		GridBagConstraints gbc_textAndGraphPanel = new GridBagConstraints();
		gbc_textAndGraphPanel.fill = GridBagConstraints.BOTH;
		gbc_textAndGraphPanel.gridheight = 5;
		gbc_textAndGraphPanel.gridwidth = 7;
		gbc_textAndGraphPanel.insets = new Insets(0, 0, 0, 0);
		gbc_textAndGraphPanel.gridx = 0;
		gbc_textAndGraphPanel.gridy = 0;
		mainPane.add(textAndGraphPanel, gbc_textAndGraphPanel);
		
		probabilityPanel = new JPanel();
		probabilityPanel.setBackground(Color.WHITE);
		probabilityPanel.setBorder(new LineBorder(Color.GRAY, 2, true));
		GridBagConstraints gbc_probabilityPanel = new GridBagConstraints();
		gbc_probabilityPanel.gridheight = 6;
		gbc_probabilityPanel.gridwidth = 2;
		gbc_probabilityPanel.insets = new Insets(0, 0, 5, 5);
		gbc_probabilityPanel.fill = GridBagConstraints.BOTH;
		gbc_probabilityPanel.gridx = 4;
		gbc_probabilityPanel.gridy = 8;
		mainPane.add(probabilityPanel, gbc_probabilityPanel);
		GridBagLayout gbl_probabilityPanel = new GridBagLayout();
		gbl_probabilityPanel.columnWidths = new int[]{145, 145};
		gbl_probabilityPanel.rowHeights = new int[]{0, 14, 0, 0, 0, 0, 0};
		gbl_probabilityPanel.columnWeights = new double[]{0.0, 0.0};
		gbl_probabilityPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		probabilityPanel.setLayout(gbl_probabilityPanel);
		
		lblNewLabel = new JLabel("Probabilities");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		probabilityPanel.add(lblNewLabel, gbc_lblNewLabel);
		
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
		
		lblNewLabel_1 = new JLabel("Business Class");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		probabilityPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		probabilityPanel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Premium Class\r\n");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		probabilityPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.WEST;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 3;
		probabilityPanel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Economy Class");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		probabilityPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.WEST;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 4;
		probabilityPanel.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Cancellation");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		probabilityPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.anchor = GridBagConstraints.WEST;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 5;
		probabilityPanel.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel labelSeed = new JLabel("Seed");
		GridBagConstraints gbc_labelSeed = new GridBagConstraints();
		gbc_labelSeed.anchor = GridBagConstraints.EAST;
		gbc_labelSeed.insets = new Insets(0, 0, 5, 5);
		gbc_labelSeed.gridx = 1;
		gbc_labelSeed.gridy = 9;
		mainPane.add(labelSeed, gbc_labelSeed);
		
		seedTextField = new JTextField();
		GridBagConstraints gbc_seedTextField = new GridBagConstraints();
		gbc_seedTextField.anchor = GridBagConstraints.WEST;
		gbc_seedTextField.insets = new Insets(0, 0, 5, 5);
		gbc_seedTextField.gridx = 2;
		gbc_seedTextField.gridy = 9;
		mainPane.add(seedTextField, gbc_seedTextField);
		seedTextField.setColumns(10);
		
		JLabel labelMaxQueueSize = new JLabel("Max Queue Size");
		GridBagConstraints gbc_labelMaxQueueSize = new GridBagConstraints();
		gbc_labelMaxQueueSize.anchor = GridBagConstraints.EAST;
		gbc_labelMaxQueueSize.insets = new Insets(0, 0, 5, 5);
		gbc_labelMaxQueueSize.gridx = 1;
		gbc_labelMaxQueueSize.gridy = 10;
		mainPane.add(labelMaxQueueSize, gbc_labelMaxQueueSize);
		
		maxQueSizeTextField = new JTextField();
		GridBagConstraints gbc_maxQueSizeTextField = new GridBagConstraints();
		gbc_maxQueSizeTextField.anchor = GridBagConstraints.WEST;
		gbc_maxQueSizeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_maxQueSizeTextField.fill = GridBagConstraints.VERTICAL;
		gbc_maxQueSizeTextField.gridx = 2;
		gbc_maxQueSizeTextField.gridy = 10;
		mainPane.add(maxQueSizeTextField, gbc_maxQueSizeTextField);
		maxQueSizeTextField.setColumns(10);
		
		labelDailyBookingMean = new JLabel("Daily Booking Mean");
		GridBagConstraints gbc_labelDailyBookingMean = new GridBagConstraints();
		gbc_labelDailyBookingMean.anchor = GridBagConstraints.EAST;
		gbc_labelDailyBookingMean.insets = new Insets(0, 0, 5, 5);
		gbc_labelDailyBookingMean.gridx = 1;
		gbc_labelDailyBookingMean.gridy = 11;
		mainPane.add(labelDailyBookingMean, gbc_labelDailyBookingMean);
		
		dailyBookingMeanTextField = new JTextField();
		GridBagConstraints gbc_dailyBookingMeanTextField = new GridBagConstraints();
		gbc_dailyBookingMeanTextField.anchor = GridBagConstraints.WEST;
		gbc_dailyBookingMeanTextField.insets = new Insets(0, 0, 5, 5);
		gbc_dailyBookingMeanTextField.gridx = 2;
		gbc_dailyBookingMeanTextField.gridy = 11;
		mainPane.add(dailyBookingMeanTextField, gbc_dailyBookingMeanTextField);
		dailyBookingMeanTextField.setColumns(10);
		
		labelMinimumBookings = new JLabel("Minimum Bookings");
		GridBagConstraints gbc_labelMinimumBookings = new GridBagConstraints();
		gbc_labelMinimumBookings.anchor = GridBagConstraints.EAST;
		gbc_labelMinimumBookings.insets = new Insets(0, 0, 5, 5);
		gbc_labelMinimumBookings.gridx = 1;
		gbc_labelMinimumBookings.gridy = 12;
		mainPane.add(labelMinimumBookings, gbc_labelMinimumBookings);
		
		minBookingsTextField = new JTextField();
		GridBagConstraints gbc_minBookingsTextField = new GridBagConstraints();
		gbc_minBookingsTextField.anchor = GridBagConstraints.WEST;
		gbc_minBookingsTextField.insets = new Insets(0, 0, 5, 5);
		gbc_minBookingsTextField.gridx = 2;
		gbc_minBookingsTextField.gridy = 12;
		mainPane.add(minBookingsTextField, gbc_minBookingsTextField);
		minBookingsTextField.setColumns(10);
		
		labelBookingStandardDevation = new JLabel("Booking Standard Devation");
		GridBagConstraints gbc_labelBookingStandardDevation = new GridBagConstraints();
		gbc_labelBookingStandardDevation.anchor = GridBagConstraints.EAST;
		gbc_labelBookingStandardDevation.insets = new Insets(0, 0, 5, 5);
		gbc_labelBookingStandardDevation.gridx = 1;
		gbc_labelBookingStandardDevation.gridy = 13;
		mainPane.add(labelBookingStandardDevation, gbc_labelBookingStandardDevation);
		
		bookingStanDevTextField = new JTextField();
		GridBagConstraints gbc_bookingStanDevTextField = new GridBagConstraints();
		gbc_bookingStanDevTextField.anchor = GridBagConstraints.WEST;
		gbc_bookingStanDevTextField.insets = new Insets(0, 0, 5, 5);
		gbc_bookingStanDevTextField.gridx = 2;
		gbc_bookingStanDevTextField.gridy = 13;
		mainPane.add(bookingStanDevTextField, gbc_bookingStanDevTextField);
		bookingStanDevTextField.setColumns(10);
		
		btnStart = new JButton("Start");
		btnStart.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		btnStart.setForeground(Color.BLACK);
		btnStart.setBackground(Color.GREEN);
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.insets = new Insets(0, 0, 0, 5);
		gbc_btnStart.gridx = 1;
		gbc_btnStart.gridy = 14;
		mainPane.add(btnStart, gbc_btnStart);
	}

}
