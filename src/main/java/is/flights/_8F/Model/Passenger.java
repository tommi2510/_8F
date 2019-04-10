package is.flights._8F.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
/**
 * The class for the Passengers itself.
 * The system generates a table schema based on this class for this entity.
 * Be sure to annotate any entities you have with the @Entity annotation.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "passengers") // If you want to specify a table name, you can do so here
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Passenger {
    // Declare that this attribute is the id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private int luggage;
    private boolean priorityB;
    private boolean firstClass;

    @ManyToOne
    private Booking booking;

}

