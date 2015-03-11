package entity;

import entity.Customer;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-03-12T00:53:15")
@StaticMetamodel(BillToAddress.class)
public class BillToAddress_ { 

    public static volatile SingularAttribute<BillToAddress, String> country;
    public static volatile SingularAttribute<BillToAddress, String> address2;
    public static volatile SingularAttribute<BillToAddress, String> city;
    public static volatile CollectionAttribute<BillToAddress, Customer> customerCollection;
    public static volatile SingularAttribute<BillToAddress, String> address1;
    public static volatile SingularAttribute<BillToAddress, String> postalcode;
    public static volatile SingularAttribute<BillToAddress, String> billState;
    public static volatile SingularAttribute<BillToAddress, String> contactNumber;
    public static volatile SingularAttribute<BillToAddress, Long> id;

}