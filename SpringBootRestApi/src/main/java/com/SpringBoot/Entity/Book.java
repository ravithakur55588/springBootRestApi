package com.SpringBoot.Entity;

public class Book {
	
	private int bid;
	private String bname;
	private String Bauthor;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bid, String bname, String bauthor) {
		super();
		this.bid = bid;
		this.bname = bname;
		Bauthor = bauthor;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBauthor() {
		return Bauthor;
	}

	public void setBauthor(String bauthor) {
		Bauthor = bauthor;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", Bauthor=" + Bauthor + "]";
	}
	
}
