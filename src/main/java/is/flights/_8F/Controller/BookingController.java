package is.flights._8F.Controller;

import is.flights._8F.Model.Booking;
import is.flights._8F.Model.User;
import is.flights._8F.Repositories.BookingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;
import org.springframework.data.domain.Page;


@RestController
@RequestMapping("/api")
class BookingController {

    private final Logger log = LoggerFactory.getLogger(GroupController.class);
    private BookingRepository bookingRepository;

    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @GetMapping("/bookings")
    Collection<Booking> bookings() {
        return bookingRepository.findAll();
    }

    @GetMapping("/users/{user}/bookings")
    Page<Booking> getUserBookings(User user) {

        Pageable pagination = PageRequest.of(0, 10);
        return bookingRepository.findByUser(user, pagination);
    }

    @GetMapping("/booking/{id}")
    ResponseEntity<?> getBooking(@PathVariable Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        return booking.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/booking")
    ResponseEntity<Booking> createBooking(@Valid @RequestBody Booking booking) throws URISyntaxException {
        log.info("Request to create booking: {}", booking);
        Booking result = bookingRepository.save(booking);
        return ResponseEntity.created(new URI("/api/booking/" + result.getId()))
                .body(result);
    }

    @PutMapping("/booking")
    ResponseEntity<Booking> updateBooking(@Valid @RequestBody Booking booking) {
        log.info("Request to update booking: {}", booking);
        Booking result = bookingRepository.save(booking);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/booking/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id) {
        log.info("Request to delete booking: {}", id);
        bookingRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

