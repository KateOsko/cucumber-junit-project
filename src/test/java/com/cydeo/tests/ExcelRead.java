package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {

    @Test
    public void read_from_Excel_file() throws IOException {
        String path = "SampleData.xlsx";

        //read from excel we need to load it to FileInput Stream
        FileInputStream fileInputStream =new FileInputStream(path);

        //workbook>sheet>row>cell
        //<1> Crete workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        // <2> We need to get specific sheet from currently open workbook
        XSSFSheet sheet = workbook.getSheet("Employees");

        //<3> Select row and cell
        //Print out mary's cell
        //Indexes starts from 0
        System.out.println(sheet.getRow(1).getCell(0));

        //print out Dev
        System.out.println(sheet.getRow(3).getCell(2));

        //GetPhysicalNumberOfRows()
        //return the counts of used rows only
        //count from 1
        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println(usedRows);


        //getLastRowNum()
        //returns the number from top cell to bottom cell
        //it doesn't care of teh cell is empty or not
        int lastUsedRows = sheet.getLastRowNum();
        System.out.println(lastUsedRows);


        // TODO: Create a logic to print Vinod's name

        for(int rowNum=0; rowNum<usedRows; rowNum++){
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Vinop")){
                System.out.println(sheet.getRow(rowNum).getCell(0));
            }
        }

        //TODO: Create a logic to print out Linda's ID

        for(int rowNum=0; rowNum<usedRows; rowNum++){
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Linda")){
                System.out.println(sheet.getRow(rowNum).getCell(2));
            }
        }



    }

    
}
