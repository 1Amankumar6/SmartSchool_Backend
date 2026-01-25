package practice.backend.smartschool.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice.backend.smartschool.dto.request.LoginRequest;
import practice.backend.smartschool.dto.request.SignUpRequest;
import practice.backend.smartschool.dto.response.JwtAuthenticationResponse;
import practice.backend.smartschool.dto.response.SignUpResponse;
import practice.backend.smartschool.service.UserService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/public/login")
    public ResponseEntity<JwtAuthenticationResponse> login(
            @RequestBody LoginRequest request) {

        return ResponseEntity.ok(userService.login(request));
    }

    @PostMapping("/public/signup")
    public ResponseEntity<SignUpResponse> signUp(@RequestBody SignUpRequest request){
        return ResponseEntity.ok(userService.signup(request));
    }

    @GetMapping("/protected")
    public ResponseEntity<String> protectedEndpoint(HttpServletRequest request) {
        String token = getJwtFromHeader(request);
        if (token == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token missing");
        }

        // validate token here...
        return ResponseEntity.ok("Token received: " + token);
    }

    public String getJwtFromHeader(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || authHeader.isBlank()) {
            return null;
        }
        if (!authHeader.startsWith("Bearer ")) {
            return null;
        }
        return authHeader.substring(7).trim();
    }


}
