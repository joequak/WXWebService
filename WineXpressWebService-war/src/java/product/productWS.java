/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package product;

import entity.Categories;
import entity.Comment;
import entity.Customer;
import entity.OrderDetail;
import entity.OrderItem;
import entity.Product;
import entity.SubCategories;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import wineXpressWebServices.ProductSessionBeanLocal;

/**
 *
 * @author Ruoxi
 */
@WebService(serviceName = "productWS")
public class productWS {
    @EJB
    private ProductSessionBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "saveNewProduct")
    public Product saveNewProduct(@WebParam(name = "picture") String picture, @WebParam(name = "productName") String productName, @WebParam(name = "productPrice") double productPrice, @WebParam(name = "productCost") double productCost, @WebParam(name = "productDescription") String productDescription, @WebParam(name = "productAQ") int productAQ, @WebParam(name = "productDiscount") int productDiscount, @WebParam(name = "productVolume") String productVolume) {
        return ejbRef.saveNewProduct(picture, productName, productPrice, productCost, productDescription, productAQ, productDiscount, productVolume);
    }

    @WebMethod(operationName = "searchProduct")
    public List<Product> searchProduct(@WebParam(name = "productName") String productName) {
        return ejbRef.searchProduct(productName);
    }

    @WebMethod(operationName = "viewAllProducts")
    public List<Product> viewAllProducts() {
        return ejbRef.viewAllProducts();
    }

    @WebMethod(operationName = "deleteProduct")
    public boolean deleteProduct(@WebParam(name = "productId") Product productId) {
        return ejbRef.deleteProduct(productId);
    }

    @WebMethod(operationName = "editProduct")
    @Oneway
    public void editProduct(@WebParam(name = "newProduct") Product newProduct, @WebParam(name = "picture") String picture, @WebParam(name = "productName") String productName, @WebParam(name = "productPrice") double productPrice, @WebParam(name = "productCost") double productCost, @WebParam(name = "productDescription") String productDescription, @WebParam(name = "productAQ") int productAQ, @WebParam(name = "productDiscount") int productDiscount, @WebParam(name = "productVolume") String productVolume) {
        ejbRef.editProduct(newProduct, picture, productName, productPrice, productCost, productDescription, productAQ, productDiscount, productVolume);
    }

    @WebMethod(operationName = "getAllCategories")
    public List<Categories> getAllCategories() {
        return ejbRef.getAllCategories();
    }

    @WebMethod(operationName = "findSubCategoryByName")
    public SubCategories findSubCategoryByName(@WebParam(name = "name") String name) {
        return ejbRef.findSubCategoryByName(name);
    }

    @WebMethod(operationName = "makeComment")
    @Oneway
    public void makeComment(@WebParam(name = "myProduct") Product myProduct, @WebParam(name = "newComment") String newComment, @WebParam(name = "cus") Customer cus) {
        ejbRef.makeComment(myProduct, newComment, cus);
    }

    @WebMethod(operationName = "rateProduct")
    @Oneway
    public void rateProduct(@WebParam(name = "cus") Customer cus, @WebParam(name = "myProduct") Product myProduct, @WebParam(name = "myRate") int myRate) {
        ejbRef.rateProduct(cus, myProduct, myRate);
    }

    @WebMethod(operationName = "deleteComment")
    @Oneway
    public void deleteComment(@WebParam(name = "myComment") Comment myComment) {
        ejbRef.deleteComment(myComment);
    }

    @WebMethod(operationName = "findCustomerById")
    public Customer findCustomerById(@WebParam(name = "cusId") long cusId) {
        return ejbRef.findCustomerById(cusId);
    }

    @WebMethod(operationName = "addProductSubcategories")
    @Oneway
    public void addProductSubcategories(@WebParam(name = "subCat") SubCategories subCat, @WebParam(name = "myPro") Product myPro) {
        ejbRef.addProductSubcategories(subCat, myPro);
    }

    @WebMethod(operationName = "productSubCategories")
    public List<SubCategories> productSubCategories(@WebParam(name = "myPro") Product myPro) {
        return ejbRef.productSubCategories(myPro);
    }

    @WebMethod(operationName = "findProductByName")
    public List<Product> findProductByName(@WebParam(name = "pName") String pName) {
        return ejbRef.findProductByName(pName);
    }

    @WebMethod(operationName = "AddOrderItemAndShoppingCart")
    public long AddOrderItemAndShoppingCart(@WebParam(name = "customer") Customer customer, @WebParam(name = "product") Product product, @WebParam(name = "quantity") int quantity) {
        return ejbRef.AddOrderItemAndShoppingCart(customer, product, quantity);
    }

    @WebMethod(operationName = "getShoppingCartList")
    public Collection<OrderItem> getShoppingCartList(@WebParam(name = "customer") Customer customer) {
        return ejbRef.getShoppingCartList(customer);
    }

    @WebMethod(operationName = "updateOrderItemQuantity")
    @Oneway
    public void updateOrderItemQuantity(@WebParam(name = "orderItem") OrderItem orderItem) {
        ejbRef.updateOrderItemQuantity(orderItem);
    }

    @WebMethod(operationName = "calculateFinalCost")
    public Double calculateFinalCost(@WebParam(name = "selectedItems") List<OrderItem> selectedItems) {
        return ejbRef.calculateFinalCost(selectedItems);
    }

    @WebMethod(operationName = "createOrderDetail")
    public OrderDetail createOrderDetail(@WebParam(name = "selectedItems") List<OrderItem> selectedItems, @WebParam(name = "customer") Customer customer) {
        return ejbRef.createOrderDetail(selectedItems, customer);
    }

    @WebMethod(operationName = "deleteOrderList")
    @Oneway
    public void deleteOrderList(@WebParam(name = "orderItems") List<OrderItem> orderItems, @WebParam(name = "customer") Customer customer) {
        ejbRef.deleteOrderList(orderItems, customer);
    }

    @WebMethod(operationName = "getCustomerLatestOrderDetail")
    public Collection<OrderItem> getCustomerLatestOrderDetail(@WebParam(name = "customer") Customer customer) {
        return ejbRef.getCustomerLatestOrderDetail(customer);
    }
    
}
