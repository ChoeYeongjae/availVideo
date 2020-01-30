package com.example.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map.Entry;

public class UserVideoList {
	// key : value 값으로 데이터를 저장한다.
	private HashMap<String, String> rentList = new HashMap<String, String>();

	public static String userFilePath = "src/main/java/com/example/demo/유저대여목록.txt";

	public HashMap<String, String> getRentList() {
		return rentList;
	}

	public void setRentList(HashMap<String, String> rentList) {
		this.rentList = rentList;
	}

	public void rent(String name, String title) {
		rentList.put(name, title);
	}

	public void rentRemove(String name, String title) {
		rentList.remove(name,title);
	}
	
	public String rentList(String name) {
		return rentList.get(name);
	}
	
	public void saveFile() {

		// TODO: 대여 목록 저장 

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(userFilePath));
			for (String key : rentList.keySet() ) {
				writer.write(key+","+rentList.get(key)+"\n");
			}
			writer.close();
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void loadFile() {

		try {
			File file = new File(userFilePath);
			BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			String line = "";

			while ((line = bufReader.readLine()) != null) {
				String[] strArr = line.split(",");
				rentList.put(strArr[0], strArr[1]);
			}
			bufReader.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			System.out.println(e);
		}

	}
}
