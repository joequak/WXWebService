/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineXpressWebServices;

import entity.CustEnquiry;
import java.sql.Timestamp;
import java.util.Date;
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
public class CustSupportSB implements CustSupportSBLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //Entity Manager to read write to DB
    @PersistenceContext
    private EntityManager em;

    public CustSupportSB() {
    }
    @Override
    public boolean creatEnquiry(CustEnquiry enquiry){       
                
            CustEnquiry newEnquiry = new CustEnquiry();
            newEnquiry.setEmailAddress(enquiry.getEmailAddress());
            newEnquiry.setSubject(enquiry.getSubject());
            newEnquiry.setContent(enquiry.getContent());           
            //get current timestamp
            Date date=new Date();
             newEnquiry.setInDate(new Timestamp(date.getTime()));
            
            em.persist(newEnquiry);     
          
            return true;
    
    }
    
    @Override
    public List<CustEnquiry> getEnquiry() {
        Query query = em.createQuery("SELECT e FROM CustEnquiry e");
        return query.getResultList();
    }
    
    
}
