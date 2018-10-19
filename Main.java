package com.homework.filecopy2txt;

import java.io.*;


public class Main {

	public static void main(String[] args) {
		File source = null;
		File target = null;
		String ext = ".txt";
		String fileName = "a";
		FileCopyTo copy = new FileCopyTo();
		
		try {
			source= new File("src/com/homework/filecopy2txt/texts/");
			target = new File("src/com/homework/filecopy2txt/" + fileName + ext);
			System.out.println(copy.FileCopyToTarget(source, target, ext));
		} catch (IOException e) {
			System.out.println("File not found");
		}

	}

}
