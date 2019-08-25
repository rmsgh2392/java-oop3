package com.bitcamp.service;
import com.bitcamp.domain.MemberBean;
public class MemberService {
	private MemberBean[] members ;
	private int count;
	
	
//기본 생성자 
	public MemberService() {
		this.members = new MemberBean[10];
		this.count = 0;
	}
	
	
	/*************************************
	 * 사용자 기능 
	 *//**********************************/
		
	/**
	 * 1.회원가입 
	*/
		public String join(MemberBean param) {
			String msg ="회원가입 되셨습니다";
			members[count] = param; 
			count++;
			return msg;
		}
	//*****************************************
		/**
		 * 2.Mypage 
		*/	
		public String getMyPage(MemberBean param) {
			return param.toString();
			}
		
		/**
		 * 3.비번수정
		 *비번수정 아이디 옛날 비번 신규비번 입력받아서 옛날비번 일치하면 신규비번으로 변경
		 *비번 변경후 로그인을 실행해서 새로 바뀐 비번이 로그인성공 ,옛날비번 로그인 실패
		 */
		
		public String changePassword(MemberBean param) {
			String msg = "비밀번호가 변경되었습니다";
			String id = param.getId();
			String pw = param.getPw();
			String[] pws = pw.split(",");
			String oldPw = pws[0];
			String newPw = pws[1];
			
			for(int i=0;i<count;i++) {
				if(param.getId().equals(members[i].getId())
						&&param.getPw().equals(members[i].getPw())) {
						 members[i].setPw(pws[1]);
						 break;
						 }
			}
			return msg;
		}
		/**
		 * 4.회원탈퇴
		 */
		public String withDraw(MemberBean param) {
			String msg = "회원탈퇴 완료";
			
			return msg;
					
		}
		
		
		/**
		 * 5.아이디 존재 체크
		 */
		public String existId(String id) {
			String msg = "가입가능한 아이디입니다.";
			for(int i=0;i<count;i++) {
				if(id.equals(members[i].getId())) {
					msg = "이미 존재한 아이디입니다.";
					break;
				}
			}
			return msg;
		}
		
		
		/**
		 * 6.로그인
		 * 파라미터로 아이디 패스워드만 입력받은 상태
		 */
		public String login(MemberBean param) {
			String msg = "로그인 실패";
			for(int i=0;i<count;i++) {
				if(param.getId().equals(members[i].getId())
						&& param.getPw().equals(members[i].getPw())) {
					msg = "로그인 성공";
					break;
				}
			}
			return msg;
		}
				
	/***********************************************************
	 * <관리자 기능>
	 * 1.회원 목록
	 * 2.아이디 검색
	 * 3.이름 검색
	 * 4.전체 회원 수 
	 *************************************************************/
	
		/**
		 * 1.회원목록
		*/
		 public String list() {
			 String msg = "";
			 for(int i=0;i<count;i++) {
//			Q 이 부분에서 카운트를 미만이아니라 <=이렇게 연산자를 써야되는거 아닌가여?		 
				 msg += members[i].toString()+", \n";
			 }
			 return msg;
		 }
		 /**
		  * 2.아이디 검색
		  */
		 public MemberBean findById(String id) {
			 MemberBean member = new MemberBean();
			 for(int i=0;i<count;i++) {
				 if(id.equals(members[i].getId())) {
					 member = members[i];
				 }
			 }
			 
			 return member;
		 }
		 /**
		  * 3.이름 검색
		  */
		 
		 public MemberBean[] findName(String name) {
			 int j = 0;//동명이인 카운트 세는 변수
			 for(int i=0;i<count;i++) {
				 if(name.equals(this.members[i].getName())) {
					 j++;
				 }
			 }
			 MemberBean[] members = new MemberBean[j];
			 j=0;
			 for(int i=0;i<count;i++) {
				 if(name.equals(this.members[i].getName())) {
					 members[j] = this.members[i];
					 j++;
					 if(members.length == j) {
						 break;
					 }
					 
				 }
				 members[i] = this.members[i];
			 }
			 return members;
		 }
		 
		 /**
		  * 4.총 회원수
		  */
		 public String counAll() {
			 return "총회원수 : "+count;
		 }
}



