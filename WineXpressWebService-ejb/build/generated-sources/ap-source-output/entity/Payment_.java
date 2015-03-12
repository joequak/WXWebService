package entity;

import entity.OrderDetail;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-03-12T23:40:17")
@StaticMetamodel(Payment.class)
public class Payment_ { 

    public static volatile SingularAttribute<Payment, Double> amount;
    public static volatile SingularAttribute<Payment, String> method;
    public static volatile SingularAttribute<Payment, String> cardHolder;
    public static volatile SingularAttribute<Payment, String> payDay;
    public static volatile SingularAttribute<Payment, OrderDetail> orderDetail;
    public static volatile SingularAttribute<Payment, Long> id;
    public static volatile SingularAttribute<Payment, Integer> cardNumber;

}