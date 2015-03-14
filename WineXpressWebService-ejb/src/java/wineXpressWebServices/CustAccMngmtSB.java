/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineXpressWebServices;

import entity.Customer;
import entity.OrderDetail;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ¿.¿.¿
 */
@Stateless
public class CustAccMngmtSB implements CustAccMngmtSBLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //Entity Manager to read write to DB
    @PersistenceContext
    private EntityManager em;

    public CustAccMngmtSB() {
    }
    
    //Vistor Method
    @Override
    public boolean registerAsMember (Customer newCust) {
        //Initialise returnValue type.
        boolean returnValue = false;
        
        //Check if email is taken
        Query query = em.createQuery("SELECT c FROM Customer c WHERE c.email = :email").setParameter("email", newCust.getEmail());
        //If email address is valid, register customer to DB
        if (query.getResultList().isEmpty()) {
            Customer toRegist = new Customer();
            toRegist.setFistName(newCust.getFistName());
            toRegist.setLastName(newCust.getLastName());
            toRegist.setEmail(newCust.getEmail());
            toRegist.setPassword(newCust.getPassword());
            toRegist.setStatus(false);
            em.persist(toRegist);     
            returnValue = true;
        }
        
        return returnValue;
    }
    
    //Visitor Method
    @Override
    public boolean activateAccount (String emailAdd) {
        //Initialise returnValue type to return.
        boolean returnValue = false;
        
        //SQL query string to look if email is valid
        Query query = em.createQuery("SELECT c FROM Customer c WHERE c.email = :email").setParameter("email", emailAdd);
        //If email address is valid, find customer entity
        if (query.getResultList().size() == 1) {
            if (query.getResultList().get(0).getClass().equals(Customer.class)){
                Customer toActivate = (Customer) query.getResultList().get(0);
                toActivate.setStatus(true);
                em.persist(toActivate);
                /* Or Alternatively
                em.getTransaction().begin();
                toActivate.setStatus(true);
                em.getTransaction().commit(); */
                returnValue = true;
            }
        }
        
        return returnValue;
    }
    
    //Member Method
    @Override
    public long logInMember (String emailAdd, String password) {
        //Initialise returnValue type to return.
        long returnValue = -1;
        
        //SQL query string to look if email is valid
        Query query = em.createQuery("SELECT c FROM Customer c WHERE c.email = :email").setParameter("email", emailAdd);
        
        //If email address is valid
        if (query.getResultList().size() == 1) {
            if (query.getResultList().get(0).getClass().equals(Customer.class)){
                Customer toLogin = (Customer) query.getResultList().get(0);
                //Check account status
                if (toLogin.getStatus()) {
                    //Check if password match
                    if (toLogin.getPassword().equals(password)) {
                        returnValue = toLogin.getId();
                    }
                }
            }
        }
        
        return returnValue;
    }
    
    //Member Method

    /**
     *
     * @param custID
     * @return
     */
        @Override
    public boolean logOutMember (long custID) {
        //Initialise returnValue type to return.
        boolean returnValue = false;
        
        Customer tempCust = em.find(Customer.class, custID);
        if (tempCust != null) {
            returnValue = true;
        }
        
        return returnValue;
    }
    
    //Member Method

    /**
     *
     * @param custID
     * @return
     */
        @Override
    public Customer viewAccInfoMember (long custID) {
        //Initialise returnValue type to return.
        Customer returnValue = new Customer();
        
        //Find customer in DB
        Customer toFind = em.find(Customer.class, custID);
        if (toFind != null) {
            returnValue = toFind;
        }
        
        return returnValue;        
    }
    
    //Member Method

    /**
     *
     * @param custID
     * @param newCust
     * @return
     */
        @Override
    public boolean editParticularsMember (long custID, Customer newCust) {
        //Initialise returnValue type to return.
        boolean returnValue = false;
        
        //Find customer in DB
        Customer tempCust = em.find(Customer.class, custID);
        if (tempCust != null) {
            tempCust.setFistName(newCust.getFistName());
            tempCust.setLastName(newCust.getLastName()); 
            em.persist(tempCust);
            returnValue = true;
        }
        
        return returnValue;
    }
    
    //Member Method

    /**
     *
     * @param custID
     * @param oldPW
     * @param newPW
     * @return
     */
        @Override
    public boolean changePwMember (long custID, String oldPW, String newPW) {
        //Initialise returnValue type to return.
        boolean returnValue = false;
        
        //Find customer in DB
        Customer tempCust = em.find(Customer.class, custID);
        if (tempCust != null) {
            if (tempCust.getPassword().equals(oldPW)) {
                tempCust.setPassword(newPW);
                em.persist(tempCust);
                returnValue = true;
            }
        }
        
        return returnValue;
    }
        
    //Member Method

    /**
     *
     * @param custID
     * @return
     */
        @Override
    public List<OrderDetail> viewPurchaseHistoryMember (long custID) {
        //Initialise returnValue type to return.
        List<OrderDetail> returnValue = new ArrayList<OrderDetail>();
        
        //Find customer in DB
        Customer toFind = em.find(Customer.class, custID);
        if (toFind != null) {
            returnValue = (List<OrderDetail>) toFind.getOrderDetailCollection();
        }

        return returnValue;
    }
    
    /**
     *
     * @param emailAdd
     * @param rstPW
     * @return
     */
    @Override
    public boolean resetPwMember (String emailAdd, String rstPW) {
        //Initialise returnValue type to return.
        boolean returnValue = false;
        
        //SQL query string to look if email is valid
        Query query = em.createQuery("SELECT c FROM Customer c WHERE c.email = :email").setParameter("email", emailAdd);
        //If email address is valid, find customer entity
        if (query.getResultList().size() == 1) {
            if (query.getResultList().get(0).getClass().equals(Customer.class)){
                Customer toRestPW = (Customer) query.getResultList().get(0);
                toRestPW.setPassword(rstPW);
                em.persist(toRestPW);
                /* Or Alternatively
                em.getTransaction().begin();
                toActivate.setStatus(true);
                em.getTransaction().commit(); */
                returnValue = true;
            }
        }
        
        return returnValue;
    }
    
}
