/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CategorySessionBean;

import entity.Categories;
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
            return -2l;
        }else{
        Categories category = new Categories();
        category.setName(categoryName);
        em.persist(category);
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
        return query.getResultList();
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
}
