/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineXpressWebServices;

import entity.CreditCard;
import entity.ShipToAddress;
import javax.ejb.Local;

/**
 *
 * @author Ruoxi
 */
@Local
public interface PaymentSBLocal {

    public ShipToAddress fetchAddress(String email);

    public void updateAddress(String email, ShipToAddress newAddress);
    
       public CreditCard fetchCredit(String email) ;
       
       public void updateCredit(String email, CreditCard newCredit) ;
}
