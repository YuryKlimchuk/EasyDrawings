package com.hydroyura.EasyDrawings.vzk;

public class Vzk {
	
	
	private int id;
	private String number;
	private String name;
	
	
	private int countsInAsm;
	
	
	public int getCountsInAsm() {
		return countsInAsm;
	}
	
	public void setCountsInAsm(int countsInAsm) {
		this.countsInAsm = countsInAsm;
	}

	public Vzk() {}

	public int getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
