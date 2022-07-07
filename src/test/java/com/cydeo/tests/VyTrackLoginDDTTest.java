package com.cydeo.tests;

import com.cydeo.pages.VyTrackDashboardPage;
import com.cydeo.pages.VyTrackLogInPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class VyTrackLoginDDTTest {

    VyTrackLogInPage loginPage = new VyTrackLogInPage();
    VyTrackDashboardPage dashboardPage = new VyTrackDashboardPage();

    @Before
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
    }

    @After
    public void tearDown(){
        Driver.getDriver();
    }

    @Test
    public void logInDDTTest() throws IOException {
        String path = "VyTrackQa2Users.xlsx";
        FileInputStream in = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        XSSFSheet sheet = workbook.getSheet("sheet1");

        for(int i =1; i<=sheet.getLastRowNum(); i++){
            String username = sheet.getRow(i).getCell(0).toString();
            String password = sheet.getRow(i).getCell(1).toString();
            String firstname = sheet.getRow(i).getCell(2).toString();
            String lastName = sheet.getRow(i).getCell(3).toString();

            loginPage.login(username, password);

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 50);
            WebElement loaderMask = Driver.getDriver().findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));

            String actualFullname = dashboardPage.fullName.getText();

            XSSFCell Result = sheet.getRow(i).getCell(4);

            if(actualFullname.contains(firstname) && actualFullname.contains(lastName)){
                System.out.println("pass");
                Result.setCellValue("PASS");
            } else {
                System.out.println("fail");
                Result.setCellValue("FAIL");
            }

            dashboardPage.logout();
        }

        FileOutputStream out = new FileOutputStream(path);
        workbook.write(out);

        in.close();
        out.close();
        workbook.close();




    }
}
