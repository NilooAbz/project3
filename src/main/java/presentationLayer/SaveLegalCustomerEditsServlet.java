package presentationLayer;

import exceptions.DatabaseConnectionException;
import exceptions.EmptyFieldException;
import exceptions.NotExistNationalCodeException;
import logicLayer.LegalCustomerLogic;
import logicLayer.RealCustomerLogic;
import utilty.OutputHtml;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by DotinSchool2 on 8/10/2016.
 */
public class SaveLegalCustomerEditsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String customerNumber = request.getParameter("customerNumber");
        String companyName = request.getParameter("companyName");
        String economicCode = request.getParameter("economicCode");
        String dateOfRegistration = request.getParameter("dateOfRegistration");

        String outPut = "";

        try {
            LegalCustomerLogic.updateCustomer( customerNumber, companyName, economicCode, dateOfRegistration);
            outPut = OutputHtml.generateLegalSuccessful("اطلاعات مشتری با موفقیت اصلاح شد.");
        } catch (DatabaseConnectionException e) {
            outPut = OutputHtml.updateLegalExceptionMessage(e.getMessage());
        } catch (EmptyFieldException e) {
            outPut = OutputHtml.updateLegalExceptionMessage(e.getMessage());
        } catch (NotExistNationalCodeException e) {
            outPut = OutputHtml.updateLegalExceptionMessage(e.getMessage());
        }


        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(outPut);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
