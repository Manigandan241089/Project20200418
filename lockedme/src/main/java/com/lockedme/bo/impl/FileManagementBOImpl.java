package com.lockedme.bo.impl;

import java.util.List;

import com.lockedme.bo.FileManagementBOInterface;
import com.lockedme.doa.FileManagementDOA;
import com.lockedme.doa.impl.FileManagementDOAImp;
import com.lockedme.exception.BusinessException;
import com.lockedme.model.FileManagement;


public class FileManagementBOImpl implements FileManagementBOInterface{

	private FileManagementDOA doa;
	public FileManagementDOA getDoa(){
		if(doa==null){
			doa=new FileManagementDOAImp();
		}
		return doa;
		
	}
	@Override
	public List<String> retriveAllFileName() throws BusinessException {
		// TODO Auto-generated method stub
		return getDoa().retriveAllFileName();
		
	}
	
	private boolean isValidFilename(String fileName){
		if(fileName.matches("[a-zA-Z]{1}[a-zA-Z0-9]{0,}\\.[a-zA-Z]{3}")){
			return true;
		}
		return false;
		
	}

	@Override
	public FileManagement addFileName(String fileName) throws BusinessException {
		// TODO Auto-generated method stub
		FileManagement fm=null;
		if(!isValidFilename(fileName)){
			throw new BusinessException("Please enter correct file name to add to directory");
		}
			fm=getDoa().addFileName(fileName);
			return fm;
	}

	@Override
	public boolean deleteFileName(String fileName) throws BusinessException {
		// TODO Auto-generated method stub
		if(!isValidFilename(fileName)){
			throw new BusinessException("Please enter correct file name to delete from directory");
		}
		if(getDoa().deleteFileName(fileName)){
			return true;
		}
		return false;
	}

	@Override
	public boolean searchFileName(String fileName) throws BusinessException {
		// TODO Auto-generated method stub
		if(!isValidFilename(fileName)){
			throw new BusinessException("Please enter correct file name to search from directory");
		}
		if(!getDoa().searchFileName(fileName)){
			throw new BusinessException("Entered file "+ fileName + " does not exist");
		} 
			return true;
		
	}

}
