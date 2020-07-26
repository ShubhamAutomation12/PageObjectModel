package com.crm.qa.utils;

import java.util.ArrayList;

public class ReadDealTestData {

	static Xls_Reader reader;

	public static ArrayList<Object[]> getTestData(){
		ArrayList<Object[]> ar = new ArrayList<Object[]>();
		
		try{
			reader = new Xls_Reader("//E:\\Testing\\crmtest\\src\\main\\java\\com\\crm\\qa\\TestData\\DealTestData.xlsx");
			
				}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		for(int rowNum = 2; rowNum <= reader.getRowCount("DealData"); rowNum++)
		{
		
			String title = reader.getCellData("DealData", "Title", rowNum);
			String company = reader.getCellData("DealData", "Company", rowNum);
			
			ar.add(new Object[]{title,company});
		}	
		
						
		return ar;
		
		
		
		
	}

}
