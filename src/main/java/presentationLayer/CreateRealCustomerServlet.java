package presentationLayer;

import dataAccessLayer.RealCustomer;
import exceptions.AssignCustomerNumberException;
import exceptions.DatabaseConnectionException;
import exceptions.EmptyFieldException;
import exceptions.NotExistNationalCodeException;
import logicLayer.RealCustomerLogic;
import utilty.OutputHtml;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by DotinSchool2 on 8/2/2016.
 */
public class CreateRealCustomerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String fatherName = request.getParameter("fatherName");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String nationalCode = request.getParameter("nationalCode");
        String outPut = "";


        RealCustomer realCustomer = null;
        try {
            realCustomer = RealCustomerLogic.CreateRealCustomer(nationalCode, firstName, lastName, fatherName, dateOfBirth);
            outPut = OutputHtml.generate(realCustomer);

        } catch (NotExistNationalCodeException e) {
            outPut = OutputHtml.createExceptionMessage(e.getMessage());
        } catch (EmptyFieldException e) {
            outPut = OutputHtml.createExceptionMessage(e.getMessage());
        } catch (DatabaseConnectionException e) {
            outPut = OutputHtml.createExceptionMessage(e.getMessage());
        } catch (AssignCustomerNumberException e) {
            outPut = OutputHtml.createExceptionMessage(e.getMessage());
        }

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(outPut);
    }


}