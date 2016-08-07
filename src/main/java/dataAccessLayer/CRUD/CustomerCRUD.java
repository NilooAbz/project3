package dataAccessLayer.CRUD;

import dataAccessLayer.JDBCConnection;
import dataAccessLayer.RealCustomer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by DotinSchool2 on 8/6/2016.
 */
public class CustomerCRUD  {
    public static String CreateCustomer(){


        return null;
    }

    private static String generateCustomerNumber()
            //throws AssignCustomerNumberException
            {
        String customerNumber = "";
        try {
            PreparedStatement preparedStatement = JDBCConnection.getJDBCConnection().prepareStatement("INSERT INTO customer ( CustomerNumber) VALUES ()",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                customerNumber = String.valueOf(resultSet.getInt(1));
            }
            System.out.println("lalalalalalalalaalalalalalaa"+ customerNumber);
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*if (customerNumber == "") {
            throw new AssignCustomerNumberException("");
        }*/
        return customerNumber;
    }

    public static String create(RealCustomer realCustomer) {
        realCustomer.setCustomerNumber(generateCustomerNumber());
        RealCustomerCRUD.create(realCustomer);

        return realCustomer.getCustomerNumber();
    }
}
