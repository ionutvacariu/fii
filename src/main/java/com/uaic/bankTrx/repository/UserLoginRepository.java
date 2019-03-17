package com.uaic.bankTrx.repository;

import com.uaic.bankTrx.model.User;
import com.uaic.bankTrx.model.UserLoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLoginRepository extends JpaRepository<UserLoginInfo, Long> {
	Optional<UserLoginInfo> findByUserName(String s);
}
