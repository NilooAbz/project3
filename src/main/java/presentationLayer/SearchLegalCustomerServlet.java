package presentationLayer;

import dataAccessLayer.LegalCustomer;
import logicLayer.LegalCustomerLogic;
import utilty.OutputHtml;

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
public class SearchLegalCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String customerNumber = request.getParameter("customerNumber");
        String companyName = request.getParameter("companyName");
        String economicCode = request.getParameter("economicCode");
        String outPut = "";

        ArrayList<LegalCustomer> legalCustomers = LegalCustomerLogic.retrieveRealCustomer(customerNumber, companyName, economicCode);

        if(legalCustomers.size() == 0){
            outPut = OutputHtml.generateLegalSuccessful("مشتری با اطلاعات وارد شده وجود ندارد.");
        }else {
            outPut = OutputHtml.generateLegalCustomerResults(legalCustomers);
        }

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(outPut);
    }
}
