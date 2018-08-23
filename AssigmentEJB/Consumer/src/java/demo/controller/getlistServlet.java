/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
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
//@WebServlet(name = "getlistServlet", urlPatterns = {"/getlist"})
public class getlistServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_43912/EJBBankAssignment-war/UserWebService.wsdl")
    private UserWebService_Service service_1;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_43912/EJBBankAssignment-war/OrderWebService.wsdl")
    private OrderWebService_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        request.getRequestDispatcher("loginlist.jsp").forward(request, response);
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
        ArrayList<Order1> list = new ArrayList<>();
        String hiddenParam = request.getParameter("buttonsm");
        if (hiddenParam.equals("Submit User")) {
            int codeUser = Integer.parseInt(request.getParameter("codeUser"));
            int codePin = Integer.parseInt(request.getParameter("codePin"));
            if(checkUserKh(codeUser, codePin)!=null){
            String a = request.getParameter("tripstart");
            a += " 00:00:00";
            String b = request.getParameter("tripend");
            b += " 00:00:00";
            list = (ArrayList<Order1>) getListOrderbyUser(codeUser, a, b);
            }else{
                response.sendRedirect("404.jsp");
            }
            
        } else if (hiddenParam.equals("Submit charmer")) {
            int codedg = Integer.parseInt(request.getParameter("codedg"));
            int passdg = Integer.parseInt(request.getParameter("passdg"));
            if(checkUserCs(codedg, passdg)!=null){
            int codeUser = checkUserCs(codedg, passdg).getCodeuser();
            String a = request.getParameter("tripstart");
            a += " 00:00:00";
            String b = request.getParameter("tripend");
            b += " 00:00:00";
            list = (ArrayList<Order1>) getListOrderbyUser(codeUser, a, b);
            }else{
                response.sendRedirect("404.jsp");
            }
        }
        request.setAttribute("lists", list);
        request. getRequestDispatcher("listhistory.jsp").forward(request, response);
       //   response.getWriter().print(list);

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

    private java.util.List<service.Order1> getListOrderbyCustormer(int codeCustormer, java.lang.String start, java.lang.String end) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.OrderWebService port = service.getOrderWebServicePort();
        return port.getListOrderbyCustormer(codeCustormer, start, end);
    }

    private java.util.List<service.Order1> getListOrderbyUser(int codeUser, java.lang.String start, java.lang.String end) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.OrderWebService port = service.getOrderWebServicePort();
        return port.getListOrderbyUser(codeUser, start, end);
    }

    private User1 checkUserCs(int codeDG, int passDG) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        services.UserWebService port = service_1.getUserWebServicePort();
        return port.checkUserCs(codeDG, passDG);
    }

    private User1 checkUserKh(int codeUser, int codePin) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        services.UserWebService port = service_1.getUserWebServicePort();
        return port.checkUserKh(codeUser, codePin);
    }
    
    
}
