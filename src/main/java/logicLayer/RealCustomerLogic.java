package logicLayer;

import dataAccessLayer.CRUD.CustomerCRUD;
import dataAccessLayer.CRUD.RealCustomerCRUD;
import dataAccessLayer.RealCustomer;
import exceptions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DotinSchool2 on 8/7/2016.
 */
public class RealCustomerLogic {

    public static RealCustomer CreateRealCustomer(String nationalCode, String firstName, String lastName, String fatherName, String dateOfBirth)
            throws NotExistNationalCodeException, EmptyFieldException, DatabaseConnectionException, AssignCustomerNumberException, DuplicateDataException {

        validate(firstName.trim(), lastName.trim(), fatherName.trim(), dateOfBirth.trim(), nationalCode.trim());

        if (RealCustomerCRUD.findByNationalCode(nationalCode.trim()).size() > 0){
            throw new DuplicateDataException("کد ملی وارد شده تکراری است.");
        }
        RealCustomer realCustomer = new RealCustomer();

        realCustomer.setNationalCode(nationalCode);
        realCustomer.setFirstName(firstName);
        realCustomer.setLastName(lastName);
        realCustomer.setFatherName(fatherName);
        realCustomer.setDateOfBirth(dateOfBirth);
        return  RealCustomerCRUD.create(realCustomer);
    }

    public static  void validate(String firstName, String lastName, String fatherName, String dateOfBirth, String nationalCode)
            throws EmptyFieldException, NotExistNationalCodeException, DuplicateDataException {
        if (firstName.equals("")) {
            throw new EmptyFieldException("لطفا فیلد نام را وارد کنید.");
        }
        if (lastName.equals("")) {
            throw new EmptyFieldException("لطفا فیلد نام خانوادگی را وارد کنید.");
        }
        if (fatherName.equals("")) {
            throw new EmptyFieldException("لطفا فیلد نام پدر را وارد کنید.");
        }
        if (dateOfBirth.equals("")) {
            throw new EmptyFieldException("لطفا فیلد تاریخ تولد را وارد کنید.");
        }
        if (nationalCode.equals("")) {
            throw new EmptyFieldException("لطفا فیلد کد ملی را وارد کنید.");
        }
        if (nationalCode.length() != 10){
            throw new NotExistNationalCodeException("کد ملی وارد شده معتبر نمی باشد. لطفا مجددا تلاش نمایید.");
        }

    }


    public static ArrayList<RealCustomer> retrieveRealCustomer(String customerNumber, String nationalCode, String firstName, String lastName){

        return RealCustomerCRUD.retrieve(customerNumber, nationalCode, firstName, lastName);
    }

    public static void deleteById(Long id){
        RealCustomer realcustomer = RealCustomerCRUD.retrieveById(id);
        RealCustomerCRUD.deleteById(realcustomer.getId());
        CustomerCRUD.deleteById(realcustomer.getId());
    }

    public static RealCustomer retrieveRealCustomerById(Long id){

        return RealCustomerCRUD.retrieveById(id);
    }

    public static void updateCustomer( String customerNumber, String firstName, String lastName, String fatherName, String dateOfBirth, String nationalCode)
            throws DatabaseConnectionException, NotExistNationalCodeException, EmptyFieldException, DuplicateDataException {
        validate(firstName.trim(), lastName.trim(), fatherName.trim(), dateOfBirth.trim(), nationalCode.trim());

        List<RealCustomer> realCustomers = RealCustomerCRUD.findByNationalCode(nationalCode);
        if (realCustomers.size() > 0){
            for (RealCustomer realCustomer : realCustomers){
                if(!realCustomer.getCustomerNumber().equals(customerNumber))
                {
                    throw new DuplicateDataException("کد ملی وارد شده تکراری است.");
                }
            }
        }
        RealCustomerCRUD.updateCustomer(customerNumber, firstName, lastName, fatherName, dateOfBirth, nationalCode);
    }
}
