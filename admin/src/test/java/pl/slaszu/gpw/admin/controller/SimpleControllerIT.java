package pl.slaszu.gpw.admin.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SimpleControllerIT {

    @Autowired
    MockMvc mvc;

    @Test
    void contextLoads() {
    }

    @Test
    void homePage() throws Exception {

        mvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("<title>Home page</title>")));
    }

    @Test
    void loginAuthPage() throws Exception {

        mvc.perform(get("/login_oauth"))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("<a href=\"/oauth2/authorization/google\">Google</a>")))
            .andExpect(content().string(containsString("<a href=\"/oauth2/authorization/github\">GitHub</a>")));
    }

    @Test
    void adminWithoutUserPage() throws Exception {

        mvc.perform(get("/admin"))
            .andExpect(status().isFound())
            .andExpect(redirectedUrl("http://localhost/login_oauth"));
    }

    @Test
    @WithMockUser(username = "admin", authorities = {"ADMIN"})
    void adminWithUserPage() throws Exception {

        mvc.perform(get("/admin"))
            .andExpect(status().isOk());
    }
}