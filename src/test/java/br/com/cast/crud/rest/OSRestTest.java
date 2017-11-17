package br.com.cast.crud.rest;

import br.com.cast.crud.domain.OS;
import br.com.cast.crud.repository.OSRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OSRestTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private ObjectMapper objectMapper;

    private MockMvc mockMvc;

    private OS os;

    @Before
    public void setUp() throws Exception {
        os = new OS();
        os.setId(1);
        os.setNome("OS 0001");
        mockMvc = MockMvcBuilders
            .webAppContextSetup(webApplicationContext)
            .build();
        objectMapper = new ObjectMapper();
    }

    private void put() throws Exception {
        mockMvc.perform(
            MockMvcRequestBuilders.put("/os", os)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writer().writeValueAsString(os))
        ).andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    public void get() throws Exception {
        put();
        mockMvc.perform(
            MockMvcRequestBuilders.get("/os?id=1")
                .accept(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    public void delete() throws Exception {
        put();
        mockMvc.perform(MockMvcRequestBuilders.delete("/os?id=1"))
            .andExpect(MockMvcResultMatchers.status().is(200));
    }

}
