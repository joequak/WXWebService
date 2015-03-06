/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineXpressWebServices;

import entity.AdminUsr;
import entity.Customer;
import entity.OrderDetail;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ¿.¿.¿
 */
@Local
public interface AdminAccMngmtSBLocal {

    public long logInAdmin(String emailAdd, String password);

    public boolean logOutAdmin(long adminID);

    public AdminUsr viewAccInfoAdmin(long adminID);

    public boolean editParticularsAdmin(long adminID, AdminUsr newAdminUsr);

    public boolean changePwAdmin(long adminID, String oldPW, String newPW);

    public List<Customer> getAllCust(long adminID);

    public boolean cancelAccount(long adminID);

    public boolean blockCust(long adminID, long custID);

    public List<OrderDetail> viewPurchaseHistoryAdmin(long adminID, long custID);

    public boolean createAdmin(AdminUsr newAdminUsr);

    public boolean reActivateAdmin(String emailAdd);

    
}
