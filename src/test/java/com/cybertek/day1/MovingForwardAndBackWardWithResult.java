package com.cybertek.day1;

import java.sql.*;

public class MovingForwardAndBackWardWithResult {

    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@54.236.52.149:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        // if we create the Statement in this way , this will generate a forward only resultset
        // meaning we can only move forward with next() and can not move backward with previous
        //Statement stmnt = conn.createStatement();
        // ResultSet.TYPE_SCROLL_INSENSITIVE will make the resultset created from this statement
        // be able to move forward and backward ,
        // ResultSet.CONCUR_READ_ONLY  will make resultset readonly and that's what we need
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        //ResultSet rs   =   stmnt.executeQuery("SELECT * FROM COUNTRIES WHERE REGION_ID = 1") ;
        ResultSet rs = stmnt.executeQuery("select * from countries");

         rs.next();
        System.out.println(rs.getString("country_id")+" "+rs.getString("country_name"));

        rs.next();
        System.out.println(rs.getString("country_id")+" "+rs.getString("country_name"));

        rs.previous();
        //goes back to previous row
        System.out.println(rs.getString("country_id")+" "+rs.getString("country_name"));

        rs.last();//this will move the cursor to the last one
        System.out.println(rs.getString("country_id")+" "+rs.getString("country_name"));

        rs.first();
        System.out.println(rs.getString("country_id")+" "+rs.getString("country_name"));

        rs.absolute(5); //directly to 5th row
        System.out.println(rs.getString("country_id")+" "+rs.getString("country_name"));
        //move to first location
        rs.beforeFirst();
        //move to afterlast row location
        rs.afterLast();


        //cleaning up
        rs.close();
        stmnt.close();
        conn.close();




    }

    }
