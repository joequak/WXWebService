/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author ¿.¿.¿
 */
@Entity
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Timestamp ordDate;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "totalPrice")
    private double totalPrice;

    @Column(name = "currency", length = 45)
    private String currency;

    @Column(name = "status", length = 45)
    private String status;

    @Column(name = "contactName", length = 45)
    private String contactName;

    @Column(name = "contactNumber", length = 45)
    private String contactNumber;

    @Column(name = "dAddress1", length = 45)
    private String dAddress1;
    
    @Column(name = "dAddress2", length = 45)
    private String dAddress2;
    
    @Column(name = "priceBeforeDisc")
    private double priceBeforeDisc;
    
    @Column(name = "shippingFee")
    private double shippingFee;
    
    @Column(name = "discountedPrice")
    private double discountedPrice;
    
    @Column(name = "dCountry", length = 45)
    private String dCountry;
    
    @Column(name = "dState", length = 45)
    private String dState;
    
    @Column(name = "dCity", length = 45)
    private String dCity;
    
    @Column(name = "dPostalCode", length = 45)
    private String dPostalCode;
    
    @Column(name = "dContact", length = 45)
    private String dContact;
    
    @Column(name = "sAddress1", length = 45)
    private String sAddress1;
    
    @Column(name = "sAddress2", length = 45)
    private String sAddress2;
    
    @Column(name = "sCountry", length = 45)
    private String sCountry;

    @Column(name = "sState", length = 45)
    private String sState;

    @Column(name = "sPostalCode", length = 45)
    private String sPostalCode;

    @Column(name = "sCity", length = 45)
    private String sCity;

    @Column(name = "sContactNum", length = 45)
    private String sContactNum;
    
    @ManyToOne
    private Customer customer;
   
    @OneToMany (cascade = {CascadeType.ALL}, mappedBy = "orderDetail")
    private Collection<OrderItem> orderItemCollection;
    
    @OneToOne (cascade = {CascadeType.ALL})
    private Payment payment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetail)) {
            return false;
        }
        OrderDetail other = (OrderDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrderDetail[ id=" + id + " ]";
    }

    /**
     * @return the ordDate
     */
    public Timestamp getOrdDate() {
        return ordDate;
    }

    /**
     * @param ordDate the ordDate to set
     */
    public void setOrdDate(Timestamp ordDate) {
        this.ordDate = ordDate;
    }

    /**
     * @return the totalPrice
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the contactName
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * @param contactName the contactName to set
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * @return the contactNumber
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * @param contactNumber the contactNumber to set
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * @return the dAddress1
     */
    public String getdAddress1() {
        return dAddress1;
    }

    /**
     * @param dAddress1 the dAddress1 to set
     */
    public void setdAddress1(String dAddress1) {
        this.dAddress1 = dAddress1;
    }

    /**
     * @return the dAddress2
     */
    public String getdAddress2() {
        return dAddress2;
    }

    /**
     * @param dAddress2 the dAddress2 to set
     */
    public void setdAddress2(String dAddress2) {
        this.dAddress2 = dAddress2;
    }

    /**
     * @return the priceBeforeDisc
     */
    public double getPriceBeforeDisc() {
        return priceBeforeDisc;
    }

    /**
     * @param priceBeforeDisc the priceBeforeDisc to set
     */
    public void setPriceBeforeDisc(double priceBeforeDisc) {
        this.priceBeforeDisc = priceBeforeDisc;
    }

    /**
     * @return the shippingFee
     */
    public double getShippingFee() {
        return shippingFee;
    }

    /**
     * @param shippingFee the shippingFee to set
     */
    public void setShippingFee(double shippingFee) {
        this.shippingFee = shippingFee;
    }

    /**
     * @return the discountedPrice
     */
    public double getDiscountedPrice() {
        return discountedPrice;
    }

    /**
     * @param discountedPrice the discountedPrice to set
     */
    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    /**
     * @return the dCountry
     */
    public String getdCountry() {
        return dCountry;
    }

    /**
     * @param dCountry the dCountry to set
     */
    public void setdCountry(String dCountry) {
        this.dCountry = dCountry;
    }

    /**
     * @return the dState
     */
    public String getdState() {
        return dState;
    }

    /**
     * @param dState the dState to set
     */
    public void setdState(String dState) {
        this.dState = dState;
    }

    /**
     * @return the dCity
     */
    public String getdCity() {
        return dCity;
    }

    /**
     * @param dCity the dCity to set
     */
    public void setdCity(String dCity) {
        this.dCity = dCity;
    }

    /**
     * @return the dPostalCode
     */
    public String getdPostalCode() {
        return dPostalCode;
    }

    /**
     * @param dPostalCode the dPostalCode to set
     */
    public void setdPostalCode(String dPostalCode) {
        this.dPostalCode = dPostalCode;
    }

    /**
     * @return the dContact
     */
    public String getdContact() {
        return dContact;
    }

    /**
     * @param dContact the dContact to set
     */
    public void setdContact(String dContact) {
        this.dContact = dContact;
    }

    /**
     * @return the sAddress1
     */
    public String getsAddress1() {
        return sAddress1;
    }

    /**
     * @param sAddress1 the sAddress1 to set
     */
    public void setsAddress1(String sAddress1) {
        this.sAddress1 = sAddress1;
    }

    /**
     * @return the sAddress2
     */
    public String getsAddress2() {
        return sAddress2;
    }

    /**
     * @param sAddress2 the sAddress2 to set
     */
    public void setsAddress2(String sAddress2) {
        this.sAddress2 = sAddress2;
    }

    /**
     * @return the sCountry
     */
    public String getsCountry() {
        return sCountry;
    }

    /**
     * @param sCountry the sCountry to set
     */
    public void setsCountry(String sCountry) {
        this.sCountry = sCountry;
    }

    /**
     * @return the sState
     */
    public String getsState() {
        return sState;
    }

    /**
     * @param sState the sState to set
     */
    public void setsState(String sState) {
        this.sState = sState;
    }

    /**
     * @return the sPostalCode
     */
    public String getsPostalCode() {
        return sPostalCode;
    }

    /**
     * @param sPostalCode the sPostalCode to set
     */
    public void setsPostalCode(String sPostalCode) {
        this.sPostalCode = sPostalCode;
    }

    /**
     * @return the sCity
     */
    public String getsCity() {
        return sCity;
    }

    /**
     * @param sCity the sCity to set
     */
    public void setsCity(String sCity) {
        this.sCity = sCity;
    }

    /**
     * @return the sContactNum
     */
    public String getsContactNum() {
        return sContactNum;
    }

    /**
     * @param sContactNum the sContactNum to set
     */
    public void setsContactNum(String sContactNum) {
        this.sContactNum = sContactNum;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the orderItemCollection
     */
    public Collection<OrderItem> getOrderItemCollection() {
        return orderItemCollection;
    }

    /**
     * @param orderItemCollection the orderItemCollection to set
     */
    public void setOrderItemCollection(Collection<OrderItem> orderItemCollection) {
        this.orderItemCollection = orderItemCollection;
    }

    /**
     * @return the payment
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
}
