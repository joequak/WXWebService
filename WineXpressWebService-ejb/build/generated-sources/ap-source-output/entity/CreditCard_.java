package entity;

import entity.Customer;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-03-12T00:53:15")
@StaticMetamodel(CreditCard.class)
public class CreditCard_ { 

    public static volatile CollectionAttribute<CreditCard, Customer> customerCollection;
    public static volatile SingularAttribute<CreditCard, String> cardHolder;
    public static volatile SingularAttribute<CreditCard, Long> id;
    public static volatile SingularAttribute<CreditCard, String> type;
    public static volatile SingularAttribute<CreditCard, String> cardNumber;
    public static volatile SingularAttribute<CreditCard, String> expDate;

}