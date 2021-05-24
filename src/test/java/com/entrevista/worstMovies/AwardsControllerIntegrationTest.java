package com.entrevista.worstMovies;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AwardsControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAwardIntervalResponse() throws Exception {
        ResultActions resultActions =  mockMvc.perform(get("/awardsInterval").contentType(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.min[0].producer", is("Joel Silver")))
                .andExpect(jsonPath("$.min[0].interval", is(1)))
                .andExpect(jsonPath("$.min[0].previousWin", is(1990)))
                .andExpect(jsonPath("$.min[0].followingWin", is(1991)))

                .andExpect(jsonPath("$.min[1].producer", is("Tom Hooper")))
                .andExpect(jsonPath("$.min[1].interval", is(1)))
                .andExpect(jsonPath("$.min[1].previousWin", is(2019)))
                .andExpect(jsonPath("$.min[1].followingWin", is(2020)))


                .andExpect(jsonPath("$.max[0].producer", is("Matthew Vaughn")))
                .andExpect(jsonPath("$.max[0].interval", is(13)))
                .andExpect(jsonPath("$.max[0].previousWin", is(2002)))
                .andExpect(jsonPath("$.max[0].followingWin", is(2015)))
        ;
    }

}
