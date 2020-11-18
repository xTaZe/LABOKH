package com.fr.adaming.jsfapp.util;

public class Test {

	public static void main(String[] args) {
		String input = "01001001001000000100110001001111010101100100010100100000010110010100111101010101";
		String output = "";
		for (int i = 0; i <= input.length() - 8; i += 8) {
			int k = Integer.parseInt(input.substring(i, i + 8), 2);
			output += (char) k;
		}
		System.out.println(output);
	}
}
