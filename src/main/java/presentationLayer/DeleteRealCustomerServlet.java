package presentationLayer;

import logicLayer.RealCustomerLogic;
import utilty.OutputHtml;
import logicLayer.CustomerLogic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by DotinSchool2 on 8/8/2016.
 */
public class DeleteRealCustomerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String customerNumber =request.getParameter("customerNumber");
        String outPut = "";

        RealCustomerLogic.deleteById(customerNumber);
        outPut = OutputHtml.generateSuccessfulDelete("عملیات حذف با موفقیت انجام شد.");

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(outPut);
    }

    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }*/
}
