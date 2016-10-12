package com.akayerov.ipraservice.jpa.security;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.akayerov.ipraservice.jpa.service.MoDAO;

// Негодяй :) в примере не указал этот импорт, впрочем и как все остальные!!!
import static java.util.Arrays.*;
@Service
public class FakeUserDetailsService implements UserDetailsService {
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private PersonDAO personDAO;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
// так в исходнике
//		Person person = personRepository.findByFirstNameEquals(username);
		System.out.println("Person NOW WILL found:" + username);
/*
		//		Person person = personRepository.findByFirstNameLike(username).get(0);

		List<Person> lp = personRepository.findByfirstNameLike(username);
		System.out.println(lp);
		Person person = lp.get(0);
		System.out.println(person);
*/
		Person person = personDAO.getByName(username);
		if (person == null) {
			System.out.println("Person NOT found:" + username);
			throw new UsernameNotFoundException("Username " + username
					+ " not found");
		}
System.out.println("Person found:" + username);
		return new User(username, "password", getGrantedAuthorities(username));
	}

	private Collection<? extends GrantedAuthority> getGrantedAuthorities(
			String username) {
		Collection<? extends GrantedAuthority> authorities;
		
		if (username.equals("Ivan")) {
			authorities = asList(() -> "ROLE_ADMIN", () -> "ROLE_BASIC");
		} else {
			authorities = asList(() -> "ROLE_BASIC");
		}
		return authorities;
	}
}