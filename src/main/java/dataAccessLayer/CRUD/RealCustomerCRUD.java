package dataAccessLayer.CRUD;

import dataAccessLayer.Customer;
import lateralRequiredFile.JDBCConnection;
import dataAccessLayer.RealCustomer;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by DotinSchool2 on 8/6/2016.
 */
public class RealCustomerCRUD extends Customer{


    public static void create(RealCustomer realCustomer) {
        try {
            //JDBCConnection.getJDBCConnection().setAutoCommit(false);

            PreparedStatement preparedStatement = JDBCConnection.getJDBCConnection()
                    .prepareStatement("INSERT INTO realcustomer(customer, nationalCode, firstName, lastName, fatherName, dateOfBirth ) VALUES ( ?, ?, ?, ?, ?,?);");
            preparedStatement.setInt(1, Integer.parseInt(realCustomer.getCustomerNumber()));
            preparedStatement.setString(2, realCustomer.getNationalCode());
            preparedStatement.setString(3, realCustomer.getFirstName());
            preparedStatement.setString(4, realCustomer.getLastName());
            preparedStatement.setString(5, realCustomer.getFatherName());
            preparedStatement.setString(6, (realCustomer.getDateOfBirth()));
            preparedStatement.executeUpdate();

            //JDBCConnection.getJDBCConnection().commit();

        } catch (SQLException e) {
            //exception khodam bayad write she
            e.printStackTrace();
        }
    }
}

