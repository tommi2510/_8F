package is.flights._8F.Repositories;
import is.flights._8F.Model.Booking;
import is.flights._8F.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Page<Booking> findByUser(User user, Pageable pageable);
}