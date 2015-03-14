/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineXpressWebServices;

import entity.AdminUsr;
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
public class AdminAccMngmtSB implements AdminAccMngmtSBLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //Entity Manager to read write to DB
    @PersistenceContext
    private EntityManager em;

    public AdminAccMngmtSB() {
    }
    
    //Admin Method

    /**
     *
     * @param emailAdd
     * @param password
     * @return
     */
        @Override
    public long logInAdmin (String emailAdd, String password) {
        //Initialise returnValue type to return.
        long returnValue = -1;
        
        //SQL query string to look if email is valid
        Query query = em.createQuery("SELECT a FROM AdminUsr a WHERE a.email = :email").setParameter("email", emailAdd);
        
        //If email address is valid
        if (query.getResultList().size() == 1) {
            if (query.getResultList().get(0).getClass().equals(AdminUsr.class)){
                AdminUsr toLogin = (AdminUsr) query.getResultList().get(0);
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
    
    //Admin Method
    @Override
    public boolean logOutAdmin (long adminID) {
        //Initialise returnValue type to return.
        boolean returnValue = false;
        
         //Find Admin in DB
        AdminUsr tempAdmin = em.find(AdminUsr.class, adminID);
        if (tempAdmin != null) {
            returnValue = true;
        }
        
        return returnValue;
    }
    
    //Admin Method

    /**
     *
     * @param adminID
     * @return
     */
        @Override
    public AdminUsr viewAccInfoAdmin (long adminID) {
        //Initialise returnValue type to return.
        AdminUsr returnValue = new AdminUsr();
        
        //Find Admin in DB
        AdminUsr toFind = em.find(AdminUsr.class, adminID);
        if (toFind != null) {
            returnValue = toFind;
        }
        
        return returnValue;         
    }
    
    //Admin Method

    /**
     *
     * @param adminID
     * @param newAdminUsr
     * @return
     */
        @Override
    public boolean editParticularsAdmin (long adminID, AdminUsr newAdminUsr) {
        //Initialise returnValue type to return.
        boolean returnValue = false;
        
        //Find Admin in DB
        AdminUsr tempAdmin = em.find(AdminUsr.class, adminID);
        if (tempAdmin != null) {
            tempAdmin.setFirstName(newAdminUsr.getFirstName());
            tempAdmin.setLastName(newAdminUsr.getLastName()); 
            em.persist(tempAdmin);
            returnValue = true;
        }
        
        return returnValue;
    }
    
    //Admin Method
    @Override
    public boolean changePwAdmin (long adminID, String oldPW, String newPW) {
        //Initialise returnValue type to return.
        boolean returnValue = false;
        
        //Find Admin in DB
        AdminUsr tempAdmin = em.find(AdminUsr.class, adminID);
        if (tempAdmin != null) {
            if (tempAdmin.getPassword().equals(oldPW)) {
                tempAdmin.setPassword(newPW);
                em.persist(tempAdmin);
                returnValue = true;
            }
        }
        
        return returnValue;
    }
    
    //Admin Method

    /**
     *
     * @param adminID
     * @return
     */
        @Override
    public boolean cancelAccount (long adminID) {
        //Initialise returnValue type to return.
        boolean returnValue = false;
        
        //Find Admin in DB
        AdminUsr toCancel = em.find(AdminUsr.class, adminID);
        if (toCancel != null) {
            toCancel.setStatus(false);
            em.persist(toCancel);
            returnValue = true;
        }
        
        return returnValue;
    }
    
    //Admin Method

    /**
     *
     * @param adminID
     * @return
     */
        @Override
    public List<Customer> getAllCust (long adminID) {
        //Initialise returnValue type to return.
        List<Customer> returnValue = new ArrayList<Customer>();
        
        //Find Admin in DB
        AdminUsr tempAdmin = em.find(AdminUsr.class, adminID);
        if (tempAdmin != null) {
            //SQL query string to get all customers
            Query query = em.createQuery("SELECT c FROM Customer c");
            for (Object o : query.getResultList()) {
                Customer cust = (Customer) o;
                returnValue.add(cust);
            }
        }
        
        return returnValue;
    }
    
    //Admin Method

    /**
     *
     * @param adminID
     * @param custID
     * @return
     */
        @Override
    public boolean blockCust (long adminID, long custID) {
        //Initialise returnValue type to return.
        boolean returnValue = false;
        
        //Find Admin in DB
        AdminUsr tempAdmin = em.find(AdminUsr.class, adminID);
        if (tempAdmin != null) {
            Customer tempCust = em.find(Customer.class, custID);
            if (tempCust != null) {
                tempCust.setStatus(false);
                em.persist(tempCust);
                returnValue = true;
            }
        }
        
        return returnValue;
    }
    
    //Admin Method

    /**
     *
     * @param adminID
     * @param custID
     * @return
     */
        @Override
    public List<OrderDetail> viewPurchaseHistoryAdmin (long adminID, long custID) {
        //Initialise returnValue type to return.
        List<OrderDetail> returnValue = new ArrayList<OrderDetail>();
        
        //Find Admin in DB
        AdminUsr tempAdmin = em.find(AdminUsr.class, adminID);
        if (tempAdmin != null) {
            Customer tempCust = em.find(Customer.class, custID);
            if (tempCust != null) {
                returnValue = (List<OrderDetail>) tempCust.getOrderDetailCollection();
            }
        }

        return returnValue;
    }
    
    /**
     *
     * @param newAdminUsr
     * @return
     */
    @Override
    public boolean createAdmin (AdminUsr newAdminUsr) {
        //Initialise returnValue type.
        boolean returnValue = false;
        
        //Check if email is taken
        Query query = em.createQuery("SELECT a FROM AdminUsr a WHERE a.email = :email").setParameter("email", newAdminUsr.getEmail());
        //If email address is valid, register customer to DB
        if (query.getResultList().isEmpty()) {
            AdminUsr toCreate = new AdminUsr();
            toCreate.setFirstName(newAdminUsr.getFirstName());
            toCreate.setLastName(newAdminUsr.getLastName());
            toCreate.setEmail(newAdminUsr.getEmail());
            toCreate.setPassword(newAdminUsr.getPassword());
            toCreate.setStatus(true);
            em.persist(toCreate);     
            returnValue = true;
        }
        
        return returnValue;
    }
    
    /**
     *
     * @param emailAdd
     * @return
     */
    @Override
    public boolean reActivateAdmin(String emailAdd) {
        //Initialise returnValue type to return.
        boolean returnValue = false;
        
        //SQL query string to look if email is valid
        Query query = em.createQuery("SELECT a FROM AdminUsr a WHERE a.email = :email").setParameter("email", emailAdd);
        //If email address is valid, find customer entity
        if (query.getResultList().size() == 1) {
            if (query.getResultList().get(0).getClass().equals(AdminUsr.class)){
                AdminUsr toActivate = (AdminUsr) query.getResultList().get(0);
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
    
    /**
     *
     * @param emailAdd
     * @param rstPW
     * @return
     */
    @Override
    public boolean resetPwAdmin (String emailAdd, String rstPW) {
         //Initialise returnValue type to return.
        boolean returnValue = false;
        
        //SQL query string to look if email is valid
        Query query = em.createQuery("SELECT a FROM AdminUsr a WHERE a.email = :email").setParameter("email", emailAdd);
        //If email address is valid, find customer entity
        if (query.getResultList().size() == 1) {
            if (query.getResultList().get(0).getClass().equals(AdminUsr.class)){
                AdminUsr toRestPW = (AdminUsr) query.getResultList().get(0);
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
