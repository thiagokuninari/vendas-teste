package br.com.xbrain.vendasteste.vendas.controller;

import br.com.xbrain.vendasteste.vendas.dto.VendedorDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:vendedores.sql", "classpath:vendas.sql"})
@Transactional
public class VendedorControllerTeste {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void exibirTodosOsVendedores() throws Exception {
        mockMvc.perform(get("/api/vendedor").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(6)));
    }

    @Test
    public void exibirOsVendedoresPorId() throws Exception {
        mockMvc.perform(get("/api/vendedor/2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome", Matchers.is("Thiago 2")));

    }

    @Test
    public void salvarVendedor() throws Exception {
        VendedorDto vendedor = new VendedorDto();
        vendedor.setNome("Thiago 7");

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/vendedor")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(vendedor)))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void alterarCadastroVendedor() throws Exception{
        VendedorDto vendedor = new VendedorDto();
        vendedor.setId(1L);
        vendedor.setNome("Thiago 8");

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(MockMvcRequestBuilders.put("/api/vendedor")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(vendedor)))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void deletarVendedor () throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/vendedor/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void exibirRelatórioDeVenda() throws Exception {
        mockMvc.perform(get("/api/vendedor/relatorio?dataInicio=2021-11-25&dataFim=2021-11-25"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nomeVendedor", Matchers.is("Thiago 1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].totalVendas", Matchers.is(5)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].mediaDeVendasDiaria", Matchers.is(5.0)));

    }

}
