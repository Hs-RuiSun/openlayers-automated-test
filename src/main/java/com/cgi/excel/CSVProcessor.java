package com.cgi.excel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class CSVProcessor {
    public static final int COLUNM_NUM = 5;
    public static final String FINAL_REPORT_SHEET_NAME = "final report";

    /**
     * convert multiple csv files into one excel with multiple sheets that is to say, one csv file will be converted
     * into one sheet
     *
     * @param srcFileName
     * @param desFileName
     * @param header
     * @throws IOException
     */
    public void convertCSVsToExcel(String srcFileName, String desFileName, String[] header) throws IOException {
        File srcFile = new File(srcFileName);
        File[] allCSVFiles = srcFile.listFiles();

        HSSFWorkbook workbook = new HSSFWorkbook();

        // the final report sheet
        HSSFSheet finalReportSheet = workbook.createSheet(FINAL_REPORT_SHEET_NAME);

        // add header to final report
        Row headerRow = finalReportSheet.createRow(0);
        for (int cellIndex = 0; cellIndex < header.length; cellIndex++) {
            Cell cell = headerRow.createCell(cellIndex);
            cell.setCellValue(header[cellIndex]);
        }

        try {
            // for each csv file
            int sheetIndex = 1;
            for (File file : allCSVFiles) {
                HSSFSheet sheet = workbook.createSheet();

                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                int rowIndex = 0;
                String currentLine;

                while ((currentLine = bufferedReader.readLine()) != null) {
                    HSSFRow row = sheet.createRow(rowIndex++);
                    String cellValueArray[] = currentLine.split(",");
                    for (int cellIndex = 0; cellIndex < cellValueArray.length; cellIndex++) {
                        Cell cell = row.createCell(cellIndex);
                        switch (cellIndex) {
                            case 0:
                            case 1:
                            case 2:
                                cell.setCellValue(Integer.parseInt(cellValueArray[cellIndex]));
                                break;
                            case 3:
                            case 4:
                                cell.setCellValue(Double.parseDouble(cellValueArray[cellIndex]));
                                break;
                        }
                    }
                }

                int formulaIndex = sheet.getLastRowNum() + 1;

                /**
                 * in the final report sheet add a new row
                 */
                Row newRow = finalReportSheet.createRow(finalReportSheet.getLastRowNum() + 1);
                for (int i = 0; i < COLUNM_NUM; i++) {
                    Cell cell = newRow.createCell(i);
                    String columnName = org.apache.poi.ss.util.CellReference.convertNumToColString(i);
                    // AVERAGE('20180717-001608'!A1:A10)
                    String formula = "AVERAGE('Sheet" + sheetIndex + "'!" + columnName + 1 + ":" + columnName
                            + (formulaIndex - 1) + ")";
                    cell.setCellFormula(formula);
                }
                sheetIndex++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        FileOutputStream fileOut =
                new FileOutputStream(srcFile.getParentFile().getAbsolutePath() + File.separator + desFileName);
        workbook.write(fileOut);

        workbook.close();
        fileOut.close();
    }

}
