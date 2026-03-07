package com.logistics.works.service;

import java.util.UUID;
import com.logistics.works.dto.AuthRequestDto;
import com.logistics.works.dto.AuthResponseDto;
import com.logistics.works.dto.UserRequestDto;
import com.logistics.works.dto.UserResponseDto;

public interface UserService {

	AuthResponseDto signup(UserRequestDto request);

	AuthResponseDto login(AuthRequestDto request);

	UserResponseDto getUserById(UUID userId);

	void logout(String token);

	UserResponseDto updateUser(UUID id, UserRequestDto request);
}
