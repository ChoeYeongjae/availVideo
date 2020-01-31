package com.example.demo;

import java.util.ArrayList;

public class VideoManager {

	// 비디오 대여 리스트 클래스
	ArrayList<Video> availableVideoList = new ArrayList<Video>(); 

	// 비디오 반납 리스트 클래스
	ArrayList<Video> unavailableVideoList = new ArrayList<Video>();


	// 비디오 대여 
	public void rentVideo(String vidoe_name) {
		for(int i = 0 ; i < availableVideoList.size() ; i++) {
			if(availableVideoList.get(i).getMovieName().equals(vidoe_name)) {
				unavailableVideoList.add(availableVideoList.get(i));
				availableVideoList.remove(availableVideoList.get(i));

			}
		}
	}

	// 비디오 반납 
	public void returnVideo(String vidoe_name_return) {
		for(int i = 0 ; i < unavailableVideoList.size() ; i++) {
			if(unavailableVideoList.get(i).getMovieName().equals(vidoe_name_return)) {
				availableVideoList.add(unavailableVideoList.get(i));
				unavailableVideoList.remove(unavailableVideoList.get(i));
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

	// 비디오 반납 리스트 출력 
	public String GetAllVideoReturn() {
		String str = "";

		for (int i = 0 ; i < unavailableVideoList.size() ; i++) {
			// += 사용시 반복되면서 str에 계속 대입됨.
			str += unavailableVideoList.get(i).getMovieName() + "\r";
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

	// 비디오 반납리스트 확인 
	public Video getVideoReturnName(String name) {

		for(int i = 0 ; i < unavailableVideoList.size() ; i++) {
			if(unavailableVideoList.get(i).getMovieName().equals(name)) {
				return unavailableVideoList.get(i);
			}
		}
		return null;
	}
}

