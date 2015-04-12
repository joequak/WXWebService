/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineXpressWebServices;

import entity.CreditCard;
import entity.Customer;
import entity.OrderDetail;
import entity.Payment;
import entity.ShipToAddress;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ruoxi
 */
@Stateless
public class PaymentSB implements PaymentSBLocal {

    @PersistenceContext(unitName = "WineXpressWebService-ejbPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public ShipToAddress fetchAddress(String email) {
        ShipToAddress returnAddress = new ShipToAddress();
        Query query = em.createQuery("SELECT a FROM Customer a WHERE a.email = :email").setParameter("email", email);
        //If email address is valid
        if (query.getResultList().size() == 1) {
            if (query.getResultList().get(0).getClass().equals(Customer.class)) {
                Customer cust = (Customer) query.getResultList().get(0);
                System.out.println("fetched customer i s" + cust.getEmail());
                returnAddress = cust.getShipAddress();
            }
        }
        return returnAddress;
    }

    @Override
    public void updateAddress(String email, ShipToAddress newAddress) {

        Query query = em.createQuery("SELECT a FROM Customer a WHERE a.email = :email").setParameter("email", email);
        //If email address is valid
        Customer cust = null;
        if (query.getResultList().size() == 1) {
            if (query.getResultList().get(0).getClass().equals(Customer.class)) {
                cust = (Customer) query.getResultList().get(0);

            }
        }
        ShipToAddress address = cust.getShipAddress();
        address.setAddress1(newAddress.getAddress1());
        address.setAddress2(newAddress.getAddress2());
        address.setCity(newAddress.getAddress2());
        address.setCountry(newAddress.getCountry());
        address.setPostalcode(newAddress.getPostalcode());
        address.setContactNumber(newAddress.getContactNumber());
        address.setShipState(newAddress.getShipState());

        em.merge(address);
        cust.setShipAddress(address);
        em.merge(cust);
    }

    @Override
    public CreditCard fetchCredit(String email) {

        CreditCard credit = new CreditCard();
        Query query = em.createQuery("SELECT a FROM Customer a WHERE a.email = :email").setParameter("email", email);
        //If email address is valid
        if (query.getResultList().size() == 1) {
            if (query.getResultList().get(0).getClass().equals(Customer.class)) {
                Customer cust = (Customer) query.getResultList().get(0);
                System.out.println("fetched customer i s" + cust.getEmail());
                credit = cust.getCreditCard();
            }
        }
        return credit;
    }

    @Override
    public void updateCredit(String email, CreditCard newCredit) {

        Query query = em.createQuery("SELECT a FROM Customer a WHERE a.email = :email").setParameter("email", email);
        //If email address is valid
        Customer cust = null;
        if (query.getResultList().size() == 1) {
            if (query.getResultList().get(0).getClass().equals(Customer.class)) {
                cust = (Customer) query.getResultList().get(0);
            }
        }
        CreditCard credit = cust.getCreditCard();
        credit.setCardHolder(newCredit.getCardHolder());
        credit.setCardNumber(newCredit.getCardNumber());
        credit.setExpDate(newCredit.getExpDate());
        credit.setType("1");

        em.merge(credit);
        cust.setCreditCard(credit);
        em.merge(cust);
    }
    @Override
    public void createPaymentRecord(long orderID, double price, String name ){
        System.out.println("orderID is at Payment session" + orderID);
       
        OrderDetail ord=em.find(OrderDetail.class, orderID);
        
        Payment payment = new Payment();
        payment.setAmount(price);
        payment.setCardHolder(name);
        payment.setMethod("PayPal");
        
        em.persist(payment);
        ord.setPayment(payment);

        em.merge(ord);
        em.merge(payment);
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
