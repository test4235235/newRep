package utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MsExcelUtility {
  private XSSFSheet ExcelWSheet;

  //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
  public void setExcelFile(String Path,String SheetName) throws Exception {
      // Open the Excel file
      FileInputStream ExcelFile = new FileInputStream(Path);
      // Access the required test data sheet
      XSSFWorkbook ExcelWBook = new XSSFWorkbook(ExcelFile);
      ExcelWSheet = ExcelWBook.getSheet(SheetName);
  }

  //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
  public String getCellData(int RowNum, int ColNum){
    try{
      XSSFCell Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
      return Cell.getStringCellValue();
    }catch (Exception e){
      return "";
    }
  }
}
