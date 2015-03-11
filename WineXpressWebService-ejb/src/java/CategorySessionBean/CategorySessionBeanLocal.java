/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CategorySessionBean;

import entity.Categories;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author wangyan  
 */
@Local
public interface CategorySessionBeanLocal {
     public long saveNewCategories(String categoriesName);
     public List<Categories> searchCategories(String categoriesName);
     public List<Categories> viewAllCategories();
     public Categories deleteCategories(long categoriesId);
     public void editCategories(Categories newCategories);
     public List<String> getCountries();
}

