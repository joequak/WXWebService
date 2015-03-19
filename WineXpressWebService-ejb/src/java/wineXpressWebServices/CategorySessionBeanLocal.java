/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineXpressWebServices;

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

    public Categories searchCategories(String categoriesName);

    public List<Categories> viewAllCategories();

    public boolean deleteCategories(long categoryId);

    public void editCategories(Categories newCategories);

    public List<String> getCategoriesName();

    public List<String> getSubCategoryNameList(String categoryName);

    public boolean editCategoryName(String newName, Categories myCat);
}
