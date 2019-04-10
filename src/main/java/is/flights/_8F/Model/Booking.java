package is.flights._8F.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Booking {

    @Id
    @GeneratedValue
    private Long id;
//    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
//    private Set<Passenger> passengers;
    @NonNull
    @ManyToOne
    private User user;

    @ManyToOne
    private Flight flight;

    private Date created;
}
