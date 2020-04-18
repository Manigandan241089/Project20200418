package com.lockedme.fileManagement.bo.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import com.lockedme.bo.FileManagementBOInterface;
import com.lockedme.bo.impl.FileManagementBOImpl;
import com.lockedme.exception.BusinessException;
import com.lockedme.model.FileManagement;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FileManagementBOTest {
	private static FileManagementBOInterface bo;
	
	@BeforeClass
	public static void preInitialization() {
		bo=new FileManagementBOImpl();
	}
	
	@Test
	public void test1AddFileName() {
		try {
			FileManagement fm=bo.addFileName("Testing.xml");
			assertEquals("Testing.xml", fm.getFileName());
		} catch (BusinessException e) {
			fail();
		}
	}
	
	@Test
	public void test2SearchFileName() {
		try {
			boolean isValid=bo.searchFileName("Testing.xml");
			assertEquals(true, isValid);
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	@Test
	public void test3DeleteFileName() {
		try {
			bo.deleteFileName("Testing.xml");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			fail();
		}
	
	} 
}
