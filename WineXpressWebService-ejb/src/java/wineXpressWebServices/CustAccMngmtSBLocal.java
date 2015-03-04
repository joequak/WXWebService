/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineXpressWebServices;

import entity.Customer;
import entity.OrderDetail;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ¿.¿.¿
 */
@Local
public interface CustAccMngmtSBLocal {

    public boolean registerAsMember(Customer newCust);

    public boolean activateAccount(String emailAdd);

    public long logInMember(String emailAdd, String password);

    public boolean logOutMember(long custID);

    public Customer viewAccInfoMember(long custID);

    public boolean editParticularsMember(long custID, Customer newCust);

    public boolean changePwMember(long custID, String oldPW, String newPW);

    public List<OrderDetail> viewPurchaseHistoryMember(long custID);
    
}
