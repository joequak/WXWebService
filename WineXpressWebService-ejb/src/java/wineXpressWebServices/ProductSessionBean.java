/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineXpressWebServices;

import entity.Categories;
import entity.Comment;
import entity.Customer;
import entity.Product;
import entity.Rate;
import entity.SubCategories;
import java.util.ArrayList;
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
    public void dataBaseInit() {
        Categories newCat = new Categories();
        newCat.setName("Origin");
        em.persist(newCat);

        SubCategories newSub1 = new SubCategories();
        newSub1.setName("France");
        newSub1.setProductCollection(new ArrayList());
        em.persist(newSub1);
        SubCategories newSub2 = new SubCategories();
        newSub2.setName("Italy");
        newSub2.setProductCollection(new ArrayList());
        em.persist(newSub2);
        SubCategories newSub3 = new SubCategories();
        newSub3.setName("Australia");
        newSub3.setProductCollection(new ArrayList());
        em.persist(newSub3);
        SubCategories newSub4 = new SubCategories();
        newSub4.setName("Grace");
        newSub4.setProductCollection(new ArrayList());
        em.persist(newSub4);

        newCat.getSubCategoriesCollection().add(newSub1);
        newCat.getSubCategoriesCollection().add(newSub2);
        newCat.getSubCategoriesCollection().add(newSub3);
        newCat.getSubCategoriesCollection().add(newSub4);
        em.merge(newCat);

        Product newPro = new Product();
        newPro.setAvailableQuantity(134);
        newPro.setAverageRate(4.5);
        newPro.setCommentCollection(new ArrayList());
        newPro.setCost(35);
        newPro.setDiscount(10);
        newPro.setName("Vado");
        newPro.setNumberOfRate(23);
        newPro.setOrderItemCollection(new ArrayList());
        newPro.setPicture("");
        newPro.setPrice(34);
        newPro.setRateCollection(new ArrayList());
        newPro.setSoldQuantity(12);
        newPro.setVolumn("1l");
        newPro.setDescription("Valdo has two wineries locate over a 20,000 sqm surface area: the first winery is headqund is synonymous with excellence in sparkling wine culture where tradition meets innovation.");
        em.persist(newPro);

        newSub1.getProductCollection().add(newPro);
        em.merge(newSub1);
    }

    public long saveNewProduct(String picture, String productName, double productPrice, double productCost, String productDescription, int productAQ, int productDiscount, String productVolume) {
        Product product = new Product();
        product.setPicture(picture);
        product.setName(productName);
        product.setPrice(productPrice);
        product.setCost(productCost);
        product.setDescription(productDescription);
        product.setAvailableQuantity(productAQ);
        product.setDiscount(productDiscount);
        product.setNumberOfRate(0);
        product.setVolumn(productVolume);
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
        Query query = em.createQuery("SELECT p FROM Product p");
        return query.getResultList();
    }

    @Override
    public Product deleteProduct(long productId) {
        System.out.println("productSessionBean");
        //delete product from sub categories!!!!!!****************************
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

    @Override
    public List<Categories> getAllCategories() {
        ArrayList<Categories> result = new ArrayList();
        Query q = em.createQuery("SELECT c FROM Categories c");
        for (Object o : q.getResultList()) {
            result.add((Categories) o);
        }
        return result;
    }

    @Override
    public SubCategories findSubCategoryByName(String name) {
        Query q = em.createQuery("SELECT c FROM SubCategories c WHERE c.name= :name");
        q.setParameter("name", name);
        SubCategories result = (SubCategories) q.getSingleResult();

        return result;
    }

    @Override
    public void rateProduct(Customer cus, Product myProduct, int myRate) {
        Rate newRate = new Rate();
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

    @Override
    public Customer findCustomerById(long cusId) {
      
        Customer myCus = (Customer) em.find(Customer.class, cusId);
        return myCus;
    }
}
