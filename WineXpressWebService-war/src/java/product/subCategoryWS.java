/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

import entity.Categories;
import entity.Product;
import entity.SubCategories;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import wineXpressWebServices.SubCategorySessionBeanLocal;

/**
 *
 * @author ¿.¿.¿
 */
@WebService(serviceName = "subCategoryWS")
public class subCategoryWS {
    @EJB
    private SubCategorySessionBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "addNewSubcategory")
    public boolean addNewSubcategory(@WebParam(name = "category") Categories category, @WebParam(name = "subName") String subName) {
        return ejbRef.addNewSubcategory(category, subName);
    }

    @WebMethod(operationName = "deleteSubCategory")
    public boolean deleteSubCategory(@WebParam(name = "mySub") SubCategories mySub) {
        return ejbRef.deleteSubCategory(mySub);
    }

    @WebMethod(operationName = "getCategoryById")
    public Categories getCategoryById(@WebParam(name = "caId") long caId) {
        return ejbRef.getCategoryById(caId);
    }

    @WebMethod(operationName = "getProductAllSubCate")
    public List<SubCategories> getProductAllSubCate(@WebParam(name = "myProduct") Product myProduct) {
        return ejbRef.getProductAllSubCate(myProduct);
    }

    @WebMethod(operationName = "removeProductFromSubCate")
    @Oneway
    public void removeProductFromSubCate(@WebParam(name = "listOfSub") List<SubCategories> listOfSub, @WebParam(name = "myProduct") Product myProduct) {
        ejbRef.removeProductFromSubCate(listOfSub, myProduct);
    }
    
}
