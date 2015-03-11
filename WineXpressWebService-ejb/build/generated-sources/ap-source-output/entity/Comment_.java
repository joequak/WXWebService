package entity;

import entity.AdminUsr;
import entity.Customer;
import entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-03-12T00:53:15")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Product> product;
    public static volatile SingularAttribute<Comment, AdminUsr> adminUsr;
    public static volatile SingularAttribute<Comment, String> comment;
    public static volatile SingularAttribute<Comment, Long> id;
    public static volatile SingularAttribute<Comment, Customer> customer;

}