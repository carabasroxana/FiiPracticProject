package com.fiipractic;

import com.fiipractic.dto.*;
import com.fiipractic.security.JwtTokenUtil;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtTokenUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    public AuthController(AuthenticationManager am,
                          JwtTokenUtil jwtUtil,
                          UserDetailsService uds) {
        this.authManager = am;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = uds;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest req) {
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(req.username(), req.password());
        authManager.authenticate(authToken);

        UserDetails user = userDetailsService.loadUserByUsername(req.username());
        String token = jwtUtil.generateToken(user.getUsername());
        return new AuthResponse(token);
    }
}
