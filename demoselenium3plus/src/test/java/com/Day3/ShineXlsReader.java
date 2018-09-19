package com.Day3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ShineXlsReader {
	
	public static String filename = System.getProperty("user.dir") + "\\src\\config\\testcases\\TestData.xlsx";
	  public String path;
	  public FileInputStream fis = null;
	  public FileOutputStream fileOut = null;
	  private XSSFWorkbook workbook = null;
	  private XSSFSheet sheet = null;
	  private XSSFRow row = null;
	  private XSSFCell cell = null;
	  
	  public ShineXlsReader(String path)
	  {
	    this.path = path;
	    try
	    {
	      this.fis = new FileInputStream(path);
	      this.workbook = new XSSFWorkbook(this.fis);
	      this.sheet = this.workbook.getSheetAt(0);
	      this.fis.close();
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }
	  }
	  
	  public int getRowCount(String sheetName)
	  {
	    int index = this.workbook.getSheetIndex(sheetName);
	    if (index == -1) {
	      return 0;
	    }
	    this.sheet = this.workbook.getSheetAt(index);
	    int number = this.sheet.getLastRowNum() + 1;
	    return number;
	  }
	  
	  public String getCellData(String sheetName, String colName, int rowNum)
	  {
	    try
	    {
	      if (rowNum <= 0) {
	        return "";
	      }
	      int index = this.workbook.getSheetIndex(sheetName);
	      int col_Num = -1;
	      if (index == -1) {
	        return "";
	      }
	      this.sheet = this.workbook.getSheetAt(index);
	      this.row = this.sheet.getRow(0);
	      for (int i = 0; i < this.row.getLastCellNum(); i++) {
	        if (this.row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
	          col_Num = i;
	        }
	      }
	      if (col_Num == -1) {
	        return "";
	      }
	      this.sheet = this.workbook.getSheetAt(index);
	      this.row = this.sheet.getRow(rowNum - 1);
	      if (this.row == null) {
	        return "";
	      }
	      this.cell = this.row.getCell(col_Num);
	      if (this.cell == null) {
	        return "";
	      }
	      if (this.cell.getCellType() == 1) {
	        return this.cell.getStringCellValue();
	      }
	      if ((this.cell.getCellType() == 0) || (this.cell.getCellType() == 2))
	      {
	        String cellText = String.valueOf(this.cell.getNumericCellValue());
	        Calendar cal = null;
	        if (HSSFDateUtil.isCellDateFormatted(this.cell))
	        {
	          double d = this.cell.getNumericCellValue();
	          
	          cal = Calendar.getInstance();
	          cal.setTime(HSSFDateUtil.getJavaDate(d));
	          cellText = 
	            String.valueOf(cal.get(1)).substring(2);
	        }
	        return 
	        
	          cal.get(5) + "/" + cal.get(2) + 1 + "/" + cellText;
	      }
	      if (this.cell.getCellType() == 3) {
	        return "";
	      }
	      return String.valueOf(this.cell.getBooleanCellValue());
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }
	    return "row " + rowNum + " or column " + colName + " does not exist in xls";
	  }
	  
	  public String getCellData(String sheetName, int colNum, int rowNum)
	  {
	    try
	    {
	      if (rowNum <= 0) {
	        return "";
	      }
	      int index = this.workbook.getSheetIndex(sheetName);
	      if (index == -1) {
	        return "";
	      }
	      this.sheet = this.workbook.getSheetAt(index);
	      this.row = this.sheet.getRow(rowNum - 1);
	      if (this.row == null) {
	        return "";
	      }
	      this.cell = this.row.getCell(colNum);
	      if (this.cell == null) {
	        return "";
	      }
	      if (this.cell.getCellType() == 1) {
	        return this.cell.getStringCellValue();
	      }
	      if ((this.cell.getCellType() == 0) || (this.cell.getCellType() == 2))
	      {
	        String cellText = String.valueOf(this.cell.getNumericCellValue());
	        Calendar cal = null;
	        if (HSSFDateUtil.isCellDateFormatted(this.cell))
	        {
	          double d = this.cell.getNumericCellValue();
	          
	          cal = Calendar.getInstance();
	          cal.setTime(HSSFDateUtil.getJavaDate(d));
	          cellText = 
	            String.valueOf(cal.get(1)).substring(2);
	        }
	        return 
	        
	          cal.get(2) + 1 + "/" + cal.get(5) + "/" + cellText;
	      }
	      if (this.cell.getCellType() == 3) {
	        return "";
	      }
	      return String.valueOf(this.cell.getBooleanCellValue());
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }
	    return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
	  }
	  
	  public boolean setCellData(String sheetName, String colName, int rowNum, String data)
	  {
	    try
	    {
	      this.fis = new FileInputStream(this.path);
	      this.workbook = new XSSFWorkbook(this.fis);
	      if (rowNum <= 0) {
	        return false;
	      }
	      int index = this.workbook.getSheetIndex(sheetName);
	      int colNum = -1;
	      if (index == -1) {
	        return false;
	      }
	      this.sheet = this.workbook.getSheetAt(index);
	      
	      this.row = this.sheet.getRow(0);
	      for (int i = 0; i < this.row.getLastCellNum(); i++) {
	        if (this.row.getCell(i).getStringCellValue().trim().equals(colName)) {
	          colNum = i;
	        }
	      }
	      if (colNum == -1) {
	        return false;
	      }
	      this.sheet.autoSizeColumn(colNum);
	      this.row = this.sheet.getRow(rowNum - 1);
	      if (this.row == null) {
	        this.row = this.sheet.createRow(rowNum - 1);
	      }
	      this.cell = this.row.getCell(colNum);
	      if (this.cell == null) {
	        this.cell = this.row.createCell(colNum);
	      }
	      this.cell.setCellValue(data);
	      
	      this.fileOut = new FileOutputStream(this.path);
	      
	      this.workbook.write(this.fileOut);
	      
	      this.fileOut.close();
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      return false;
	    }
	    return true;
	  }
	  
	  public boolean setCellData(String sheetName, String colName, int rowNum, String data, String url)
	  {
	    try
	    {
	      this.fis = new FileInputStream(this.path);
	      this.workbook = new XSSFWorkbook(this.fis);
	      if (rowNum <= 0) {
	        return false;
	      }
	      int index = this.workbook.getSheetIndex(sheetName);
	      int colNum = -1;
	      if (index == -1) {
	        return false;
	      }
	      this.sheet = this.workbook.getSheetAt(index);
	      
	      this.row = this.sheet.getRow(0);
	      for (int i = 0; i < this.row.getLastCellNum(); i++) {
	        if (this.row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName)) {
	          colNum = i;
	        }
	      }
	      if (colNum == -1) {
	        return false;
	      }
	      this.sheet.autoSizeColumn(colNum);
	      this.row = this.sheet.getRow(rowNum - 1);
	      if (this.row == null) {
	        this.row = this.sheet.createRow(rowNum - 1);
	      }
	      this.cell = this.row.getCell(colNum);
	      if (this.cell == null) {
	        this.cell = this.row.createCell(colNum);
	      }
	      this.cell.setCellValue(data);
	      XSSFCreationHelper createHelper = this.workbook.getCreationHelper();
	      
	      CellStyle hlink_style = this.workbook.createCellStyle();
	      XSSFFont hlink_font = this.workbook.createFont();
	      hlink_font.setUnderline((byte)1);
	      hlink_font.setColor(IndexedColors.BLUE.getIndex());
	      hlink_style.setFont(hlink_font);
	      
	      XSSFHyperlink link = createHelper.createHyperlink(4);
	      link.setAddress(url);
	      this.cell.setHyperlink(link);
	      this.cell.setCellStyle(hlink_style);
	      
	      this.fileOut = new FileOutputStream(this.path);
	      this.workbook.write(this.fileOut);
	      
	      this.fileOut.close();
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      return false;
	    }
	    return true;
	  }
	  
	  public boolean addSheet(String sheetname)
	  {
	    try
	    {
	      this.workbook.createSheet(sheetname);
	      FileOutputStream fileOut = new FileOutputStream(this.path);
	      this.workbook.write(fileOut);
	      fileOut.close();
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      return false;
	    }
	    FileOutputStream fileOut;
	    return true;
	  }
	  
	  public boolean removeSheet(String sheetName)
	  {
	    int index = this.workbook.getSheetIndex(sheetName);
	    if (index == -1) {
	      return false;
	    }
	    try
	    {
	      this.workbook.removeSheetAt(index);
	      FileOutputStream fileOut = new FileOutputStream(this.path);
	      this.workbook.write(fileOut);
	      fileOut.close();
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      return false;
	    }
	    FileOutputStream fileOut;
	    return true;
	  }
	  
	  public boolean addColumn(String sheetName, String colName)
	  {
	    try
	    {
	      this.fis = new FileInputStream(this.path);
	      this.workbook = new XSSFWorkbook(this.fis);
	      int index = this.workbook.getSheetIndex(sheetName);
	      if (index == -1) {
	        return false;
	      }
	      XSSFCellStyle style = this.workbook.createCellStyle();
	      style.setFillForegroundColor((short)55);
	      style.setFillPattern((short)1);
	      
	      this.sheet = this.workbook.getSheetAt(index);
	      
	      this.row = this.sheet.getRow(0);
	      if (this.row == null) {
	        this.row = this.sheet.createRow(0);
	      }
	      if (this.row.getLastCellNum() == -1) {
	        this.cell = this.row.createCell(0);
	      } else {
	        this.cell = this.row.createCell(this.row.getLastCellNum());
	      }
	      this.cell.setCellValue(colName);
	      this.cell.setCellStyle(style);
	      
	      this.fileOut = new FileOutputStream(this.path);
	      this.workbook.write(this.fileOut);
	      this.fileOut.close();
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      return false;
	    }
	    return true;
	  }
	  
	  public boolean removeColumn(String sheetName, int colNum)
	  {
	    try
	    {
	      if (!isSheetExist(sheetName)) {
	        return false;
	      }
	      this.fis = new FileInputStream(this.path);
	      this.workbook = new XSSFWorkbook(this.fis);
	      this.sheet = this.workbook.getSheet(sheetName);
	      XSSFCellStyle style = this.workbook.createCellStyle();
	      style.setFillForegroundColor((short)55);
	      XSSFCreationHelper createHelper = this.workbook.getCreationHelper();
	      style.setFillPattern((short)0);
	      for (int i = 0; i < getRowCount(sheetName); i++)
	      {
	        this.row = this.sheet.getRow(i);
	        if (this.row != null)
	        {
	          this.cell = this.row.getCell(colNum);
	          if (this.cell != null)
	          {
	            this.cell.setCellStyle(style);
	            this.row.removeCell(this.cell);
	          }
	        }
	      }
	      this.fileOut = new FileOutputStream(this.path);
	      this.workbook.write(this.fileOut);
	      this.fileOut.close();
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      return false;
	    }
	    return true;
	  }
	  
	  public boolean isSheetExist(String sheetName)
	  {
	    int index = this.workbook.getSheetIndex(sheetName);
	    if (index == -1)
	    {
	      index = this.workbook.getSheetIndex(sheetName.toUpperCase());
	      if (index == -1) {
	        return false;
	      }
	      return true;
	    }
	    return true;
	  }
	  
	  public int getColumnCount(String sheetName)
	  {
	    if (!isSheetExist(sheetName)) {
	      return -1;
	    }
	    this.sheet = this.workbook.getSheet(sheetName);
	    this.row = this.sheet.getRow(0);
	    if (this.row == null) {
	      return -1;
	    }
	    return this.row.getLastCellNum();
	  }
	  
	  public boolean addHyperLink(String sheetName, String screenShotColName, String testCaseName, int index, String url, String message)
	  {
	    url = url.replace('\\', '/');
	    if (!isSheetExist(sheetName)) {
	      return false;
	    }
	    this.sheet = this.workbook.getSheet(sheetName);
	    for (int i = 2; i <= getRowCount(sheetName); i++) {
	      if (getCellData(sheetName, 0, i).equalsIgnoreCase(testCaseName))
	      {
	        setCellData(sheetName, screenShotColName, i + index, message, url);
	        break;
	      }
	    }
	    return true;
	  }
	  
	  public int getCellRowNum(String sheetName, String colName, String cellValue)
	  {
	    for (int i = 2; i <= getRowCount(sheetName); i++) {
	      if (getCellData(sheetName, colName, i).equalsIgnoreCase(cellValue)) {
	        return i;
	      }
	    }
	    return -1;
	  }
	  
	  public static void main(String[] arg)
	    throws IOException
	  {
	    ShineXlsReader datatable = null;
	    
	    datatable = new ShineXlsReader("H:\\Student_Selenium_Workspaces\\Framework_Weekend\\src\\Framework_XL_Files\\Controller.xlsx");
	    for (int col = 0; col < datatable.getColumnCount("TC5"); col++) {
	      System.out.println(datatable.getCellData("TC5", col, 1));
	    }
	  }

}
