package presentationLayer;

import dataAccessLayer.RealCustomer;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by DotinSchool2 on 8/2/2016.
 */
public class SearchLegalCustomerServlet extends HttpServlet {

    protected void doPost(ServletRequest request, ServletResponse response) throws ServletException,IOException {
        String customerNumber = request.getParameter("customerNumber");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String fatherName = request.getParameter("fatherName");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String nationalCode = request.getParameter("nationalCode");
        String outputHTML="";

        //ArrayList<RealCustomer> realCustomers =
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

    }
}