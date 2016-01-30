/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ifnu.b.fatkhan
 */
public class MysqlJdbcExample {

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
            //3. Create Statement
            Statement statement = connection.createStatement();
            //4. Execute Query
            String name = "Shaquile O'Neal";
            String email = "fulan@email.com";
            String address = "kampus ipb";
            String birthDate = "1991-01-03";
            String insertQuery = "INSERT INTO "
                    + "CUSTOMER(ID, NAME, EMAIL, ADDRESS, BIRTH_DATE) "
                    + "VALUES(1,'" + name + "','" + email + "','" + address + "','" + birthDate + "')";
            int result = statement.executeUpdate(insertQuery);
            System.out.println("Successful insert. " + result + " rows inserted");
            //5. If query Return ResultSet, fetch data from result set
            String selectQuery = "SELECT * FROM CUSTOMER";
            ResultSet selectCustomerResultSet = statement.executeQuery(selectQuery);
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
