/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WS;

import entity.CreditCard;
import entity.ShipToAddress;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import wineXpressWebServices.PaymentSBLocal;

/**
 *
 * @author Ruoxi
 */
@WebService(serviceName = "PaymentWS")
public class PaymentWS {
    @EJB
    private PaymentSBLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "fetchAddress")
    public ShipToAddress fetchAddress(@WebParam(name = "email") String email) {
        return ejbRef.fetchAddress(email);
    }

    @WebMethod(operationName = "updateAddress")
    @Oneway
    public void updateAddress(@WebParam(name = "email") String email, @WebParam(name = "newAddress") ShipToAddress newAddress) {
        ejbRef.updateAddress(email, newAddress);
    }

    @WebMethod(operationName = "fetchCredit")
    public CreditCard fetchCredit(@WebParam(name = "email") String email) {
        return ejbRef.fetchCredit(email);
    }

    @WebMethod(operationName = "updateCredit")
    @Oneway
    public void updateCredit(@WebParam(name = "email") String email, @WebParam(name = "newCredit") CreditCard newCredit) {
        ejbRef.updateCredit(email, newCredit);
    }

    @WebMethod(operationName = "createPaymentRecord")
    @Oneway
    public void createPaymentRecord(@WebParam(name = "orderID") long orderID, @WebParam(name = "price") double price, @WebParam(name = "name") String name) {
        ejbRef.createPaymentRecord(orderID, price, name);
    }
    
}
