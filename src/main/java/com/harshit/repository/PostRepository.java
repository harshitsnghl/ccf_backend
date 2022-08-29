package com.harshit.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.harshit.entity.Post;
import com.harshit.entity.Tag;
import com.harshit.entity.User;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostsByAuthor(User author, Pageable pageable);
    List<Post> findPostsByAuthorIdIn(List<Long> followingUserIds, Pageable pageable);
    List<Post> findPostsBySharedPost(Post post, Pageable pageable);
    List<Post> findPostsByPostTags(Tag tag, Pageable pageable);
}
