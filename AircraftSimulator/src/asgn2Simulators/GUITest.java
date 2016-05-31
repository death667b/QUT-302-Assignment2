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

public class GUITest extends JFrame {

	private JPanel contentPane;
	private JTextField maxQueSizeTextField;
	private JTextField dailyBookingMeanTextField;
	private JTextField minBookingsTextField;
	private JTextField bookingStanDevTextField;
	private JTextField seedTextField;
	private JLabel labelDailyBookingMean;
	private JLabel labelMinimumBookings;
	private JLabel labelBookingStandardDevation;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPanel panel;
	private JButton btnStart;

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
		setBounds(100, 100, 666, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {150, 93, 110, 0, 5};
		gbl_contentPane.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 44, 10};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 7;
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		
		JLabel labelSeed = new JLabel("Seed");
		GridBagConstraints gbc_labelSeed = new GridBagConstraints();
		gbc_labelSeed.anchor = GridBagConstraints.EAST;
		gbc_labelSeed.insets = new Insets(0, 0, 5, 5);
		gbc_labelSeed.gridx = 0;
		gbc_labelSeed.gridy = 9;
		contentPane.add(labelSeed, gbc_labelSeed);
		
		seedTextField = new JTextField();
		GridBagConstraints gbc_seedTextField = new GridBagConstraints();
		gbc_seedTextField.anchor = GridBagConstraints.WEST;
		gbc_seedTextField.insets = new Insets(0, 0, 5, 5);
		gbc_seedTextField.gridx = 1;
		gbc_seedTextField.gridy = 9;
		contentPane.add(seedTextField, gbc_seedTextField);
		seedTextField.setColumns(10);
		
		lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 9;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 9;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel labelMaxQueueSize = new JLabel("Max Queue Size");
		GridBagConstraints gbc_labelMaxQueueSize = new GridBagConstraints();
		gbc_labelMaxQueueSize.anchor = GridBagConstraints.EAST;
		gbc_labelMaxQueueSize.insets = new Insets(0, 0, 5, 5);
		gbc_labelMaxQueueSize.gridx = 0;
		gbc_labelMaxQueueSize.gridy = 10;
		contentPane.add(labelMaxQueueSize, gbc_labelMaxQueueSize);
		
		maxQueSizeTextField = new JTextField();
		GridBagConstraints gbc_maxQueSizeTextField = new GridBagConstraints();
		gbc_maxQueSizeTextField.anchor = GridBagConstraints.WEST;
		gbc_maxQueSizeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_maxQueSizeTextField.fill = GridBagConstraints.VERTICAL;
		gbc_maxQueSizeTextField.gridx = 1;
		gbc_maxQueSizeTextField.gridy = 10;
		contentPane.add(maxQueSizeTextField, gbc_maxQueSizeTextField);
		maxQueSizeTextField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 10;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 10;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		labelDailyBookingMean = new JLabel("Daily Booking Mean");
		GridBagConstraints gbc_labelDailyBookingMean = new GridBagConstraints();
		gbc_labelDailyBookingMean.anchor = GridBagConstraints.EAST;
		gbc_labelDailyBookingMean.insets = new Insets(0, 0, 5, 5);
		gbc_labelDailyBookingMean.gridx = 0;
		gbc_labelDailyBookingMean.gridy = 11;
		contentPane.add(labelDailyBookingMean, gbc_labelDailyBookingMean);
		
		dailyBookingMeanTextField = new JTextField();
		GridBagConstraints gbc_dailyBookingMeanTextField = new GridBagConstraints();
		gbc_dailyBookingMeanTextField.anchor = GridBagConstraints.WEST;
		gbc_dailyBookingMeanTextField.insets = new Insets(0, 0, 5, 5);
		gbc_dailyBookingMeanTextField.gridx = 1;
		gbc_dailyBookingMeanTextField.gridy = 11;
		contentPane.add(dailyBookingMeanTextField, gbc_dailyBookingMeanTextField);
		dailyBookingMeanTextField.setColumns(10);
		
		lblNewLabel_2 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 11;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.WEST;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 11;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		labelMinimumBookings = new JLabel("Minimum Bookings");
		GridBagConstraints gbc_labelMinimumBookings = new GridBagConstraints();
		gbc_labelMinimumBookings.anchor = GridBagConstraints.EAST;
		gbc_labelMinimumBookings.insets = new Insets(0, 0, 5, 5);
		gbc_labelMinimumBookings.gridx = 0;
		gbc_labelMinimumBookings.gridy = 12;
		contentPane.add(labelMinimumBookings, gbc_labelMinimumBookings);
		
		minBookingsTextField = new JTextField();
		GridBagConstraints gbc_minBookingsTextField = new GridBagConstraints();
		gbc_minBookingsTextField.anchor = GridBagConstraints.WEST;
		gbc_minBookingsTextField.insets = new Insets(0, 0, 5, 5);
		gbc_minBookingsTextField.gridx = 1;
		gbc_minBookingsTextField.gridy = 12;
		contentPane.add(minBookingsTextField, gbc_minBookingsTextField);
		minBookingsTextField.setColumns(10);
		
		lblNewLabel_3 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 12;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.WEST;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 12;
		contentPane.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		labelBookingStandardDevation = new JLabel("Booking Standard Devation");
		GridBagConstraints gbc_labelBookingStandardDevation = new GridBagConstraints();
		gbc_labelBookingStandardDevation.anchor = GridBagConstraints.EAST;
		gbc_labelBookingStandardDevation.insets = new Insets(0, 0, 5, 5);
		gbc_labelBookingStandardDevation.gridx = 0;
		gbc_labelBookingStandardDevation.gridy = 13;
		contentPane.add(labelBookingStandardDevation, gbc_labelBookingStandardDevation);
		
		bookingStanDevTextField = new JTextField();
		GridBagConstraints gbc_bookingStanDevTextField = new GridBagConstraints();
		gbc_bookingStanDevTextField.anchor = GridBagConstraints.WEST;
		gbc_bookingStanDevTextField.insets = new Insets(0, 0, 5, 5);
		gbc_bookingStanDevTextField.gridx = 1;
		gbc_bookingStanDevTextField.gridy = 13;
		contentPane.add(bookingStanDevTextField, gbc_bookingStanDevTextField);
		bookingStanDevTextField.setColumns(10);
		
		lblNewLabel_4 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 13;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.anchor = GridBagConstraints.WEST;
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 13;
		contentPane.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		btnStart = new JButton("Start");
		btnStart.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		btnStart.setForeground(Color.BLACK);
		btnStart.setBackground(Color.BLACK);
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.insets = new Insets(0, 0, 0, 5);
		gbc_btnStart.gridx = 0;
		gbc_btnStart.gridy = 14;
		contentPane.add(btnStart, gbc_btnStart);
	}

}
