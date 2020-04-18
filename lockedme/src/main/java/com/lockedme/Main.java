package com.lockedme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lockedme.bo.FileManagementBOInterface;
import com.lockedme.bo.impl.FileManagementBOImpl;
import com.lockedme.exception.BusinessException;
import com.lockedme.model.FileManagement;

public class Main {
	static  Scanner scanner=new Scanner(System.in); 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileManagementBOInterface bo=new FileManagementBOImpl();
		FileManagement file=new FileManagement();
		List<String> list=new ArrayList();
		System.out.println("File Management system [LockedMe.com]");
		System.out.println("Developed by Manigandan");
		int ch=0;
		do{
			System.out.println("1) List the file present in the directory");
			System.out.println("2) File Management action[Create,delete,search]");
			System.out.println("3) close the application");
			
			try{
				ch=Integer.parseInt(scanner.nextLine());
				switch(ch){
				case 1:
					try {
						list=bo.retriveAllFileName();
						for(String l:list){
							System.out.println(l);
						}
					} catch (BusinessException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					fileManagementActivity(bo,file);
					break;
				case 3:
					System.out.println("Thanks for using File Mangement System");
					break;
				default:
				System.out.println("Please enter the choice between 1-3");
				break;
				}
			}
			catch(NumberFormatException e){
				System.out.println("Please enter the numerical option [1-3]");
			}
		}while(ch!=3);

	}
	
	public static void fileManagementActivity(FileManagementBOInterface bo,	FileManagement file){
		System.out.println("Enter the file Mangement Choice");
		int ch=0;
		do{
			System.out.println("1) Add the file");
			System.out.println("2) Delete the file");
			System.out.println("3) Search the file");
			System.out.println("4) Go to Main Menu");
			
			try{
				ch=Integer.parseInt(scanner.nextLine());
				switch(ch){
				case 1:
					System.out.println("Enter Filename to be added");
					try {
						file=bo.addFileName(scanner.nextLine());
						System.out.println("File "+file.getFileName()+ " added successfully in project root directory ");
					} catch (com.lockedme.exception.BusinessException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					break;
					
				case 2:
					System.out.println("Enter Filename to be deleted");
					try {
						String fn = scanner.nextLine();
						if(bo.deleteFileName(fn)){
							System.out.println("File name "+fn+" deleted from  project root directory");
						}
					} catch (com.lockedme.exception.BusinessException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}					
					break;
				case 3:
					System.out.println("Enter Filename to be search");
					try {
						String fn = scanner.nextLine();
						if(bo.searchFileName(fn)){
							System.out.println("File name "+fn+" present in  project root directory");
						}
					} catch (com.lockedme.exception.BusinessException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}		
					break;
				default:
				System.out.println("Please enter the choice between 1-3");
				break;
					
				}
			}
			catch(NumberFormatException e){
				System.out.println("Please enter the numerical option [1-4]");
			}
		}while(ch!=4);
		
	}

}
