package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
    private Workbook workbook;
    private Sheet sheet;
    private DataFormatter formatter = new DataFormatter();

    public void openExcel(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            workbook.close();
            fis.close();
        }
        System.out.println("Excel file opened successfully");
        System.out.println("Sheet: " + sheetName);
    }

    public String getCellData(int rowNumber, int columnNumber) {

        Row row = sheet.getRow(rowNumber);

        if (row == null) {
            return "";
        }

        Cell cell = row.getCell(columnNumber);

        if (cell == null) {
            return "";
        }

        return formatter.formatCellValue(cell);
    }

    public String getCellData(int rowNumber, String columnName) {
        int columnNumber = getColumnNumber(columnName);

        return getCellData(rowNumber, columnNumber);
    }

    private int getColumnNumber(String columnName) {

        Row headerRow = sheet.getRow(0);

        if (headerRow == null) {
            throw new IllegalArgumentException("Header row is empty");
        }

        for (Cell cell : headerRow) {

            String header = formatter.formatCellValue(cell);

            if (header.equalsIgnoreCase(columnName)) {
                return cell.getColumnIndex();
            }
        }

        throw new IllegalArgumentException(
                "Column not found: " + columnName);
    }


}
