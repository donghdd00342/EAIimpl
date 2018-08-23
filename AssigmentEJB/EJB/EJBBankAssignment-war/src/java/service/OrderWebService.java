/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import demo.entity.Order1;
import demo.sessionbean.Order1FacadeLocal;
import demo.sessionbean.User1FacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "OrderWebService")
public class OrderWebService {


    @EJB
    private Order1FacadeLocal ejbRef;

// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "order1") Order1 order1) {
        ejbRef.create(order1);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "order1") Order1 order1) {
        ejbRef.edit(order1);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "order1") Order1 order1) {
        ejbRef.remove(order1);
    }

    @WebMethod(operationName = "find")
    public Order1 find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Order1> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Order1> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "calutorFee")
    public int calutorFee(@WebParam(name = "moneyOrder") int moneyOrder) {
        return ejbRef.calutorFee(moneyOrder);
    }
    @WebMethod(operationName = "getListOrderbyUser")
    public List<Order1> getListOrderbyUser(@WebParam(name = "codeUser")int codeUser,
            @WebParam(name = "start")String start,
            @WebParam(name = "end")String end){
        return ejbRef.getListOrderbyUser(codeUser, start, end);
    }
    @WebMethod(operationName = "getListOrderbyCustormer")
    public List<Order1> getListOrderbyCustormer(@WebParam(name = "codeCustormer")int codeCustormer,
            @WebParam(name = "start")String start,
            @WebParam(name = "end")String end){
        return ejbRef.getListOrderbyCustormer(codeCustormer, start, end);
    }
    
}
