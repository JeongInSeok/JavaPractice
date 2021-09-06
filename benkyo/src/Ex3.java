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

import java.awt.Font;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerListModel;

public class Ex3 extends JFrame {
	
	public Ex3() {
		showFrame();
	}
	
	public void showFrame() {
		setBounds(600, 400, 300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("굴림", Font.PLAIN, 20));
		
		// 1. String[] 객체를 생성하여 항목 추가하는 방법
//		spinner.setModel(new SpinnerListModel(new String[] {"과목을 선택하세요", "JAVA", "JSP", "ANDROID"}));
		
		// 2. Model 객체를 생성하여 항목 추가하는 방법
		spinner.setModel(new SpinnerListModel(
				Arrays.asList("과목을 선택하세요", "JAVA", "JSP", "ANDROID")));
		
		
		getContentPane().add(spinner, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("확인");
		getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
		// 확인 버튼 클릭 시 Spinner 에 표시된 항목 가져와서 출력
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(spinner.getValue());
			}
		});
		
		// Spinner 의 변경 버튼(위/아래) 클릭 시 표시된 항목 가져와서 출력
		spinner.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println(spinner.getValue());
			}
		});
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex3();
	}

}
