package com.lockedme.model;


public class FileManagement {
	private String fileName;
	

	public FileManagement() {
		super();
	}

	@Override
	public String toString() {
		return "FileManagement [fileName=" + fileName +  "]";
	}

	public FileManagement(String fileName) {
		super();
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
