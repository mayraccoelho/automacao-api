package plataformaFilmes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlataformaFilmesTest {

    @Test
    public void validarLogin(){
        RestAssured.baseURI = "http://localhost:8080/";

        String json = "{\n" +
                "  \"email\": \"aluno@email.com\",\n" +
                "  \"senha\": \"123456\"\n" +
                "}";

        Response response = post(json, ContentType.JSON, "auth");

        assertEquals(200, response.statusCode());
        String token = response.jsonPath().get("token");
    }

    public Response post(Object json, ContentType contentType, String endpoint) {
        return RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(contentType)
                .body(json)
                .when()
                .post(endpoint)
                .thenReturn();
    }

}
