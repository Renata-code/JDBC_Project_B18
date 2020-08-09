package com.cybertek.utility;

import java.sql.*;
import java.util.*;

public class DB_Utility {

    //adding static field so we can access in all static methods
    private static  Connection conn;
    private static ResultSet rs;
    private static Statement stmnt;

    public static Map<String,String> getRowMap( int rowNum ){

        Map<String,String> rowMap = new LinkedHashMap<>();//HashMap<>();
        try{
            rs.absolute(rowNum);

            ResultSetMetaData rsmd = rs.getMetaData();
            for (int colNum = 1; colNum <= getColumnCNT() ; colNum++) {
                String colName = rsmd.getColumnName( colNum );
                String colValue= rs.getString( colNum ) ;
                rowMap.put(colName, colValue);
            }
            rs.beforeFirst();
        }catch (SQLException e){
            System.out.println("ERRROR AT ROW MAP FUNCTION");
        }

        return rowMap;
    }

    /**
     *
     * @return The entire resultset as List of Row Map
     */
    public static List<Map<String,String> > getAllDataAsListOfMap(){
        // each row is represented as a map
        // and we want to get List of each row data as map
        // so the data type of my List is Map -->> since map has key and value data type
        // it becomes List< Map<String,String> >
        List<Map<String,String> > rowMapList = new ArrayList<>();
        // we can get one rowMap using getRowMap(i) methods
        // so we can iterate over each row and get Map object and put it into the List
        for (int i = 1; i <= getRowCount(); i++) {
            rowMapList.add(   getRowMap(i)    ) ;
        }
        return rowMapList ;
    }



    public static  List<String>getColumnDataAsList(String columnName){
        List<String> columnDataList = new ArrayList<>();
        try {
            rs.beforeFirst();//moving the cursor to before first location
            while(rs.next() ){
                String data =  rs.getString(columnName) ;
                columnDataList.add( data );
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
            rs.beforeFirst();// moving the cursor to before first location
            while(rs.next() ){
                String data =  rs.getString(columnIndex) ;
                // getting the data from that column and adding to the the list
                columnDataList.add( data  );

            }
            rs.beforeFirst();  // moving the cursor to before first location after we are done
        } catch (SQLException e) {
            System.out.println("Error while getColumnDataAsList");
            e.printStackTrace();
        }
        return columnDataList;
    }


    //getting single column cell value at certain row 2 column 3 --.the data
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
            for (int i = 1; i <=getColumnCNT() ; i++) {  //change i to colNum later if you have time
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
            rs.beforeFirst();

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



    public static void createConnection(){  //CREATE CONNECTION /////

        String connectionStr = ConfigurationReader.getProperty("database.url");
        String username = ConfigurationReader.getProperty("database.username");
        String password = ConfigurationReader.getProperty("database.password");
        try {
             conn = DriverManager.getConnection(connectionStr, username, password);
            System.out.println("Connection successful");
        } catch (SQLException e) {
            System.out.println("Connection has failed");
            e.printStackTrace();
        }
    }

    public static void createConnection(String env){
        // add validation to avoid invalid input
        // because we currently only have 2 env : test , dev
        // or add some condition for invalid env
        //  to directly get the information as database.url , database.username, database.password
        // without any env
        System.out.println("You are in "+env+" environment");
        String connectionStr = ConfigurationReader.getProperty(env + ".database.url");
        String username = ConfigurationReader.getProperty(env + ".database.username");
        String password = ConfigurationReader.getProperty(env + ".database.password");

        createConnection(connectionStr,username,password);


    }




    /**
     *  Overload createConnection method to accept url, username, password
     *     * so we can provide those information for different database
     * @param url  The connection String that used to connect to the database
     * @param username the username of database
     * @param password the password of database
     */

    public static void createConnection (String url,String username,String password){

        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful");
        } catch (SQLException e) {
            System.out.println("Connection has failed");
            e.printStackTrace();
        }

    }

    public static ResultSet runQuery(String query){
        /**
         * a static method to get the ResultSet object
         * with valid connection by executing query
         * @param query
         * @return ResultSet object that contain the result just in cases needed outside the class
         */
        try {
            Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs= stmnt.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //cleaning up the resources
    public static void destroy(){

        try{
            if(rs!=null){
                rs.close();
            }
            if(stmnt!=null){
                stmnt.close();
            }
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //a method to get the column count of the current ResultSet
    // getColumnCount()
    public static  int getColumnCNT(){

        int colCount = 0; ;
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            colCount = rsmd.getColumnCount();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR WHILE COUNTING THE COLUMNS");
        }
        return  colCount;
    }
}
