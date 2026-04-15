package com.IAQMS.IAQMS.Controller;


import com.IAQMS.IAQMS.Model.AdminLoginData;
import com.IAQMS.IAQMS.Service.AdminDetailsService;
import com.IAQMS.IAQMS.Service.JwtService;
import com.IAQMS.IAQMS.dto.AuthRequest;
import com.IAQMS.IAQMS.dto.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/auth")


public class AdminLoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final AdminDetailsService adminDetailsService;

    public AdminLoginController(AuthenticationManager authenticationManager , JwtService jwtService , AdminDetailsService adminDetailsService){
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.adminDetailsService = adminDetailsService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        var adminDetails = adminDetailsService.loadUserByUsername(request.getUsername());

        String jwtToken = jwtService.generateToken(adminDetails);

        return ResponseEntity.ok(new AuthResponse(jwtToken));
    }

}
