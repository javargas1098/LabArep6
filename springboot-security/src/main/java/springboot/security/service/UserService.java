package springboot.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import springboot.security.model.User;
import springboot.security.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
