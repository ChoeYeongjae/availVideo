package com.example.demo;

import java.util.ArrayList;

public class VideoManger {
	
	// 비디오 대여 리스트 클래스
	ArrayList<Video> video_possibility_list = new ArrayList<Video>(); 
	
	// 비디오 반납 리스트 클래스
	
	ArrayList<Video> video_wrong_list = new ArrayList<Video>();

	
	public VideoManger () {
		
		// 비디오 대여 리스트 객체
		
		/*video_possibility_list.add(new Video("최영재영화1", "2020", "최영재", "호러"));	
		video_possibility_list.add(new Video("최영재영화1", "2020", "최영재", "호러"));	
		*/
		// 비디오 대여 불가 객체
		
		/*video_wrong_list.add(new Video("최영재영화2", "2020", "최영재", "호러"));	
		video_wrong_list.add(new Video("최영재영화2", "2020", "최영재", "호러"));	*/
	}
	
	// 비디오 대여 
	public void video_possibility(String vidoe_name) {
		for(int i = 0 ; i < video_possibility_list.size() ; i++) {
			if(video_possibility_list.get(i).equals(vidoe_name)) {
				video_wrong_list.add(video_possibility_list.get(i));
				video_possibility_list.remove(video_possibility_list.get(i));
			}
		}
	}
	
	// 비디오 반납 
	public void video_wrong(String vidoe_name) {
		for(int i = 0 ; i < video_wrong_list.size() ; i++) {
			if(video_wrong_list.get(i).equals(vidoe_name)) {
				video_possibility_list.add(video_wrong_list.get(i));
				video_wrong_list.remove(video_wrong_list.get(i));
			}
		}	
	}
	
}

