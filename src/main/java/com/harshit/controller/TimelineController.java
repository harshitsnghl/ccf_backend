package com.harshit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harshit.entity.Tag;
import com.harshit.response.PostResponse;
import com.harshit.service.PostService;
import com.harshit.service.TagService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TimelineController {
	private final PostService postService;
	private final TagService tagService;

	@GetMapping("/")
	public ResponseEntity<?> getTimelinePosts(@RequestParam("page") Integer page, @RequestParam("size") Integer size,
			@RequestParam("allPost") Boolean allPost) {
		page = page < 0 ? 0 : page - 1;
		size = size <= 0 ? 5 : size;
		List<PostResponse> timelinePosts = postService.getTimelinePostsPaginate(page, size,allPost);
		return new ResponseEntity<>(timelinePosts, HttpStatus.OK);
	}

	@GetMapping("/tags")
	public ResponseEntity<?> getTimelineTags() {
		List<Tag> timelineTags = tagService.getTimelineTags();
		return new ResponseEntity<>(timelineTags, HttpStatus.OK);
	}
}
