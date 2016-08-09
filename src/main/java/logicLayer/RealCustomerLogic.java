package logicLayer;

import dataAccessLayer.CRUD.CustomerCRUD;
import dataAccessLayer.CRUD.RealCustomerCRUD;
import dataAccessLayer.RealCustomer;

import java.util.ArrayList;

/**
 * Created by DotinSchool2 on 8/7/2016.
 */
public class RealCustomerLogic {

    public static RealCustomer CreateRealCustomer(String nationalCode, String firstName, String lastName, String fatherName, String dateOfBirth){

        //validate
        RealCustomer realCustomer = new RealCustomer();
        realCustomer.setNationalCode(nationalCode);
        realCustomer.setFirstName(firstName);
        realCustomer.setLastName(lastName);
        realCustomer.setFatherName(fatherName);
        realCustomer.setDateOfBirth(dateOfBirth);
        return  RealCustomerCRUD.create(realCustomer);

    }

    public static ArrayList<RealCustomer> retrieveRealCustomer(String customerNumber, String nationalCode, String firstName, String lastName){
        //validate
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

    public static void updateCustomer( String customerNumber, String firstName, String lastName, String fatherName, String dateOfBirth, String nationalCode){
        RealCustomerCRUD.updateCustomer(customerNumber, firstName, lastName, fatherName, dateOfBirth, nationalCode);
    }
}
