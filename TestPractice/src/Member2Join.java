import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Member2Join extends JFrame {
	private JButton btnJoin, btnCancel;
	private JTextField tfName, tfAge, tfEmail1, tfEmail2, tfJumin1, tfJumin2;
	private JRadioButton rbMale, rbFemale;
	private JComboBox<String> comboEmailDomain;
	private JButton btnSelect;
	
	public Member2Join() {
		showFrame();
	}
	
	public void showFrame() {
		setBounds(600, 300, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("회원 가입 시스템");
		
		getContentPane().setLayout(null);
		
		// ----------- SOUTH 영역 => 데이터 입력 -----------
		// 이름
		JLabel lblName = new JLabel("이 름");
		lblName.setBounds(12, 20, 70, 20);
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(lblName);
		
		tfName = new JTextField(10);
		tfName.setBounds(100, 20, 100, 20);
		getContentPane().add(tfName);
		
		
		// 나이
		JLabel lblAge = new JLabel("나 이");
		lblAge.setBounds(12, 60, 70, 20);
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(lblAge);
		
		tfAge = new JTextField(10);
		tfAge.setBounds(100, 60, 50, 20);
		getContentPane().add(tfAge);
		
		
		// 성별
		JLabel lblGender = new JLabel("성 별");
		lblGender.setBounds(12, 100, 70, 20);
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(lblGender);
		
		rbMale = new JRadioButton("남", true);
		rbMale.setBounds(100, 100, 50, 20);
		getContentPane().add(rbMale);
		
		rbFemale = new JRadioButton("여");
		rbFemale.setBounds(150, 100, 50, 20);
		getContentPane().add(rbFemale);
		
		ButtonGroup rGroup = new ButtonGroup();
		rGroup.add(rbMale); rGroup.add(rbFemale);
		
		
		// E-Mail
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setBounds(12, 140, 70, 20);
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(lblEmail);
		
		tfEmail1 = new JTextField(7);
		tfEmail1.setBounds(100, 140, 60, 20);
		getContentPane().add(tfEmail1);
		
		JLabel label = new JLabel("@");
		label.setBounds(161, 140, 12, 20);
		getContentPane().add(label);
		
		tfEmail2 = new JTextField(7);
		tfEmail2.setBounds(175, 140, 60, 20);
		getContentPane().add(tfEmail2);
		
		comboEmailDomain = new JComboBox<String>();
		Vector<String> emailDomainList = new Vector<String>(Arrays.asList("직접 입력", "nate.com", "naver.com", "gmail.com"));
		comboEmailDomain.setModel(new DefaultComboBoxModel<String>(emailDomainList));
		comboEmailDomain.setBounds(247, 140, 125, 21);
		getContentPane().add(comboEmailDomain);
		
		// 콤보박스 도메인 선택 시 이벤트 처리
		comboEmailDomain.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				changeDomain();
			}
		});
		
		
		// 주민번호
		JLabel lblJumin = new JLabel("주민번호");
		lblJumin.setBounds(12, 180, 70, 20);
		lblJumin.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(lblJumin);
		
		tfJumin1 = new JTextField(7);
		tfJumin1.setBounds(100, 180, 80, 20);
		getContentPane().add(tfJumin1);
		
		JLabel label_1 = new JLabel("-");
		label_1.setBounds(185, 180, 12, 20);
		getContentPane().add(label_1);
		
		tfJumin2 = new JTextField(7);
		tfJumin2.setBounds(200, 180, 80, 20);
		getContentPane().add(tfJumin2);
		
		
		
		// ----------- SOUTH 영역 => 버튼 -----------
		JPanel pButton = new JPanel();
		pButton.setBounds(72, 221, 255, 40);
		getContentPane().add(pButton);
		
		btnJoin = new JButton("가 입");
		pButton.add(btnJoin);
		
		btnCancel = new JButton("취 소");
		pButton.add(btnCancel);
		
		btnSelect = new JButton("조 회");
		pButton.add(btnSelect);
		
		btnJoin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 입력값 검증을 통해 입력값이 정상일 경우에만 회원 가입 수행
				if(inputCheck()) {
					join();
				}
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});

		btnSelect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				select();
			}
		});
		
		
		setVisible(true);
	}

	public void changeDomain() {
		// 1. 직접 입력 선택 시 도메인주소 텍스트필드 삭제
		// 2. 직접 입력 외의 항목 선택 시 도메인주소 텍스트필드에 선택한 값 출력
		if(comboEmailDomain.getSelectedItem().equals("직접 입력")) {
			tfEmail2.setText("");
			tfEmail2.setEditable(true); // 텍스트필드 입력 잠금 해제
			tfEmail2.requestFocus();
		} else {
			tfEmail2.setText(comboEmailDomain.getSelectedItem().toString());
			// 도메인주소 자동입력 시 입력창 잠금
			tfEmail2.setEditable(false);
		}
		
	}
	
	public void join() {
		String name = tfName.getText();
		int age = Integer.parseInt(tfAge.getText());
		
		String gender = "남";
		if(rbFemale.isSelected()) {
			gender = "여";
		}
		
		String email = tfEmail1.getText() + '@' + tfEmail2.getText();
		String jumin = tfJumin1.getText() + '-' + tfJumin2.getText();
		
//		System.out.println(
//				name + ", " + age + ", " + gender + ", " + email + ", " + jumin);
		
		// ----------------------------------------------------
		// DB 접속을 통해 입력받은 데이터를 INSERT
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/java";
		String user = "root";
		String password = "1234";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공!");
			
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 성공!");
			
			String sql = "INSERT INTO member2 VALUES (null,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setString(3, gender);
			pstmt.setString(4, email);
			pstmt.setString(5, jumin);
			
			int count = pstmt.executeUpdate();
			System.out.println("INSERT 성공 - " + count + "개");
			
			// --------- SELECT ---------
			sql = "SELECT * FROM member2";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int idx = rs.getInt(1);
				name = rs.getString(2);
				age = rs.getInt(3);
				gender = rs.getString(4);
				email = rs.getString(5);
				jumin = rs.getString(6);
				
				System.out.println(idx + ", " + 
						name + ", " + age + ", " + gender + ", " + email + ", " + jumin);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		

		// ----------------------------------------------------
		clear();
		
	}
	
	public void cancel() {
		clear();
	}
	
	public void clear() {
		// 모든 항목 처음 상태로 초기화
		tfName.setText("");
		tfAge.setText("");
		tfEmail1.setText("");
		tfEmail2.setText("");
		tfJumin1.setText("");
		tfJumin2.setText("");
		
		// 라디오버튼 선택 해제(그룹화가 되어 있으므로 초기 상태로 설정)
		rbMale.setSelected(true);
		rbFemale.setSelected(false);
		
		// 콤보박스 첫번째 항목(0번 인덱스 항목) 선택
		comboEmailDomain.setSelectedIndex(0);
		
		// 특정 컴포넌트에 포커스 요청(커서 위치시킴)
		tfName.requestFocus();
	}
	
	public boolean inputCheck() {
		String nameRegex = "^[가-힣]{2,5}$"; // 한글 2 ~ 5글자
		String ageRegex = "^[0-9]{1,3}$"; // 나이 숫자 1 ~ 3자리
		
		if(!Pattern.matches(nameRegex, tfName.getText())) { // 이름 틀렸을 때
			System.out.println("이름을 한글 2 ~ 5글자로 입력하세요!");
			tfName.requestFocus();
			return false;
		}
		
		if(!Pattern.matches(ageRegex, tfAge.getText())) { // 나이 틀렸을 때
			System.out.println("나이를 숫자 1 ~ 3자리로 입력하세요!");
			tfAge.requestFocus();
			return false;
		}
		
		return true;
	}
	
	public void select() {
		// 새로운 JFrame 객체를 생성하여 조회 결과를 JTable 에 표시
		// => 기본 레이아웃은 BorderLayout
		JFrame selectFrame = new JFrame("회원 정보 조회");
		selectFrame.setBounds(600, 400, 700, 300);
		selectFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 현재창 종료
		selectFrame.setResizable(false); // 프레임 크기 고정
		
		// JScrollPane 객체 생성하여 JFrame 에 부착
		JScrollPane selectScrollPane = new JScrollPane();
		selectFrame.add(selectScrollPane, BorderLayout.CENTER);
		
		// JTable 생성하여 JScrollPane 에 부착
		JTable selectTable = new JTable();
		selectScrollPane.setViewportView(selectTable);
		// 테이블 열 위치 변경 불가능하도록 설정
		selectTable.getTableHeader().setReorderingAllowed(false);
		
		Vector<String> columnNames = new Vector<String>(
				Arrays.asList("번호", "이름", "나이", "성별", "E-Mail", "주민번호"));
		// 제목열 Vector 객체를 DefaultTableModel 객체에 추가 => 행번호 0으로 설정
		DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);
		// JTable 에 DefaultTableModel 전달하여 제목 표시
		selectTable.setModel(dtm);
		
		// 새로운 프레임 표시
		selectFrame.setVisible(true);
		
		// ----------------------------------------
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/java";
		String user = "root";
		String password = "1234";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공!");
			
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 성공!");
			
			String sql = "SELECT * FROM member2";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// 만약, JTable 객체로부터 DefaultTableModel 객체를 가져와야 할 경우
			// => DefaultTableModel 참조변수에 접근 가능할 경우 생략
			DefaultTableModel dtm2 = (DefaultTableModel)selectTable.getModel();
			
			while(rs.next()) {
				int idx = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				String gender = rs.getString(4);
				String email = rs.getString(5);
				String jumin = rs.getString(6);
				
//				System.out.println(idx + ", " + 
//						name + ", " + age + ", " + gender + ", " + email + ", " + jumin);
				
				// Vector 객체에 1개 레코드 데이터 추가
				Vector rowData = new Vector();
				rowData.add(idx);
				rowData.add(name);
				rowData.add(age);
				rowData.add(gender);
				rowData.add(email);
				rowData.add(jumin);
				
				dtm2.addRow(rowData); // 1개 레코드 Vector 객체 추가 => 반복
				
			}
			
			// 추가된 데이터를 적용하기 위해 JTable 의 setModel() 메서드 호출
			selectTable.setModel(dtm2);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new Member2Join();
	}
}
