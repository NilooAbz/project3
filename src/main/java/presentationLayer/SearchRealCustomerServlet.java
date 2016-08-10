package presentationLayer;

import dataAccessLayer.RealCustomer;
import utilty.OutputHtml;
import logicLayer.RealCustomerLogic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by DotinSchool2 on 8/2/2016.
 */
public class SearchRealCustomerServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String customerNumber = request.getParameter("customerNumber");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String nationalCode = request.getParameter("nationalCode");
        String outPut = "";

        ArrayList<RealCustomer> realCustomers = RealCustomerLogic.retrieveRealCustomer(customerNumber, nationalCode, firstName,lastName);

        if(realCustomers.size() == 0){
            outPut = OutputHtml.generateRealSuccessful("مشتری با اطلاعات وارد شده وجود ندارد.");
        }else {
            outPut = OutputHtml.generateRealCustomerResults(realCustomers);
        }
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(outPut);
    }

}