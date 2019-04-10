package is.flights._8F.Repositories;
import is.flights._8F.Model.Booking;
import is.flights._8F.Model.Passenger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long>  {
    Page<Passenger> findByBooking(Booking booking, Pageable pageable);
}
