/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package product;

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

    @WebMethod(operationName = "saveSubCategories")
    public long saveSubCategories(@WebParam(name = "categoryName") String categoryName, @WebParam(name = "subcategoriesName") String subcategoriesName) {
        return ejbRef.saveSubCategories(categoryName, subcategoriesName);
    }
    
}
