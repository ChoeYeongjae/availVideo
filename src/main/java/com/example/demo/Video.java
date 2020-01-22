package com.example.demo;

public class Video {
	String movie_name; // 영화이름
	String production_year; // 제작연도
	String superVision; // 감독
	String genre; // 장르
	
	// 생성자 - 처음에 값을 초기화 해줌
	
	public Video(String movie_name, String production_year, String superVision, String genre) {
		this.movie_name = movie_name;
		this.production_year = production_year;
		this.superVision = superVision;
		this.genre = genre;
	}
	

	// 값을 얻어와서 리턴해주는 메소드 
	
	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public String getProduction_year() {
		return production_year;
	}

	public void setProduction_year(String production_year) {
		this.production_year = production_year;
	}

	public String getSuperVision() {
		return superVision;
	}

	public void setSuperVision(String superVision) {
		this.superVision = superVision;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getVideoList() {
		return this.getMovie_name() + "," +  this.getProduction_year() + "," 
				+ this.getSuperVision() + "," + this.getGenre();
	}
	
}
