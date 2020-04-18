package com.lockedme.doa;

import java.util.List;

import com.lockedme.exception.BusinessException;
import com.lockedme.model.FileManagement;

public interface FileManagementDOA {
	List<String> retriveAllFileName() throws BusinessException;
	FileManagement addFileName(String fileName) throws BusinessException;
	boolean deleteFileName(String fileName) throws BusinessException;
	boolean searchFileName(String fileName) throws BusinessException;
}
