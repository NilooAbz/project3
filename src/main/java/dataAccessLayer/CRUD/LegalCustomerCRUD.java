package dataAccessLayer.CRUD;

import dataAccessLayer.Customer;
import lateralRequiredFile.JDBCConnection;
import dataAccessLayer.LegalCustomer;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by DotinSchool2 on 8/6/2016.
 */
public class LegalCustomerCRUD extends Customer{

    public static void create(LegalCustomer legalCustomer){
        try {
            PreparedStatement preparedStatement = JDBCConnection.getJDBCConnection()
                    .prepareStatement("INSERT INTO legalcustomer (CompanyName, EconomicCode, DateOfRegistration, CustomerNumber) VALUES (?, ?, ?, ?);");
            preparedStatement.setString(1, legalCustomer.getCompanyName());
            preparedStatement.setString(2, legalCustomer.getEconomicCode());
            preparedStatement.setDate(3, Date.valueOf(legalCustomer.getDateOfRegistration()));
            preparedStatement.setInt(4, Integer.parseInt(legalCustomer.getCustomerNumber()));

        } catch (SQLException e) {
            //exception khodam bayad write she
            e.printStackTrace();
        }
    }

    //public static void deleteBy

    /*public static ArrayList<LegalCustomer> regain( String companyName, String economicCode, String dateOfRegistration, String customerNumber)
            throws SQLException {
        PreparedStatement preparedStatement = generatePreparedStatement(companyName,economicCode,dateOfRegistration,customerNumber);
        ResultSet results = preparedStatement.executeQuery();
        ArrayList<LegalCustomer> legalCustomers = new ArrayList<LegalCustomer>();

        while (results.next()) {
            LegalCustomer legalcustomer = new LegalCustomer();
            legalcustomer.setId(Long.valueOf(results.getInt("id")));
            legalcustomer.setCompanyName(results.getString("CompanyName"));
            legalcustomer.setEconomicCode(results.getString("EconomicCode"));
            legalcustomer.setDateOfRegistration(String.valueOf(results.getDate("DataOfRegistration")));
            //legalcustomer.setDateOfRegistration(String.valueOf(results.getDate("DataOfRegistration").toLocalDate()));
        }

        if (preparedStatement != null){
            preparedStatement.close();
        }

        return legalCustomers;
    }

    private static PreparedStatement generatePreparedStatement( String companyName, String economicCode, String dateOfRegistration, String customerNumber)
            throws SQLException {
        PreparedStatement preparedStatement = null;
        if (companyName != "") {
            preparedStatement = JDBCConnection.getJDBCConnection().prepareStatement("SELECT * From legalcustomer WHERE ComponyName = ? ;");
            preparedStatement.setString(1, companyName);
        }else if (economicCode !="") {
            preparedStatement = JDBCConnection.getJDBCConnection().prepareStatement("SELECT * FROM legalcustomer WHERE EconomicCode=?;");
            preparedStatement.setString(1, economicCode);
        }else if(customerNumber !=""){
            preparedStatement = JDBCConnection.getJDBCConnection().prepareStatement("SELECT * From legal_customer WHERE CustomerNumber=?;");
            preparedStatement.setInt(1, Integer.parseInt(customerNumber));
        }else if (dateOfRegistration !=""){
            preparedStatement = JDBCConnection.getJDBCConnection().prepareStatement("SELECT * From legalcustomer WHERE DateOfRegistration=?;");
            preparedStatement.setString(1, dateOfRegistration);
        }else {
            preparedStatement = JDBCConnection.getJDBCConnection().prepareStatement("SELECT * From legalcustomer;");
        }
        return preparedStatement;
    }*/
}
