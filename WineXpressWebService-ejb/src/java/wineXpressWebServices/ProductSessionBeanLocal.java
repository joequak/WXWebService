/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wineXpressWebServices;

import entity.Product;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author wangyan  
 */
@Local
public interface ProductSessionBeanLocal {
     public long saveNewProduct(String productName,double productPrice,double productCost,String productDescription,int productAQ,int productDiscount);
     public List<Product> searchProduct(String productName);
     public List<Product> viewAllProducts();
     public Product deleteProduct(long productId);
     public void editProduct(Product newProduct);
}

