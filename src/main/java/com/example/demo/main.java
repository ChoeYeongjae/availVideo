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

	// 회원목록 저장  
	public static void member_save(String files) {
		
		// MemberManger에 담을 객체생성함.
		MemberManger  membermanger = new MemberManger(); 
			
		try{
			//파일 객체 생성   영화목록
			File file = new File(files);
			//데이터처리 효율성때문에 BufferedReader를 사용함
			BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
			String line = "";
		            
			while((line = bufReader.readLine()) != null){
			// 읽어들인 파일을 split으로 , 별로 잘라서 배열 객체에 저장
				String[] strArr = line.split(",");
			// membermanger의 객체안에는 Membranger클래스의 메소드를 가져와서초기화한다. 각속성별로
				membermanger.sing_up(strArr[0], strArr[1], strArr[2], strArr[3]);
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
		public static void	video_save(String files) {
			
			// VideoManger에 담을 객체생성함.
			VideoManger videomanger = new VideoManger(); 
				
			try{
				//파일 객체 생성   영화목록
				File file = new File(files);
				//데이터처리 효율성때문에 BufferedReader를 사용함
				BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
				String line = "";
			            
				while((line = bufReader.readLine()) != null){
				// 읽어들인 파일을 split으로 , 별로 잘라서 배열 객체에 저장
					String[] strArr = line.split(",");
				// video의 객체안에는 video클래스의 메소드를 가져와서초기화한다. 각속성별로
					videomanger.video_possibility_list.add(new Video(strArr[0],strArr[1],strArr[2],strArr[3]));
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
		
		//회원목록 
		member_save("/Users/choeyeongjae/Desktop/회원목록.txt");
		
		//비디오대여목록
		video_save("/Users/choeyeongjae/Desktop/영화목록.txt");
		
	}
}
