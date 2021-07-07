package uz.talaba.talabauz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import uz.talaba.talabauz.config.JwtUtil;
import uz.talaba.talabauz.security.Token;
import uz.talaba.talabauz.security.UserMaxsus;
import uz.talaba.talabauz.security.UserProvider;


@RestController
@CrossOrigin(maxAge = 3600)
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserProvider userProvider;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserMaxsus userMaxsus)
            throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    userMaxsus.getUsername(), userMaxsus.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

         UserDetails userDetails = userProvider.loadUserByUsername(userMaxsus.getUsername());

         String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new Token(token));
    }

}