/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineXpressWebServices;

import entity.Categories;
import entity.Product;
import entity.SubCategories;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author wangyan
 */
@Local
public interface SubCategorySessionBeanLocal {

    public boolean addNewSubcategory(Categories category, String subName);

    public boolean deleteSubCategory(SubCategories mySub);

    public Categories getCategoryById(long caId);

    public List<SubCategories> getProductAllSubCate(Product myProduct);

    void removeProductFromSubCate(List<SubCategories> listOfSub, Product myProduct);
}
