package com.bitcamp.service2;
import com.bitcamp.domain2.MemberBean;
public class MemberService {
	private MemberBean[] members;
	private int count;
	
//	기본생성자
	public MemberService() {
		members = new MemberBean[10];
		count = 0;
	}
	
	public String join(MemberBean param) {
		String msg = "회원가입 성공";
		members[count] = param;
		count++;
		return msg;
	}
	public String getMyPage(MemberBean param) {
		return param.toString();
//		멤버빈 클래스에 있는 tostring메서드를 반환한다.
	}
	public String changePassword(MemberBean param) {
		String msg = "비번변경 완료";
		String id = param.getId();
		String password = param.getPw();
		String[] arr = password.split(",");
		String oldPw = arr[0];
		String newPw = arr[1];
		for(int i=0;i<count;i++) {
			if(param.getId().equals(members[i].getId()) && param.getPw().equals(members[i].getPw())) {
					members[i].setPw(arr[1]);
					break;
			}
		}
		return msg;
	}
	public String withDraw(MemberBean param) {
		String msg = "회원탈퇴 완료";
		
		return msg;
	}
	
	public String existId(String id) {
		String msg = "이미존재한 아이디";
		for(int i=0;i<count;i++) {
			if(id.equals(members[i].getId())) {
				msg = "이미존재한 아이디"; break;
			}else {
				msg = "사용가능한 아이디입니다";
			}
		}
		return msg;
	}
	
	public String login(MemberBean param) {
		String msg = "";
		for(int i=0;i<count;i++) {
			if(param.getId().equals(members[i].getId())
					&& param.getPw().equals(members[i].getPw())) {
					msg = "로그인성공";
					break;
			}
		}
		return msg;
	}
	
	public String list() {
		String msg = "";
		for(int i=0;i<count;i++) {
			msg += members[i].toString();
			}
		return msg;
	}
	
	public MemberBean findId(String id) {
		MemberBean member = new MemberBean();
		for(int i=0;i<count;i++) {
			if(id.equals(members[i].getId())) {
				member = members[i];
			}
		}
		return member;
	}
	
	public MemberBean[] findName(String name) {
		int j =0;
		for(int i=0;i<count;i++) {
			if(name.equals(this.members[i].getName())) {
				j++;
			}
		}
		j=0;
		MemberBean[] members = new MemberBean[j];
		for(int i=0;i<count;i++) {
			if(name.equals(this.members[i].getName())) {
				members[count] = this.members[i];
				j++;
				if(members.length == j) {
					break;
				}
					
			}
			members[i] = this.members[i];
		}
		return members;
	}
}

