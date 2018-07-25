import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View {

	private JFrame frame;
	private JTextField Statistics;
	private JLabel Answer;
	private JEditorPane ArrayPanel;
	private Analizer analizer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frame.setVisible(true); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel label = new JLabel("Введите значения через пробел:");
		springLayout.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(label);
		
		
		ArrayPanel = new JEditorPane();
		springLayout.putConstraint(SpringLayout.NORTH, ArrayPanel, 6, SpringLayout.SOUTH, label);
		springLayout.putConstraint(SpringLayout.WEST, ArrayPanel, 0, SpringLayout.WEST, label);
		springLayout.putConstraint(SpringLayout.SOUTH, ArrayPanel, 106, SpringLayout.SOUTH, label);
		springLayout.putConstraint(SpringLayout.EAST, ArrayPanel, 438, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(ArrayPanel);
		
		JLabel label_1 = new JLabel("Статистика №:");
		springLayout.putConstraint(SpringLayout.NORTH, label_1, 6, SpringLayout.SOUTH, ArrayPanel);
		springLayout.putConstraint(SpringLayout.WEST, label_1, 0, SpringLayout.WEST, label);
		frame.getContentPane().add(label_1);
		
		Statistics = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, Statistics, 6, SpringLayout.SOUTH, label_1);
		springLayout.putConstraint(SpringLayout.WEST, Statistics, 0, SpringLayout.WEST, label);
		frame.getContentPane().add(Statistics);
		Statistics.setColumns(10);
		
		JLabel label_2 = new JLabel("Ответ");
		springLayout.putConstraint(SpringLayout.NORTH, label_2, 6, SpringLayout.SOUTH, Statistics);
		springLayout.putConstraint(SpringLayout.WEST, label_2, 0, SpringLayout.WEST, label);
		frame.getContentPane().add(label_2);
		
		JButton button = new JButton("Загрузить в массив");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				analizer = Analizer.extruder(ArrayPanel);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, button, 6, SpringLayout.SOUTH, ArrayPanel);
		springLayout.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.EAST, ArrayPanel);
		frame.getContentPane().add(button);
	
		JButton button_1 = new JButton("Найти статистику (min)");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Answer.setText(analizer.FindStatistic(Integer.parseInt(Statistics.getText())));
			}
		});
		
		JButton button_2 = new JButton("Найти статистику (max)");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Answer.setText(analizer.FindStatistic2(Integer.parseInt(Statistics.getText())));
			}
		});
		
		springLayout.putConstraint(SpringLayout.NORTH, button_2, 40, SpringLayout.SOUTH, button);
		springLayout.putConstraint(SpringLayout.EAST, button_2, 0, SpringLayout.EAST, ArrayPanel);
		frame.getContentPane().add(button_2);
		
		springLayout.putConstraint(SpringLayout.NORTH, button_1, 6, SpringLayout.SOUTH, button);
		springLayout.putConstraint(SpringLayout.EAST, button_1, 0, SpringLayout.EAST, ArrayPanel);
		frame.getContentPane().add(button_1);
		
//-------------------------------
		JButton button_3 = new JButton("Найти O(n)");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Answer.setText(analizer.LinTime (Integer.parseInt(Statistics.getText())));
			}
		});
		
		springLayout.putConstraint(SpringLayout.NORTH, button_3, 75, SpringLayout.SOUTH, button);
		springLayout.putConstraint(SpringLayout.EAST, button_3, 0, SpringLayout.EAST, ArrayPanel);
		frame.getContentPane().add(button_3);	
//-------------------------------		*/

		Answer = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, Answer, 6, SpringLayout.SOUTH, label_2);
		springLayout.putConstraint(SpringLayout.WEST, Answer, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, Answer, 21, SpringLayout.SOUTH, label_2);
		springLayout.putConstraint(SpringLayout.EAST, Answer, 0, SpringLayout.EAST, Statistics);
		frame.getContentPane().add(Answer);
	}
}
