package com.example.authentification.Controller;

import com.example.authentification.DTO.AuthResponseDTO;
import com.example.authentification.DTO.LoginDto;
import com.example.authentification.DTO.RegisterDto;
import com.example.authentification.Entity.RoleEntity;
import com.example.authentification.Entity.UserEntity;
import com.example.authentification.Repository.RoleRepository;
import com.example.authentification.Repository.UserRepository;
import com.example.authentification.Security.JWTGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JWTGenerator jwtGenerator;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody RegisterDto registerDto) {
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(Collections.singletonMap("error", "Username is taken!")); // 400
        }
        UserEntity user = new UserEntity();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        Optional<RoleEntity> optionalRole = roleRepository.findByName("USER");
        if (!optionalRole.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("error", "Role not found!")); // 404
        }
        RoleEntity role = optionalRole.get();
        user.setRoles(Collections.singletonList(role));
        userRepository.save(user);
        return ResponseEntity
                .ok(Collections.singletonMap("message", "User registered successfully!")); // 200
    }
    @PostMapping("/admin/register")
    public ResponseEntity<Map<String, String>> registerAdmin(@RequestBody RegisterDto registerDto) {
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(Collections.singletonMap("error", "Username is taken!")); // 400
        }
        UserEntity user = new UserEntity();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        Optional<RoleEntity> optionalRole = roleRepository.findByName("ADMIN");
        if (!optionalRole.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("error", "Role not found!")); // 404
        }
        RoleEntity role = optionalRole.get();
        user.setRoles(Collections.singletonList(role));
        userRepository.save(user);
        return ResponseEntity
                .ok(Collections.singletonMap("message", "User registered successfully!")); // 200
    }
    @PostMapping("login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtGenerator.generateToken(authentication);

            return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






}
