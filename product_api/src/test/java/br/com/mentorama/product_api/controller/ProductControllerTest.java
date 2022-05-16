package br.com.mentorama.product_api.controller;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.StatusAssertions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    private static final String MOCKED_RESULT="{\"product\"]}";

    private static WireMockServer wireMockServer= new WireMockServer(options().port(8081));

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeAll
    static void beforeAll() throws JacksonException {
        wireMockServer.start();
    }

    @BeforeEach
    void setUp(){
        wireMockServer.resetAll();
    }

    @AfterAll
    static void afterAll(){
        wireMockServer.stop();
    }

    @Test
    public void shouldFindAllProducts() throws Exception{
        wireMockServer.stubFor(
                WireMock.get(WireMock.urlPathEqualTo("/product"))
                .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "aplicattion/json")
                .withBody(MOCKED_RESULT)));
        ResultActions resultActions = mockMvc.perform(
                get("/product").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(4)));

        //=============================================================================
        //Conforme os "products" adicionados à List<Product>products em ProductRepository
        // o teste apura corretamente a quantidade de 4 tipos (TV, Geladeira, Fogão e Lavadoura).
        // Se alterarmos o hasSize() para outra quantidade, o teste apura o erro,
        // demostrando corretamente a integração com o serviço Http (status 200).
        //=============================================================================
    }
}
