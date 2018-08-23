/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.sessionbean;

import demo.entity.User1;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class User1Facade extends AbstractFacade<User1> implements User1FacadeLocal {

    @PersistenceContext(unitName = "EJBBankAssignment-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public User1Facade() {
        super(User1.class);
    }

    @Override
    public User1 checkUserCs(int codeDG, int passDG) {
         try {
             Query query = em.createQuery("SELECT u FROM User1 u WHERE u.codegd = :codegd AND u.passgd = :passgd");
             query.setParameter("codegd", codeDG);
             query.setParameter("passgd", passDG);
            return (User1) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public User1 checkUserKh(int codeUser, int CodePin) {
         try {
             Query query = em.createQuery("SELECT u FROM User1 u WHERE u.codeuser = :codeuser AND u.codepin = :codepin");
             query.setParameter("codeuser", codeUser);
             query.setParameter("codepin", CodePin);
            return (User1) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean editUserWithId(int id, int money) {
         if (findUserById(id)!=null) {
            User1 user = findUserById(id);
            int moneyUser =(int) (user.getMoneyuser().intValue() - money);
            user.setMoneyuser(moneyUser);
            return true;
            
        }
        return false;
    }

    @Override
    public User1 findUserById(int id) {
         try {
             Query query = em.createQuery("SELECT u FROM User1 u WHERE u.codeuser = :codeuser");
             query.setParameter("codeuser", id);
            return (User1) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    
}
