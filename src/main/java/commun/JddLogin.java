package main.java.commun;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class JddLogin {

    @DataProvider(name = "excelData")
    public Object[][] excelDataProvider() throws IOException {

        String excelpath = "src/test.xlsx";
        FileInputStream inputstream = new FileInputStream(excelpath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
        XSSFSheet sheet = workbook.getSheet("Feuil1");

        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount][2];
        for (int i = 0; i < rowCount; i++) {
            XSSFRow row = sheet.getRow(i);
            XSSFCell username = row.getCell(0);
            if (username == null) data[i][0] = "";
            else {
                username.setCellType(CellType.STRING);
                data[i][0] = username.getStringCellValue();
            }
            XSSFCell password = row.getCell(1);
            if (password == null) data[i][1] = "";
            else {
                password.setCellType(CellType.STRING);
                data[i][1] = password.getStringCellValue();
            }
        }
        return data;

    }

    public static void main(String[] args) throws IOException {

        JddLogin exp = new JddLogin();
        exp.excelDataProvider();


    }
}