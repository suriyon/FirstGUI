package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class SecondJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JButton btnShow;
	private JComboBox cmbGender;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondJFrame frame = new SecondJFrame();
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
	public SecondJFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SecondJFrame.class.getResource("/image32/32_bit.png")));
		setTitle("Second JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ป้อนชื่อ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(50, 45, 59, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("เลือกเพศ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(50, 88, 59, 25);
		contentPane.add(lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtName.setBounds(119, 42, 180, 25);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		btnShow = new JButton("Show");
		btnShow.setIcon(new ImageIcon(SecondJFrame.class.getResource("/image16/accept.png")));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String gender = cmbGender.getSelectedItem().toString();
				
				if(gender.equals("ชาย")){
					lblResult.setText("Hello Mr." + name);
				}else{
					lblResult.setText("Hello Ms." + name);
				}
				txtName.setText("");
				cmbGender.setSelectedIndex(0);
			}
		});
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnShow.setBounds(321, 42, 89, 25);
		contentPane.add(btnShow);
		
		cmbGender = new JComboBox();
		cmbGender.setModel(new DefaultComboBoxModel(new String[] {"ชาย", "หญิง"}));
		cmbGender.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cmbGender.setBounds(119, 88, 113, 25);
		contentPane.add(cmbGender);
		
		lblResult = new JLabel("");
		lblResult.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblResult.setBounds(50, 159, 360, 51);
		contentPane.add(lblResult);
	}
}
