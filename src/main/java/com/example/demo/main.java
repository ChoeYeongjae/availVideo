package com.example.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class main {
	
	// 회원목록 리스트 가져오기 
	// 공통적으로 같은 값이 유지되어야 하는 경우 static 사
	static MemberManager membermanger = new MemberManager(); 
	
	// 회원목록 저장  
	public static void member_load() {
		String files = "/Users/choeyeongjae/Desktop/회원목록.txt";
		
		try{
			//파일 객체 생성 영화목록
			File file = new File(files);
			//데이터처리 효율성때문에 BufferedReader를 사용함
			BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
			String line = "";
		            
			while((line = bufReader.readLine()) != null){
			// 읽어들인 파일을 split으로 , 별로 잘라서 배열 객체에 저장
				String[] strArr = line.split(",");
			// membermanger의 객체안에는 Membranger클래스의 메소드를 가져와서초기화한다. 각속성별로
				membermanger.sign_up(strArr[0], strArr[1], strArr[2], strArr[3]);
			}
			//.readLine()은 끝에 개행문자를 읽지 않는다.            
			bufReader.close();
		}catch (FileNotFoundException e) {
			// TODO: handle exception
		}catch(IOException e){
			System.out.println(e);
			}	
		}
	
	//비디오 목 저장  
	public static void video_load() {
			
		// VideoManger에 담을 객체생성함.
		VideoManager videomanger = new VideoManager(); 
				
		try{
			//파일 객체 생성   영화목록
			File file = new File("/Users/choeyeongjae/Desktop/영어목.txt");
			//데이터처리 효율성때문에 BufferedReader를 사용함
			BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
			String line = "";
			            
			while((line = bufReader.readLine()) != null){
				// 읽어들인 파일을 split으로 , 별로 잘라서 배열 객체에 저장
				String[] strArr = line.split(",");
				// video의 객체안에는 video클래스의 메소드를 가져와서초기화한다. 각속성별로
				videomanger.availableVideoList.add(new Video(strArr[0],strArr[1],strArr[2],strArr[3]));
			}
			//.readLine()은 끝에 개행문자를 읽지 않는다.            
			bufReader.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e){
			System.out.println(e);
		}
	}
		
	//회원 목록 저장  
	public static void member_txt_save() {
			
		BufferedWriter out = null;
			
		try {
			out = new BufferedWriter(new FileWriter("/Users/choeyeongjae/Desktop/회원목록.txt"));		
			out.write(membermanger.GetAllMemberString());
		} catch (IOException e) {
			System.err.println(e); // 에러가 있다면 메시지 출력
			System.exit(1);
		} finally { 
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public static void memberSignUp() {
		
		Scanner form_data = new Scanner(System.in);	
				
		System.out.println("---------회원가입--------");	
		System.out.println("1.name");
		String name_input = form_data.nextLine();
		System.out.println("2.address");
		String address_input = form_data.nextLine();
		System.out.println("3.idNumber");
		String idNumber_input = form_data.nextLine();
		System.out.println("4.phoneNumber");
		String phoneNumber_input = form_data.nextLine();
		
		// 사용자가 입력한값을회원가입 메소드로값처
		membermanger.sign_up(name_input, address_input, idNumber_input, phoneNumber_input);
		// 회원가입이 완료되었으면 로드한 데이터와 현재 회원가입된 데이터를 txt파일에 출력 
		member_txt_save();
		System.out.println("회원가입완료");
	}
	
	
	public static void main(String[] args) {	

		// 멤버 로드를 호출함으로써 member클래스에 값 대
		member_load();
		// 비디오 로드
		video_load();
		
		
		Scanner scanner = new Scanner(System.in);	
		boolean isboolean = true;
		
		// isboolean값이 flase가 될때까지반
		while(isboolean) {
			
		System.out.println("------ 비디오대여 프로그램 ------");
		System.out.println("1. 회원가입 ");
		System.out.println("2. 종료 ");
		System.out.println("----------------------------");
			
		System.out.println("원하는 번호를 입력해주세요 ");
		String user_input = scanner.nextLine();
		
		if(user_input.equals("1")) {
			// 만약 유저가 입력한 값이 1인경우 메소드호출 
			memberSignUp();
		} else {
			isboolean = false;
		}
		}
	}
}
