package com.cybertek.day1;

import java.sql.*;

public class IteratingPractice {

    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@54.236.52.149:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        Statement stmnt = conn.createStatement();
        //ResultSet rs   =   stmnt.executeQuery("SELECT * FROM COUNTRIES WHERE REGION_ID = 1") ;
        ResultSet rs   =   stmnt.executeQuery("select * from countries");

        // as long as rs.next() return true I know I have next row to print the data
        // we will keep looping as long as rs.next() return true
        while(rs.next()){
            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+
                    rs.getString(3));
        }

        rs.previous();

        rs.close();
        stmnt.close();
        conn.close();



    }

    }
