package dataAccessLayer.CRUD;

import dataAccessLayer.Customer;
import exceptions.AssignCustomerNumberException;
import utilty.JDBCConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by DotinSchool2 on 8/6/2016.
 */
public class CustomerCRUD {


    public static Customer create() throws AssignCustomerNumberException {
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
        if (customerNumber == ""){
            throw new AssignCustomerNumberException("خطا در تخصیص شماره مشتری! لطفا مجددا تلاش فرمایید.");
        }
        return  new Customer(id , customerNumber);
    }

    private static String generateCustomerNumber() {
        String customerNumber = "";
        try {
            PreparedStatement preparedStatement = JDBCConnection.getJDBCConnection().prepareStatement(
                    "SELECT MAX(customerNumber)  FROM customer " );
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                customerNumber = String.valueOf(resultSet.getInt(1) + 1);
            }else{
                customerNumber = "1000";
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Customer customer = new Customer();
        customer.setCustomerNumber(customerNumber);
        return customerNumber;
    }

    public static void deleteById(Long id){

        try {
            PreparedStatement preparedStatement = JDBCConnection.getJDBCConnection().prepareStatement("DELETE From customer WHERE id=?;");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
