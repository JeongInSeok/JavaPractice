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

public class Ex4 extends JFrame {
	
	public Ex4() {
		showFrame();
	}
	
	public void showFrame() {
		setBounds(600, 400, 300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JList 객체에 데이터 추가 방법
		// 1. AbstractListModel() 의 Anonymous Inner Type 구현으로 추가하는 방법
//		JList list = new JList();
//		list.setModel(new AbstractListModel() {
//			String[] values = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
//			public int getSize() {
//				return values.length;
//			}
//			public Object getElementAt(int index) {
//				return values[index];
//			}
//		});
		
		
		// 2. Vector 객체 생성하여 항목 추가 후 JList 객체에 Vector 객체 추가하는 방법
//		Vector<String> vList = new Vector<String>(
//				Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"));
//		JList list = new JList(vList);
//
//		
//		getContentPane().add(list, BorderLayout.CENTER);
		
		
		
		JButton btnNewButton = new JButton("New button");
		getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
		// 스크롤바 기능을 제공하는 JScrollPane 객체 생성
		// => JTable, JList 등 스크롤이 필요한 컴포넌트를 결합하여 사용
		JScrollPane scrollPane = new JScrollPane();
		// JFrame 또는 JPanel 등 필요한 곳에 JScrollPane 객체 부착
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		Vector<String> vList = new Vector<String>(
				Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"));
		JList<String> list = new JList<String>(vList);
		
		// JList 컴포넌트의 목록 선택 방식 변경
		// => 단일 선택 모드(Shift 키 범위 지정 불가) : SINGLE_SELECTION
		// => 단일 선택 모드(Shift 키 범위 지정 가능) : SINGLE_INTERVAL_SELECTION
		// => 다중 선택 모드(Shift 키 범위 지정 가능) : MULTIPLE_INTERVAL_SELECTION
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		// JScrollPane 객체에 스크롤할 객체를 추가하기 위해
		// setViewportView() 메서드에 스크롤바를 동작시킬 객체 전달
		scrollPane.setViewportView(list);
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// JList 에서 선택된 항목 가져와서 출력
				// 1. 다중 선택 모드에서 항목 가져오기
				// getSelectedValuesList() 메서드를 사용하여 
				// 선택된 모든 항목을 List 타입 객체로 리턴
//				List<String> values = list.getSelectedValuesList();
//				System.out.println(values);
				
				// 2. 단일 선택 모드에서 항목 가져오기
				// getSelectedValue() 메서드를 사용하여
				// 선택된 항목을 지정한 제네릭 타입(생략시 Object) 객체로 리턴
				String value = list.getSelectedValue();
				System.out.println(value);
			}
		});
		
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex4();
	}

}
