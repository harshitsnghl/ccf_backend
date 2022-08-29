package com.harshit.dto;

import lombok.*;

import javax.validation.constraints.Size;

import com.harshit.annotation.PasswordRepeatEqual;
import com.harshit.annotation.ValidEmail;
import com.harshit.annotation.ValidPassword;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@PasswordRepeatEqual(
        passwordFieldFirst = "password",
        passwordFieldSecond = "passwordRepeat"
)
public class SignupDto {
    @ValidEmail
    private String email;

    @ValidPassword
    private String password;
    private String passwordRepeat;

    @Size(max = 64)
    private String firstName;

    @Size(max = 64)
    private String lastName;
}
