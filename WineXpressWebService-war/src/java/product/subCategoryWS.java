/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package product;

import entity.Categories;
import entity.SubCategories;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import wineXpressWebServices.SubCategorySessionBeanLocal;

/**
 *
 * @author mac
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
    
}
