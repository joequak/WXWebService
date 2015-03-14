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
import java.util.Random;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import manager.EmailManager;

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
    public boolean creatEnquiry(CustEnquiry enquiry) {

        CustEnquiry newEnquiry = new CustEnquiry();
        newEnquiry.setEmailAddress(enquiry.getEmailAddress());
        newEnquiry.setSubject(enquiry.getSubject());
        newEnquiry.setContent(enquiry.getContent());
        newEnquiry.setReply("0");
        //get current timestamp
        Date date = new Date();
        newEnquiry.setInDate(new Timestamp(date.getTime()));

        em.persist(newEnquiry);

        return true;

    }

    @Override
    public List<CustEnquiry> getNewEnquiry() {

        Query query = em.createQuery("SELECT e FROM CustEnquiry e WHERE e.reply = :out").setParameter("out", "0");

        return query.getResultList();
    }

    @Override
    public boolean sendResponse(Long id, String response) {

        CustEnquiry enquiry = em.find(CustEnquiry.class, id);

        Date date = new Date();
        enquiry.setOutDate(new Timestamp(date.getTime()));

        enquiry.setReply(response);

        em.merge(enquiry);

        String emailAddress = enquiry.getEmailAddress();
        emailAddress = "Yan Ruoxi<" + emailAddress + ">";

        EmailManager emailManager = new EmailManager();
        String subject = "Reply to Enquiry- Wine Xpress";
        String content = "Hello " + enquiry.getEmailAddress() + " :\n \n" + "This email is resgarding your enquiry with the following content : \n \n" + " " + enquiry.getContent() + "\n\n We sincerely thank you for your help. Our response is as follow : \n\n" + " " + enquiry.getReply() + "\n\n Thanks & Regards\n Wine Express";
        emailManager.sendResponse(emailAddress, subject, content);

        return true;
    }

    @Override
    public boolean sendEmail(String emailAddress, String subject, String content) {
        EmailManager emailManager = new EmailManager();
        emailManager.sendResponse(emailAddress, subject, content);

        return true;

    }

    @Override
    public String generatePassword() {
        Random random = new Random();

        Integer value = random.nextInt(50000000);
        String password = value.toString();

        return password;
    }

}
