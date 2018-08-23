/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import service.Order1;
import service.OrderWebService_Service;
import services.User1;
import services.UserWebService_Service;

/**
 *
 * @author quang
 */
//@WebServlet(name = "orderServlet", urlPatterns = {"/orderServlet"})
public class orderServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_43912/EJBBankAssignment-war/UserWebService.wsdl")
    private UserWebService_Service service_1;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_43912/EJBBankAssignment-war/OrderWebService.wsdl")
    private OrderWebService_Service service;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("orderPage.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codeOrder = Integer.valueOf(request.getParameter("codeOrder"));
        String nameOrder = request.getParameter("nameOrder");
        int moneyOrder = Integer.valueOf(request.getParameter("moneyOrder"));
        int codeCustomer = Integer.valueOf(request.getParameter("codeCustomer"));
        int codeUser = Integer.valueOf(request.getParameter("codeUser"));
        int codePin = Integer.valueOf(request.getParameter("codePin"));
         Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        if (checkUserKh(codeUser, codePin) != null) {
            int fee = calutorFee(moneyOrder);
            Order1 order = new Order1();
            order.setCodeorder(codeOrder);
            order.setCodecustomer(codeCustomer);
            order.setCodeuser(codeUser);
            order.setFeeorder(calutorFee(moneyOrder));
            order.setMoneyorder(moneyOrder);
            order.setNameorder(nameOrder);
            order.setDateorder(date);
            create(order);
            int moneyOrdercs;
            int moneyOrderKh;
            if(nameOrder.equals("0")){
                moneyOrderKh = moneyOrder +fee;
                moneyOrdercs = moneyOrder;
            }else{
                moneyOrderKh = moneyOrder;
                moneyOrdercs = moneyOrder -fee;
            }
            if(editUserWithId(codeUser,moneyOrderKh)&&editUserWithId(codeCustomer, -moneyOrdercs)){
                response.sendRedirect("success.jsp");
            }else{
                return;
            }
            
        } else {
            //return;
            response.sendRedirect("orderPage.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private User1 checkUserKh(int codeUser, int codePin) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        services.UserWebService port = service_1.getUserWebServicePort();
        return port.checkUserKh(codeUser, codePin);
    }

    private void create(service.Order1 order1) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.OrderWebService port = service.getOrderWebServicePort();
        port.create(order1);
    }

    private int calutorFee(int moneyOrder) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.OrderWebService port = service.getOrderWebServicePort();
        return port.calutorFee(moneyOrder);
    }

    private boolean editUserWithId(int codeUser, int moneyOrder) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        services.UserWebService port = service_1.getUserWebServicePort();
        return port.editUserWithId(codeUser, moneyOrder);
    }

}
