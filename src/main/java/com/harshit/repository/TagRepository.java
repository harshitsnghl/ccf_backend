package com.harshit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshit.entity.Tag;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> findTagByName(String name);
}
