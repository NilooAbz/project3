package dataAccessLayer;

/**
 * Created by DotinSchool2 on 8/1/2016.
 */
public class RealCustomer extends Customer{

    private Long id;
    private String nationalCode;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String dateOfBirth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }



    public static RealCustomer CreateRealCustomer( String nationalCode, String firstName, String lastName, String fatherName, String dateOfBirth){

        RealCustomer realCustomer = new RealCustomer();
        realCustomer.setNationalCode(nationalCode);
        realCustomer.setFirstName(firstName);
        realCustomer.setLastName(lastName);
        realCustomer.setFatherName(fatherName);
        realCustomer.setDateOfBirth(dateOfBirth);
/*        realCustomer.setId(id);
        realCustomer.setCustomerNumber(?);*/
        return realCustomer;
    }

}
