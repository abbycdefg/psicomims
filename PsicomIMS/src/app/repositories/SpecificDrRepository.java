package app.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.SpecificDr;

public interface SpecificDrRepository extends JpaRepository<SpecificDr, Long> {

}
