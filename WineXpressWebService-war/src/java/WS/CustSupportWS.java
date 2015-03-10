/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WS;

import entity.CustEnquiry;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import wineXpressWebServices.CustSupportSBLocal;

/**
 *
 * @author Ruoxi
 */
@WebService(serviceName = "CustSupportWS")
public class CustSupportWS {
    @EJB
    private CustSupportSBLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "creatEnquiry")
    public boolean creatEnquiry(@WebParam(name = "enquiry") CustEnquiry enquiry) {
        return ejbRef.creatEnquiry(enquiry);
    }

    @WebMethod(operationName = "getEnquiry")
    public List<CustEnquiry> getEnquiry() {
        return ejbRef.getEnquiry();
    }
    
}
