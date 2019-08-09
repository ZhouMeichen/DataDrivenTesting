package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelHandler {
    String filename;
    String sheetName;
    ArrayList<ArrayList<String>> list;
    
    public ExcelHandler(String filename, String sheetName) {
        this.filename = filename;
        this.sheetName = sheetName;
        this.list = new ArrayList<ArrayList<String>>();
    }
    
    public ArrayList<ArrayList<String>> readData() {
         File file = new File(filename);
         FileInputStream fs = null;
        try {
            fs = new FileInputStream(file);
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
         XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(fs);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
        XSSFSheet sheet = wb.getSheet(sheetName);
        Iterator<Row> irt = sheet.iterator();

      while (irt.hasNext()) {
          Row currentRow = irt.next();
          Iterator<Cell> cellirt = currentRow.iterator();
          ArrayList<String> arr = new ArrayList<String>();
          
          while (cellirt.hasNext()) {
              
              Cell currentCell = cellirt.next();
              if (currentCell.getCellType() == CellType.STRING) {
                  arr.add(currentCell.getStringCellValue());
              }else if (currentCell.getCellType() == CellType.NUMERIC) {
                  arr.add(String.valueOf(currentCell.getNumericCellValue()));
              }
          }
          list.add(arr);
          
      }
      
      return list;

    }
    
    
}
