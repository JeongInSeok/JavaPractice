import javax.swing.JFrame;

public class MemberGUI extends JFrame {
	
	public MemberGUI() {
		showFrame();
	}
	
	public void showFrame() {
		
		
		
		// 버튼에 따라 각각 다른 메서드 호출
		
	}
	
	public void insert() {
		// 입력값 검증 및 입력 데이터 가져오기
		// MemberDAO 객체의 insert() 메서드를 통해 DB INSERT 작업 수행
		// => 가져온 데이터를 DTO 객체에 저장하거나 변수 그대로 파라미터로 전달
		
	}
	
	public void select() {
		// MemberDAO 객체의 select() 메서드를 통해 DB SELECT 작업 수행
		// => 리턴받은 데이터를 DefaultTableModel 객체를 통해 JTable 에 추가
		
	}
	
	public void delete() {
		// InputDialog 를 사용하여 삭제할 번호를 입력받아
		// MemberDAO 객체의 delete() 메서드를 통해 DB DELETE 작업 수행
	}
	
	public static void main(String[] args) {
		new MemberGUI();
	}
	
}
