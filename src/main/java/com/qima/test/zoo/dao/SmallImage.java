package com.qima.test.zoo.dao;

public class SmallImage {
	private String smallPath;
	private int x;
	private int y;
	private int h;
	
	public SmallImage(String smallPath, int x, int y, int h){
		this.smallPath = smallPath;
		this.h = h;
		this.x = x;
		this.y = y;
	}

	public String getSmallPath() {
		return smallPath;
	}

	public void setSmallPath(String smallPath) {
		this.smallPath = smallPath;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}
}