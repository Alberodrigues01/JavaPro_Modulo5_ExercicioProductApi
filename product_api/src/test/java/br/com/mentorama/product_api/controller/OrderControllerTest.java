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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.hamcrest.Matchers.hasValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {

     private static final String MOCKED_RESULT="" + "{\"order\":[\n"+
         "{\n"+
         "{\"product\":\n"+
         "\"id\":01,\n"+
         "\"name\":\"TV\",\n"+
         "\"quantityInStock\":3,\n"+
         "\"price\":3000.00,\n"+
         "\"maxDiscountPercentage\":0.9\n"+
         "},\n"+
         "{\n"+
         "\"quantity\":2,\n"+
         "\"discount\":0.1\n"+
         "},\n"+
         "]}";

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
     public void shouldDoOrderCalculate() throws Exception{
         wireMockServer.stubFor(
             WireMock.get(WireMock.urlPathEqualTo("/order"))
                     .willReturn(aResponse()
                     .withStatus(200)
                     .withHeader("Content-Type", "aplicattion/json")
                     .withBody(MOCKED_RESULT)));
         ResultActions resultActions = mockMvc.perform(
                     get("/order").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$",hasValue(5400.00)));

            //=============================================================================
            //Reconhece os parametros JSON informados acima entre as linhas 30 e 42. Retorna
            // que o valor da Order e valida com o valor esperado em hasValue.
            //=============================================================================
        }
}



