package entity;

import entity.SubCategories;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-03-12T23:40:17")
@StaticMetamodel(Categories.class)
public class Categories_ { 

    public static volatile CollectionAttribute<Categories, SubCategories> subCategoriesCollection;
    public static volatile SingularAttribute<Categories, String> name;
    public static volatile SingularAttribute<Categories, Long> id;

}