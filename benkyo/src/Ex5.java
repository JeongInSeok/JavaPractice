import javax.swing.JFrame;
import javax.swing.JPasswordField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Font;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
import javax.swing.SpinnerListModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class Ex5 extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	
	public Ex5() {
		showFrame();
	}
	
	public void showFrame() {
		setBounds(600, 400, 300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JFrame 또는 JPanel 객체의 setLayout() 메서드에 null 값 전달 시
		// 컴포넌트를 마음대로 좌표를 지정하여 배치 가능한 AbsoluteLayout 으로 지정됨
		getContentPane().setLayout(null);
		
		// AbsoluteLayout 내에 컴포넌트 부착할 때
		// setBounds() 메서드를 사용하여 위치 및 크기 지정 필수!
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(12, 113, 115, 38); // 버튼 객체의 위치 및 크기 지정
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(157, 113, 115, 38);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(12, 10, 57, 15);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(86, 7, 186, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(12, 47, 57, 15);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(86, 44, 186, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex5();
	}
}
