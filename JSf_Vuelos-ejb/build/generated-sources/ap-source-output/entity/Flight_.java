package entity;

import entity.City;
import entity.FlightPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-06-04T11:10:58")
@StaticMetamodel(Flight.class)
public class Flight_ { 

    public static volatile SingularAttribute<Flight, Date> arriveTime;
    public static volatile SingularAttribute<Flight, Character> meal;
    public static volatile SingularAttribute<Flight, Date> departTime;
    public static volatile SingularAttribute<Flight, String> aircraft;
    public static volatile SingularAttribute<Flight, FlightPK> flightPK;
    public static volatile SingularAttribute<Flight, Double> flyingTime;
    public static volatile SingularAttribute<Flight, City> destAirport;
    public static volatile SingularAttribute<Flight, Integer> miles;
    public static volatile SingularAttribute<Flight, City> origAirport;

}