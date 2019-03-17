package com.uaic.bankTrx.repository;

import com.uaic.bankTrx.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {


}
