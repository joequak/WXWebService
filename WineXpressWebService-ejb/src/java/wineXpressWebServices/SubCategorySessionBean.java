/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineXpressWebServices;

import entity.Categories;
import entity.SubCategories;
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
        }

        return result;
    }

    @Override
    public boolean deleteSubCategory(SubCategories mySub) {
        boolean result = false;
        Categories myCat = new Categories();
        Query q = em.createQuery("SELECT c FROM Categories c");
        for (Object o : q.getResultList()) {
            Categories cat = (Categories) o;
            for (Object oo : cat.getSubCategoriesCollection()) {
                SubCategories sub = (SubCategories) oo;
                if (sub.getName().equalsIgnoreCase(mySub.getName())) {
                    cat.getSubCategoriesCollection().remove(sub);
                    em.remove(mySub);
                    em.flush();
                    result =true;
                }
            }
        }
        return result;
    }

}
