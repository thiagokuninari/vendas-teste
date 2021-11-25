package br.com.xbrain.vendasteste.vendas.controller;


import br.com.xbrain.vendasteste.vendas.dto.VendaDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Sql("/vendedores.sql")
@Transactional
public class VendaControllerTeste {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void salvarVenda() throws Exception {

        VendaDto venda = new VendaDto();

        venda.setValorDaVenda(new BigDecimal(100.00));
        venda.setDataDaVenda(LocalDate.of(2021, 11, 25));
        venda.setVendedorId(1L);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        mockMvc.perform(MockMvcRequestBuilders.post("/api/venda")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(venda)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
