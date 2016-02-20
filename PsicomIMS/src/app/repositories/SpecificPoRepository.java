package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.SpecificPo;

public interface SpecificPoRepository  extends JpaRepository<SpecificPo, Long> {
}




