package is.flights._8F.Repositories;
import is.flights._8F.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    Page<Flight> findAll(Pageable pageable);
    Page<Flight> findBySeatsAvailable(int passenger, Pageable pageable);
    Page<Flight> findBySeatsAvailableGreaterThanEqualAndScheduledTimeGreaterThan(int passenger, Date date, Pageable pageable);

    List<Flight> findByDepartureAndArrival(String departure, String arrival);

    List<Flight> findByDepartureAndArrivalAndScheduledTimeBetween(String departure, String arrival, Date startOf, Date endOf);

    Page<Flight> findByScheduledTimeGreaterThanAndSeatsAvailableGreaterThanEqual( Date date, int passengers, Pageable pageable);

    Page<Flight> findByDepartureAndArrivalAndScheduledTimeBetweenAndSeatsAvailableGreaterThanEqual(String departure, String arrival, Date startOf, Date endOf, int passengers, Pageable pageable);

    Page<Flight> findByScheduledTimeGreaterThanAndSeatsAvailable(Date date, int passengers, Pageable pageable);
}