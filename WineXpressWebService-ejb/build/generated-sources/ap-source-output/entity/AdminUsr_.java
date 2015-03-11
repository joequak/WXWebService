package entity;

import entity.Comment;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-03-12T00:53:15")
@StaticMetamodel(AdminUsr.class)
public class AdminUsr_ { 

    public static volatile SingularAttribute<AdminUsr, String> firstName;
    public static volatile SingularAttribute<AdminUsr, String> lastName;
    public static volatile SingularAttribute<AdminUsr, String> password;
    public static volatile CollectionAttribute<AdminUsr, Comment> commentCollection;
    public static volatile SingularAttribute<AdminUsr, Long> id;
    public static volatile SingularAttribute<AdminUsr, String> email;
    public static volatile SingularAttribute<AdminUsr, Boolean> status;

}