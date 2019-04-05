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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "passengers") // If you want to specify a table name, you can do so here

public class Passenger {
    // Declare that this attribute is the id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName", nullable = false, updatable = false)
    private String firstName;
    @Column(name = "lastName", nullable = false, updatable = false)
    private String lastName;
    @Column(name = "luggage", nullable = false, updatable = false)
    private int luggage;
    @Column(name = "priorityB", nullable = false, updatable = false)
    private boolean priorityB;
    @Column(name = "firstClass", nullable = false, updatable = false)
    private boolean firstClass;
    @Column(name = "bookingId", nullable = false, updatable = false)
    private long bookingId;
}

