/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineXpressWebServices;

import entity.Categories;
import entity.Product;
import entity.SubCategories;
import java.util.ArrayList;
import java.util.Collection;
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
public class SubCategorySessionBean implements SubCategorySessionBeanLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean addNewSubcategory(Categories category, String subName) {
        boolean result = true;
        Query q = em.createQuery("SELECT c FROM SubCategories c");
        for (Object o : q.getResultList()) {
            SubCategories mySub = (SubCategories) o;
            if (mySub.getName().equalsIgnoreCase(subName)) {
                result = false;
            }
        }
        if (result) {
            SubCategories newSub = new SubCategories();
            newSub.setName(subName);
            em.persist(newSub);
            category.getSubCategoriesCollection().add(newSub);
            em.merge(category);
            em.flush();
        }

        return result;
    }

    @Override
    public boolean deleteSubCategory(SubCategories mySub) {
        boolean result = false;
        SubCategories deSub = em.find(SubCategories.class, mySub.getId());
        Categories myCat = new Categories();
        Query q = em.createQuery("SELECT c FROM Categories c");
        for (Object o : q.getResultList()) {
            Categories cat = (Categories) o;
            for (Object oo : cat.getSubCategoriesCollection()) {
                SubCategories sub = (SubCategories) oo;
                if (sub.getName().equalsIgnoreCase(mySub.getName())) {
                   myCat = cat;
                   break;
                }
            }
        }
        if(myCat!=null){
            Collection<SubCategories> toUpdate = myCat.getSubCategoriesCollection();
            toUpdate.remove(deSub);
            myCat.setSubCategoriesCollection(toUpdate);
            em.merge(myCat);
            em.flush();
            
            em.remove(deSub);
            em.flush();
            result=true;
        }
        
        return result;
    }

    @Override
    public Categories getCategoryById(long caId) {
        Categories myCat = new Categories();
        myCat = em.find(Categories.class, caId);
        return myCat;
    }

    @Override
    public List<SubCategories> getProductAllSubCate(Product myProduct) {
        List<SubCategories> result = new ArrayList();
        Query q = em.createQuery("SELECT c FROM SubCategories c");
        for(Object o: q.getResultList()){
            SubCategories sub = (SubCategories) o;
            for(Object oo: sub.getProductCollection()){
                Product myPro = (Product )oo;
                if(myPro.getId()==myProduct.getId()){
                    result.add(sub);
                }
            }
        }
        return result;
    }

    @Override
    public void removeProductFromSubCate(List<SubCategories> listOfSub, Product myProduct) {
          for (Object o : listOfSub) {
            SubCategories ss = (SubCategories) o;
            if (ss.getProductCollection().contains(myProduct)) {
                ss.getProductCollection().remove(myProduct);
                em.persist(ss);
            }
        }
    }
    
    




}
