package entity;

import entity.BillToAddress;
import entity.Comment;
import entity.CreditCard;
import entity.OrderDetail;
import entity.Rate;
import entity.ShipToAddress;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-03-12T23:40:17")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> lastName;
    public static volatile SingularAttribute<Customer, String> password;
    public static volatile SingularAttribute<Customer, String> fistName;
    public static volatile CollectionAttribute<Customer, OrderDetail> orderDetailCollection;
    public static volatile CollectionAttribute<Customer, Rate> rateCollection;
    public static volatile CollectionAttribute<Customer, BillToAddress> billToAdressCollection;
    public static volatile CollectionAttribute<Customer, Comment> commentCollection;
    public static volatile SingularAttribute<Customer, Long> id;
    public static volatile CollectionAttribute<Customer, ShipToAddress> shipToAddressCollection;
    public static volatile SingularAttribute<Customer, String> email;
    public static volatile CollectionAttribute<Customer, CreditCard> creditCardCollection;
    public static volatile SingularAttribute<Customer, Boolean> status;

}