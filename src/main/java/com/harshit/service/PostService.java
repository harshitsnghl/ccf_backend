package com.harshit.service;

import org.springframework.web.multipart.MultipartFile;

import com.harshit.dto.TagDto;
import com.harshit.entity.Comment;
import com.harshit.entity.Post;
import com.harshit.entity.Tag;
import com.harshit.entity.User;
import com.harshit.response.PostResponse;

import java.util.List;

public interface PostService {
    Post getPostById(Long postId);
    PostResponse getPostResponseById(Long postId);
    List<PostResponse> getPostsByUserPaginate(User author, Integer page, Integer size);
    List<PostResponse> getTimelinePostsPaginate(Integer page, Integer size, Boolean allPost);
    List<PostResponse> getPostSharesPaginate(Post sharedPost, Integer page, Integer size);
    List<PostResponse> getPostByTagPaginate(Tag tag, Integer page, Integer size, Boolean allPost);
    Post createNewPost(String content, MultipartFile postPhoto, List<TagDto> postTags);
    Post updatePost(Long postId, String content, MultipartFile postPhoto, List<TagDto> postTags);
    void deletePost(Long postId);
    void deletePostPhoto(Long postId);
    void likePost(Long postId);
    void unlikePost(Long postId);
    Comment createPostComment(Long postId, String content);
    Comment updatePostComment(Long commentId, Long postId, String content);
    void deletePostComment(Long commentId, Long postId);
    Post createPostShare(String content, Long postShareId);
    Post updatePostShare(String content, Long postShareId);
    void deletePostShare(Long postShareId);
}
