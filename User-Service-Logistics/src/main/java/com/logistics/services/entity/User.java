package com.logistics.services.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true, nullable=false)
	private String username;
	
	@Column(unique=true, nullable=false)
	private String email;
	
	private String password;
	
	private String firstName;
	
	private String LastName;
	
	@Column(unique=true, nullable=false)
	private String phoneNumber;
	
	@Column(nullable=false)
	private String address;
	
	@Column(nullable=false)
	private String state;
	
	@Column(nullable=false)
	private String country;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Role role;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="blacklisted_tokens")
	@Column(name="token")
	private Set<String> blacklistedTokens = new HashSet<>();
	
}
