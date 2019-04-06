package is.flights._8F.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany
    private Set<Passenger> passengers;
    @NonNull

    @ManyToOne(cascade=CascadeType.PERSIST)
    private User user;

    @ManyToOne(cascade=CascadeType.PERSIST)
    private Flight flight;

    private Date created;
}
