/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ifnu.b.fatkhan
 */
public class MysqlJdbcPreparedStatementExample {

    public static void main(String[] args) {
        try {
            //1. Load JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");
            //2. Create Connection
            Connection connection
                    = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/trainingjava", //jdbc connection string
                            "root", //user
                            "root");//password
            //3. Create Prepared Statement Statement
            String insertQuery = "INSERT INTO "
                    + "CUSTOMER(ID, NAME, EMAIL, ADDRESS, BIRTH_DATE) "
                    + "VALUES(?,?,?,?,?)";
            String selectQuery = "SELECT * FROM CUSTOMER";
            PreparedStatement insertQueryPreparedStatement
                    = connection.prepareStatement(insertQuery);
            PreparedStatement selectQueryPreparedStatement
                    = connection.prepareStatement(selectQuery);
            //4. Execute Query
            String name = "Fulan,'','');drop table trainingjava;";
            String email = "fulan@email.com";
            String address = "kampus ipb";
            Calendar birthDateCalendar = new GregorianCalendar(1993, 1, 12);
            Date birthDate = new Date(birthDateCalendar.getTimeInMillis());
            //insert 1 million data using batch execution, execute to server per 1000 data
            for (int i = 0; i < 1000000; i++) {
                insertQueryPreparedStatement.setInt(1, i);
                insertQueryPreparedStatement.setString(2, name);
                insertQueryPreparedStatement.setString(3, email);
                insertQueryPreparedStatement.setString(4, address);
                insertQueryPreparedStatement.setDate(5, birthDate);
                //add query to batch
                insertQueryPreparedStatement.addBatch();
                if (i % 1000 == 0 || i == 999999) {
                    //execute batch per 1000 data
                    int[] result = insertQueryPreparedStatement.executeBatch();
                    System.out.println("Successful insert. " + result.length + " rows inserted");
                }
            }

            //5. If query Return ResultSet, fetch data from result set
            ResultSet selectCustomerResultSet
                    = selectQueryPreparedStatement.executeQuery();
            //iterasi ResultSet for all rows fetched
            while (selectCustomerResultSet.next()) {
                String customerDataRow
                        = selectCustomerResultSet.getInt("ID") + "||"
                        + selectCustomerResultSet.getString("NAME") + "||"
                        + selectCustomerResultSet.getString("EMAIL") + "||"
                        + selectCustomerResultSet.getString("ADDRESS") + "||"
                        + selectCustomerResultSet.getDate("BIRTH_DATE");
                System.out.println(customerDataRow);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MysqlJdbcExample.class.getName()).log(Level.SEVERE, null, ex);
            //ex.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(MysqlJdbcExample.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
