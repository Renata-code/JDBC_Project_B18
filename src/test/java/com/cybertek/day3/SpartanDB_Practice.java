package com.cybertek.day3;
import com.cybertek.utility.DB_Utility;
import static com.cybertek.utility.DB_Utility.*;
public class SpartanDB_Practice {

    public static void main(String[] args) {

        //create package called utility and move it under that package
        //String url = "jdbc:oracle:thin:@54.236.52.149:1521:XE";

        DB_Utility.createConnection();

        // Run query "SELECT * FROM spartans"
        runQuery("select *from spartans");

        // 1. Display all data in console
        //displayAllData();

        //2. Print column count
       // System.out.println("column count is "+ getColumnCNT());

        //3. Print row count
        //System.out.println("row count is "+getRowCount());

        //4. Print out 3rd row data as a list
       // System.out.println("#rd row data as a list \n"+getRowDataAsList(3));

        //5. Print out 2nd column data as a list
       // System.out.println("2nd column as a list \n "+getColumnDataAsList(2));

        //6, Print out Name column data as a list
       // System.out.println("name column as a list \n "+getColumnDataAsList("name"));

        //7, Print out 4th row as a Map
       // System.out.println("4th row as a Map \n "+ getRowMap(4));

        //8, Print out the data at row 5, column 1
       // System.out.println("Data at row 5 column 1 : ---> "+getColumnDataAtRow(5,1));

        //9, Print out the data at row 53, phone column
       // System.out.println("Data at row 53 column : ---> "+getColumnDataAtRow(53,"Phone"));

        //10. Print out all the data as List of Map
        System.out.println(getAllDataAsListOfMap());

        createConnection("test");








    }


}
