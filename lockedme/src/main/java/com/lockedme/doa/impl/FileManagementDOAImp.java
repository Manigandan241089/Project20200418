package com.lockedme.doa.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.lockedme.doa.FileManagementDOA;
import com.lockedme.exception.BusinessException;
import com.lockedme.model.FileManagement;


public class FileManagementDOAImp implements FileManagementDOA{

	private static FileManagement fm = new FileManagement();
	private  String[] listFileName;

	
	@Override
	public List<String> retriveAllFileName() throws BusinessException {
		List<String> fn=new ArrayList<String>();
		String path = new File("").getAbsolutePath();
		File myFile = new File(path);
		listFileName=myFile.list();
		for(String lfn:listFileName){
			fn.add(lfn);	
		}
		return fn;
	}
	
	

	@Override
	public FileManagement addFileName(String fileName) throws BusinessException {
		// TODO Auto-generated method stub
		//FileManagement fm=null;
		String path = new File(fileName).getAbsolutePath();
		File myFile = new File(path);
		if(!myFile.exists()){
			try {
				myFile.createNewFile();
				fm.setFileName(fileName);
				return fm;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			throw new BusinessException("File already exist");
		}
		return fm;
		
	}

	@Override
	public boolean deleteFileName(String fileName) throws BusinessException {
		boolean fileExist=false;
		String path = new File(fileName).getAbsolutePath();
		File myFile = new File(path);
		if(myFile.delete()){ 
			fileExist=true;
			return fileExist;
		}
		throw new BusinessException("File name does not exist");	
	}

	@Override
	public boolean searchFileName(String fileName) throws BusinessException {
		// TODO Auto-generated method stub
		List<String> fn=new ArrayList<String>();
		boolean fileExist=false;
		String path = new File("").getAbsolutePath();
		File myFile = new File(path);
		listFileName=myFile.list();
		for(String lfn:listFileName){
			fn.add(lfn);	
		}
		Collections.sort(fn);
		if((Collections.binarySearch(fn,fileName))>=0)
		{
				fileExist=true;
		}
		return fileExist;
		
	}
}
