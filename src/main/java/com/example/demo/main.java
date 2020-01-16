package com.example.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class main {

	public static void memberListTrans(String member_list) {

		// 멤버 객체 
		ArrayList<Member> members = new ArrayList<Member>();
		
		try{
            //파일 객체 생성
	        File file = new File(member_list);
	        //데이터처리 효율성때문에 BufferedReader를 사용함
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"EUC-KR"));
            String line = "";
            
            while((line = bufReader.readLine()) != null){
            	// 읽어들인 파일을 split으로 , 별로 잘라서 배열 객체에 저장
            	String[] strArr = line.split(",");  
            	// 배열 객체에 저장 되어있는 인덱스별로 하나씩 가져온 후 member객체에 저장
            	Member member = new Member(strArr[0], strArr[1], strArr[2], strArr[3]);
            	// member객체에 저장후 각 속성별로 초기화후 members객체에 저장
            	members.add(new Member(member.getAddress(), member.getIdNumber(), member.getName(), member.getPhoneNumber()));
            }
            //.readLine()은 끝에 개행문자를 읽지 않는다.            
            bufReader.close();
        	}catch (FileNotFoundException e) {
            // TODO: handle exception
        	}catch(IOException e){
        		System.out.println(e);
        	}
	}
	
	public static void videoListTrans(String video_list) {

		// 멤버 객체 
		ArrayList<Video> video_possibility_list = new ArrayList<Video>(); 
		
		try{
            //파일 객체 생성
	        File file = new File(video_list);
	        //데이터처리 효율성때문에 BufferedReader를 사용함
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"EUC-KR"));
            String line = "";
            
            while((line = bufReader.readLine()) != null){
            	// 읽어들인 파일을 split으로 , 별로 잘라서 배열 객체에 저장
            	String[] strArr = line.split(",");  
            	// 배열 객체에 저장 되어있는 인덱스별로 하나씩 가져온 후 videos객체에 저장
            	Video videos = new Video(strArr[0], strArr[1], strArr[2], strArr[3]);
            	// videos객체에 저장후 각 속성별로 초기화후 videos객체에 저장
            	video_possibility_list.add(new Video(videos.getGenre(), videos.getMovie_name(), videos.getProduction_year(),videos.getSuperVision()));
            }
            //.readLine()은 끝에 개행문자를 읽지 않는다.            
            bufReader.close();
        	}catch (FileNotFoundException e) {
            // TODO: handle exception
        	}catch(IOException e){
        		System.out.println(e);
        	}
	}
	
	public static void main(String[] args) {
			
			// 회원가입 리스트 저장 함수
			memberListTrans("C:/Users/nhd59/Desktop/회원목록.txt");
			
			// 비디오 리스트 저장 함수 
			videoListTrans("C:/Users/nhd59/Desktop/비디오목록.txt");

			System.out.print("tsss");
	}
		
	}

