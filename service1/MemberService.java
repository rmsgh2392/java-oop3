package com.bitcamp.service1;
import com.bitcamp.domain1.MemberBean;
public class MemberService {
/**
 * 서비스 클래스 겸 서버 클래스 
 * 클라이언트가 여러명이지만 서버는 한개 !! 여기서 클라이언트들을 다 관리한다
 */
	private MemberBean[] members;
//	서비스 클래스에 멤버변수(배열)
	private int count;
	public MemberService() {
//	1.기본생성자는 클래스 안에 있는 인스턴스 변수 즉 멤버변수들을 초기화 해준다 
//	2.생성자는 메서드와는 다르게 리턴값이 없다.
		members = new MemberBean[10];
		count = 0;
//	이 생성자는 서비스 클래스 필드에 있는 멤버변수(인스턴스 변수들을) 초기화 해주고 있다.
//	먼저 MemBean[]배열의 래퍼런스 변수인 members의 맥시멈크기 주소가 들어올 공간을 10을 준다.
//	그리고 카운트의 값을 디폴트로 초기화 해준다 카운트는 클라이언트 수 즉 회원수 
	}
	
	/**
	 * 고객 요구 사항 서비스 
	 * 1.회원가입
	 * 2.개인페이지
	 * 3.비번 변경
	 * 4.회원탈퇴
	 * 5.아이디 존재 체크
	 * 6.로그인
	 */
//	1.회원가입
	public String join(MemberBean param) {
		String msg = "회원가입 되셨습니다.";
		members[count] = param;
		count++;
		return msg;
	}
//	2.개인 페이지
	public String getMyPage(MemberBean param) {
		String msg = "개인정보입니다.";
		return param.toString();
	}
//	3.비번 변경(아이디와 옛날 비번 신규비번 입력받아서 옛날 비번 일치하면 비번 변경)
	public String changePassword(MemberBean param) {
		String msg ="비번변경 완료";
		String id  = param.getId();
		String passwords = param.getPw();
		String[] pwArr = passwords.split(",");
		String oldPw = pwArr[0];
		String newPw = pwArr[1];
		for(int i=0;i<count;i++) {
			if(param.getId().equals(members[i].getId())
					&& param.getPw().equals(members[i].getPw())){
					members[i].setPw(pwArr[1]);			
					break;
			}
		}
		return msg;
	}
//	4.회원 탈퇴 
	public String withDraw(MemberBean param) {
		String msg = "회원 탈퇴 되셨습니다.";
		
		
		return msg;
	}
//	5.아이디 존재 여부 
	public String existId(String id) {
		String msg = "사용 가능한 아이디 입니다";
		for(int i=0;i<count;i++) {
			if(id.equals(members[i].getId())) {
				msg = "이미 존재한 아이디입니다.";
				break;
			}
		}
		return msg;
	}
//	6.로그인
	public String login(MemberBean param) {
		String msg = "로그인 실패.";
		for(int i=0;i<count;i++) {
			if(param.getId().equals(members[i].getId())
					&&param.getPw().equals(members[i].getPw())) {
					msg = "로그인 성공";
					break;
			}
		}
		return msg;
	}
//*******************************************************************
	
	
//	1.회원목록
	public String list() {
		String msg = "";
		for(int i=0;i<count;i++) {
			msg += members[i].toString();
		}
		return msg;
	}
//	2.검색 아이디
	public MemberBean findId(String id) {
		String msg = "";
		MemberBean member = new MemberBean();
		for(int i =0;i<count;i++) {
			if(id.equals(members[i].getId())) {
				member = members[i];
			}
		}
		return member;
	}
//	3.이름 검색
	public MemberBean[] findByName(String name) {
		int cnt =0;
		for(int i=0;i<count;i++) {
			if(name.equals(this.members[i].getName())) {
				cnt++;
			}
		}
		cnt = 0;
		MemberBean[] members = new MemberBean[cnt];
		for(int i=0;i<count;i++) {
			if(name.equals(this.members[i].getName())) {
				members[count] = this.members[i];
				cnt++;
				if(members.length == cnt) {
					break;
				}
				
			}
			members[i] = this.members[i];
		}
		return members;
	}
//	4.총 회원 수 
	public String countAll() {
		return "총 회원수 ="+ count;
	}
	
	
	
	
	
}
