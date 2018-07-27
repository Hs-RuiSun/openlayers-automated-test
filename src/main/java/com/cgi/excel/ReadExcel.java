package com.cgi.excel;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.JOptionPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Used to read excel sheets
 *
 */
public class ReadExcel {
    private static final Logger logger = Logger.getLogger(ReadExcel.class);

    private static String testSuiteFile;
    static {
        testSuiteFile = JOptionPane.showInputDialog("Test File Name: ");
    }

    private Collection<Object[]> data = null;

    /**
     * Constructs a collection based on sheet in an excel workbook
     *
     * @param sheetName
     *            Name of the excel sheet.
     */
    public ReadExcel(String sheetName) {
        data = parse(sheetName);
    }

    /*
     * This method finds the first empty cell and through this it determines how many columns it should expect.
     */
    private int firstEmptyCellPosition(Sheet firstSheet) {
        int columnCount = 0;
        Row firstRow = firstSheet.getRow(0);
        for (Cell cell : firstRow) {
            if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                break;
            }
            columnCount++;
        }
        return columnCount;
    }

    /**
     *
     * @return collection of data in an excel workbook sheet
     */
    public Collection<Object[]> getData() {
        return data;
    }

    private Collection<Object[]> parse(String sheetName) {
        String excelFilePath = "Test Cases//";
        FileInputStream inputStream = null;
        List<Object[]> ret = new ArrayList<>();
        Workbook workbook = null;

        try {
            inputStream = new FileInputStream(excelFilePath + testSuiteFile + ".xlsx");
            workbook = new XSSFWorkbook(inputStream);
        }catch (FileNotFoundException e) {
            logger.error("Excel file not found.");
        }catch (IOException e) {
            logger.error("Can not read excel file.");
        }

        Sheet sheet = workbook.getSheet(sheetName);

        List<Object> rowData = new ArrayList<>();
        int numberOfColumns = firstEmptyCellPosition(sheet);
        int columnsAdded = 0;

        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            for (int cn = 0; cn < numberOfColumns; cn++) {
                Cell cell = nextRow.getCell(cn, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                if (cell == null) {
                    rowData.add(" ");
                    columnsAdded++;
                }
                else {
                    switch (cell.getCellTypeEnum()) {
                        case STRING :
                            rowData.add(cell.getStringCellValue());
                            columnsAdded++;
                            break;
                        case BOOLEAN :
                            rowData.add(String.valueOf(cell.getBooleanCellValue()));
                            columnsAdded++;
                            break;
                        case NUMERIC :
                            rowData.add(String.valueOf((cell.getNumericCellValue())));
                            columnsAdded++;
                            break;
                        case BLANK :
                            rowData.add(" ");
                            columnsAdded++;
                            break;
                        case FORMULA :
                            break;
                        default :
                            ;
                    }
                }
                // If the column count equals the expected columns then go to the next row.
                if (columnsAdded == numberOfColumns) {
                    ret.add(rowData.toArray());
                    rowData.clear();
                    columnsAdded = 0;
                }
            }
            // After we're done with the data then close the book.
            try {
                workbook.close();
                inputStream.close();
            }
            catch (IOException e) {
                logger.error("Error closing workbook.");
            }
        }
        return ret;
    }
}
