package presentationLayer;

import dataAccessLayer.RealCustomer;
import utilty.OutputHtml;
import logicLayer.RealCustomerLogic;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by DotinSchool2 on 8/2/2016.
 */
public class SearchLegalCustomerServlet extends HttpServlet {

    protected void doPost(ServletRequest request, ServletResponse response) throws ServletException,IOException {
        String customerNumber = request.getParameter("customerNumber");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        /*String fatherName = request.getParameter("fatherName");
        String dateOfBirth = request.getParameter("dateOfBirth");*/
        String nationalCode = request.getParameter("nationalCode");
        String outPut = "";

        ArrayList<RealCustomer> realCustomers = RealCustomerLogic.retrieveRealCustomer(customerNumber,nationalCode,firstName,lastName);
        outPut = OutputHtml.generateRealCustomerResults(realCustomers);

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(outPut);
    }
}
