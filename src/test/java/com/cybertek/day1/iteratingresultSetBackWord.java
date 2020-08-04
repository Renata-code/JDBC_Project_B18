package com.cybertek.day1;

import java.sql.*;

public class iteratingresultSetBackWord {

    public static void main(String[] args) throws SQLException {

            String connectionStr = "jdbc:oracle:thin:@54.236.52.149:1521:XE";
            String username = "hr";
            String password = "hr";
            Connection conn = DriverManager.getConnection(connectionStr, username, password);
            Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmnt.executeQuery("select * from regions");

            //first move to the after las location
            //then keep moving to previous row as long as there is more row above

        rs.afterLast();
        //rs.previous();
        //System.out.println(rs.getString(1)+" "+ rs.getString(2));

        while(rs.previous()){
            System.out.println(rs.getString(1)+" "+ rs.getString(2));
        }
        System.out.println("-------------more moving -------------");
        //move to second row
        rs.absolute(2);
        System.out.println("currently i should be at 2 row "+rs.getRow());
        System.out.println(rs.getString(1)+" "+ rs.getString(2));

        rs.first();
        System.out.println(rs.getString(1)+" "+ rs.getString(2));

        rs.last();
        System.out.println(rs.getString(1)+" "+ rs.getString(2));

        System.out.println("rs.getRow()= "+rs.getRow());

        rs.close();
        stmnt.close();
        conn.close();

    }
}
