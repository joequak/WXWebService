package entity;

import entity.Categories;
import entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-03-12T23:40:17")
@StaticMetamodel(SubCategories.class)
public class SubCategories_ { 

    public static volatile CollectionAttribute<SubCategories, Product> productCollection;
    public static volatile SingularAttribute<SubCategories, String> name;
    public static volatile SingularAttribute<SubCategories, Long> id;
    public static volatile SingularAttribute<SubCategories, Categories> categories;

}