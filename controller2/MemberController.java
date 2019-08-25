package com.bitcamp.controller2;
import javax.swing.JOptionPane;
import com.bitcamp.domain2.MemberBean;
import com.bitcamp.service2.MemberService;
public class MemberController{
	public static void main(String[] args) {
		MemberBean member = null;//아직 인스턴스 생성 전 참조변수 멤버를 위한 공간만 마련
		MemberService service = new MemberService();
//		연산자 new에 의해 서비스클래스의 인스턴스가 메모리의 빈공간에 생성
//		이 때 인스턴의 멤버변수들은 기본값으로 초기화 된다.
//		그 다음 생성된 객체의 주소값이 서비스라는 참조변수에 저장 이제는 차조변수 서비스를 통해 
//		멤버서비스 인스턴스에 접근할 수 있다.
		while(true) {
			switch (JOptionPane.showInputDialog("0.종료 \n"
					+ "1.회원가입\n"
					+ "2.마이페이지\n"
					+ "3.비번변경\n"
					+ "4.회원탈퇴\n"
					+ "5.아이디 존재 여부\n"
					+ "6.로그인\n")) {
			case "0":
				JOptionPane.showMessageDialog(null, "시스템종료하겠씁니다.");
				return;
			case "1":
				member = new MemberBean();
//				new연산자가 인스턴스를 생성하는것이지 생성자가 인스턴스를 생성하는것이 아니다.
				String memberShip = JOptionPane.showInputDialog("이름,아이디,비번,주민번호,혈액형,키,몸무게");
				String[] arr = memberShip.split(",");
				member.setName(arr[0]);
				member.setId(arr[1]);
				member.setPw(arr[2]);
				member.setSsn(arr[3]);
				member.setBlood(arr[4]);
				member.setHeight(Double.parseDouble(arr[5]));
				member.setWeight(Double.parseDouble(arr[6]));
				JOptionPane.showMessageDialog(null, service.join(member));
				break;
			case "2":
				JOptionPane.showMessageDialog(null, service.getMyPage(member));
				break;
				
			case "3":
				String password = JOptionPane.showInputDialog("아이디,비번,새비번 입력:");
				member = new MemberBean();
				String[] pws = password.split(",");
				member.setId(pws[0]);
				member.setPw(pws[1]+","+pws[2]);
				JOptionPane.showMessageDialog(null, service.changePassword(member));
				break;
				
			case "4" :
				break;
				
			case "5":
				String id = JOptionPane.showInputDialog("아이디 존재여부:");
				member.setId(id);
				JOptionPane.showMessageDialog(null, service.existId(id));
				break;
				
			case "6":
				member = new MemberBean();
				String temp = JOptionPane.showInputDialog("아이디,비번 입력:");
				String[] temparr = temp.split(",");
				member.setId(temparr[0]);
				member.setPw(temparr[1]);
				JOptionPane.showMessageDialog(null, service.login(member));
				break;
			default:
				break;
			}
		}
	}
}