/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RatingSessionBean;

import entity.Product;
import entity.Rate;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author wangyan  
 */
@Local
public interface RatingSessionBeanLocal {
     public long saveNewRate(String categoriesName);
     public List<Rate> searchRate(String categoriesName);
     public List<Rate> viewAllRate();
     public Rate deleteRate(long categoriesId);
     public void editRate(Rate newRate);
     public List<String> getCountries();
     
     public boolean rateProduct(Product product, Integer rateStar);
}

