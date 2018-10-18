package com.homework.filecopy2txt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		File file = null;
		File[] paths;
		
		FilenameFilter fileFilter = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				  if(name.lastIndexOf('.')>0) {
		               
		                 
	                  int lastIndex = name.lastIndexOf('.');
	                  
	                  
	                  String str = name.substring(lastIndex);
	                
	                  
	                  if(str.equals(".txt")) {
	                     return true;
	                  }
	               }
	               
	               return false;
				
			}
		};
		try {

			List<String> check = new ArrayList<String>();
			List<String> buf = new ArrayList<String>();
			file = new File("src/com/homework/filecopy2txt/texts/");
			paths = file.listFiles(fileFilter);
			
			FileWriter fileFinish = new FileWriter("src/com/homework/filecopy2txt/a.txt",false);
			
			for (File path : paths) {
				List<String> tmp = new ArrayList<String>();
				
				FileReader fileOne = new FileReader(path);

				Scanner scan = new Scanner(fileOne);
				

				
				while (scan.hasNextLine()) {
					String nextLine = scan.nextLine();
					String[] str = nextLine.split(" ");
					for (int i = 0; i < str.length;i++) {
						tmp.add(str[i]);
					}
				}
				scan.close();
				if (buf.isEmpty()) {
					for (int i = 0; i < tmp.size();i++) {	
							buf.add(tmp.get(i));
					}
				} else {
					for (String stringOne : buf) {
						for (String stringTwo : tmp) {
							if (stringOne.equals(stringTwo)) {
								if (!check.contains(stringOne))
								check.add(stringOne);
							}
						}
					}
				}
				
			}
			for (String string : check) {
				fileFinish.write(string + " ");
			}
			fileFinish.flush();
			fileFinish.close();
		} catch (IOException e) {
			System.out.println("File not found");
		}

	}

}
