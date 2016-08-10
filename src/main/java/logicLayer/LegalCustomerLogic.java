package logicLayer;

import dataAccessLayer.CRUD.LegalCustomerCRUD;
import dataAccessLayer.LegalCustomer;
import exceptions.AssignCustomerNumberException;
import exceptions.EmptyFieldException;
import exceptions.NotExistNationalCodeException;

/**
 * Created by DotinSchool2 on 8/10/2016.
 */
public class LegalCustomerLogic {

    public static LegalCustomer CreateLegalCustomer(String economicCode, String companyName, String dateOfRegistration)
            throws AssignCustomerNumberException, NotExistNationalCodeException, EmptyFieldException {

        validate(economicCode.trim(), companyName.trim(), dateOfRegistration.trim());
        LegalCustomer legalCustomer = new LegalCustomer();
        legalCustomer.setEconomicCode(economicCode);
        legalCustomer.setCompanyName(companyName);
        legalCustomer.setDateOfRegistration(dateOfRegistration);

        return LegalCustomerCRUD.create(legalCustomer);
    }


    public static  void validate(String economicCode, String companyName, String dateOfRegistration) throws EmptyFieldException, NotExistNationalCodeException {
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
}
