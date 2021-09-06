import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ex extends JFrame {
	private JTable table;
	
	public Ex() {
		showFrame();
	}
	
	public void showFrame() {
		setBounds(600, 400, 300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 260, 141);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		// JTable 에 데이터를 추가하는 방법
		// 1. DefaultTableModel 객체를 생성하여 배열 형태로 데이터 추가
		// => 1차원 배열 : 열 제목, 2차원 배열 : 각 데이터(1개 행 = 1차원 배열)
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"1", "홍길동", "20"},
//				{"2", "이순신", "44"},
//				{"3", "강감찬", null},
//			},
//			new String[] {
//				"번호", "이름", "나이"
//			}
//		));
		
		// 2. Vector 객체를 사용하여 제목과 데이터를 설정하는 방법
		// 2-1. 제목과 데이터가 모두 한 번에 추가되는 경우
		// 1) 열 제목을 Vector 객체에 저장
//		Vector<String> columnNames = 
//				new Vector<String>(Arrays.asList("번호", "이름", "나이"));
		// 2) 데이터를 Vector 객체에 저장
		// 전체 데이터를 저장할 Vector 객체 생성
//		Vector data = new Vector();
//		// 1개 행 데이터를 저장할 Vector 객체 생성 및 데이터 저장 = XXXBean 역할 수행
//		Vector rowData = new Vector();
//		rowData.add(1);
//		rowData.add("홍길동");
//		rowData.add(20);
//		// 1개 행 데이터를 저장한 Vector 객체를 전체 데이터를 저장하는 Vector 에 추가
//		data.add(rowData);
//		
//		rowData = new Vector();
//		rowData.add(2);
//		rowData.add("이순신");
//		rowData.add(44);
//		// 1개 행 데이터를 저장한 Vector 객체를 전체 데이터를 저장하는 Vector 에 추가
//		data.add(rowData);
//
//		// DefaultTableModel 객체를 생성하여 전체데이터와 열제목 Vector 객체 전달
//		DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
//		table.setModel(dtm);
		
		
		// 2-2. 제목열만 먼저 추가 후, 1개 레코드의 Vector 객체를 별도로 추가하는 방법
		Vector<String> columnNames = 
				new Vector<String>(Arrays.asList("번호", "이름", "나이"));
		// 제목열 Vector 객체를 DefaultTableModel 객체에 추가 => 행번호 0으로 설정
		DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);
		
		// 1개 레코드를 Vector 객체에 추가
		Vector rowData = new Vector();
		rowData.add(1);
		rowData.add("홍길동");
		rowData.add(20);
		
		// DefaultTableModel 객체의 addRow() 메서드를 사용하면 1개 레코드 추가
		dtm.addRow(rowData);
		
		rowData = new Vector();
		rowData.add(2);
		rowData.add("이순신");
		rowData.add(44);
		
		// DefaultTableModel 객체의 addRow() 메서드를 사용하면 1개 레코드 추가
		dtm.addRow(rowData);
		
		// JTable 에 DefaultTableModel 객체 추가
		table.setModel(dtm);
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex();
	}
}
