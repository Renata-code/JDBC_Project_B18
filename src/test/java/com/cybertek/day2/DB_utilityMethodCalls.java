package com.cybertek.day2;

public class DB_utilityMethodCalls {

    public static void main(String[] args) {

        DB_Utility.createConnection();
        DB_Utility.runQuery("select*from jobs");

        //System.out.println("column count is "+ DB_Utility.getColumnCNT());
       // System.out.println("row count is "+ DB_Utility.getRowCount());

      //  System.out.println("Getting 3d row of Jobs Table \n "+DB_Utility.getRowDataAsList(3));

        //System.out.println("Getting 2d row of Jobs Table \n "+DB_Utility.getColumnDataAsList(2));


    }
}
