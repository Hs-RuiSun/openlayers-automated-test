package com.cgi.test.excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {
    public static void readFromExcel() throws IOException, InvalidFormatException {
        FileInputStream fis = new FileInputStream("path of excel file");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet s = wb.getSheet("sheetName");
        String value = s.getRow(1).getCell(1).getStringCellValue();
    }
}
