package projektor.projekt;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface Repository extends CrudRepository<Projekt, Long> {

    @Query("SELECT * FROM PROJECT JOIN PERSON WHERE person.id = :name")
    List<Projekt> allPerson(@Param("name") String name);

/*    @Query("SELECT * FROM PROJECT JOIN zeitraum WHERE person.id = :name")*/
List<Projekt> findByZeitraum_vonGreaterThanAndZeitraum_bisLessThan(LocalDate von, LocalDate bis);
    //List<Projekt> findByZeitraum_VonAndZeitraum_BisBefore(LocalDate von, LocalDate bis);
}
