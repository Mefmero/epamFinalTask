package entity;

import entity.Contacts;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-19T20:40:55")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile CollectionAttribute<Users, Contacts> contactsCollection;
    public static volatile SingularAttribute<Users, String> pass;
    public static volatile SingularAttribute<Users, String> login;

}