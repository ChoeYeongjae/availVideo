package com.example.demo;

public class userVideoList {
	
	String userName;    // 유저 이름 
	String videoName;   // 비디오 이름 
	
	public userVideoList(String userName ,String videoName) {
		this.userName = userName;
		this.videoName =  videoName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	
	
	
}
