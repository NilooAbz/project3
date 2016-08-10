package presentationLayer;

import dataAccessLayer.LegalCustomer;
import exceptions.*;
import logicLayer.LegalCustomerLogic;
import utilty.OutputHtml;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by DotinSchool2 on 8/2/2016.
 */

public class CreateLegalCustomerServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        String companyName = request.getParameter("companyName");
        String dateOfRegistration = request.getParameter("dateOfRegistration");
        String economicCode = request.getParameter("economicCode");
        String outPut = "";

        LegalCustomer legalCustomer = null;
        try {
            legalCustomer = LegalCustomerLogic.CreateLegalCustomer(economicCode, companyName, dateOfRegistration);
            outPut = OutputHtml.generate(legalCustomer);

        } catch (AssignCustomerNumberException e) {
            outPut = OutputHtml.createLegalExceptionMessage(e.getMessage());
        } catch (EmptyFieldException e) {
            outPut = OutputHtml.createLegalExceptionMessage(e.getMessage());
        } catch (NotExistNationalCodeException e) {
            outPut = OutputHtml.createLegalExceptionMessage(e.getMessage());
        } catch (DatabaseConnectionException e) {
            outPut = OutputHtml.createLegalExceptionMessage(e.getMessage());
        } catch (DuplicateDataException e) {
            outPut = OutputHtml.createLegalExceptionMessage(e.getMessage());
        }

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(outPut);
    }
}

