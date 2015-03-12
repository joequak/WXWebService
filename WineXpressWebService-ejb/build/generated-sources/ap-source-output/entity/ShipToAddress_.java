package entity;

import entity.Customer;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-03-12T23:40:17")
@StaticMetamodel(ShipToAddress.class)
public class ShipToAddress_ { 

    public static volatile SingularAttribute<ShipToAddress, String> country;
    public static volatile SingularAttribute<ShipToAddress, String> address2;
    public static volatile SingularAttribute<ShipToAddress, String> city;
    public static volatile CollectionAttribute<ShipToAddress, Customer> customerCollection;
    public static volatile SingularAttribute<ShipToAddress, String> address1;
    public static volatile SingularAttribute<ShipToAddress, String> postalcode;
    public static volatile SingularAttribute<ShipToAddress, String> contactNumber;
    public static volatile SingularAttribute<ShipToAddress, String> shipState;
    public static volatile SingularAttribute<ShipToAddress, Long> id;

}