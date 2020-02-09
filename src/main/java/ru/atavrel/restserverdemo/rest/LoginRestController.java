package ru.atavrel.restserverdemo.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.atavrel.restserverdemo.dto.AuthenticationRequestDTO;
import ru.atavrel.restserverdemo.dto.AuthenticationResponseDTO;
import ru.atavrel.restserverdemo.model.Role;
import ru.atavrel.restserverdemo.model.User;
import ru.atavrel.restserverdemo.security.UserDetailsServiceImpl;
import ru.atavrel.restserverdemo.service.UserService;
import ru.atavrel.restserverdemo.util.JwtUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(value = "http://localhost:8080")
public class LoginRestController {

    private AuthenticationManager authenticationManager;
    private UserDetailsServiceImpl userDetailsService;
    private JwtUtil jwtUtil;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    public void setUserDetailsService(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void setJwtUtil(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    //POST: http://localhost:8075/api/login
    @PostMapping
    public ResponseEntity<AuthenticationResponseDTO> createAuthenticationToken(@RequestBody AuthenticationRequestDTO requestDTO) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDTO.getUsername(), requestDTO.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect email or password", e);
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(requestDTO.getUsername());
        String jwtToken = jwtUtil.generateToken(userDetails);
        User user = userService.getUserByEmail(requestDTO.getUsername());
        Set<Role> roles = user.getRoles();
        List<String> roleList = new ArrayList<>();
        for (Role role : roles) {
            roleList.add(role.getRole());
        }
        return new ResponseEntity<>(new AuthenticationResponseDTO(jwtToken, roleList), HttpStatus.OK);
    }
}
