package com.harshit.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.harshit.entity.Comment;
import com.harshit.entity.Post;
import com.harshit.entity.Tag;
import com.harshit.entity.User;
import com.harshit.response.PostResponse;
import com.harshit.service.PostService;
import com.harshit.service.TagService;
import com.harshit.shared.MockResource;
import com.harshit.shared.WithMockAuthUser;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TimelineControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    PostService postService;

    @MockBean
    TagService tagService;

    private final User USER_JOHN = MockResource.getMockUserJohn();
    private final User USER_JANE = MockResource.getMockUserJane();
    private final Post POST_ONE = MockResource.getPostOne();
    private final Post POST_TWO = MockResource.getPostTwo();
    private final Post POST_ONE_SHARE = MockResource.getPostOneShare();
    private final Comment COMMENT_ONE = MockResource.getCommentOne();
    private final Tag TAG_ONE = MockResource.getTagOne();
    private final Tag TAG_TWO = MockResource.getTagTwo();
    private final String API_URL_PREFIX = "/api/v1";

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @WithMockAuthUser
    void shouldReturnListOfTimelinePosts() throws Exception {
        when(postService.getTimelinePostsPaginate(0, 5))
                .thenReturn(List.of(
                        new PostResponse(POST_ONE, false),
                        new PostResponse(POST_TWO, false)
                ));

        mockMvc.perform(get(API_URL_PREFIX + "/")
                        .param("page", "1")
                        .param("size", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    @WithMockAuthUser
    void shouldReturnListOfTimelineTags() throws Exception {
        when(tagService.getTimelineTags())
                .thenReturn(List.of(TAG_ONE, TAG_TWO));

        mockMvc.perform(get(API_URL_PREFIX + "/tags"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }
}