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
import entity.SubCategories;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author wangyan
 */
@Local
public interface ProductSessionBeanLocal {

    public Product saveNewProduct(String picture, String productName, double productPrice, double productCost, String productDescription, int productAQ, int productDiscount, String productVolume);

    public List<Product> searchProduct(String productName);

    public List<Product> viewAllProducts();

    public boolean deleteProduct(Product productId);

    public void editProduct(Product newProduct, String picture, String productName, double productPrice, double productCost,
            String productDescription, int productAQ, int productDiscount, String productVolume);

    public List<Categories> getAllCategories();

    public SubCategories findSubCategoryByName(String name);

    public void makeComment(Product myProduct, String newComment, Customer cus);

    public void rateProduct(Customer cus, Product myProduct, int myRate);

    public void deleteComment(Comment myComment);

    public Customer findCustomerById(long cusId);

    void addProductSubcategories(SubCategories subCat, Product myPro);

    List<SubCategories> productSubCategories(Product myPro);

    List<Product> findProductByName(String pName);

    public long AddOrderItemAndShoppingCart(Customer customer, Product product, int quantity);

    public Collection<OrderItem> getShoppingCartList(Customer customer);

    public void updateOrderItemQuantity(OrderItem orderItem);

    public Double calculateFinalCost(List<OrderItem> selectedItems);

    public OrderDetail createOrderDetail(List<OrderItem> selectedItems, Customer customer);

    public void deleteOrderList(List<OrderItem> orderItems, Customer customer);

    public Collection<OrderItem> getCustomerLatestOrderDetail(Customer customer);
}
