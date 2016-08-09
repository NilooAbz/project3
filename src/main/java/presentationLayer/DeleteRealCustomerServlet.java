package presentationLayer;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //Long id = Long.valueOf(request.getParameter("id"));
        String customerNumber =request.getParameter("customerNumber");
        String outPut = "";

        //RealCustomerLogic.deleteById(id);
        CustomerLogic.deleteById(customerNumber);
        outPut = OutputHtml.generateSuccessful("عملیات حذف با موفقیت انجام شد.");

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(outPut);
    }

    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }*/
}
