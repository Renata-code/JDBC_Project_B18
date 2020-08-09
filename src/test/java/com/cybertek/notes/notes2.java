package com.cybertek.notes;

public class notes2 {
    /*
    ------- difference between truncate and drop
--- truncate will delete all the data from the table but will keep the table structure
--- drop will delete the table + all of its data
DML  : data maipulation language SELECT , INSERT , UPDATE ,DELETE
DDL : data definition languge  CREATE , ALTER , DROP , TRUNCATE , RENAME
DIFFERENCE BETWEEN JOIN AND SET OPERATORS
     JOIN USE PRIMARY KEY AND FOREIGN KEY RELATIONSHIP SO WE CAN QUERY MULTIPLE TABLE
     2 TABLE CAN HAVE ANY NUMBER OF COLUMNS OR DATA TYPES
     AS LONG AS THE PROMARY KEY AND FOREIGN KET RELATIONSHIP EXISTS
     SET OPERATORS LIKE UNION , UNION ALL , MINUS , INTERSECT
     IS USED FOR 2 RESULTSET OF QUERY WITH SAME COLUMN COUNT , COLUMN DATA TYPE , COLUMN NAME
    -- UNION ALL
    -- WILL COMBINE THE RESULTSET OF 2 QUERY ON TOP OF EACH OTHER.
      --- IT DOES NOT REMOVE DUPLICATE IT DOES NOT SORT

    -- UNION
     -- WILL COMBINE THE RESULTSET OF 2 QUERY ON TOP OF EACH OTHER.
     --- REMOVE DUPLICATE AND SORT BY FIRST COLUMN

     --- MINUS
    --- WILL REMOVE FROM FIRST RESULTSET IF IT EXISTS IN SECOND TABLE

    --- INTERSECT
    --- WILL ONLY RETURN THE MATCHING(OVERLAPING) ROWS FROM BOTH RESULTSET
      WHAT IS A VIRTUAL TABLE  : VIEW
      A view is a virtual table resulted from a query and act like a table
      Its easy to create view from SQL Develoepr
      by clicking view -- new -->> provide the valid query and click ok
      if the name of the view is EMP_NAME_SALARY_VIEW
        you can query using
      SELECT * FROM EMP_NAME_SALARY_VIEW
      just like you would for any table
      Command for creating table is :

      CREATE VIEW YOUR_VIEW_NAME_HERE AS (
            THE QUERY GOES HERE
      )
------  JDBC REVIEW
    JDBC is java database connectivity, which helps us connect java and database, in order to connect we need a database driver
    we have 3 important interfaces: CONNECTION, STATEMENT, RESULTSET
    EACH DATABASE VENDOR WILL HAVE THEIR DRIVER TO PROVIDE IMPLEMENTATION
    ORACLE HAS ORACLE DRIVER , MYSQL HAS MYSQL DRIVER
    AND in our maven project we specify the drivers as dependency
        This is oracle dependency
        <dependency>
            <groupId>com.oracle.ojdbc</groupId>
            <artifactId>ojdbc8</artifactId>
            <version>19.3.0.0</version>
        </dependency>
        This is my sql dependency
         <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.21</version>
        </dependency>
      Once we have the driver
      DriverManager Class will use the Connection String , username , password
      to create the Connection object
      Connection String is the way Driver manager find database vendor , driver type
      host and port information
      Then we create a statement and with that we get resultset to work on .
      It does not matter what database vendor you are connecting ,
      JDBC will work the same way.

     */
}
