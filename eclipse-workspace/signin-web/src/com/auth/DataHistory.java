package com.auth;

import java.sql.Timestamp;

//POJO - Plain Old Java Object
public class DataHistory {
	private int num1;
	private int num2;
	private int total;
	private Timestamp timestamp;

	public DataHistory(int num1, int num2, int total, Timestamp timestamp) {
		this.num1 = num1;
		this.num2 = num2;
		this.total = total;
		this.timestamp = timestamp;
	}

	public int getNum1() {
		return num1;
	}

	public int getNum2() {
		return num2;
	}

	public int getTotal() {
		return total;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

}
