package com.bitcamp.controller1;
import javax.swing.JOptionPane;
import com.bitcamp.domain1.MemberBean;
import com.bitcamp.service1.MemberService;
public class AdminController {

	public static void main(String[] args) {
		MemberBean  member = null;
		MemberService service = new MemberService();
		
		
		while(true) {
			switch (JOptionPane.showInputDialog("0.종료 \n"
					+ "1.회원목록 \n"
					+ "2.아이디 찾기 \n"
					+ "3.이름 찾기 \n"
					+ "4.총 회원수 \n")) {
			case "0":
				JOptionPane.showInputDialog("시스템 종료하겠습니다");
				return;
				
			case "1":
				JOptionPane.showMessageDialog(null, service.list());
				break;
				
			case "2":
				String searchId = JOptionPane.showInputDialog("아이디 검색:");
				member = service.findId(searchId);
				JOptionPane.showMessageDialog(null, member);
				break;
				
			case "3":
				MemberBean[] marr = service.findByName(JOptionPane.showInputDialog("이름 검색:"));
				JOptionPane.showMessageDialog(null, marr);
				break;
				
			case "4":
				JOptionPane.showMessageDialog(null, service.countAll());
				break;
			default:
				break;
			}
		}
		
		
	}

}
