package logicLayer;

import dataAccessLayer.CRUD.CustomerCRUD;
import dataAccessLayer.CRUD.LegalCustomerCRUD;
import dataAccessLayer.CRUD.RealCustomerCRUD;
import dataAccessLayer.LegalCustomer;
import dataAccessLayer.RealCustomer;
import exceptions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DotinSchool2 on 8/10/2016.
 */
public class LegalCustomerLogic {

    public static LegalCustomer CreateLegalCustomer(String economicCode, String companyName, String dateOfRegistration)
            throws AssignCustomerNumberException, NotExistNationalCodeException, EmptyFieldException, DatabaseConnectionException, DuplicateDataException {

        validate(economicCode.trim(), companyName.trim(), dateOfRegistration.trim());

        if (LegalCustomerCRUD.findByNationalCode(economicCode.trim()).size() > 0){
            throw new DuplicateDataException("کد اقتصادی وارد شده تکراری است.");
        }

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
            throws DatabaseConnectionException, NotExistNationalCodeException, EmptyFieldException, DuplicateDataException {

        LegalCustomerLogic.validate(economicCode, companyName, dateOfRegistration);
        List<LegalCustomer> legalCustomers = LegalCustomerCRUD.findByNationalCode(economicCode);
        if (legalCustomers.size() > 0){
            for (LegalCustomer legalCustomer : legalCustomers){
                if(!legalCustomer.getCustomerNumber().equals(customerNumber))
                {
                    throw new DuplicateDataException("کد ملی وارد شده تکراری است.");
                }
            }
        }


        LegalCustomerCRUD.updateCustomer(customerNumber, companyName, economicCode, dateOfRegistration);
    }
}
