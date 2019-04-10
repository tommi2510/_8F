package is.flights._8F.Controller;

import is.flights._8F.Model.Flight;
import is.flights._8F.Repositories.FlightRepository;
import javafx.scene.control.Pagination;
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
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Optional;
import java.time.LocalDate;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api")
class FlightController {

    private final Logger log = LoggerFactory.getLogger(FlightController.class);
    private FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @GetMapping("/flights")
    Page<Flight> flights(@RequestParam("departure") Optional<String> departure,
                               @RequestParam("arrival") Optional<String> arrival,
                               @RequestParam("scheduledTime") Optional<String> scheduledTime,
                               @RequestParam("passenger") Optional<Integer> passenger,
                               @RequestParam("page") Optional<Integer> page) {

        String currentDeparture = departure.orElse("No departure");
        String currentArrival = arrival.orElse("No arrival");
        String currentDate = scheduledTime.orElse("No date");
        int currentPassenger = passenger.orElse(-1);
        int currentPage = page.orElse(1);




        Pageable pagination = PageRequest.of(currentPage - 1, 10, Sort.by("scheduledTime").ascending());


        if (currentDeparture.equals("No departure") ||
            currentArrival.equals("No arrival") ||
            currentDate.equals("No date") ||
            currentPassenger <= 0
        ) {
            Date date = new Date();
            return flightRepository.findBySeatsAvailableGreaterThanEqualAndScheduledTimeGreaterThan(currentPassenger, date, pagination);
        } else {

        }

        try {
            Date date = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z (zzzz)").parse(currentDate);
            System.out.println(date);

            LocalDate locallinn = date.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            LocalDateTime startOfDay = LocalDateTime.of(locallinn, LocalTime.MIDNIGHT);
            LocalDateTime endOfDay = LocalDateTime.of(locallinn, LocalTime.MAX);


            Timestamp startDate = Timestamp.valueOf(startOfDay);
            Timestamp endDate = Timestamp.valueOf(endOfDay);

            System.out.println("passenger: " + currentPassenger);

            return flightRepository.findByDepartureAndArrivalAndScheduledTimeBetweenAndSeatsAvailableGreaterThanEqual(currentDeparture, currentArrival, startDate, endDate, currentPassenger, pagination);
        } catch (ParseException e) {
            System.out.println(e);
        }

        Date date = new Date();
        return flightRepository.findBySeatsAvailableGreaterThanEqualAndScheduledTimeGreaterThan(currentPassenger, date, pagination);
    }

    @GetMapping("/search")
    Collection<Flight> searchFlights(
            @RequestParam("departure") String departure,
            @RequestParam("arrival") String arrival
    )
    {
        return flightRepository.findByDepartureAndArrival(departure, arrival);
    }

    @GetMapping("/flight/{id}")
    ResponseEntity<?> getFlight(@RequestParam Long id) {
        Optional<Flight> flight = flightRepository.findById(id);
        return flight.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/flight")
    ResponseEntity<Flight> createFlight(@Valid @RequestBody Flight flight) throws URISyntaxException {
        log.info("Request to create flight: {}", flight);
        Flight result = flightRepository.save(flight);
        return ResponseEntity.created(new URI("/api/flight/" + result.getId()))
                .body(result);
    }

    @PutMapping("/flight")
    ResponseEntity<Flight> updateFlight(@Valid @RequestBody Flight flight) {
        log.info("Request to update flight: {}", flight);
        Flight result = flightRepository.save(flight);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/flight/{id}")
    public ResponseEntity<?> deleteFlight(@PathVariable Long id) {
        log.info("Request to delete flight: {}", id);
        flightRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
