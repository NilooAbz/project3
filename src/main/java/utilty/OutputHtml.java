package utilty;

import dataAccessLayer.LegalCustomer;
import dataAccessLayer.RealCustomer;

import java.util.ArrayList;

/**
 * Created by DotinSchool2 on 8/6/2016.
 */
public class OutputHtml {

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
        stringBuilder.append("            <div class=main-box>");
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
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        return stringBuilder.toString();
    }

    public static String generate(LegalCustomer legalCustomer){
        StringBuilder stringBuilder = new StringBuilder();



        return stringBuilder.toString();
    }


    public static String generateSuccessful(String message){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>");
        stringBuilder.append("<html lang=fa>");
        stringBuilder.append("<head>");
        stringBuilder.append("    <meta charset=UTF-8>");
        stringBuilder.append("    <link href=css/Style.css rel=stylesheet>");
        stringBuilder.append("    <title>عملیات موفق</title>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<div class=title>");
        stringBuilder.append("    <h1>عملیات موفق</h1>");
        stringBuilder.append("</div>");
        stringBuilder.append("            <div class=main-box>");
        stringBuilder.append("                <br>");
        stringBuilder.append("                <br>");
        stringBuilder.append("                <p>" + message + "</p>");
        stringBuilder.append("<a href=searchRealCustomer.html class=form>بازگشت به صفحه قبل</a>");
        stringBuilder.append("            </div>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        return stringBuilder.toString();
    }
    public static String generateSuccessfulDelete(String message){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>");
        stringBuilder.append("<html lang=fa>");
        stringBuilder.append("<head>");
        stringBuilder.append("    <meta charset=UTF-8>");
        stringBuilder.append("    <link href=css/Style.css rel=stylesheet>");
        stringBuilder.append("    <title>عملیات موفق</title>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<div class=title>");
        stringBuilder.append("    <h1>عملیات موفق</h1>");
        stringBuilder.append("</div>");
        stringBuilder.append("            <div class=main-box>");
        stringBuilder.append("                <br>");
        stringBuilder.append("                <br>");
        stringBuilder.append("                <p>" + message + "</p>");
        stringBuilder.append("<a href=realCustomerManagement.html class=form>بازگشت به صفحه قبل</a>");
        stringBuilder.append("            </div>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        return stringBuilder.toString();
    }

    public static String generateRealCustomerResults(ArrayList<RealCustomer> realCustomers){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>");
        stringBuilder.append("<html lang=fa>");
        stringBuilder.append("<head>");
        stringBuilder.append("    <meta charset=UTF-8>");
        stringBuilder.append("    <link href=css/Style.css rel=stylesheet>");
        stringBuilder.append("    <title>جستجوی مشتری</title>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<div class=title>");
        stringBuilder.append("    <h1>جستجوی مشتری</h1>");
        stringBuilder.append("</div>");
        stringBuilder.append("            <div class=main-box>");
        stringBuilder.append("                <br>");
        stringBuilder.append("                <p>نتایج جستجو به شرح زیر است:</p>");
        stringBuilder.append("                <br>");
        stringBuilder.append("                    <table class=result-table>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td> نام </td>");
        stringBuilder.append("                            <td> نام خانوادگی</td>");
        stringBuilder.append("                            <td>نام پدر</td>");
        stringBuilder.append("                            <td>تاریخ تولد</td>");
        stringBuilder.append("                            <td>کد ملی</td>");
        stringBuilder.append("                            <td>شماره مشتری</td>");
        stringBuilder.append("                <br>");
        stringBuilder.append("                            <td>انجام عملیات</td>");
        stringBuilder.append("                        </tr>");
        for (RealCustomer realCustomer : realCustomers) {
            stringBuilder.append("                        <tr>");
            stringBuilder.append("                            <td>" + realCustomer.getFirstName() + "</td>");
            stringBuilder.append("                            <td>" + realCustomer.getLastName() + "</td>");
            stringBuilder.append("                            <td>" + realCustomer.getFatherName() + "</td>");
            stringBuilder.append("                            <td>" + realCustomer.getDateOfBirth() + "</td>");
            stringBuilder.append("                            <td>" + realCustomer.getNationalCode() + "</td>");
            stringBuilder.append("                            <td>" + realCustomer.getCustomerNumber() + "</td>");
            stringBuilder.append("                <br>");
            stringBuilder.append("                            <td><a href=DeleteRealCustomerServlet?id=" + realCustomer.getId() + " class=button type=>حذف</a>");
            stringBuilder.append("                            <a href=UpdateRealCustomerServlet?id=" + realCustomer.getId() + " class=button>اصلاح</a></td>");}
        stringBuilder.append("                    </table>");
        stringBuilder.append("                    <a href=searchRealCustomer.html class=form>بازگشت به صفحه قبل</a>");
        stringBuilder.append("            </div>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        return stringBuilder.toString();
    }

    public static String generateUpdatePage(RealCustomer realCustomer) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>");
        stringBuilder.append("<html lang=fa>");
        stringBuilder.append("<head>");
        stringBuilder.append("    <meta charset=UTF-8>");
        stringBuilder.append("    <link href=css/Style.css rel=stylesheet>");
        stringBuilder.append("    <title>اصلاح اطلاعات مشتری</title>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<div class=title>");
        stringBuilder.append("    <h1>اصلاح اطلاعات مشتری</h1>");
        stringBuilder.append("</div>");
        stringBuilder.append("            <div class=main-box>");
        stringBuilder.append("                <br>");
        stringBuilder.append("                 <form action='/SaveRealCustomerEditsServlet' method='post'>");
        //stringBuilder.append("                 <form>");
        stringBuilder.append("                <p>اطلاعات مشتری حقیقی :</p>");
        stringBuilder.append("                <br>");
        //stringBuilder.append("<input type='hidden' name='id' value='" + realCustomer.getId() + "'>");
        stringBuilder.append("                    <table>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td>شماره مشتری</td>");
        stringBuilder.append("                            <td><input type='text' name='customerNumber' value='" + realCustomer.getCustomerNumber() + "' readonly ></td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td> نام  </td>");
        stringBuilder.append("                            <td><input type='text' name='firstName' value='" + realCustomer.getFirstName() + "'></td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                            <td> نام خانوادگی  </td>");
        stringBuilder.append("                            <td><input type='text' name='lastName' value='" + realCustomer.getLastName() + "'></td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                            <td> نام پدر  </td>");
        stringBuilder.append("                            <td><input type='text' name='fatherName' value='" + realCustomer.getFatherName() + "'></td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td> تاریخ تولد</td>");
        stringBuilder.append("                            <td><input type='text' name='dateOfBirth' value='" + realCustomer.getDateOfBirth() + "'></td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td>کد ملی</td>");
        stringBuilder.append("                            <td><input type='text' name='nationalCode' value='" + realCustomer.getNationalCode() + "'></td>");
        stringBuilder.append("                        </tr>");
        //stringBuilder.append("                    <td><a href=SaveRealCustomerEditsServlet class=button> ذخیره تغییرات </a></td");
        stringBuilder.append("                    </table>");
        stringBuilder.append("                    <input type='submit' class='button' value='ذخیره تغییرات'>");

        stringBuilder.append("                    </form>");
//        stringBuilder.append("                    <a href=SaveRealCustomerEditsServlet type='submit' class=button> ذخیره تغییرات </a>");
        stringBuilder.append("            </div>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        return stringBuilder.toString();
    }

}

