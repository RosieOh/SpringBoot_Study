package com.jwtpractice.global.security.jwt.dto;

import com.jwtpractice.domain.member.member.dto.MemberResponseDto;
import lombok.*;

@ToString
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor
public class JwtResponse {
    private final String accessToken;
    private final Long accessTokenExp;
    private final String refreshToken;
    private MemberResponseDto member;
}
