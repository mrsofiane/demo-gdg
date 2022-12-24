package me.mrsofiane.demogdg;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloWorldControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldGetAllStudents() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/students"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().string("[{\"id\":1,\"firstName\":\"amine\",\"lastName\":\"amine\",\"email\":\"amine@gmail.com\"},{\"id\":2,\"firstName\":\"amina\",\"lastName\":\"amina\",\"email\":\"amina@gmail.com\"}]"));

    }
}
