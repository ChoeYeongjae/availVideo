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
	static MemberManager memberManager = new MemberManager();

	// VideoManger에 담을 객체생성함.
	static VideoManager videoManager = new VideoManager();
	
	static UserVideoList userVideoList = new UserVideoList();

	final static String filePath = "src/main/java/com/example/demo/회원목록.txt";
	
	final static String videoFilePath = "src/main/java/com/example/demo/영화목록.txt";

	
	// 회원목록 저장
	public static void member_load() {

		try {
			// 파일 객체 생성 영화목록
			File file = new File(filePath);
			// 데이터처리 효율성때문에 BufferedReader를 사용함
			BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			String line = "";

			while ((line = bufReader.readLine()) != null) {
				// 읽어들인 파일을 split으로 , 별로 잘라서 배열 객체에 저장
				String[] strArr = line.split(",");
				// MemberManager의 객체안에는 Membranger클래스의 메소드를 가져와서초기화한다. 각속성별로
				memberManager.sign_up(strArr[0], strArr[1], strArr[2], strArr[3]);
			}
			// .readLine()은 끝에 개행문자를 읽지 않는다.
			bufReader.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	// 비디오 목 저장
	public static void video_load() {

		try {
			// 파일 객체 생성 영화목록
			File file = new File(videoFilePath);
			// 데이터처리 효율성때문에 BufferedReader를 사용함
			BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			String line = "";

			while ((line = bufReader.readLine()) != null) {
				// 읽어들인 파일을 split으로 , 별로 잘라서 배열 객체에 저장
				String[] strArr = line.split(",");
				// video의 객체안에는 video클래스의 메소드를 가져와서초기화한다. 각속성별로
				videoManager.availableVideoList.add(new Video(strArr[0], strArr[1], strArr[2], strArr[3]));
			}
			// .readLine()은 끝에 개행문자를 읽지 않는다.
			bufReader.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	// 회원 목록 저장
	public static void member_txt_save() {

		BufferedWriter out = null;

		try {
			out = new BufferedWriter(new FileWriter(filePath));
			out.write(memberManager.GetAllMemberString());
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

	public static Member memberSignUp() {

		Scanner form_data = new Scanner(System.in);

		System.out.println("---------회원가입--------");
		System.out.println("1.name");
		String nameInput = form_data.nextLine();
		System.out.println("2.address");
		String addressInput = form_data.nextLine();
		System.out.println("3.idNumber");
		String idNumberInput = form_data.nextLine();
		System.out.println("4.phoneNumber");
		String phoneNumberInput = form_data.nextLine();

		// 사용자가 입력한값을회원가입 메소드로값처
		Member member = memberManager.sign_up(nameInput, addressInput, idNumberInput, phoneNumberInput);
		// 회원가입이 완료되었으면 로드한 데이터와 현재 회원가입된 데이터를 txt파일에 출력
		member_txt_save();
		System.out.println("회원가입완료");
		return member;
	}

	// 비디오 대여기능
	public static void videoRent() {

		Scanner formData = new Scanner(System.in);

		System.out.println("---------비디오대여--------");
		System.out.println("이름을 입력하세요. ");
		String nameInput = formData.nextLine();
		//videoComparison(nameInput);
		Member member = memberManager.getMemberByName(nameInput);
		if(member == null) {
			// TODO: 회원가입.
			member = memberSignUp();
		}
		
		Video video = null;
		while(video == null) {
			System.out.println("비디오 대여 리스트 입니다. ");
			System.out.println(videoManager.GetAllVideoString());
			
			System.out.println("비디오이름 입력해주세요. ");
			String videoNameInput = formData.nextLine();
			
			video = videoManager.getVideoByName(videoNameInput);
			if(video == null)
				System.out.println("대여할 비디오가 존재하지 않습니다. 다시 입력해주세요.");
		}
		
		// TODO: 대여작업 .
		userVideoList.rent(member.getName(), video.getMovieName());
		userVideoList.saveFile();
		videoManager.rentVideo(video.getMovieName());
	}
	
	// 비디오 반납 
	public static void videoReturn() {
		
		Scanner videoName = new Scanner(System.in);

		System.out.println("---------비디오반납--------");
		System.out.println("이름을 입력하세요. ");
		String nameInput = videoName.nextLine();

		Member member = memberManager.getMemberByName(nameInput);

		Video video = null;
		while(video == null) {
			System.out.println("비디오 반납 리스트");
			System.out.println(userVideoList.rentList(member.getName()));
			
			System.out.println("비디오이름 입력해주세요. ");
			String videoNameInput = videoName.nextLine();
			
			video = videoManager.getVideoReturnName(videoNameInput);
			if(video == null)
				System.out.println("반납 할 비디오가 존재하지 않습니다. 다시 입력해주세요.");
		}
		
		// TODO: 반납 작업
		videoManager.returnVideo(video.getMovieName());
		userVideoList.rentRemove(member.getName(),video.getMovieName());
		userVideoList.saveFile();
		System.out.println("반납 완료 ");
	}

	// 비디오 대여 시 이름 비교
//	public static void videoComparison(String nameInput) {
//
//		boolean isExist = false;
//
//		for (int i = 0; i < memberManager.members.size(); i++) {
//			if (memberManager.members.get(i).getName().equals(nameInput)) {
//				isExist = true;
//				
//			}
//		}
//
//		if (!isExist) {
//			// TODO: 회원가입
//			System.out.println("회원가입을 시도해주세요.");
//			memberSignUp();
//		}
//	}

	public static void main(String[] args) {
		// 멤버 로드를 호출함으로써 member클래스에 값 대
		member_load();
		// 비디오 로드
		video_load();

		userVideoList.loadFile();
		for (String title : userVideoList.getRentList().values()) {
		    videoManager.rentVideo(title);
		}
//		
//		for (String title : userVideoList.getRentList().values()) {
//			userVideoList.rentRemove(title);
//		}
		
		Scanner scanner = new Scanner(System.in);
		boolean isboolean = true;

		// isboolean값이 flase가 될때까지반
		while (isboolean) {
			System.out.println("------ 비디오대여 프로그램 ------");
			System.out.println("1. 회원가입 ");
			System.out.println("2. 대여 ");
			System.out.println("3. 반납 ");
			System.out.println("4. 종료 ");
			System.out.println("----------------------------");

			System.out.println("원하는 번호를 입력해주세요 ");
			String user_input = scanner.nextLine();

			if (user_input.equals("1")) {
				// 만약 유저가 입력한 값이 1인경우 메소드호출
				memberSignUp();
			} else if (user_input.equals("2")) {
				// 만약 유저가 입력한 값이 2인경우메소드 호
				videoRent();
			}  else if (user_input.equals("3")) {
				// 만약 유저가 입력한 값이 2인경우메소드 호
				videoReturn();
			}  else {
				isboolean = false;
			}
		}
	}
}
