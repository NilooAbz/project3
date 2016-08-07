package dataAccessLayer;

/**
 * Created by DotinSchool2 on 8/1/2016.
 */
public class Customer extends CustomerNumberGenerator{

    private Long id;
    private String customerNumber;

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


}
