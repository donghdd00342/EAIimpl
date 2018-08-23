/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.sessionbean;

import demo.entity.Order1;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class Order1Facade extends AbstractFacade<Order1> implements Order1FacadeLocal {

    @PersistenceContext(unitName = "EJBBankAssignment-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Order1Facade() {
        super(Order1.class);
    }

    @Override
    public int calutorFee(int moneyOrder) {
        if(moneyOrder >5000000){
            return (int) (moneyOrder*0.005);
        }else if(moneyOrder>1000000){
            return (int) (moneyOrder*0.01);
        }else if(moneyOrder>500000){
            return (int) (moneyOrder*0.015);
        }else if(moneyOrder>100000){
            return (int) (moneyOrder*0.02);
        }else {
            return 10000;
        }  
    }

    @Override
    public List<Order1> getListOrderbyUser(int codeUser, String start, String end) {
        try {
             Query query = em.createQuery("SELECT o FROM Order1 o WHERE o.codeuser = :codeuser "
                     + "AND o.dateorder BETWEEN :dateStart AND  :endStart ");
             query.setParameter("codeuser", codeUser);
             query.setParameter("dateStart", Timestamp.valueOf(start));
             query.setParameter("endStart", Timestamp.valueOf(end));
            return  (List<Order1>) query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Order1> getListOrderbyCustormer(int codeCustormer, String start, String end) {
        try {
             Query query = em.createQuery("SELECT o FROM Order1 o WHERE o.codecustomer = :codeCustormer "
                     + "AND o.dateorder BETWEEN :dateStart AND  :endStart ");
             query.setParameter("codeCustormer", codeCustormer);
             query.setParameter("dateStart", Timestamp.valueOf(start));
             query.setParameter("endStart", Timestamp.valueOf(end));
            return  (List<Order1>) query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

  
    
}
