package com.bitcamp.controller1;
import javax.swing.JOptionPane;

import com.bitcamp.domain1.MemberBean;
import com.bitcamp.service1.MemberService;
public class MemberController {
		public static void main(String[] args) {
			String temp = "";
			String[] arr = null;
			MemberService service = new MemberService();
			MemberBean member = null;
	
		while(true) {
			switch (JOptionPane.showInputDialog("0.종료\n"
					+ "1.회원가입 \n"
					+ "2.개인정보페이지 \n"
					+ "3.비번변경 \n"
					+ "4.회원탈퇴 \n"
					+ "5.아이디 존재여부 \n"
					+ "6.로그인 ")) {
			case "0":
				JOptionPane.showMessageDialog(null, "시스템 종료하겠습니다.");
				return;
			case "1":
			temp = JOptionPane.showInputDialog("이름,아이디,비번,주민번호,혈액형,나이,키,몸무게");
			arr = temp.split(",");
			member = new MemberBean();
			member.setName(arr[0]);
			member.setId(arr[1]);
			member.setPw(arr[2]);
			member.setSsn(arr[3]);
			member.setBlood(arr[4]);
			member.setAge(Integer.parseInt(arr[5]));
			member.setHeight(Double.parseDouble(arr[6]));
			member.setWeight(Double.parseDouble(arr[7]));
			JOptionPane.showMessageDialog(null, service.join(member));
			break;
			
			case "2":
				JOptionPane.showMessageDialog(null, service.getMyPage(member));
				break;
			case "3":
				temp = JOptionPane.showInputDialog("로그인에 썼던 정보와 새로 바꿀 비번을 입력하세요");
				arr = temp.split(",");
				member = new MemberBean();
				member.setId(arr[0]);
				member.setPw(arr[1]+ ","+arr[2]);
				JOptionPane.showMessageDialog(null, service.changePassword(member));
				break;
			case "4":
//			회원탈퇴
				break;
				
				
			case "5":
				String id = JOptionPane.showInputDialog("아이디 검색:");
				member.setId(id);
				JOptionPane.showMessageDialog(null, service.existId(id));
				break;
				
			case "6":
				member = new MemberBean();
				temp = JOptionPane.showInputDialog("아이디,비번");
				arr = temp.split(",");
				member.setId(arr[0]);
				member.setPw(arr[1]);
				JOptionPane.showMessageDialog(null, service.login(member));
				break;
			default:
				break;
			}
		}
		}
	}


