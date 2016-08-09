package dataAccessLayer.CRUD;

import dataAccessLayer.Customer;
import utilty.JDBCConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by DotinSchool2 on 8/6/2016.
 */
public class CustomerCRUD {


    private static String generateCustomerNumber() {
        String customerNumber = "";
        try {
            PreparedStatement preparedStatement = JDBCConnection.getJDBCConnection().prepareStatement(
                    "SELECT MAX(customerNumber)  FROM customer " );
            ResultSet resultSet = preparedStatement.executeQuery();

            //customerNumber = String.valueOf(resultSet.getInt("customerNumber") + 1);
            if (resultSet.next()) {
                customerNumber = String.valueOf(resultSet.getInt(1) + 1);
            }else{
                customerNumber = "1000";
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
       // create(customerNumber);
        Customer customer = new Customer();
        customer.setCustomerNumber(customerNumber);
        return customerNumber;
    }
    public static Customer create(){
        String customerNumber = "";
        Long id = 0l;
        try {
            customerNumber = generateCustomerNumber();
            PreparedStatement preparedStatement = JDBCConnection.getJDBCConnection().prepareStatement(
                    "INSERT INTO customer (customerNumber) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,customerNumber);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                id = Long.valueOf(resultSet.getInt(1));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  new Customer(id , customerNumber);
    }





}
