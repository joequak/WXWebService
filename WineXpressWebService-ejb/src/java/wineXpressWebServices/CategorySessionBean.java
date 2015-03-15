/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineXpressWebServices;

import entity.Categories;
import entity.SubCategories;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author wangyan
 */
@Stateless
public class CategorySessionBean implements CategorySessionBeanLocal {

    @PersistenceContext
    private EntityManager em;

    public CategorySessionBean() {
    }

    @Override
    public long saveNewCategories(String categoryName) {

        Query query = em.createQuery("select c from Categories c where c.name=:cName");
        query.setParameter("cName", categoryName);
        if(!query.getResultList().isEmpty()){
            System.out.println("Categories added failed, because category :"+categoryName +" already existed in Database");
            return -2l;
        }else{
        Categories category = new Categories();
        category.setName(categoryName);
        em.persist(category);
        em.flush();
        return category.getId();
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<Categories> searchCategories(String categoryName) {
        Query query = em.createQuery("select p from Categories p where p.name = :pName");
        query.setParameter("pName", categoryName);
        return query.getResultList();
    }

    @Override
    public List<Categories> viewAllCategories() {
        Query query = em.createQuery("select p from Categories p");
        List<Categories> returnList = query.getResultList();
        return returnList;
    }

    @Override
    public Categories deleteCategories(long categoryId) {
        Categories category = em.find(Categories.class, categoryId);
        em.remove(category);
        em.flush();
        return category;
    }

    @Override
    public void editCategories(Categories newCategories) {
        Categories origin = em.find(Categories.class, newCategories.getId());
        origin.setName(newCategories.getName());
        em.persist(origin);

    }
    
    @Override
    public List<String> getCategoriesName(){
        List<String> categoriesName = new ArrayList<>();
        categoriesName.clear();
        Query q = em.createQuery("select c from Categories c");
        for(Object o: q.getResultList()){
            Categories category = (Categories)o;
            categoriesName.add(category.getName());
        }
        return categoriesName;
    }
    
  /*  
    @Override
    public List<String> getCountries(){
        List<String> countries = new ArrayList<>();
        countries.clear();
        Query q = em.createQuery("select c from Categories c");
        for(Object o : q.getResultList()){
            Categories category = (Categories)o;
            countries.add(category.getName());      
        }
        return countries;
    }
*/
    @Override
    public List<String> getSubCategoryNameList(String categoryName) {
        List<String> subCategoryList = new ArrayList<>();
        subCategoryList.clear();
        Query q = em.createQuery("select c from Categories c where c.name=:categoryName");
        q.setParameter("categoryName", categoryName);
        if(q.getResultList().isEmpty()){
             return subCategoryList;
        }else{
        Categories cs = (Categories)q.getResultList().get(0);
        for(Object o:cs.getSubCategoriesCollection()){
            SubCategories sc = (SubCategories)o;
            subCategoryList.add(sc.getName());
        }
        return subCategoryList;
        }
    }
}
