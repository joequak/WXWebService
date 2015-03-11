package entity;

import entity.Customer;
import entity.OrderItem;
import entity.Payment;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-03-12T00:53:15")
@StaticMetamodel(OrderDetail.class)
public class OrderDetail_ { 

    public static volatile SingularAttribute<OrderDetail, Double> totalPrice;
    public static volatile SingularAttribute<OrderDetail, String> sPostalCode;
    public static volatile SingularAttribute<OrderDetail, String> sCity;
    public static volatile SingularAttribute<OrderDetail, String> dCity;
    public static volatile SingularAttribute<OrderDetail, Timestamp> ordDate;
    public static volatile SingularAttribute<OrderDetail, String> sCountry;
    public static volatile SingularAttribute<OrderDetail, String> dCountry;
    public static volatile SingularAttribute<OrderDetail, String> contactNumber;
    public static volatile SingularAttribute<OrderDetail, String> currency;
    public static volatile SingularAttribute<OrderDetail, Payment> payment;
    public static volatile SingularAttribute<OrderDetail, Long> id;
    public static volatile SingularAttribute<OrderDetail, String> dPostalCode;
    public static volatile SingularAttribute<OrderDetail, String> sState;
    public static volatile SingularAttribute<OrderDetail, String> dState;
    public static volatile SingularAttribute<OrderDetail, String> sAddress1;
    public static volatile SingularAttribute<OrderDetail, String> sAddress2;
    public static volatile SingularAttribute<OrderDetail, String> contactName;
    public static volatile SingularAttribute<OrderDetail, String> dAddress1;
    public static volatile CollectionAttribute<OrderDetail, OrderItem> orderItemCollection;
    public static volatile SingularAttribute<OrderDetail, String> dAddress2;
    public static volatile SingularAttribute<OrderDetail, Double> shippingFee;
    public static volatile SingularAttribute<OrderDetail, Double> discountedPrice;
    public static volatile SingularAttribute<OrderDetail, String> dContact;
    public static volatile SingularAttribute<OrderDetail, Double> priceBeforeDisc;
    public static volatile SingularAttribute<OrderDetail, String> sContactNum;
    public static volatile SingularAttribute<OrderDetail, String> status;
    public static volatile SingularAttribute<OrderDetail, Customer> customer;

}