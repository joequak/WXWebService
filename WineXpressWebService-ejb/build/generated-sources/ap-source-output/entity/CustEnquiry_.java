package entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-03-12T00:53:15")
@StaticMetamodel(CustEnquiry.class)
public class CustEnquiry_ { 

    public static volatile SingularAttribute<CustEnquiry, Timestamp> outDate;
    public static volatile SingularAttribute<CustEnquiry, String> emailAddress;
    public static volatile SingularAttribute<CustEnquiry, String> subject;
    public static volatile SingularAttribute<CustEnquiry, Timestamp> inDate;
    public static volatile SingularAttribute<CustEnquiry, Long> id;
    public static volatile SingularAttribute<CustEnquiry, String> reply;
    public static volatile SingularAttribute<CustEnquiry, String> content;

}