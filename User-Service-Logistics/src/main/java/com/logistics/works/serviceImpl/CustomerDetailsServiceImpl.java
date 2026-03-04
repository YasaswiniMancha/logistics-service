package com.logistics.works.serviceImpl;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.logistics.works.entity.User;
import com.logistics.works.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerDetailsServiceImpl implements UserDetailsService{

	private final UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("user not found"));
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(),
				user.getPassword(),
				user.getRoles()
				.stream().map(role-> new SimpleGrantedAuthority(role.name()))
				.collect(Collectors.toSet())
				);
		
	}

}
