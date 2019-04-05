package is.flights._8F.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
/**
 * The class for the Flight itself.
 * The system generates a table schema based on this class for this entity.
 * Be sure to annotate any entities you have with the @Entity annotation.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "flight") // If you want to specify a table name, you can do so here
public class Flight {

    // Declare that this attribute is the id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "scheduledtime", nullable = false, updatable = false)
    private Date scheduledTime;
    @Column(name = "flightno", nullable = false, updatable = false)
    private String flightNo;
    @Column(name = "departure", nullable = false, updatable = false)
    private String departure;
    @Column(name = "departureiata", nullable = false, updatable = false)
    private String departureIATA;
    @Column(name = "arrival", nullable = false, updatable = false)
    private String arrival;
    @Column(name = "arrivaliata", nullable = false, updatable = false)
    private String arrivalIATA;
    @Column(name = "airline", nullable = false, updatable = false)
    private String airline;
    @Column(name = "seats", nullable = false, updatable = true)
    private int seats;
    @Column(name = "seatsavailable", nullable = false, updatable = true)
    private int seatsAvailable;
    @Column(name = "price", nullable = false, updatable = true)
    private int price;
}
