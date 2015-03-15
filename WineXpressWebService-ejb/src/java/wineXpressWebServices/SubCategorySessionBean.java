/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineXpressWebServices;

import entity.Categories;
import entity.SubCategories;
import java.util.Collection;
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
    public long saveSubCategories(String categoryName, String subcategoriesName) {
        System.out.println("enter saveSubCategories method in SubCategorySessionBean.java");

        Query query = em.createQuery("SELECT CC FROM Categories CC where cc.name = :categoryName");
        query.setParameter("categoryName", categoryName);
        if (query.getResultList() == null) {
            System.out.print("test print NULL in saveSubCategories method in subCategorySessionBean");
        }
        if (query.getResultList().isEmpty()) {
            System.out.print("test print NULL in saveSubCategories method in subCategorySessionBean");
        }
        Categories c = (Categories) query.getResultList().get(0);
        Collection<SubCategories> sc = c.getSubCategoriesCollection();
        for (Object o : sc) {
            SubCategories sub = (SubCategories) o;
            if (sub.getName().toLowerCase().equals(subcategoriesName.toLowerCase())) {
                System.out.println("add subcategory failed because the subcantegory :" + subcategoriesName + " already existed in " + categoryName);
                return -2l;//subcategories already existed in categoires;
            }

        }
        //no subcategoryName exist in category now,so can add it now
        SubCategories addNew = new SubCategories();
        addNew.setName(subcategoriesName);
        em.persist(addNew);
        em.flush();
        c.getSubCategoriesCollection().add(addNew);
        em.persist(c);
        em.flush();
        return 2l;//successully add subcategories into categories;
    }

}
