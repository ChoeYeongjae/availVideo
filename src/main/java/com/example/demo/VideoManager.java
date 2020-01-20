package com.example.demo;

import java.util.ArrayList;

public class VideoManager {
	
	// 비디오 대여 리스트 클래스
	ArrayList<Video> availableVideoList = new ArrayList<Video>(); 
	
	// 비디오 반납 리스트 클래스
	
	ArrayList<Video> unavailableVideoList = new ArrayList<Video>();

	
	public VideoManager () {
		
		// 비디오 대여 리스트 객체
		
		/*video_possibility_list.add(new Video("최영재영화1", "2020", "최영재", "호러"));	
		video_possibility_list.add(new Video("최영재영화1", "2020", "최영재", "호러"));	
		*/
		// 비디오 대여 불가 객체
		
		/*video_wrong_list.add(new Video("최영재영화2", "2020", "최영재", "호러"));	
		video_wrong_list.add(new Video("최영재영화2", "2020", "최영재", "호러"));	*/
	}
	
	// 비디오 대여 
	public void rentVideo(String vidoe_name) {
		for(int i = 0 ; i < availableVideoList.size() ; i++) {
			if(availableVideoList.get(i).equals(vidoe_name)) {
				availableVideoList.add(availableVideoList.get(i));
				availableVideoList.remove(availableVideoList.get(i));
			}
		}
	}
	
	// 비디오 반납 
	public void returnVideo(String vidoe_name) {
		for(int i = 0 ; i < unavailableVideoList.size() ; i++) {
			if(unavailableVideoList.get(i).equals(vidoe_name)) {
				availableVideoList.add(unavailableVideoList.get(i));
				unavailableVideoList.remove(unavailableVideoList.get(i));
			}
		}	
	}
	
}
