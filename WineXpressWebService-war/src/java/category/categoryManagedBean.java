/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package category;

import CategorySessionBean.CategorySessionBeanLocal;

import entity.Categories;
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

import org.primefaces.event.RowEditEvent;

/**
 *
 * @author wangyan
 */
@Named(value = "categoryManagedBean")
@ViewScoped
public class categoryManagedBean implements Serializable {



    @EJB
    CategorySessionBeanLocal categorySB;

    private Long categoryId;
    private String categoryName;

    private String statusMessage;
    private List<Categories> categoryList;
    private List<String> countries;
    private List<Categories> filteredCategories;

    /**
     * Creates a new instance of categoryManagedBean
     */
    public categoryManagedBean() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public List<Categories> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Categories> categoryList) {
        this.categoryList = categoryList;
    }

    public List<String> getCountries() {
        countries = new ArrayList<>();
        countries.clear();
        countries.add("CountryA");
        countries.add("CountryB");
        countries.add("CountryC");
        return countries;
        // return getCountries_1(); // this one need a very long time to run and cause the connectionpool overflow
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    //Methods
    //save new category
    public void saveNewCategory(ActionEvent event) {
        try {
            categoryId = categorySB.saveNewCategories(categoryName);
            if (categoryId != -2l) {
                statusMessage = "category saved successfully";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ADD NEW CATEGORY RESULT: " + statusMessage + "(new category id is " + categoryId + ")", ""));
            } else {
                statusMessage = "category saved failed. category name already exists";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ADD NEW CATEGORY RESULT: " + statusMessage, ""));
            }
        } catch (NumberFormatException e) {
            statusMessage = "category saved failed. invalid number format";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "PLEASE ENTER A VALID NUMBER FORMAT: " + statusMessage, ""));
        }
    }

    //search category
    public void searchCategory(ActionEvent event) {
        categoryList = categorySB.searchCategories(categoryName);
        if (categoryList == null) {
            FacesMessage msg;
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "No such Prduct", "The category you are searching for does not exist");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            categoryList.clear();

        }
    }

    //view all categorys
    public void viewAllcategories(ActionEvent event) {
        categoryList = categorySB.viewAllCategories();
        if (categoryList == null) {
            FacesMessage msg;
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "empty", "No result");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            categoryList.clear();
        }
    }

    //delete category
    public void deletecategory(ActionEvent event) {
        categoryId = (Long) event.getComponent().getAttributes().get("categoryId");
        try {
            Categories category = categorySB.deleteCategories(categoryId);
            statusMessage = " Deleted successfully";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, statusMessage, ""));
            categoryList.remove(category);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Edit the category
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("category Edited");
        Categories edit = (Categories) event.getObject();
        categorySB.editCategories(edit);
        System.out.println("category: " + edit.getName() + " " + edit.getId() + "has been edited");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    //Edit cancelled
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<Categories> getFilteredCategories() {
        return filteredCategories;
    }

    public void setFilteredCategories(List<Categories> filteredCategories) {
        this.filteredCategories = filteredCategories;
    }
/*
    // webservice to get all the country
    private List<String> getCountries_1() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        net.webservicex.CountrySoap port = service.getCountrySoap();
        String s = port.getCountries();
        s = s.replaceAll("<Name>", "@");
        s = s.replaceAll("</Name>", "!");
        String country;
        List<String> countryList = new ArrayList<>();
        countryList.clear();
        while (s.contains("@")) {
            int first = s.indexOf("@");
            int second = s.indexOf("!");
            country = s.substring(first + 1, second);
            countryList.add(country);
            s = s.substring(second + 1);
        }
        return countryList;
    }
*/
}
