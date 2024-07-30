package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadData {

    static String testDataDir = System.getProperty("user.dir") + "/src/test/java/TestData/TestData.xlsx";
    @Test
    public void test(){
        System.out.println(testDataDir);
    }
    static FileInputStream fileInputStream;

    static {
        try {
            fileInputStream = new FileInputStream(testDataDir);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static XSSFWorkbook workbook;

    static {
        try {
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public ReadData() throws IOException {
    }

    static XSSFSheet sheet =workbook.getSheet("Login Details");

    public static String username =sheet.getRow(1).getCell(0).getStringCellValue();
    public static String password =sheet.getRow(1).getCell(1).getStringCellValue();
    @Test
    public void test1 (){
        System.out.println(username);
        System.out.println(password);
    }

}
