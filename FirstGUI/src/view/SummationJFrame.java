package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SummationJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtNum1;
	private JTextField txtNum2;
	private JButton btnCalculate;
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
					SummationJFrame frame = new SummationJFrame();
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
	public SummationJFrame() {
		setTitle("Summation");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SummationJFrame.class.getResource("/image32/calculator_black.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 378, 232);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Summation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 334, 172);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNumber = new JLabel("Number 1");
		lblNumber.setBounds(24, 26, 68, 14);
		panel.add(lblNumber);
		
		lblResult = new JLabel("New label");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setForeground(Color.RED);
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResult.setBounds(24, 123, 279, 38);
		panel.add(lblResult);
		
		txtNum1 = new JTextField();
		txtNum1.setColumns(10);
		txtNum1.setBounds(102, 23, 94, 20);
		panel.add(txtNum1);
		
		btnCalculate = new JButton("คำนวณ");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1 = Integer.parseInt(txtNum1.getText());
				int num2 = Integer.parseInt(txtNum2.getText());
				int sum = 0;
				if(num1 <= num2){
					
					int i = num1;
					while(i <= num2){
						sum = sum + i;
						i++;
					}
				}else{
//					for(int i=num2; i<=num1; i++){
//						sum = sum + i;
//					}
					int i = num2;
					do {
						sum = sum + i;
						i++;
					}while(i <= num1);
				}
				lblResult.setText("Summation is : " + sum);
				txtNum1.setText("");
				txtNum2.setText("");
			}
		});
		btnCalculate.setIcon(new ImageIcon(SummationJFrame.class.getResource("/image16/calculator_black.png")));
		btnCalculate.setBounds(214, 22, 89, 59);
		panel.add(btnCalculate);
		
		txtNum2 = new JTextField();
		txtNum2.setColumns(10);
		txtNum2.setBounds(102, 61, 94, 20);
		panel.add(txtNum2);
		
		JLabel lblNumber_1 = new JLabel("Number 2");
		lblNumber_1.setBounds(24, 64, 68, 14);
		panel.add(lblNumber_1);
	}
}
