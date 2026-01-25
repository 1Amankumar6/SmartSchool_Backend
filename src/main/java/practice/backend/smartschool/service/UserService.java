package practice.backend.smartschool.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import practice.backend.smartschool.config.jwt.JwtUtils;
import practice.backend.smartschool.dto.request.LoginRequest;
import practice.backend.smartschool.dto.request.SignUpRequest;
import practice.backend.smartschool.dto.response.JwtAuthenticationResponse;
import practice.backend.smartschool.dto.response.SignUpResponse;
import practice.backend.smartschool.model.Role;
import practice.backend.smartschool.model.User;
import practice.backend.smartschool.repository.UserRepository;
import practice.backend.smartschool.service.impl.UserDetailsImpl;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public SignUpResponse signup(SignUpRequest request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.valueOf("ROLE_"+request.getRole()));

        User savedUser = userRepository.save(user);

        return new SignUpResponse(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getEmail(),
                savedUser.getRole().name()
        );
    }

    public JwtAuthenticationResponse login(LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String token = jwtUtils.generateToken(userDetails);

        return new JwtAuthenticationResponse(request.getUsername(), token, "Bearer");
    }
}
