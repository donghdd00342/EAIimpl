/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import services.User1;
import services.UserWebService;
import services.UserWebService_Service;

/**
 *
 * @author quang
 */
@WebServlet(name = "demojsp", urlPatterns = {"/demojsp"})
public class demojsp extends HttpServlet {

//    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_43912/EJBBankAssignment-war/UserWebService.wsdl")
//    private UserWebService_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet demojsp</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet demojsp at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
        UserWebService_Service service_Service = new UserWebService_Service();
        UserWebService services = service_Service.getUserWebServicePort();
       int codedg = Integer.parseInt(request.getParameter("codedg"));
       int passdg = Integer.parseInt(request.getParameter("passdg"));
        if (services.checkUserCs(codedg, passdg)!=null) {
            User1 user = (User1) services.checkUserCs(codedg, passdg);
            HttpSession session = request.getSession();
            session.setAttribute("codeCustormer",user.getCodeuser());
            request.getRequestDispatcher("orderPage.jsp").forward(request, response);
        }else{
            response.sendRedirect("404.jsp");
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

//    private User1 checkUser(int codeDG, int passDG) {
//        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
//        // If the calling of port operations may lead to race condition some synchronization is required.
//        services.UserWebService port = service.getUserWebServicePort();
//        return port.checkUser(codeDG, passDG);
//    }

}
