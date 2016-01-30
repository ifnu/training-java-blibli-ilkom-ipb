/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training.util;

import co.id.ipb.ilkom.training.dao.mysql.CustomerDaoMysqlTest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author ifnu.b.fatkhan
 */
public class DatabaseTest {

    private static final String MYSQL_JDBC_DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private static final String JDBC_CONNECTION_STRING = "jdbc:mysql://localhost:3306/trainingjava";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    protected static Connection connection;
    private static IDatabaseTester databaseTester;
    private static IDataSet dataSet;

    @BeforeClass
    public static void prepareDb() {
        try {
            connection = DriverManager.getConnection(
                    JDBC_CONNECTION_STRING, USER_NAME, PASSWORD);
            //connection needed for getting actual result from database
            dataSet = new FlatXmlDataSetBuilder()
                    .build(CustomerDaoMysqlTest.class.getResourceAsStream("/customer-dataset.xml"));
            //2. connect to database
            databaseTester = new JdbcDatabaseTester(
                    MYSQL_JDBC_DRIVER_CLASS_NAME,
                    JDBC_CONNECTION_STRING,
                    USER_NAME,
                    PASSWORD);
            databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
            databaseTester.setDataSet(dataSet);
        } catch (ClassNotFoundException | DataSetException ex) {
            Logger.getLogger(CustomerDaoMysqlTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Before
    public void prepareDbBeforeTest() {
        try {
            //prepare database if database is not instantiated
            prepareDb();
            //3. cleanup table and insert dataset
            databaseTester.onSetup();
        } catch (Exception ex) {
            Logger.getLogger(CustomerDaoMysqlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
