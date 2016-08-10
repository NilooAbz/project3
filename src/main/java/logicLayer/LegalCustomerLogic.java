package logicLayer;

import dataAccessLayer.CRUD.CustomerCRUD;
import dataAccessLayer.CRUD.LegalCustomerCRUD;
import dataAccessLayer.CRUD.RealCustomerCRUD;
import dataAccessLayer.LegalCustomer;
import dataAccessLayer.RealCustomer;
import exceptions.AssignCustomerNumberException;
import exceptions.DatabaseConnectionException;
import exceptions.EmptyFieldException;
import exceptions.NotExistNationalCodeException;

import java.util.ArrayList;

/**
 * Created by DotinSchool2 on 8/10/2016.
 */
public class LegalCustomerLogic {

    public static LegalCustomer CreateLegalCustomer(String economicCode, String companyName, String dateOfRegistration)
            throws AssignCustomerNumberException, NotExistNationalCodeException, EmptyFieldException, DatabaseConnectionException {

        validate(economicCode.trim(), companyName.trim(), dateOfRegistration.trim());
        LegalCustomer legalCustomer = new LegalCustomer();
        legalCustomer.setEconomicCode(economicCode);
        legalCustomer.setCompanyName(companyName);
        legalCustomer.setDateOfRegistration(dateOfRegistration);

        return LegalCustomerCRUD.create(legalCustomer);
    }

    public static  void validate(String economicCode, String companyName, String dateOfRegistration)
            throws EmptyFieldException, NotExistNationalCodeException {
        if (companyName.equals("")) {
            throw new EmptyFieldException("لطفا فیلد نام شرکت را وارد کنید.");
        }
        if (dateOfRegistration.equals("")) {
            throw new EmptyFieldException("لطفا فیلد تاریخ ثبت شرکت را وارد کنید.");
        }
        if (economicCode.equals("")) {
            throw new EmptyFieldException("لطفا فیلد کد اقتصادی را وارد کنید.");
        }
        if (economicCode.length() != 12){
            throw new NotExistNationalCodeException("کد اقتصادی وارد شده معتبر نمی باشد. لطفا مجددا تلاش نمایید.");
        }
    }

    public static ArrayList<LegalCustomer > retrieveRealCustomer(String customerNumber, String companyName, String economicCode){
        return LegalCustomerCRUD.retrieve(customerNumber, companyName, economicCode);
    }

    public static void deleteById(Long id){
        LegalCustomer legalCustomer = LegalCustomerCRUD.retrieveById(id);
        LegalCustomerCRUD.deleteById(legalCustomer.getId());
        CustomerCRUD.deleteById(legalCustomer.getId());
    }

    public static LegalCustomer retrieveLegalCustomerById(Long id){

        return LegalCustomerCRUD.retrieveById(id);
    }

    public static void updateCustomer( String customerNumber, String companyName, String economicCode, String dateOfRegistration)
            throws DatabaseConnectionException, NotExistNationalCodeException, EmptyFieldException {
        LegalCustomerCRUD.updateCustomer(customerNumber, companyName, economicCode, dateOfRegistration);
    }
}
