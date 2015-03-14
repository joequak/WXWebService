/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineXpressWebServices;

import entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author wangyan
 */
@Stateless
public class ProductSessionBean implements ProductSessionBeanLocal {
    
    @PersistenceContext
    private EntityManager em;
    
    public ProductSessionBean() {
    }
    
    @Override
    public long saveNewProduct(String productName, double productPrice, double productCost, String productDescription, int productAQ, int productDiscount) {
        Product product = new Product();
        product.setName(productName);
        product.setPrice(productPrice);
        product.setCost(productCost);
        product.setDescription(productDescription);
        product.setAvailableQuantity(productAQ);
        product.setSoldQuantity(0);
        product.setAverageRate(0);
        product.setDiscount(productDiscount);
        product.setNumberOfRate(0);
        em.persist(product);
        return product.getId();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<Product> searchProduct(String productName) {
        Query query = em.createQuery("select p from Product p where p.name = :pName");
        query.setParameter("pName", productName);
        return query.getResultList();
    }
    
    @Override
    public List<Product> viewAllProducts() {
        Query query = em.createQuery("select p from Product p");
        return query.getResultList();
    }
    
    @Override
    public Product deleteProduct(long productId) {
        System.out.println("productSessionBean");
        Product product = em.find(Product.class, productId);
        em.remove(product);
        em.flush();
        return product;
    }
    
    @Override
    public void editProduct(Product newProduct) {
        Product origin = em.find(Product.class, newProduct.getId());
        origin.setName(newProduct.getName());
        origin.setPrice(newProduct.getPrice());
        origin.setCost(newProduct.getCost());
        origin.setAvailableQuantity(newProduct.getAvailableQuantity());
        origin.setDescription(newProduct.getDescription());
        origin.setDiscount(newProduct.getDiscount());
        em.persist(origin);
        
    }
}
