package com.example.demo;

import java.util.ArrayList;

public class VideoManager {
	
	// 비디오 대여 리스트 클래스
	ArrayList<Video> availableVideoList = new ArrayList<Video>(); 
	
	// 비디오 반납 리스트 클래스
	ArrayList<Video> unVailableVideoList = new ArrayList<Video>();
	
	// 비디오 대여 
	public void rentVideo(String vidoe_name) {
		for(int i = 0 ; i < availableVideoList.size() ; i++) {
			if(availableVideoList.get(i).getMovieName().equals(vidoe_name)) {
				unVailableVideoList.add(availableVideoList.get(i));
				availableVideoList.remove(availableVideoList.get(i));
			}
		}
	}
	
	// 비디오 반납 
	public void returnVideo(String vidoe_name) {
		for(int i = 0 ; i < unVailableVideoList.size() ; i++) {
			if(unVailableVideoList.get(i).equals(vidoe_name)) {
				availableVideoList.add(unVailableVideoList.get(i));
				unVailableVideoList.remove(unVailableVideoList.get(i));
			}
		}	
	}
	
	// 비디오 리스트 출력 
	public String GetAllVideoString() {
		String str = "";
		
		for (int i = 0 ; i < availableVideoList.size() ; i++) {
			// += 사용시 반복되면서 str에 계속 대입됨.
			str += availableVideoList.get(i).getVideoList() + "\r";
		}	
		return str;
	}
	
	public Video getVideoByName(String name) {
		
		for(int i = 0 ; i < availableVideoList.size() ;i++ ) {
			if(availableVideoList.get(i).getMovieName().equals(name)) {
				return availableVideoList.get(i);
			}
		}
		return null;
	}
	
}

