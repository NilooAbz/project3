package dataAccessLayer.CRUD;

import dataAccessLayer.Customer;
import dataAccessLayer.RealCustomer;
import lateralRequiredFile.JDBCConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by DotinSchool2 on 8/7/2016.
 */
public class CustomerNumberGeneratorCRUD {

    private static String generateCustomerNumber()
    {
        String customerNumber = "";
        try {
            PreparedStatement preparedStatement = JDBCConnection.getJDBCConnection().prepareStatement("INSERT INTO customernumber () VALUES ()",
                    new String[]{"idCustomerNumber"});
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                customerNumber = String.valueOf(resultSet.getInt(1));
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerNumber;
    }


    public static String create(RealCustomer realCustomer) {
        Customer customer = new Customer();
        customer.setCustomerNumber(generateCustomerNumber());
        realCustomer.setCustomerNumber(CustomerCRUD.createCustomer(customer.getCustomerNumber()));
        RealCustomerCRUD.create(realCustomer);
        return realCustomer.getCustomerNumber();
    }
}
