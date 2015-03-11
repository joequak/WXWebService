/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RatingSessionBean;

import entity.Product;
import entity.Rate;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author user
 */
@Stateless
public class RatingSessionBean implements RatingSessionBeanLocal {

    @PersistenceContext
    private EntityManager em;
    
    
    
    @Override
    public long saveNewRate(String categoriesName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rate> searchRate(String categoriesName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rate> viewAllRate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rate deleteRate(long categoriesId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editRate(Rate newRate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getCountries() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public boolean rateProduct(Product product, Integer rateStar) {
       Product p = em.find(Product.class, product.getId());
       Rate r = new Rate();
       r.setRate(rateStar);
       r.setProduct(p);
       em.persist(r);
     //r.setCustomer(null);
       p.getRateCollection().add(r);
       em.persist(p);
       return true;//successfully rate the product
    }
}
