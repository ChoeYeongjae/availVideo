package com.example.demo;

import java.util.ArrayList;

public class MemberManger {

	// ArrayList 선언 및 초기화
	ArrayList<Member> members = new ArrayList<Member>();
	
	// index 값 초기화
	int index = 0;

	// 회원가입 	
	public void sing_up(String name,String addres,String idNumber,String phoneNumber) {
		
		// 객체를 생성후 members list에 추가
		
		Member member_info = new Member(name,addres,idNumber,phoneNumber);			
		members.add(member_info);
	}
	
	// 회원목록

	public void show_members() {
	
		// 클래스 배열 데이터 출력
		for(Member data : members) {
			System.out.println(data);
		}
	}
	
	// 이름으로 조회하기
	
	public Member getMemberByName(String insert_name) {
	      // 맴버 클래스 배열 데이터 조회
	      for(int i = 0; i < members.size(); i ++) {
	    	  // 만약에 문자열을 비교가 true일경우
	    	  if(insert_name.equals(members.get(i).getName())) 
	        	 // members.get(i)째의 값을 리턴을 시켜서 Member클래스 값을 전달
	        	 return members.get(i);
	      	}               
	      return null;
	   }

	// index 조회
	
	public Member getMemberByIndex(int index) {
	      return members.get(index);
	}
	
	
}
