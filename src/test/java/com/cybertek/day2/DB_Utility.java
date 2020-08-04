package com.cybertek.day2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DB_Utility {

    //adding static field so we can access in all static methods
    private static  Connection conn;
    private static ResultSet rs;

    public static  List<String>getColumnDataAsList(String columnName){
        List<String> columnDataList = new ArrayList<>();
        try {
            while(rs.next() ){
                columnDataList.add(  rs.getString(columnName)  );
            }
            rs.beforeFirst();//moving to first just to make sure we are in first again
        } catch (SQLException throwables) {
            System.out.println("Error while getColumnDataAsList");
            throwables.printStackTrace();
        }
        return columnDataList;
    }



    public static  List<String>getColumnDataAsList(int columnIndex){
        List<String> columnDataList = new ArrayList<>();
        try {
            while(rs.next() ){
                columnDataList.add(  rs.getString(columnIndex)  );
            }
            rs.beforeFirst();//moving to first just to make sure we are in first again
        } catch (SQLException throwables) {
            System.out.println("Error while getColumnDataAsList");
            throwables.printStackTrace();
        }
        return columnDataList;
    }


    //getting single column cell valu at certain row 2 column 3 --.the data
    public static String getColumnDataAtRow(int rowNum,int columnIndex){//rownum get data from and ctr..
      String result ="";
        try {
            rs.absolute(rowNum);
            result= rs.getString(columnIndex);
        } catch (SQLException e) {
            System.out.println("Error while getColumnData");
            e.printStackTrace();
        }
        return result;
    }




    public static String getColumnDataAtRow(int rowNum,String columnName){//rownum get data from and ctr..
        String result ="";
        try {
            rs.absolute(rowNum);
            result= rs.getString(columnName);
        } catch (SQLException e) {
            System.out.println("Error while getColumnData");
            e.printStackTrace();
        }
        return result;
    }




    //getting the entire row as List<String>
    public static List<String>getRowDataAsList( int rowNum){

        List<String> rowDataList = new ArrayList<>();
        //move to that rownum
        try {
            rs.absolute(rowNum);
            //iterate over each and every column and add the value to the list
            for (int i = 1; i <=getColumnCNT() ; i++) {
                rowDataList.add( rs.getString(i));
            }
            //moving the cursor back to before first location just in case
            rs.beforeFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowDataList;
    }



    public  static int getRowCount(){
        int rowCount=0;
        try {
            rs.last();//move to last row
            rowCount=rs.getRow();//get the row number and assign it to rowCount
            //moving the cursor to before location just in case

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while get row count");
        }
        return rowCount;
    }




    //a method to display all the data in the result set
    // get the first row data  | without knowing the column names
    public static void displayAllData() {
        int colCount = DB_Utility.getColumnCNT();
        // in order to get whole result cursor must be at before first location !
        try { // in order to start from beginning , we should be at beforefirst location
            rs.beforeFirst();
            while (rs.next()) { // row iteration
                for (int i = 1; i <= colCount; i++) { // column iteration
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println(); /// adding a blank line for next line
                // now the cursor is at after last location
                // move it back to before first location so we can have no issue calling the method again
            }
            rs.beforeFirst();
        }catch(SQLException e){
            System.out.println("Error while getting all data");
            e.printStackTrace();
        }
        //now the cursor is at after last location
        //move it back to before first location so we can have no issue calling this method
    }



    public static void createConnection(){  //CREATE CONNECTION

        String connectionStr = "jdbc:oracle:thin:@54.236.52.149:1521:XE";
        String username = "hr";
        String password = "hr";
        try {
             conn = DriverManager.getConnection(connectionStr, username, password);
            System.out.println("Connection successful");
        } catch (SQLException e) {
            System.out.println("Connection has failed");
            e.printStackTrace();
        }
    }



    public static ResultSet runQuery(String query){

        try {
            Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs= stmnt.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }





    //a method to get the column count of the current ResultSet
    // getColumnCount()
    public static  int getColumnCNT(){

        int colCount = 0; ;

        ResultSetMetaData rsmd = null;
        try {
            rsmd = rs.getMetaData();
             colCount = rsmd.getColumnCount();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR WHILE COUNTING THE COLUMNS");
        }

        return  colCount;
    }


}
