package presentationLayer;

import dataAccessLayer.LegalCustomer;
import dataAccessLayer.RealCustomer;
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
public class UpdateLegalCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Long id = Long.valueOf(request.getParameter("id"));
        String outPut = "";

        LegalCustomer legalCustomer = LegalCustomerLogic.retrieveLegalCustomerById(id);
        outPut = OutputHtml.generateLegalUpdatePage(legalCustomer);

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(outPut);
    }
}