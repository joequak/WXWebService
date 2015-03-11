/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rate;

import RatingSessionBean.RatingSessionBeanLocal;

import entity.Rate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.xml.ws.WebServiceRef;
import net.webservicex.Country;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author wangyan
 */
@Named(value = "ratingManagedBean")
@ViewScoped
public class ratingManagedBean implements Serializable {

   

    @EJB
    RatingSessionBeanLocal ratingSB;

    private Long ratingId;
    private Integer ratingStar;

    /**
     * Creates a new instance of ratingManagedBean
     */
    public ratingManagedBean() {
    }

    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public Integer getRatingStar() {
        return ratingStar;
    }

    public void setRatingStar(Integer ratingStar) {
        this.ratingStar = ratingStar;
    }

   

    

   

    // webservice to get all the country
    

}
