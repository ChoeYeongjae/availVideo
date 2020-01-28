package com.example.demo;

public class Video {
	String movieName; // 영화이름
	String productionYear; // 제작연도
	String superVision; // 감독
	String genre; // 장르
	
	// 생성자 - 처음에 값을 초기화 해줌
	
	public Video(String movieName, String productionYear, String superVision, String genre) {
		this.movieName = movieName;
		this.productionYear = productionYear;
		this.superVision = superVision;
		this.genre = genre;
	}
	

	// 값을 얻어와서 리턴해주는 메소드 
	
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getProductionYear() {
		return productionYear;
	}

	public void setproductionYear(String productionYear) {
		this.productionYear = productionYear;
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
		return this.getMovieName() + "," +  this.getProductionYear() + "," 
				+ this.getSuperVision() + "," + this.getGenre();
	}
	
}
