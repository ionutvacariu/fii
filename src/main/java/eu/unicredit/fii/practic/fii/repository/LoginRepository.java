package eu.unicredit.fii.practic.fii.repository;

import eu.unicredit.fii.practic.fii.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login,Long> {
    Optional<Login> findByUsername(String username);

}
