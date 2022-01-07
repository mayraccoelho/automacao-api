package plataformaFilmes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import maps.LoginMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.RestUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PlataformaFilmesTest {
    static String json = "{\n" +
            "  \"email\": \"aluno@email.com\",\n" +
            "  \"senha\": \"123456\"\n" +
            "}";

    @Test
    public void validarLogin(){
        RestUtils.setBaseURI("http://localhost:8080/");

        Response response = RestUtils.post(json, ContentType.JSON, "auth");

        assertEquals(200, response.statusCode());
        LoginMap.token = response.jsonPath().get("token");
    }

    @BeforeAll
    public static void validarLoginMap(){
        RestUtils.setBaseURI("http://localhost:8080/");
        LoginMap.initLogin();

        Response response = RestUtils.post(LoginMap.getLogin(), ContentType.JSON, "auth");

        assertEquals(200, response.statusCode());
        LoginMap.token = response.jsonPath().get("token");
    }

    @Test
    public void validarConsultaCategorias() {
        Map<String, String> header = new HashMap<>();
        header.put("Authorization","Bearer "+ LoginMap.token);

        Response response = RestUtils.get(header,"categorias");

        assertEquals(200, response.statusCode());
        
        System.out.println(response.jsonPath().get().toString());

        assertEquals("Terror", response.jsonPath().get("tipo[2]"));
        List<String> listTipo = response.jsonPath().get("tipo");
        assertTrue(listTipo.contains("Terror"), "Não foi encontrado o tipo solicitado!");

    }
}
