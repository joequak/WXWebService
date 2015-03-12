package entity;

import entity.Comment;
import entity.OrderItem;
import entity.Rate;
import entity.SubCategories;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-03-12T23:40:17")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Double> averageRate;
    public static volatile SingularAttribute<Product, Integer> availableQuantity;
    public static volatile SingularAttribute<Product, String> country;
    public static volatile SingularAttribute<Product, Integer> numberOfRate;
    public static volatile SingularAttribute<Product, Double> cost;
    public static volatile CollectionAttribute<Product, Comment> commentCollection;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, Integer> discount;
    public static volatile SingularAttribute<Product, String> picture;
    public static volatile SingularAttribute<Product, Integer> soldQuantity;
    public static volatile SingularAttribute<Product, String> volume;
    public static volatile CollectionAttribute<Product, OrderItem> orderItemCollection;
    public static volatile CollectionAttribute<Product, Rate> rateCollection;
    public static volatile SingularAttribute<Product, Double> price;
    public static volatile CollectionAttribute<Product, SubCategories> subCategoriesCollection;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, Long> id;

}