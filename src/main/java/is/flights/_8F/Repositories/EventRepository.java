package is.flights._8F.Repositories;
import is.flights._8F.Model.Event;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}