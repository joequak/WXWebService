/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rate;

import RatingSessionBean.RatingSessionBeanLocal;
import entity.Customer;
import entity.OrderDetail;
import entity.Product;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import wineXpressWebServices.CustAccMngmtSBLocal;

/**
 *
 * @author wangyan
 */
@WebService(serviceName = "RatingProductWS")
public class RatingProductWS {
    @EJB
    private RatingSessionBeanLocal ratingSB;
    
    @WebMethod(operationName = "rateProduct")
    public boolean reateProduct(@WebParam(name = "product") Product product ,@WebParam(name="rateStar") int rateStar){
        return ratingSB.rateProduct(product,rateStar);
    }
    
    
}
