package dataAccessLayer.CRUD;

import dataAccessLayer.Customer;
import dataAccessLayer.RealCustomer;
import exceptions.AssignCustomerNumberException;
import exceptions.DatabaseConnectionException;
import exceptions.EmptyFieldException;
import exceptions.NotExistNationalCodeException;
import logicLayer.LegalCustomerLogic;
import logicLayer.RealCustomerLogic;
import utilty.JDBCConnection;
import dataAccessLayer.LegalCustomer;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DotinSchool2 on 8/6/2016.
 */
public class LegalCustomerCRUD extends Customer{

    public static LegalCustomer create(LegalCustomer legalCustomer)
            throws AssignCustomerNumberException, DatabaseConnectionException {

        Customer customer = CustomerCRUD.create();
        legalCustomer.setId(customer.getId());
        legalCustomer.setCustomerNumber(customer.getCustomerNumber());

        try {
            PreparedStatement preparedStatement = JDBCConnection.getJDBCConnection()
                    .prepareStatement("INSERT INTO legalcustomer(id, companyName, economicCode, dateOfRegistration, customerNumber) VALUES (?, ?, ?, ?, ?);");
            preparedStatement.setLong(1, legalCustomer.getId());
            preparedStatement.setString(2, legalCustomer.getCompanyName());
            preparedStatement.setString(3, legalCustomer.getEconomicCode());
            preparedStatement.setString(4, legalCustomer.getDateOfRegistration());
            preparedStatement.setString(5, legalCustomer.getCustomerNumber());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseConnectionException(e.getMessage() + "خطا در ایجاد اتصال به پایگاه داده!");
        }

        return legalCustomer;
    }

    public static ArrayList<LegalCustomer> retrieve(String customerNumber, String companyName, String economicCode){
        ArrayList<LegalCustomer> legalCustomers = new ArrayList<LegalCustomer>();
        PreparedStatement preparedStatement = generateFromDatabase( customerNumber, companyName, economicCode);

        try {
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()){
                LegalCustomer legalCustomer = new LegalCustomer();
                legalCustomer.setId(results.getLong("id"));
                legalCustomer.setCustomerNumber(results.getString("customerNumber"));
                legalCustomer.setEconomicCode(results.getString("economicCode"));
                legalCustomer.setCompanyName(results.getString("companyName"));
                legalCustomer.setDateOfRegistration(String.valueOf(results.getDate("dateOfRegistration")));
                legalCustomers.add(legalCustomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return legalCustomers;
    }

    private static PreparedStatement generateFromDatabase(String customerNumber, String companyName, String economicCode){
        PreparedStatement preparedStatement = null;
        StringBuilder sqlCommand = new StringBuilder("SELECT * From legalcustomer WHERE ");
        int counter = 1;
        List<String> parameters = new ArrayList<String>();

        if(!companyName.equals("")) {
            sqlCommand.append(" companyName =? AND");
            parameters.add(companyName);
        }
        if(!"".equals(economicCode)) {
            sqlCommand.append(" economicCode =? AND");
            parameters.add(economicCode);
        }
        if(customerNumber != null && (!customerNumber.equals( ""))) {
            sqlCommand.append(" customerNumber =? AND");
            parameters.add(customerNumber);
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

    public static LegalCustomer retrieveById(Long id){

        LegalCustomer legalCustomer = new LegalCustomer();
        try {
            PreparedStatement preparedStatement = JDBCConnection.getJDBCConnection().prepareStatement("SELECT * From legalcustomer WHERE id=?;");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                legalCustomer.setId(resultSet.getLong("id"));
                legalCustomer.setCustomerNumber(resultSet.getString("customerNumber"));
                legalCustomer.setCompanyName(resultSet.getString("companyName"));
                legalCustomer.setEconomicCode(resultSet.getString("economicCode"));
                legalCustomer.setDateOfRegistration(resultSet.getString("dateOfRegistration"));
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return legalCustomer;
    }

    public static void deleteById(Long id){

        try {
            PreparedStatement preparedStatement = JDBCConnection.getJDBCConnection().prepareStatement("DELETE From legalcustomer WHERE id=?;");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void  updateCustomer( String customerNumber, String companyName, String economicCode, String dateOfRegistration) throws NotExistNationalCodeException, EmptyFieldException, DatabaseConnectionException {
        try {
            PreparedStatement preparedStatement = JDBCConnection.getJDBCConnection().prepareStatement
                    ("UPDATE legalcustomer SET companyName = ?  ,  economicCode = ?  ,  dateOfRegistration = ?  WHERE customerNumber=?");
            preparedStatement.setString(1, companyName);
            preparedStatement.setString(2, economicCode);
            preparedStatement.setString(3, dateOfRegistration);
            preparedStatement.setString(4, customerNumber);

            LegalCustomerLogic.validate(economicCode, companyName, dateOfRegistration);

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new DatabaseConnectionException(e.getMessage() + "خطا در به روز رسانی اطلاعات پایگاه داده!");
        }
    }
}
