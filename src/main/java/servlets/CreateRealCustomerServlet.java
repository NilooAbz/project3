package servlets;

import dataAccessLayer.Customer;
import dataAccessLayer.RealCustomer;

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
public class CreateRealCustomerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String fatherName = request.getParameter("fatherName");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String nationalCode = request.getParameter("nationalCode");

        RealCustomer realCustomer = RealCustomer.CreateRealCustomer(nationalCode,firstName,lastName,fatherName,dateOfBirth);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("");
    }


}