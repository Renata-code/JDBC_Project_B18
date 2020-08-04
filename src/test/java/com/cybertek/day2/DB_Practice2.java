package com.cybertek.day2;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DB_Practice2 {

    public static void main(String[] args) throws SQLException {

        //print out all data from jobs table

        DB_Utility.createConnection();
        ResultSet rs = DB_Utility.runQuery("Select * from regions");

        DB_Utility.displayAllData();

        //move resulset cursor to second row
       // rs.absolute(2);

       // DB_Utility.displayAllData();

       // int colCount = DB_Utility.getColumnCNT();
        //while (rs.next() == true) { // row iteration
           // for (int i = 1; i <= colCount; i++) { // column iteration
            //    System.out.print(rs.getString(i) + "\t");
           // }
           // System.out.println(); /// adding a blank line for next line
        //}
        //DB_Utility.runQuery(("select * from employees where salary>19000"));
         DB_Utility.displayAllData();
        System.out.println(DB_Utility.getColumnDataAtRow(3,2));
        System.out.println(DB_Utility.getColumnDataAtRow(3,"region_name"));
        DB_Utility.runQuery("select * from employees");
        System.out.println(DB_Utility.getRowDataAsList(4));
        System.out.println(DB_Utility.getRowCount());

        System.out.println(DB_Utility.getColumnDataAsList(4));//need to check

        System.out.println(DB_Utility.getColumnDataAsList("first_name"));


    }

}