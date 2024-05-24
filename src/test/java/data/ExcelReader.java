package data;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    static FileInputStream fis = null;

    public FileInputStream getFileInputStream() throws FileNotFoundException {
        String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\DataFile.xlsx";
        File srcFile = new File(filePath);
        fis = new FileInputStream(srcFile);
        return fis;
    }

    public Object[][] getExcelData() throws IOException {
        fis = getFileInputStream();
        XSSFWorkbook wb = null;
        Object[][] arrayOfData = null;
        try {
            wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            int totalNumberOfRows = sheet.getPhysicalNumberOfRows();
            int totalNumberOfCols = 8;

            arrayOfData = new Object[totalNumberOfRows][totalNumberOfCols];

            for (int i = 0; i < totalNumberOfRows; i++) {
                XSSFRow row = sheet.getRow(i);
                if (row != null) {
                    for (int j = 0; j < totalNumberOfCols; j++) {
                        if (row.getCell(j) != null) {
                            CellType cellType = row.getCell(j).getCellType();
                            if (cellType == CellType.NUMERIC) {
                                double numericValue = row.getCell(j).getNumericCellValue();
                                long longValue = (long) numericValue;
                                arrayOfData[i][j] = String.valueOf(longValue);
                            } else {
                                arrayOfData[i][j] = row.getCell(j).toString();
                            }
                        } else {
                            arrayOfData[i][j] = "";
                        }
                    }
                }
            }
        } finally {
            if (wb != null) {
                wb.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return arrayOfData;
    }
}
