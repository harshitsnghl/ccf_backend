package com.harshit.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.harshit.dto.*;
import com.harshit.entity.Comment;
import com.harshit.entity.Post;
import com.harshit.entity.User;
import com.harshit.response.UserResponse;

import java.util.List;

public interface UserService {
    User getUserById(Long userId);
    User getUserByEmail(String email);
    List<UserResponse> getFollowerUsersPaginate(Long userId, Integer page, Integer size);
    List<UserResponse> getFollowingUsersPaginate(Long userId, Integer page, Integer size);
    User createNewUser(SignupDto signupDto);
    User updateUserInfo(UpdateUserInfoDto updateUserInfoDto);
    User updateEmail(UpdateEmailDto updateEmailDto);
    User updatePassword(UpdatePasswordDto updatePasswordDto);
    User updateProfilePhoto(MultipartFile photo);
    User updateCoverPhoto(MultipartFile photo);
    User verifyEmail(String token);
    void forgotPassword(String email);
    User resetPassword(String token, ResetPasswordDto resetPasswordDto);
    void deleteUserAccount();
    void followUser(Long userId);
    void unfollowUser(Long userId);
    User getAuthenticatedUser();
    List<UserResponse> getUserSearchResult(String key, Integer page, Integer size);
    List<User> getLikesByPostPaginate(Post post, Integer page, Integer size);
    List<User> getLikesByCommentPaginate(Comment comment, Integer page, Integer size);
}
