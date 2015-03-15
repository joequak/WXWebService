/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author ¿.¿.¿
 */
@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "name", length = 200)
    private String name;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private double price;
    
    @Column(name = "cost")
    private double cost;
    
    @Column(name = "description", length = 1000)
    private String description;
    
    @Column(name = "availableQuantity")
    private int availableQuantity;
    
    @Column(name = "soldQuantity")
    private int soldQuantity=0;
    
    @Column(name = "averageRate")
    private double averageRate=0;
    
    @Column(name = "picture", length = 500)
    private String picture;
    
    @Column(name = "discount")
    private int discount;
    
    @Column(name = "numberOfRate")
    private int numberOfRate=0;
    
    @Column(name = "volumn", length = 45)
    private String volumn;
    
    @OneToMany(cascade = {CascadeType.ALL})
    private Collection<Comment> commentCollection = new ArrayList();
    
    @OneToMany(cascade = {CascadeType.ALL})
    private Collection<Rate> rateCollection = new ArrayList();
 
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "product")
    private Collection<OrderItem> orderItemCollection;

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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Product[ id=" + id + " ]";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the availableQuantity
     */
    public int getAvailableQuantity() {
        return availableQuantity;
    }

    /**
     * @param availableQuantity the availableQuantity to set
     */
    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    /**
     * @return the soldQuantity
     */
    public int getSoldQuantity() {
        return soldQuantity;
    }

    /**
     * @param soldQuantity the soldQuantity to set
     */
    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    /**
     * @return the averageRate
     */
    public double getAverageRate() {
        return averageRate;
    }

    /**
     * @param averageRate the averageRate to set
     */
    public void setAverageRate(double averageRate) {
        this.averageRate = averageRate;
    }

    /**
     * @return the picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * @param picture the picture to set
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * @return the discount
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    /**
     * @return the volumn
     */
    public String getVolumn() {
        return volumn;
    }

    /**
     * @param volumn the volumn to set
     */
    public void setVolumn(String volumn) {
        this.volumn = volumn;
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
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * @return the numberOfRate
     */
    public int getNumberOfRate() {
        return numberOfRate;
    }

    /**
     * @param numberOfRate the numberOfRate to set
     */
    public void setNumberOfRate(int numberOfRate) {
        this.numberOfRate = numberOfRate;
    }
    
}
