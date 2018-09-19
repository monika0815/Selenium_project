package com.Day3;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import xls.ShineXlsReader;

public class DataDrivenWithExcel {
	@Test(dataProvider="monika")
public void testcase(String cname,String cpass) {
System.out.println(cname+"============="+cpass);	
}
	@DataProvider(name="monika")
	public Object[][] getdata()
	{
		ShineXlsReader xls=new ShineXlsReader("C:\\Users\\a07208trng_b4a.04.28\\Desktop\\monika.xlsx");
		int rcount=xls.getRowCount("Sheet1");
		int ccount=xls.getColumnCount("Sheet1");
		Object[][] obj=new Object[rcount-1][ccount];
		for(int i=2;i<=rcount;i++)
		{
			for(int j=0;j<ccount;j++)
			{
				obj[i-2][j]=xls.getCellData("Sheet1",j,i);
			}
		}
		return obj;
	}
}
