package is.flights._8F.Controller;

import is.flights._8F.Model.Flight;
import is.flights._8F.Repositories.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
class FlightController {

    private final Logger log = LoggerFactory.getLogger(FlightController.class);
    private FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @GetMapping("/flights")
    Collection<Flight> flights(@RequestParam("departure") Optional<String> departure,
                               @RequestParam("arrival") Optional<String> arrival) {

        String currentDeparture = departure.orElse("No departure");
        String currentArrival = arrival.orElse("No arrival");

        if (currentDeparture.equals("No departure") || currentArrival.equals("No arrival")) {
            return flightRepository.findAll();
        }

        return flightRepository.findByDepartureAndArrival(currentDeparture, currentArrival);

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
