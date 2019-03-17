package com.uaic.bankTrx.service;

import com.uaic.bankTrx.model.UserLoginInfo;
import com.uaic.bankTrx.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserLoginService implements UserDetailsService {

	@Autowired
	private UserLoginRepository userLoginRepository;

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		final UserLoginInfo userLoginInfo = userLoginRepository.findByUserName(s).get();
		List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));
		return User.withDefaultPasswordEncoder().username(userLoginInfo.getUserName())
				.password(userLoginInfo.getPassword()).authorities(authorities).build();

	}
}
