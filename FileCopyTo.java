package com.homework.filecopy2txt;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileCopyTo {
	private File sourceDir;
	private File targetDir;
	private String ext;
	
	public FileCopyTo(File sourceDir, File targetDir, String ext) {
		super();
		this.sourceDir = sourceDir;
		this.targetDir = targetDir;
		this.ext = ext;
	}
	
	public File getSourceDir() {
		return sourceDir;
	}

	public void setSourceDir(File sourceDir) {
		this.sourceDir = sourceDir;
	}

	public File getTargetDir() {
		return targetDir;
	}

	public void setTargetDir(File targetDir) {
		this.targetDir = targetDir;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public FileCopyTo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Boolean FileCopyToTarget (File source, File target, String ext) throws IOException {
		List<String> check = new ArrayList<String>();
		List<String> buf = new ArrayList<String>();
		File[] paths;
		FilenameFilter fileFilter = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				  if(name.lastIndexOf('.')>0) {
		               
		                 
	                  int lastIndex = name.lastIndexOf('.');
	                  
	                  
	                  String str = name.substring(lastIndex);
	                
	                  
	                  if(str.equals(ext)) {
	                     return true;
	                  }
	               }
	               
	               return false;
				
			}
		};
		paths = source.listFiles(fileFilter);
		FileWriter fileFinish = new FileWriter(target,false);
		
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
		return true;
		
	}

	@Override
	public String toString() {
		return "FileCopyTo [sourceDir=" + sourceDir + ", targetDir=" + targetDir + ", ext=" + ext + "]";
	}

}
