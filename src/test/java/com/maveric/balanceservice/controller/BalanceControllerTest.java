package com.maveric.balanceservice.controller;

import com.maveric.balanceservice.repository.BalanceRepository;
import com.maveric.balanceservice.service.BalanceServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.ws.rs.core.MediaType;

import static com.maveric.balanceservice.BalanceServiceApplicationTests.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes=BalanceController.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(BalanceController.class)
class BalanceControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private BalanceRepository balanceRepository;

    @MockBean
    BalanceServiceImpl balanceService;
    @Test
    void getBalances() throws Exception {
        mvc.perform(get(APIV1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void createBalance() throws Exception {
        mvc.perform(post(APIV1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(getBalanceDto()))
                )
                .andExpect(status().isCreated())
                .andDo(print());
      }

//    @Test
//    void getBalanceDetails() throws Exception {
//        mvc.perform(get(APIV1+"/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andDo(print());
//      }

    @Test
    void updateBalance() throws Exception {
        mvc.perform(put(APIV1+"/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(getBalanceDto()))
                )
                .andExpect(status().isOk())
                .andDo(print());
      }

    @Test
    void deleteBalance() throws Exception {
        mvc.perform(delete(APIV1+"/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
      }

    @Test
    void testDeleteBalance() throws Exception {
        mvc.perform(delete(APIV1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
      }
}