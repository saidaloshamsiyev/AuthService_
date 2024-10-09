package org.example.authservice.service.service.user;



import metube.com.dto.request.LoginDTO;
import metube.com.dto.response.UserResponse;
import org.example.authservice.domain.request.UserRequest;
import org.example.authservice.domain.response.JwtResponse;


import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponse saveUser(UserRequest userRequest);
    UserResponse updateUser(UUID id, UserRequest userRequest);
    void deleteUser(UUID id);
    UserResponse findById(UUID id);
    List<UserResponse>getAllUsers();
    JwtResponse login(LoginDTO loginDTO);

}
