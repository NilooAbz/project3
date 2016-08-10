package presentationLayer;

import exceptions.DatabaseConnectionException;
import exceptions.DuplicateDataException;
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
 * Created by DotinSchool2 on 8/9/2016.
 */
public class SaveRealCustomerEditsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //Long id = Long.valueOf(request.getParameter("id"));
        String customerNumber = request.getParameter("customerNumber");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String fatherName = request.getParameter("fatherName");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String nationalCode = request.getParameter("nationalCode");
        String outPut = "";

        try {
            RealCustomerLogic.updateCustomer( customerNumber.trim(), firstName.trim(), lastName.trim(), fatherName.trim(), dateOfBirth.trim(), nationalCode.trim());
            outPut = OutputHtml.generateRealSuccessful("اطلاعات مشتری با موفقیت اصلاح شد.");
        } catch (DatabaseConnectionException e) {
            outPut = OutputHtml.updateRealExceptionMessage(e.getMessage());
        } catch (EmptyFieldException e) {
            outPut = OutputHtml.updateRealExceptionMessage(e.getMessage());
        } catch (NotExistNationalCodeException e) {
            outPut = OutputHtml.updateRealExceptionMessage(e.getMessage());
        } catch (DuplicateDataException e) {
            outPut = OutputHtml.updateRealExceptionMessage(e.getMessage());        }


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
