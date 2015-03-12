/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package category;

import CategorySessionBean.CategorySessionBeanLocal;
import entity.Categories;

import java.util.List;
import javax.ejb.EJB;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author wangyan
 */
@WebService(serviceName = "categoryWS")
public class categoryWS {

    @EJB
    CategorySessionBeanLocal categorySB;

    //Relative saveNewCagtegoryWS
    @WebMethod(operationName = "saveNewCategory")
    public Long saveNewCategory(@WebParam(name = "categoryName") String categoryName) {
        return categorySB.saveNewCategories(categoryName);

    }

    //searchCategoryWS
    @WebMethod(operationName = "searchCategory")
    public List<Categories> searchCategory(@WebParam(name = "categoryName") String categoryName) {
        return categorySB.searchCategories(categoryName);
    }

    //viewAllCategoriesWS
    @WebMethod(operationName = "veiwAllCategories")
    public List<Categories> viewAllCategories() {
        return categorySB.viewAllCategories();
    }

    //WS
    @WebMethod(operationName = "deleteCategory")
    public Categories deleteCategory(@WebParam(name = "categoryId") Long categoryId) {
        Categories c = categorySB.deleteCategories(categoryId);
        return c;
    }

    @WebMethod(operationName = "onRowEdit")
    public void onRowEdit(@WebParam(name = "edit") Categories edit) {
        categorySB.editCategories(edit);
    }

}
