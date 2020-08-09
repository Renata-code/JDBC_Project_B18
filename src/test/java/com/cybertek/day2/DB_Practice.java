package com.cybertek.day2;

import com.cybertek.utility.DB_Utility;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DB_Practice {

    public static void main(String[] args) throws SQLException {

        //print out all data from jobs table

        DB_Utility.createConnection();
        ResultSet rs = DB_Utility.runQuery("Select * from jobs");

        //iterate over the resultset

       // rs.next();
       // System.out.println(rs.getString(1));
        //rs.next();

        while(rs.next()){
            System.out.println(rs.getString(1));
        }

        ResultSetMetaData rsmd = rs.getMetaData();
        int colCount = rsmd.getColumnCount();
        System.out.println("colCount = " +DB_Utility.getColumnCNT());

        //print everything without knowing the column names

        //get the first data | without knowing the column name

        int colCount1 = DB_Utility.getColumnCNT();
        rs.first();
        for (int i = 1; i <=colCount1 ; i++) {
            System.out.print(rs.getString(i)+ "\t");

        }


    }
}
