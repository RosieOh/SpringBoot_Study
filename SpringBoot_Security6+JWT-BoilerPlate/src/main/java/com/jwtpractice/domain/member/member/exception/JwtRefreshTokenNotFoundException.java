package com.jwtpractice.domain.member.member.exception;

public class JwtRefreshTokenNotFoundException extends RuntimeException {
    public JwtRefreshTokenNotFoundException(String message) {
        super(message);
    }
}
