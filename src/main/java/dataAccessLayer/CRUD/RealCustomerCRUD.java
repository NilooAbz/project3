package dataAccessLayer.CRUD;

import dataAccessLayer.JDBCConnection;
import dataAccessLayer.RealCustomer;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by DotinSchool2 on 8/6/2016.
 */
public class RealCustomerCRUD {


    public static void create(RealCustomer realCustomer) {
        try {
            PreparedStatement preparedStatement = JDBCConnection.getJDBCConnection()
                    .prepareStatement("INSERT INTO realcustomer (NationalCode, FirstName, LastName, FatherName, DateOfBirth, CustomerNumber) VALUES (?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, realCustomer.getNationalCode());
            preparedStatement.setString(2, realCustomer.getFirstName());
            preparedStatement.setString(3, realCustomer.getLastName());
            preparedStatement.setString(4, realCustomer.getFatherName());
            preparedStatement.setDate(5, Date.valueOf(realCustomer.getDateOfBirth()));
            preparedStatement.setInt(6, Integer.parseInt(realCustomer.getCustomerNumber()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            //exception khodam bayad write she
            e.printStackTrace();
        }
    }
}

