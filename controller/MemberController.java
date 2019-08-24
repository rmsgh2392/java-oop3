package com.bitcamp.controller;
import javax.swing.JOptionPane;
import com.bitcamp.domain.MemberBean;
import com.bitcamp.service.MemberService;
public class MemberController{
	public static void main(String[] args) {
		MemberBean member = null;
		MemberService service = new MemberService();
		String temp = "";
		String[] arr = null;
	while(true) {
		switch (JOptionPane.showInputDialog("0.종료\n"
				+ "1.회원가입\n"
				+ "2.마이페이지\n"
				+ "3.비번수정\n"
				+ "4.회원탈퇴\n"
				+ "5.아이디 존재여부체크\n"
				+ "6.로그인\n"
				+ "7.회원목록\n"
				+ "8.아이디 검색\n"
				+ "9.이름 검색\n"
				+ "10.전체 회원수")){
		case "0":
			JOptionPane.showMessageDialog(null, "시스템 종료하겠습니다.");
			return;
		case "1":
//			1.회원가입 화면
			temp = JOptionPane.showInputDialog("이름,아이디,비밀번호,"
					+ "주민번호,혈액형,키,몸무게");
			member = new MemberBean();
//			Q/여기서 생성자를 만들어주는 이유가 While문에 넣어서 반복해서 회원수를 더 늘리려고 여기다 써주는건가요?
			 arr = temp.split(",");
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
//			2.마이페이지 화면
			JOptionPane.showMessageDialog(null, service.getMyPage(member));
			break;
		case "3":
//			3.비번변경 화면
			temp = JOptionPane.showInputDialog("로그인 정보와 새로 바꿀 비번을 입력하세요");
			member = new MemberBean();
			arr = temp.split(",");
			member.setId(arr[0]);
			member.setPw(arr[1]+","+arr[2]);
			JOptionPane.showMessageDialog(null, service.changePassword(member));
			break;
			
		case "4":
//			4.회원탈퇴
			
			
			
		case "5":
//			5.아이디 존재 체크
			String id = "";
			JOptionPane.showInputDialog("아이디 입력:");
			member.setId(id);
			JOptionPane.showMessageDialog(null, service.existId(id));
			break;
			
		case "6":
//			6.로그인
			temp = JOptionPane.showInputDialog("아이디,비밀번호입력");
			member = new MemberBean();
			arr = temp.split(",");
			member.setId(arr[0]);
			member.setPw(arr[1]);
			JOptionPane.showMessageDialog(null, service.login(member));
			break;
			
		case "7":
//			7. 회원목록
			JOptionPane.showMessageDialog(null, service.list());
			break;
			
		case "8":
//			8.아이디 검색 
			String searchId = JOptionPane.showInputDialog("검색 ID");
			member = service.findById(searchId);
			JOptionPane.showMessageDialog(null, member);
			break;
			
		case "9":
//			9.이름 검색
//			String serchName = JOptionPane.showInputDialog("검색 이름");
//			member = service.findName(serchName);
//			JOptionPane.showMessageDialog(null, member);
			MemberBean[] memberarr = service.findName(JOptionPane.showInputDialog("이름검색:"));
			JOptionPane.showMessageDialog(null, memberarr);
		case "10":
//			10.전체 회원수 
			JOptionPane.showMessageDialog(null, "총 회원수 ");
			JOptionPane.showMessageDialog(null, service.counAll());
			
			
		default:
		
			break;
			
			
			
			
		}
	}
	}
}
	
	
	
	
	
	
	

	

