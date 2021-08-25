package com.freelancerLink;


import com.freelancerLink.controller.AccountController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello_return() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }


    @Test
    public void accountInfoDto() throws Exception{
        String name = "junhowon";
        String address = "yangju-si";

        mvc.perform(
                get("/hello/dto")
                    .param("name", name)
                    .param("address", address)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.address", is(address)));
    }

}
