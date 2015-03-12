package entity;

import entity.Customer;
import entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-03-12T23:40:17")
@StaticMetamodel(Rate.class)
public class Rate_ { 

    public static volatile SingularAttribute<Rate, Product> product;
    public static volatile SingularAttribute<Rate, Double> rate;
    public static volatile SingularAttribute<Rate, Long> id;
    public static volatile SingularAttribute<Rate, Customer> customer;

}