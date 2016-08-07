package lateralRequiredFile;

import dataAccessLayer.LegalCustomer;
import dataAccessLayer.RealCustomer;

/**
 * Created by DotinSchool2 on 8/6/2016.
 */
public class OutputGenerator {

    public static String generate(RealCustomer realCustomer) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>");
        stringBuilder.append("<html lang=fa>");
        stringBuilder.append("<head>");
        stringBuilder.append("    <meta charset=UTF-8>");
        stringBuilder.append("    <link href=css/Style.css rel=stylesheet>");
        stringBuilder.append("    <title>اطلاعات مشتری جدید</title>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<div class=title>");
        stringBuilder.append("    <h1>اطلاعات مشتری جدید</h1>");
        stringBuilder.append("</div>");
        stringBuilder.append("<div id=wrapper>");
        stringBuilder.append("    <div class=content>");
        stringBuilder.append("        <div class=box>");
        stringBuilder.append("            <div class=box-top></div>");
        stringBuilder.append("            <div class=box-in>");
        stringBuilder.append("                <br>");
        stringBuilder.append("                <p>اطلاعات زیر برای مشتری جدید ثبت شد</p>");
        stringBuilder.append("                <br>");
        stringBuilder.append("                    <table>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td> نام </td>");
        stringBuilder.append("                            <td>" + realCustomer.getFirstName() + "</td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td> نام خانوادگی</td>");
        stringBuilder.append("                            <td>" + realCustomer.getLastName() + "</td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td>نام پدر</td>");
        stringBuilder.append("                            <td>" + realCustomer.getFatherName() + "</td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td>تاریخ تولد</td>");
        stringBuilder.append("                            <td>" + realCustomer.getDateOfBirth() + "</td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td>کد ملی</td>");
        stringBuilder.append("                            <td>" + realCustomer.getNationalCode() + "</td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td>شماره مشتری</td>");
        stringBuilder.append("                            <td>" + realCustomer.getCustomerNumber() + "</td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                    </table>");
        stringBuilder.append("                    <a href=realCustomerManagement.html class=form>بازگشت به صفحه قبل</a>");
        stringBuilder.append("            </div>");
        stringBuilder.append("            <div class=box-bottom></div>");
        stringBuilder.append("        </div>");
        stringBuilder.append("        <div class=cleaner>&nbsp</div>");
        stringBuilder.append("    </div>");
        stringBuilder.append("</div>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        return stringBuilder.toString();
    }

    public static String generate(LegalCustomer legalCustomer){
        StringBuilder stringBuilder = new StringBuilder();



        return stringBuilder.toString();
    }
}
