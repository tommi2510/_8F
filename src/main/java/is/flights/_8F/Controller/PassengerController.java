package is.flights._8F.Controller;

import is.flights._8F.Model.Passenger;
import is.flights._8F.Repositories.PassengerRepository;
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
class PassengerController {

    private final Logger log = LoggerFactory.getLogger(GroupController.class);
    private PassengerRepository passengerRepository;

    public PassengerController(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @GetMapping("/passengers")
    Collection<Passenger> passengers() {
        return passengerRepository.findAll();
    }

    @GetMapping("/passenger/{id}")
    ResponseEntity<?> getPassenger(@PathVariable Long id) {
        Optional<Passenger> passenger = passengerRepository.findById(id);
        return passenger.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/passenger")
    ResponseEntity<Passenger> createPassenger(@Valid @RequestBody Passenger passenger) throws URISyntaxException {
        log.info("Request to create passenger: {}", passenger);
        Passenger result = passengerRepository.save(passenger);
        return ResponseEntity.created(new URI("/api/passenger/" + result.getId()))
                .body(result);
    }

    @PutMapping("/passenger")
    ResponseEntity<Passenger> updatePassenger(@Valid @RequestBody Passenger passenger) {
        log.info("Request to update passenger: {}", passenger);
        Passenger result = passengerRepository.save(passenger);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/passenger/{id}")
    public ResponseEntity<?> deletePassenger(@PathVariable Long id) {
        log.info("Request to delete passenger: {}", id);
        passengerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

