package com.controller;

import com.model.Blog;
import com.service.BlogService;
import com.service.IBlogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@WebAppConfiguration
public class BlogControllerTest {
    private IBlogService blogService = Mockito.mock(BlogService.class);

    private MockMvc mockMVC;

    @InjectMocks
    private BlogController blogController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMVC = MockMvcBuilders
                .standaloneSetup(blogController)
                .build();
    }

    @Test
    public void findAllTest() throws Exception {
        Blog blog1 = new Blog(Long.parseLong("4"), "Han Quoc", "Dat Nuoc", "Kho Tinh");
        Blog blog2 = new Blog(Long.parseLong("5"), "Nhat Ban", "Dat Nuoc", "Ham Do");
        when(blogService.findAll()).thenReturn(Arrays.asList(blog1, blog2));

        mockMVC
                .perform(get("/api/blogs"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("blogs", hasItem(
                        allOf(
                                hasProperty("id", is(Long.parseLong("4"))),
                                hasProperty("name", is("Han Quoc")),
                                hasProperty("description", is("Dat Nuoc")),
                                hasProperty("content", is("Kho Tinh"))
                        )
                )))
                .andExpect(model().attribute("blogs", hasItem(
                        allOf(
                                hasProperty("id", is(Long.parseLong("5"))),
                                hasProperty("name", is("Nhat Ban")),
                                hasProperty("description", is("Dat Nuoc")),
                                hasProperty("content", is("Ham Do"))
                        )
                )));
        verify(blogService, times(1)).findAll();
        verifyNoMoreInteractions(blogService);
    }
}
