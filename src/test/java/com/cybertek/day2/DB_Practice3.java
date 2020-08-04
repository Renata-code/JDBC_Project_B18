package com.cybertek.day2;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DB_Practice3 {

    public static void main(String[] args) throws SQLException {

        DB_Utility.createConnection();;
        ResultSet rs = DB_Utility.runQuery("select * from regions");
        rs.next();

        //store first row data as a map<String,String>
        //the key of the map is column name , value of the map is the column data

        Map<String,String> rowMap = new HashMap<>();
        //rowMap.put("region_id","1");
        //rowMap.put("region_name","Europe");

        // rowMap.put("region_id",rs.getString(1));
        // rowMap.put("region_name",rs.getString(2));

        ResultSetMetaData rsmd = rs.getMetaData();
        for (int i = 1; i <rsmd.getColumnCount() ; i++) {
            System.out.println(rsmd.getColumnName(i));

        }
    }
}
