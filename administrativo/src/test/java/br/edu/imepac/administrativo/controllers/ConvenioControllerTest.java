package br.edu.imepac.administrativo.controllers;

import br.edu.imepac.administrativo.models.ConvenioModel;
import br.edu.imepac.administrativo.repositories.ConvenioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class ConvenioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ConvenioRepository convenioRepository;

    @BeforeEach
    void setUp() {
        convenioRepository.deleteAll();

        // Criando um convênio de teste no banco de dados em memória
        ConvenioModel convenio = new ConvenioModel();
        convenio.setNome("Unimed Teste");
        convenio.setDescricao("Plano de saúde Unimed");
        convenioRepository.save(convenio);
    }

    @Test
    void deveListarTodosOsConveniosComSucesso() throws Exception {
        mockMvc.perform(get("/api/convenios")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Unimed Teste"));
    }
}