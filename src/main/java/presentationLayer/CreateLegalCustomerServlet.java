package presentationLayer;

import dataAccessLayer.LegalCustomer;
import utilty.OutputHtml;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by DotinSchool2 on 8/2/2016.
 */

public class CreateLegalCustomerServlet extends HttpServlet{

    protected void doPost(ServletRequest request, ServletResponse response) throws ServletException,IOException {
        request.setCharacterEncoding("UTF8");
        String companyName = request.getParameter("companyName");
        String dateOfRecognition = request.getParameter("dateOfRecognition");
        String economicCode = request.getParameter("economicCode");
        String customerNumber = request.getParameter("customerNumber");
        String outPut = "";

        LegalCustomer legalCustomer = LegalCustomer.CreateLegalCustomer(economicCode,companyName,dateOfRecognition, customerNumber);
        outPut = OutputHtml.generate(legalCustomer);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(outPut);
    }

    public void destroy()
    {
        // do nothing.
    }
}

