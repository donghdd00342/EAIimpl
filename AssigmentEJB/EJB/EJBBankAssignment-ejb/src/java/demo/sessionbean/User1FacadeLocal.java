/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.sessionbean;

import demo.entity.User1;
import java.util.List;
import javax.ejb.Local;

@Local
public interface User1FacadeLocal {

    void create(User1 user1);

    void edit(User1 user1);

    void remove(User1 user1);

    User1 find(Object id);

    List<User1> findAll();

    List<User1> findRange(int[] range);

    int count();
    
    User1 checkUserCs(int codeDG, int passDG);
    User1 checkUserKh(int codeUser, int CodePin);
    User1 findUserById(int id);
    boolean editUserWithId(int id,int money);
  
    
}
