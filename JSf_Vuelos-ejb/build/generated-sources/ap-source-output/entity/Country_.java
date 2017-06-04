package entity;

import entity.City;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-06-04T11:10:58")
@StaticMetamodel(Country.class)
public class Country_ { 

    public static volatile SingularAttribute<Country, String> country;
    public static volatile SingularAttribute<Country, String> countryIsoCode;
    public static volatile CollectionAttribute<Country, City> cityCollection;
    public static volatile SingularAttribute<Country, String> region;

}