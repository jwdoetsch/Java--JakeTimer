package usr.doetsch.jaketimer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JakeTimerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JakeTimerFrame frame = new JakeTimerFrame();
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
	public JakeTimerFrame() {
		setTitle("00:00:00.000 - JakeTimer (1)");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 440, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.WHITE);
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("00:00:00.000");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 52));
		contentPane.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		Box verticalBox = Box.createVerticalBox();
		contentPane.add(verticalBox, BorderLayout.EAST);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		
		JButton btnNewButton = new JButton("Pause");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				(new JakeTimerWorker((long) 1,(long) 60000, textField)).execute();
				
			}
		});
		verticalBox.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		verticalBox.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Config");
		verticalBox.add(btnNewButton_2);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_1);
		
		Box verticalBox_1 = Box.createVerticalBox();
		contentPane.add(verticalBox_1, BorderLayout.SOUTH);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Sound Alert");
		chckbxNewCheckBox.setSelected(true);
		verticalBox_1.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Popup Alert");
		chckbxNewCheckBox_1.setSelected(true);
		verticalBox_1.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("System Tray Baloon Alert");
		chckbxNewCheckBox_2.setSelected(true);
		verticalBox_1.add(chckbxNewCheckBox_2);
	}

}
