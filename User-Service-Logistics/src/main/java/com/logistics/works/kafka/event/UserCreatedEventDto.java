package com.logistics.works.kafka.event;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreatedEventDto {

	private UUID id;
	private String username;
	private String email;
	private String phoneNumber;
	
}
