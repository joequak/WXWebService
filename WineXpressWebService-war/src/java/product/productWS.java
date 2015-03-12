/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

import CategorySessionBean.CategorySessionBeanLocal;
import ProductSessionBean.ProductSessionBeanLocal;
import entity.Product;
import java.util.List;
import javax.ejb.EJB;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author wangyan
 */
@WebService(serviceName = "productWS")
public class productWS {

    /**
     * This is a sample web service operation
     */
    @EJB
    ProductSessionBeanLocal productSB;
    @EJB
    CategorySessionBeanLocal categorySB;

    @WebMethod(operationName = "saveNewProduct")
    public Long saveNewProduct(@WebParam(name = "productName") String productName, @WebParam(name = "productPrice") Double productPrice, @WebParam(name = "productCost") Double productCost, @WebParam(name = "productDescription") String productDescription, @WebParam(name = "productAQ") Integer productAQ, @WebParam(name = "productDiscount") Integer productDiscount, @WebParam(name = "productVolume") String productVolume, @WebParam(name = "productCountry") String productCountry) {
        return productSB.saveNewProduct(productName, productPrice, productCost, productDescription, productAQ, productDiscount, productVolume, productCountry);

    }

    @WebMethod(operationName = "searchProduct")
    public List<Product> searchProduct(@WebParam(name = "productName") String productName) {
        return productSB.searchProduct(productName);
    }

    @WebMethod(operationName = "viewAllProducts")
    public List<Product> viewAllProducts() {
        return productSB.viewAllProducts();
    }

    @WebMethod(operationName = "deleteProduct")
    public Product deleteProduct(@WebParam(name = "productId") Long productId) {
        return productSB.deleteProduct(productId);
    }

    @WebMethod(operationName = "onRowEdit")
    public void onRowEdit(@WebParam(name = "edit") Product edit) {
        productSB.editProduct(edit);
    }

    @WebMethod(operationName = "getCountries")
    public List<String> getCountries() {
        return categorySB.getCountries();
    }
}
