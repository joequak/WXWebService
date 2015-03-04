/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author ¿.¿.¿
 */
@Entity
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "fistName", length = 100)
    private String fistName;
    
    @Column(name = "lastName", length = 100)
    private String lastName;
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Column(unique=true, name = "email", length = 100)
    private String email;
    
    @Column(name = "password", length = 45)
    private String password;
    
    @Column(name = "status")
    private Boolean status;

    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "customerCollection")
    private Collection<ShipToAddress> shipToAddressCollection;
    
    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "customerCollection")
    private Collection<BillToAddress> billToAdressCollection;
    
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "customer")
    private Collection<Comment> commentCollection;
    
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "customer")
    private Collection<OrderDetail> orderDetailCollection;
    
    @ManyToMany(cascade = {CascadeType.ALL})
    private Collection<CreditCard> creditCardCollection;
    
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "customer")
    private Collection<Rate> rateCollection;

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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Customer[ id=" + id + " ]";
    }

    /**
     * @return the fistName
     */
    public String getFistName() {
        return fistName;
    }

    /**
     * @param fistName the fistName to set
     */
    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the status
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * @return the shipToAddressCollection
     */
    public Collection<ShipToAddress> getShipToAddressCollection() {
        return shipToAddressCollection;
    }

    /**
     * @param shipToAddressCollection the shipToAddressCollection to set
     */
    public void setShipToAddressCollection(Collection<ShipToAddress> shipToAddressCollection) {
        this.shipToAddressCollection = shipToAddressCollection;
    }

    /**
     * @return the billToAdressCollection
     */
    public Collection<BillToAddress> getBillToAdressCollection() {
        return billToAdressCollection;
    }

    /**
     * @param billToAdressCollection the billToAdressCollection to set
     */
    public void setBillToAdressCollection(Collection<BillToAddress> billToAdressCollection) {
        this.billToAdressCollection = billToAdressCollection;
    }

    /**
     * @return the commentCollection
     */
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    /**
     * @param commentCollection the commentCollection to set
     */
    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    /**
     * @return the orderDetailCollection
     */
    public Collection<OrderDetail> getOrderDetailCollection() {
        return orderDetailCollection;
    }

    /**
     * @param orderDetailCollection the orderDetailCollection to set
     */
    public void setOrderDetailCollection(Collection<OrderDetail> orderDetailCollection) {
        this.orderDetailCollection = orderDetailCollection;
    }

    /**
     * @return the creditCardCollection
     */
    public Collection<CreditCard> getCreditCardCollection() {
        return creditCardCollection;
    }

    /**
     * @param creditCardCollection the creditCardCollection to set
     */
    public void setCreditCardCollection(Collection<CreditCard> creditCardCollection) {
        this.creditCardCollection = creditCardCollection;
    }

    /**
     * @return the rateCollection
     */
    public Collection<Rate> getRateCollection() {
        return rateCollection;
    }

    /**
     * @param rateCollection the rateCollection to set
     */
    public void setRateCollection(Collection<Rate> rateCollection) {
        this.rateCollection = rateCollection;
    }
    
}
