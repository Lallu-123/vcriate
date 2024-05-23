package com.resturant.management.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.resturant.management.dto.LoginDto;
import com.resturant.management.security.JwtToken;
import com.resturant.managment.entity.UserLogin;
import com.resturant.managment.repository.UserRepository;

@Service
public class UserAuthenticationService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    public void saveUser(UserLogin user) {
        userRepository.save(user);
    }

    public ResponseEntity authenticate(LoginDto loginDto) {
        UserLogin userLogin = userRepository.findByUsername(loginDto.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
        try {
            Authentication auth = authenticationManager.authenticate(authReq);
            if (auth.isAuthenticated()) {
                String token = JwtToken.getToken(userLogin);
                HttpHeaders responseHeaders = new HttpHeaders();
                responseHeaders.set("Authorization", token);
                return ResponseEntity.ok()
                        .headers(responseHeaders).build();
            }
        } catch (BadCredentialsException | JoseException ex) {
            ex.printStackTrace();
            //throw exception
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username/password");
    }

}
