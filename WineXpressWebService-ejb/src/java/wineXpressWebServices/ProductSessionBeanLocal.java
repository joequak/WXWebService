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
import entity.SubCategories;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author wangyan
 */
@Local
public interface ProductSessionBeanLocal {

    public long saveNewProduct(String picture,String productName, double productPrice, double productCost, String productDescription, int productAQ, int productDiscount, String productVolume);

    public List<Product> searchProduct(String productName);

    public List<Product> viewAllProducts();

    public Product deleteProduct(long productId);

    public void editProduct(Product newProduct);

    public List<Categories> getAllCategories();

    public SubCategories findSubCategoryByName(String name);

    public void makeComment(Product myProduct, String newComment, Customer cus);

    public void rateProduct(Customer cus, Product myProduct, int myRate);

    public void deleteComment(Comment myComment);

   public Customer findCustomerById(long cusId);

    public void dataBaseInit();

    }
