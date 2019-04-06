package is.flights._8F.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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
    private Long userId;
    @ManyToMany
    private Set<Passenger> passengers;
    @NonNull
    @Column(unique=true, nullable = false)
    private String email;


    @ManyToOne(cascade=CascadeType.PERSIST)
    private User user;

    @ManyToOne(cascade=CascadeType.PERSIST)
    private Flight flight;
}
