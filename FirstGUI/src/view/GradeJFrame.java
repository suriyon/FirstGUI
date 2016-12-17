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
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GradeJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtPoint;
	private JButton btnCalulate;
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
					GradeJFrame frame = new GradeJFrame();
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
	public GradeJFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GradeJFrame.class.getResource("/image32/calculator_black.png")));
		setTitle("Calculate Grade");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 144);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("กรอกคะแนน");
		lblNewLabel.setBounds(10, 11, 68, 14);
		contentPane.add(lblNewLabel);
		
		txtPoint = new JTextField();
		txtPoint.setBounds(88, 8, 102, 20);
		contentPane.add(txtPoint);
		txtPoint.setColumns(10);
		
		btnCalulate = new JButton("คำนวณ");
		btnCalulate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int point = Integer.parseInt(txtPoint.getText());
				String grade = calGrade(point);
											
				lblResult.setText(grade);
				txtPoint.setText("");
			}
		});
		btnCalulate.setIcon(new ImageIcon(GradeJFrame.class.getResource("/image16/calculator_black.png")));
		btnCalulate.setBounds(200, 7, 89, 23);
		contentPane.add(btnCalulate);
		
		lblResult = new JLabel("New label");
		lblResult.setForeground(Color.RED);
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResult.setBounds(10, 48, 279, 38);
		contentPane.add(lblResult);
	}

	protected String calGrade(int point) {
		String grade = "";
		if(point >= 80){
			grade = "Grade A";
		}else if(point >= 75){
			grade = "Grade B+";
		}else if(point >= 70){
			grade = "Grade B";
		}else if(point >= 65){
			grade = "Grade C+";
		}else if(point >= 60){
			grade = "Grade C";
		}else if(point >= 55){
			grade = "Grade D+";
		}else if(point >= 50){
			grade = "Grade D";
		}else{
			grade = "Grade E";
		}
		return grade;
	}

}
