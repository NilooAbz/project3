package logicLayer;

import dataAccessLayer.CRUD.CustomerCRUD;
import dataAccessLayer.CRUD.CustomerNumberGeneratorCRUD;
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
        realCustomer.setCustomerNumber(CustomerNumberGeneratorCRUD.create(realCustomer));

        return realCustomer;
    }

    public static ArrayList<RealCustomer> retrieveCustomer(String customerNumber, String nationalCode, String firstName, String lastName, String fatherName, String dateOfBirth){


        return null;
    }
}
