package dataAccessLayer.CRUD;

import lateralRequiredFile.JDBCConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by DotinSchool2 on 8/6/2016.
 */
public class CustomerCRUD  {

    public static String createCustomer(String customerNumber)
    {
        String id = "";
        try {
            PreparedStatement preparedStatement = JDBCConnection.getJDBCConnection().prepareStatement("INSERT INTO customer (customerNumber) VALUES (?)",
                    new String[]{"id"});
            preparedStatement.setString(1,customerNumber);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                id = String.valueOf(resultSet.getInt(1));
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}
