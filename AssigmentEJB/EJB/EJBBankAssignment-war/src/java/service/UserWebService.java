/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import demo.entity.User1;
import demo.sessionbean.User1FacadeLocal;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "UserWebService")
public class UserWebService {

    @EJB
    private User1FacadeLocal user1Facade;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "checkUserCs")
    public User1 checkUserCs(@WebParam(name = "codeDG")int codeDG,@WebParam(name = "passDG") int passDG) {
        return user1Facade.checkUserCs(codeDG, passDG);
    }
    @WebMethod(operationName = "checkUserKh")
    public User1 checkUserKh(@WebParam(name = "CodeUser")int codeUser,@WebParam(name = "CodePin") int codePin) {
        return user1Facade.checkUserKh(codeUser, codePin);
    }
    @WebMethod(operationName = "editUser")
    public void editUser(@WebParam(name = "user") User1 user) {
        user1Facade.edit(user);
    }
    @WebMethod(operationName = "editUserWithId")
   public boolean editUserWithId(@WebParam(name = "codeUser")int id, @WebParam(name = "moneyOrder")int money) {
        return user1Facade.editUserWithId(id, money);
    }

}
