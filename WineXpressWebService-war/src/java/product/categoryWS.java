/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package product;

import entity.Categories;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import wineXpressWebServices.CategorySessionBeanLocal;

/**
 *
 * @author mac
 */
@WebService(serviceName = "categoryWS")
public class categoryWS {
    @EJB
    private CategorySessionBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "saveNewCategories")
    public long saveNewCategories(@WebParam(name = "categoriesName") String categoriesName) {
        return ejbRef.saveNewCategories(categoriesName);
    }

    @WebMethod(operationName = "searchCategories")
    public List<Categories> searchCategories(@WebParam(name = "categoriesName") String categoriesName) {
        return ejbRef.searchCategories(categoriesName);
    }

    @WebMethod(operationName = "viewAllCategories")
    public List<Categories> viewAllCategories() {
        return ejbRef.viewAllCategories();
    }

    @WebMethod(operationName = "deleteCategories")
    public boolean deleteCategories(@WebParam(name = "categoryId") long categoryId) {
        return ejbRef.deleteCategories(categoryId);
    }

    @WebMethod(operationName = "editCategories")
    @Oneway
    public void editCategories(@WebParam(name = "newCategories") Categories newCategories) {
        ejbRef.editCategories(newCategories);
    }

    @WebMethod(operationName = "getCategoriesName")
    public List<String> getCategoriesName() {
        return ejbRef.getCategoriesName();
    }

    @WebMethod(operationName = "getSubCategoryNameList")
    public List<String> getSubCategoryNameList(@WebParam(name = "categoryName") String categoryName) {
        return ejbRef.getSubCategoryNameList(categoryName);
    }
    
}
