package com.gapple.weeingback.domain.user.entity.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserJoinRequest {
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@gsm.hs.kr$")
    @NotBlank
    private String email;

    @NotBlank
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,16}$", message = "Invalid password")
    private String password;
}