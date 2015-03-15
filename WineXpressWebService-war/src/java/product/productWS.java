/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package product;

import entity.Categories;
import entity.Comment;
import entity.Customer;
import entity.Product;
import entity.SubCategories;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import wineXpressWebServices.ProductSessionBeanLocal;

/**
 *
 * @author mac
 */
@WebService(serviceName = "productWS")
public class productWS {
    @EJB
    private ProductSessionBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "saveNewProduct")
    public long saveNewProduct(@WebParam(name = "picture") String picture, @WebParam(name = "productName") String productName, @WebParam(name = "productPrice") double productPrice, @WebParam(name = "productCost") double productCost, @WebParam(name = "productDescription") String productDescription, @WebParam(name = "productAQ") int productAQ, @WebParam(name = "productDiscount") int productDiscount, @WebParam(name = "productVolume") String productVolume, @WebParam(name = "subCateogryName") String subCategoryName) {
        return ejbRef.saveNewProduct(picture, productName, productPrice, productCost, productDescription, productAQ, productDiscount, productVolume, subCategoryName);
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
    public Product deleteProduct(@WebParam(name = "productId") long productId) {
        return ejbRef.deleteProduct(productId);
    }

    @WebMethod(operationName = "editProduct")
    @Oneway
    public void editProduct(@WebParam(name = "newProduct") Product newProduct) {
        ejbRef.editProduct(newProduct);
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
    
}
