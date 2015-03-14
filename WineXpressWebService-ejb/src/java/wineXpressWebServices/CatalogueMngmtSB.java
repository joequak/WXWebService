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
 * @author ¿.¿.¿
 */
@Stateless
public class CatalogueMngmtSB implements CatalogueMngmtSBLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //Entity Manager to read write to DB
    @PersistenceContext
    private EntityManager em;

    public CatalogueMngmtSB() {
    }

    @Override
    public Boolean addNewCategory(String name) {
        Categories newCate = new Categories();
        newCate.setName(name);
        em.persist(newCate);
        return true;
    }

    @Override
    public Boolean addNewSubCategori(String cateoryName, String newSubName) {
        Query q = em.createQuery("SELECT c FROM Categories c WHERE c.name = :name");
        q.setParameter("name", newSubName);
        Categories myCate= (Categories) q.getSingleResult();
        if(myCate==null){
            return false;
        }
        else{
            SubCategories newSubCate= new SubCategories();
            newSubCate.setName(newSubName);
            
        }
        return true;
    }
}


