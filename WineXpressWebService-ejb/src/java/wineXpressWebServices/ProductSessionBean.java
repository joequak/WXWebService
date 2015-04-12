/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineXpressWebServices;

import entity.Categories;
import entity.Comment;
import entity.Customer;
import entity.OrderDetail;
import entity.OrderItem;
import entity.Product;
import entity.Rate;
import entity.ShoppingCart;
import entity.SubCategories;
import java.util.ArrayList;
import java.util.Collection;
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
    public Product saveNewProduct(String picture, String productName, double productPrice, double productCost, String productDescription, int productAQ, int productDiscount, String productVolume) {
        String newUrl = "./../images/productImg/" + picture; 
        Product product = new Product();
        product.setPicture(newUrl);
        product.setName(productName);
        product.setPrice(productPrice);
        product.setCost(productCost);
        product.setDescription(productDescription);
        product.setAvailableQuantity(productAQ);
        product.setDiscount(productDiscount);
        product.setNumberOfRate(0);
        product.setVolumn(productVolume);
        product.setProductStatus(1);
        em.persist(product);
        return product;
    }

    @Override
    public void addProductSubcategories(SubCategories subCat, Product myPro) {
        subCat.getProductCollection().add(myPro);
        em.merge(subCat);
        em.flush();
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
    public boolean deleteProduct(Product myProduct) {
        myProduct.setProductStatus(0);
        em.merge(myProduct);
        em.flush();
        return true;
//        Query query = em.createQuery("select s from SubCategories s ");
//        for (Object o : query.getResultList()) {
//            SubCategories ss = (SubCategories) o;
//            if (ss.getProductCollection().contains(myProduct)) {
//                ss.getProductCollection().remove(myProduct);
//                em.persist(ss);
//            }
//        }
//        em.remove(myProduct);
//        em.flush();
//        return true;
    }

    @Override
    public void editProduct(Product newProduct, String picture, String productName, double productPrice, double productCost,
            String productDescription, int productAQ, int productDiscount, String productVolume) {
        newProduct.setPicture(picture);
        newProduct.setPrice(productPrice);
        newProduct.setAvailableQuantity(productAQ);
        newProduct.setPrice(productPrice);
        newProduct.setCost(productCost);
        newProduct.setDescription(productDescription);
        newProduct.setDiscount(productDiscount);
        newProduct.setVolumn(productVolume);
        em.merge(newProduct);
        em.flush();

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
        em.flush();
        Collection<Rate> tuRate = cus.getRateCollection();
        if (tuRate == null) {
            tuRate = new ArrayList<Rate>();
        }
        tuRate.add(newRate);
        cus.setRateCollection(tuRate);
        em.merge(cus);
        em.flush();
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
        newCom.setcStatus(true);
        em.persist(newCom);
        em.flush();
        Product prodTU = em.find(Product.class, myProduct.getId());
        Collection<Comment> ptuComment = prodTU.getCommentCollection();
        if (ptuComment == null) {
            ptuComment = new ArrayList<Comment>();
        }
        ptuComment.add(newCom);
        prodTU.setCommentCollection(ptuComment);
        em.merge(prodTU);
        em.flush();
        Customer custTU = em.find(Customer.class, cus.getId());
        Collection<Comment> ctuComment = custTU.getCommentCollection();
        if (ctuComment == null) {
            ctuComment = new ArrayList<Comment>();
        }
        ctuComment.add(newCom);
        custTU.setCommentCollection(ctuComment);
        em.merge(custTU);
        em.flush();

    }

    @Override
    public void deleteComment(Comment myComment) {
        myComment.setcStatus(false);
        em.merge(myComment);
    }

    @Override
    public Customer findCustomerById(long cusId) {

        Customer myCus = (Customer) em.find(Customer.class, cusId);
        return myCus;
    }

    @Override
    public List<SubCategories> productSubCategories(Product myPro) {
        List<SubCategories> result = new ArrayList();
        Query q = em.createQuery("SELECT c FROM SubCategories c");
        for (Object o : q.getResultList()) {
            SubCategories mySub = (SubCategories) o;
            for (Object oo : mySub.getProductCollection()) {
                Product pro = (Product) oo;
                if (pro.getId() == myPro.getId()) {
                    result.add(mySub);
                    break;
                }

            }
        }
        return result;
    }

    @Override
    public List<Product> findProductByName(String pName) {
        List<Product> result = new ArrayList(0);
        Query q = em.createQuery("SELECT c FROM Product c");
        for (Object o : q.getResultList()) {
            Product myPro = (Product) o;
            if (myPro.getName().contains(pName)) {
                result.add(myPro);
            }
        }
        return result;
    }
    
    //create orderItem for product: customer, Product, quantity
    @Override
    public long AddOrderItemAndShoppingCart(Customer customer, Product product, int quantity){
       ShoppingCart customerSC = customer.getShoppingCart();
       for(Object o:customerSC.getOrderItems()){
           OrderItem existedOI = (OrderItem)o;
           if(existedOI.getProduct().equals(product)){
               existedOI.setQuantity(quantity+existedOI.getQuantity());
               em.merge(existedOI);
               return 2l;
           }
       }
       
        OrderItem oi = new OrderItem();
        System.out.println("&&&&successfully addOrderItems1");
        oi.setProduct(product);     
        oi.setQuantity(quantity);
        em.persist(oi);
        //add orderItem to product
     //   product.getOrderItemCollection().add(oi);
      //  System.out.println("&&&&successfully addOrderItems2");
      //  em.merge(product);
        System.out.println("&&&&successfully addOrderItems3");
        //add orderItem to shoppingcart
        ShoppingCart shoppingcart = customer.getShoppingCart();
        shoppingcart.getOrderItems().add(oi);
        em.merge(shoppingcart);
        System.out.println("&&&&successfully addOrderItems");
        return 2l;
        
    }
    @Override
    public Collection<OrderItem> getShoppingCartList(Customer customer){
        ShoppingCart sc = customer.getShoppingCart();
        return sc.getOrderItems();
    }
      
    @Override
    public void updateOrderItemQuantity(OrderItem orderItem){
        OrderItem old = em.find(OrderItem.class, orderItem.getId());
        old.setQuantity(orderItem.getQuantity());
        em.merge(old);
    }
    @Override
    public Double calculateFinalCost(List<OrderItem> selectedItems){
            Double cost = 0.0;
        for(Object o: selectedItems){
            OrderItem  oi = (OrderItem)o;
            cost = cost + (oi.getProduct().getPrice())*oi.getQuantity()* (1-oi.getProduct().getDiscount()*0.01) ;
        }
        return cost;
    }
    
    @Override
    public OrderDetail createOrderDetail(List<OrderItem> selectedItems, Customer customer){
        System.out.println("_%%%%%1_");
        OrderDetail od = new OrderDetail();
        od.setOrderItemCollection(selectedItems);
        em.merge(od);
        em.flush();
         System.out.println("_%%%%%1_");
        customer.getOrderDetailCollection().add(od);
         System.out.println("_%%%%%1_1");
        em.merge(customer);
         System.out.println("_%%%%%1_11");
         return od;
    }
        
    @Override
    public void deleteOrderList(List<OrderItem> orderItems,Customer customer){
        ShoppingCart sc = customer.getShoppingCart();
        Collection<OrderItem> oi = new ArrayList<OrderItem>(orderItems);
        sc.getOrderItems().removeAll(oi);
        em.merge(sc);
        System.out.println("$$$$!!remove");
    }
    
    @Override 
    public Collection<OrderItem> getCustomerLatestOrderDetail(Customer customer){
       List<OrderDetail> od = new ArrayList<>(customer.getOrderDetailCollection());
       return od.get(od.size()-1).getOrderItemCollection();
    }
}
