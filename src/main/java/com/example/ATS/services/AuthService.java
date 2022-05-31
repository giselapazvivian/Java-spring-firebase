package com.example.ATS.services;

import com.example.ATS.payload.request.LoginRequest;
import com.example.ATS.payload.request.SignupRequest;
import com.example.ATS.payload.response.JwtResponse;
import com.example.ATS.payload.response.MessageResponse;

public interface AuthService {

    /**
     * Authenticate user and generate token
     * 
     * @param loginRequest object with user data
     */
    JwtResponse generateTokenByUser(LoginRequest loginRequest);

    /**
     * Authenticate user and generate token
     * 
     * @param signUpRequest object with user data
     */
    MessageResponse registerUser(SignupRequest signUpRequest);
}