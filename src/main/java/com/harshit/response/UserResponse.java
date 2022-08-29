package com.harshit.response;

import com.harshit.entity.User;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private User user;
    private Boolean followedByAuthUser;
}
