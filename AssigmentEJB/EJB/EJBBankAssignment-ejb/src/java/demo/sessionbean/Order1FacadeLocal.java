/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.sessionbean;

import demo.entity.Order1;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

@Local
public interface Order1FacadeLocal {

    void create(Order1 order1);

    void edit(Order1 order1);

    void remove(Order1 order1);

    Order1 find(Object id);

    List<Order1> findAll();

    List<Order1> findRange(int[] range);

    int count();
    
    int calutorFee(int moneyOrder);
    List<Order1> getListOrderbyUser(int codeUser,String start,String end);
    List<Order1> getListOrderbyCustormer(int codeCustormer,String start,String end);
}
