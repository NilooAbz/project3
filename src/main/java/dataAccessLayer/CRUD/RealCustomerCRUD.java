package dataAccessLayer.CRUD;

import dataAccessLayer.Customer;
import exceptions.*;
import logicLayer.RealCustomerLogic;
import utilty.JDBCConnection;
import dataAccessLayer.RealCustomer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DotinSchool2 on 8/6/2016.
 */
public class RealCustomerCRUD extends Customer{

    public static RealCustomer create(RealCustomer realCustomer)
            throws DatabaseConnectionException, AssignCustomerNumberException, DuplicateDataException {

        Customer customer = CustomerCRUD.create();
        realCustomer.setId(customer.getId());
        realCustomer.setCustomerNumber(customer.getCustomerNumber());

        try {
            //JDBCConnection.getJDBCConnection().setAutoCommit(false);

            PreparedStatement preparedStatement = JDBCConnection.getJDBCConnection().prepareStatement(
                    "INSERT INTO realcustomer(id, nationalCode, firstName, lastName, fatherName, dateOfBirth , customerNumber ) VALUES ( ?, ?, ?, ?, ?, ? , ?);");
            preparedStatement.setLong(1, realCustomer.getId());
            preparedStatement.setString(2, realCustomer.getNationalCode());
            preparedStatement.setString(3, realCustomer.getFirstName());
            preparedStatement.setString(4, realCustomer.getLastName());
            preparedStatement.setString(5, realCustomer.getFatherName());
            preparedStatement.setString(6, realCustomer.getDateOfBirth());
            preparedStatement.setString(7, realCustomer.getCustomerNumber());
            preparedStatement.executeUpdate();

            //JDBCConnection.getJDBCConnection().commit();

        } catch (SQLException e) {
            throw new DatabaseConnectionException(e.getMessage() + "خطا در ایجاد اتصال به پایگاه داده!");
        }

        return  realCustomer;
    }

    public static ArrayList<RealCustomer> retrieve(String customerNumber, String nationalCode, String firstName, String lastName){
        ArrayList<RealCustomer> realCustomers = new ArrayList<RealCustomer>();
        PreparedStatement preparedStatement = generateFromDatabase( customerNumber, nationalCode, firstName, lastName);
        try {
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()){
                RealCustomer realCustomer = new RealCustomer();
                realCustomer.setId(results.getLong("id"));
                realCustomer.setCustomerNumber(results.getString("customerNumber"));
                realCustomer.setNationalCode(results.getString("nationalCode"));
                realCustomer.setFirstName(results.getString("firstName"));
                realCustomer.setLastName(results.getString("lastName"));
                realCustomer.setFatherName(results.getString("fatherName"));
                realCustomer.setDateOfBirth(String.valueOf(results.getDate("dateOfBirth")));
                realCustomers.add(realCustomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return realCustomers;
    }

    private static PreparedStatement generateFromDatabase(String customerNumber, String nationalCode, String firstName, String lastName){
        PreparedStatement preparedStatement = null;
        StringBuilder sqlCommand = new StringBuilder("SELECT * From realcustomer WHERE ");
        int counter = 1;
        List<String> parameters = new ArrayList<String>();

        if(!firstName.equals("")) {
            sqlCommand.append(" firstName =? AND");
            parameters.add(firstName);
        }
        if(!"".equals(lastName)) {
            sqlCommand.append(" lastName =? AND");
            parameters.add(lastName);
        }if(customerNumber != null && (!customerNumber.equals( ""))) {
            sqlCommand.append(" customerNumber =? AND");
            parameters.add(customerNumber);
        }
        if(!nationalCode.equals( "")) {
            sqlCommand.append(" nationalCode =? AND");
            parameters.add(nationalCode);
        }
        sqlCommand.append(" true ");

        try {
            preparedStatement = JDBCConnection.getJDBCConnection().prepareStatement(sqlCommand.toString());
            for (String param: parameters) {
                preparedStatement.setString(counter++,param);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static RealCustomer retrieveById(Long id){

        RealCustomer realcustomer = new RealCustomer();
        try {
            PreparedStatement preparedStatement = JDBCConnection.getJDBCConnection().prepareStatement("SELECT * From realcustomer WHERE id=?;");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                realcustomer.setId(resultSet.getLong("id"));
                realcustomer.setCustomerNumber(resultSet.getString("customerNumber"));
                realcustomer.setFirstName(resultSet.getString("firstName"));
                realcustomer.setLastName(resultSet.getString("lastName"));
                realcustomer.setFatherName(resultSet.getString("fatherName"));
                realcustomer.setNationalCode(resultSet.getString("nationalCode"));
                realcustomer.setDateOfBirth(resultSet.getString("dateOfBirth"));
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return realcustomer;
    }

    public static void deleteById(Long id){

        try {
            PreparedStatement preparedStatement = JDBCConnection.getJDBCConnection().prepareStatement("DELETE From realcustomer WHERE id=?;");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateCustomer( String customerNumber, String firstName, String lastName, String fatherName, String dateOfBirth, String nationalCode)
            throws DatabaseConnectionException {
        try {
            PreparedStatement preparedStatement = JDBCConnection.getJDBCConnection().prepareStatement
                    ("UPDATE realcustomer SET firstName = ? , lastName =  ? ,  fatherName = ?  ,  nationalCode = ?  ,  dateOfBirth = ?  WHERE customerNumber=?");
            //preparedStatement.setLong(1, id);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, fatherName);
            preparedStatement.setString(4, nationalCode);
            preparedStatement.setString(5, dateOfBirth);
            preparedStatement.setString(6, customerNumber);


            preparedStatement.execute();

        } catch (SQLException e) {
            throw new DatabaseConnectionException(e.getMessage() + "خطا در به روز رسانی اطلاعات پایگاه داده!");
        }

    }

    public static List findByNationalCode(String nationalCode){
        return retrieve("", nationalCode, "", "");
    }
}

