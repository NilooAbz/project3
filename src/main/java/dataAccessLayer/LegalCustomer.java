package dataAccessLayer;

import dataAccessLayer.CRUD.LegalCustomerCRUD;

/**
 * Created by DotinSchool2 on 8/1/2016.
 */
public class LegalCustomer extends Customer {

    private Long id;
    private String customerNumber;
    private String economicCode;
    private String companyName;
    private String dateOfRegistration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getEconomicCode() {
        return economicCode;
    }

    public void setEconomicCode(String economicCode) {
        this.economicCode = economicCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public static LegalCustomer CreateLegalCustomer( String economicCode, String companyName, String dateOfRegistration){

        //validate
        LegalCustomer legalCustomer = new LegalCustomer();
        legalCustomer.setEconomicCode(economicCode);
        legalCustomer.setCompanyName(companyName);
        legalCustomer.setDateOfRegistration(dateOfRegistration);

        return LegalCustomerCRUD.create(legalCustomer);
    }

}
