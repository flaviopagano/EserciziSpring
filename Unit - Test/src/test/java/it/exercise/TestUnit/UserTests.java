package it.exercise.TestUnit;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.exercise.TestUnit.controllers.HomeController;
import it.exercise.TestUnit.entities.User;
import it.exercise.TestUnit.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UserTests {


    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private UserRepository userRepository;


    @Autowired
    private ObjectMapper objectMapper;


    @Autowired
    private HomeController homeController;


    @Test
    void contextLoadsHomeController() {
        assertThat(homeController).isNotNull();
    }


    @Test
    void contextLoads() {
        assertThat(userRepository).isNotNull();
    }


    /**
     *  Get all Users
     */
    @Test
    void getAll() throws Exception {

        this.mockMvc.perform(get("/users")).andDo(print()).andExpect(status().isOk());

    }

    /**
     *  Get One user
     */
    @Test
    void getSingle() throws Exception {

        User user = userRepository.save(
                new User(1L,"Flavio","Pagano", "flavio@mail.com"));

        this.mockMvc.perform(get("/users/" + user.getId())).andDo(print()).andExpect(status().isOk());

    }

    /**
     *  Create one user
     */
    @Test
    void create() throws Exception {

        User user = new User(1L,"Flavio","Pagano", "flavio@mail.com");

        this.mockMvc.perform(post("/users")
                .content(objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());

    }

    /**
     * Update one user
     */
    @Test
    void update() throws Exception {

        User user = userRepository.save(
                new User(1L,"Flavio","Pagano", "flavio@mail.com"));

        user.setFirstName("Pino");

        this.mockMvc.perform(put("/users/" + user.getId())
                .content(objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());

    }

    /**
     * Delete one user
     */
    @Test
    void userDelete() throws Exception {

        User user = userRepository.save(

                new User(1L,"Flavio","Pagano", "flavio@mail.com"));

        this.mockMvc.perform(delete("/users/" + user.getId()))
                .andDo(print()).andExpect(status().isOk());

    }

}

