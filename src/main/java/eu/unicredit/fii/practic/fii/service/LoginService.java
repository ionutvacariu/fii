package eu.unicredit.fii.practic.fii.service;

import eu.unicredit.fii.practic.fii.model.Login;
import eu.unicredit.fii.practic.fii.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(Login user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
    }

}
