/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineXpressWebServices;

import entity.Comment;
import entity.Customer;
import entity.Product;
import entity.Rate;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ¿.¿.¿
 */
@Stateless
public class ContentMngmtSB implements ContentMngmtSBLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    //Entity Manager to read write to DB
    @PersistenceContext
    private EntityManager em;

    public ContentMngmtSB() {
    }

    @Override
    public void rateProduct(Customer cus, Product myProduct, int myRate) {
        Rate newRate = new Rate();
        newRate.setCustomer(cus);
        newRate.setProduct(myProduct);
        newRate.setRate(myRate);
        em.persist(newRate);
        cus.getRateCollection().add(newRate);
        em.merge(cus);
        int numOfRates = myProduct.getRateCollection().size();
        double totalRates = myProduct.getAverageRate() * numOfRates;
        myProduct.getRateCollection().add(newRate);
        double newAver = (totalRates + myRate) / (numOfRates + 1);
        myProduct.setAverageRate(newAver);
        em.merge(myProduct);
        em.flush();
    }

    @Override
    public void makeComment(Product myProduct, String newComment, Customer cus) {
        Comment newCom = new Comment();
        newCom.setComment(newComment);
        newCom.setCustomer(cus);
        newCom.setProduct(myProduct);
        newCom.setStatus(true);
        em.persist(newCom);
        myProduct.getCommentCollection().add(newCom);
        cus.getCommentCollection().add(newCom);
        em.merge(myProduct);
        em.merge(cus);

    }

    @Override
    public void deleteComment(Comment myComment) {
        myComment.setStatus(false);
        em.merge(myComment);
    }
    

}
