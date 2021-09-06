import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ex2 extends JFrame {
	private JTable table;
	private JButton btnMessage, btnConfirm, btnInput;
	
	public Ex2() {
		showFrame();
	}
	
	public void showFrame() {
		setBounds(600, 400, 300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		add(p, BorderLayout.CENTER);
		
		btnMessage = new JButton("Message");
		p.add(btnMessage);

		btnConfirm = new JButton("Confirm");
		p.add(btnConfirm);

		btnInput = new JButton("Input");
		p.add(btnInput);
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * JOptionPane 클래스
				 * - 간단한 다이얼로그(Dialog) 를 사용하여 사용자와 상호작용하는 객체
				 * - JOptionPane.showXXXDialog() 메서드 사용
				 *   1) MessageDialog : 사용자에게 메세지 표시
				 *      JOptionPane.showMessageDialog(parentComponent, message, title, messageType, icon);
				 *      - parentComponent : 다이얼로그를 표시할 대상 컴포넌트
				 *        => 참조변수 지정 시 해당 컴포넌트 위에 표시됨
				 *           만약, null 값 지정 시 화면 가운데 표시됨
				 *      - message : 사용자에게 보여질 다이얼로그 메세지 본문
				 *      - title : 다이얼로그 제목 표시줄 내용
				 *      - messageType : 다이얼로그 성격을 지정
				 *        => JOptionPane.XXX_MESSAGE 상수 사용하여 지정
				 *           INFORMATION_MESSAGE : 일반적인 정보(보라색 '!' 아이콘)
				 *           WARNING_MESSAGE : 경고 정보(노란색 '!' 아이콘)
				 *           ERROR_MESSAGE : 오류 정보(빨간색 'X' 아이콘)
				 *           QUESTION_MESSAGE : 질문 정보(초록색 '?' 아이콘)
				 *           PLAIN_MESSAGE : 아이콘 없음
				 *           
				 *   2) ConfirmDialog : 사용자로부터 버튼을 눌러서 확인
				 *      => 리턴타입이 int이므로 선택한 버튼에 대한 결과값 받아 판별 가능
				 *      JOptionPane.showConfirmDialog(parentComponent, message, title, optionType, messageType);
				 *      - parentComponent : 동일
				 *      - message : 동일
				 *      - title : 동일
				 *      - optionType : 확인할 버튼의 종류 설정
				 *        JOptionPane.XXX_OPTION 상수 사용
				 *        => YES_NO_OPTION : 예(Y), 아니오(N) 버튼
				 *           YES_NO_CANCEL_OPTION : 예(Y), 아니오(N), 취소 버튼
				 *           OK_CANCEL_OPTION : 확인, 취소 버튼
				 *        => 리턴값으로 전달되는 선택 버튼의 값이 다름
				 *           (YES_OPTION 과 OK_OPTION 은 동일한 값, NO_OPTION, CANCEL_OPTION)
				 *      - messageType : 동일
				 *      
				 *   3) InputDialog : 사용자로부터 값을 입력
				 *      => 리턴타입이 String 이므로 입력받은 값 저장 가능
				 */
				if(e.getSource() == btnMessage) {
					// MessageDialog 사용
					JOptionPane.showMessageDialog(
							null, // 현재 화면의 중앙에 표시
							"사용자에게 보여지는 메세지", 
							"다이얼로그 제목", 
							JOptionPane.WARNING_MESSAGE, 
							null); // 표시할 아이콘이 없으므로 null 지정
				} else if(e.getSource() == btnConfirm) {
					// ConfirmDialog 사용
					int result = JOptionPane.showConfirmDialog(
							btnConfirm, 
							"사용자에게 보여지는 메세지", 
							"다이얼로그 제목", 
							JOptionPane.OK_CANCEL_OPTION, 
							JOptionPane.QUESTION_MESSAGE);
					
					if(result == JOptionPane.YES_OPTION) {
						// YES_OPTION 과 OK_OPTION 은 동일한 값을 갖는다!
						// =>  || result == JOptionPane.OK_OPTION 추가해도 동일함
						System.out.println("YES 또는 OK 선택!");
					} else if(result == JOptionPane.NO_OPTION) {
						System.out.println("NO 선택!");
					} else if(result == JOptionPane.CANCEL_OPTION) {
						System.out.println("CANCEL 선택!");
					}
					
				} else if(e.getSource() == btnInput) {
					// InputDialog 사용
					String result = 
							JOptionPane.showInputDialog(btnInput, "사용자에게 보여질 메세지");
					System.out.println(result);
				}
			}
		};
		
		btnMessage.addActionListener(listener);
		btnConfirm.addActionListener(listener);
		btnInput.addActionListener(listener);
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex2();
	}
}
