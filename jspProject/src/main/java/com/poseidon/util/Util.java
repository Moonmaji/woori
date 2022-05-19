package com.poseidon.util;

public class Util {
	public static boolean str2Int(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	//12a3 -> 123
	

	
}
