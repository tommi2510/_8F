package is.flights._8F.Repositories;
import is.flights._8F.Model.Booking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}