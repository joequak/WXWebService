/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.accountManagement;

import entity.Customer;
import entity.OrderDetail;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import wineXpressWebServices.CustAccMngmtSBLocal;

/**
 *
 * @author ¿.¿.¿
 */
@WebService(serviceName = "CustAccMngmtWS")
public class CustAccMngmtWS {
    @EJB
    private CustAccMngmtSBLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "registerAsMember")
    public boolean registerAsMember(@WebParam(name = "newCust") Customer newCust) {
        return ejbRef.registerAsMember(newCust);
    }

    @WebMethod(operationName = "activateAccount")
    public boolean activateAccount(@WebParam(name = "emailAdd") String emailAdd) {
        return ejbRef.activateAccount(emailAdd);
    }

    @WebMethod(operationName = "logInMember")
    public long logInMember(@WebParam(name = "emailAdd") String emailAdd, @WebParam(name = "password") String password) {
        return ejbRef.logInMember(emailAdd, password);
    }

    @WebMethod(operationName = "logOutMember")
    public boolean logOutMember(@WebParam(name = "custID") long custID) {
        return ejbRef.logOutMember(custID);
    }

    @WebMethod(operationName = "viewAccInfoMember")
    public Customer viewAccInfoMember(@WebParam(name = "custID") long custID) {
        return ejbRef.viewAccInfoMember(custID);
    }

    @WebMethod(operationName = "editParticularsMember")
    public boolean editParticularsMember(@WebParam(name = "custID") long custID, @WebParam(name = "newCust") Customer newCust) {
        return ejbRef.editParticularsMember(custID, newCust);
    }

    @WebMethod(operationName = "changePwMember")
    public boolean changePwMember(@WebParam(name = "custID") long custID, @WebParam(name = "oldPW") String oldPW, @WebParam(name = "newPW") String newPW) {
        return ejbRef.changePwMember(custID, oldPW, newPW);
    }

    @WebMethod(operationName = "viewPurchaseHistoryMember")
    public List<OrderDetail> viewPurchaseHistoryMember(@WebParam(name = "custID") long custID) {
        return ejbRef.viewPurchaseHistoryMember(custID);
    }
    
}
