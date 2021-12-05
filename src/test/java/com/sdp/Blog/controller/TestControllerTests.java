package com.sdp.Blog.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class TestControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/test/all")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
