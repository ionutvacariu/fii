package eu.unicredit.fii.practic.fii.repository;

import eu.unicredit.fii.practic.fii.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
