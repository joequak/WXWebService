/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.accountManagement;

import entity.AdminUsr;
import entity.Customer;
import entity.OrderDetail;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import wineXpressWebServices.AdminAccMngmtSBLocal;

/**
 *
 * @author ¿.¿.¿
 */
@WebService(serviceName = "AdminAccMngmtWS")
public class AdminAccMngmtWS {
    @EJB
    private AdminAccMngmtSBLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "logInAdmin")
    public long logInAdmin(@WebParam(name = "emailAdd") String emailAdd, @WebParam(name = "password") String password) {
        return ejbRef.logInAdmin(emailAdd, password);
    }

    @WebMethod(operationName = "logOutAdmin")
    public boolean logOutAdmin(@WebParam(name = "adminID") long adminID) {
        return ejbRef.logOutAdmin(adminID);
    }

    @WebMethod(operationName = "viewAccInfoAdmin")
    public AdminUsr viewAccInfoAdmin(@WebParam(name = "adminID") long adminID) {
        return ejbRef.viewAccInfoAdmin(adminID);
    }

    @WebMethod(operationName = "editParticularsAdmin")
    public boolean editParticularsAdmin(@WebParam(name = "adminID") long adminID, @WebParam(name = "newAdminUsr") AdminUsr newAdminUsr) {
        return ejbRef.editParticularsAdmin(adminID, newAdminUsr);
    }

    @WebMethod(operationName = "changePwAdmin")
    public boolean changePwAdmin(@WebParam(name = "adminID") long adminID, @WebParam(name = "oldPW") String oldPW, @WebParam(name = "newPW") String newPW) {
        return ejbRef.changePwAdmin(adminID, oldPW, newPW);
    }

    @WebMethod(operationName = "getAllCust")
    public List<Customer> getAllCust(@WebParam(name = "adminID") long adminID) {
        return ejbRef.getAllCust(adminID);
    }

    @WebMethod(operationName = "cancelAccount")
    public boolean cancelAccount(@WebParam(name = "adminID") long adminID) {
        return ejbRef.cancelAccount(adminID);
    }

    @WebMethod(operationName = "blockCust")
    public boolean blockCust(@WebParam(name = "adminID") long adminID, @WebParam(name = "custID") long custID) {
        return ejbRef.blockCust(adminID, custID);
    }

    @WebMethod(operationName = "viewPurchaseHistoryAdmin")
    public List<OrderDetail> viewPurchaseHistoryAdmin(@WebParam(name = "adminID") long adminID, @WebParam(name = "custID") long custID) {
        return ejbRef.viewPurchaseHistoryAdmin(adminID, custID);
    }

    @WebMethod(operationName = "createAdmin")
    public boolean createAdmin(@WebParam(name = "newAdminUsr") AdminUsr newAdminUsr) {
        return ejbRef.createAdmin(newAdminUsr);
    }

    @WebMethod(operationName = "reActivateAdmin")
    public boolean reActivateAdmin(@WebParam(name = "emailAdd") String emailAdd) {
        return ejbRef.reActivateAdmin(emailAdd);
    }

    @WebMethod(operationName = "resetPwAdmin")
    public boolean resetPwAdmin(@WebParam(name = "emailAdd") String emailAdd, @WebParam(name = "rstPW") String rstPW) {
        return ejbRef.resetPwAdmin(emailAdd, rstPW);
    }
    
}
