package restassured;

import appleapi.SearchResultDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class ApiTest {

    @Test
    public void getResultsTest() throws JsonProcessingException {
        JsonPath jsonPath = RestAssured.given()
                .header("Content-Type", "application/json")
                .baseUri("https://itunes.apple.com")
                .params(Map.of("term", "Nirvana",
                        "country", "US",
                        "media", "audiobook"))
                .get("/search")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        SearchResultDto searchResultDto = new ObjectMapper().readValue(jsonPath.prettyPrint(), SearchResultDto.class);
        Assert.assertTrue(searchResultDto.getResults().stream().allMatch(result -> result.getMedia().
                equals("audiobook")));


    }

    @Test
    public void getTrackNameTest() throws JsonProcessingException {
        JsonPath jsonPath = RestAssured.given()
                .header("Content-Type", "application/json")
                .baseUri("https://itunes.apple.com")
                .params(Map.of("term", "Billie Eilish",
                        "country", "US",
                        "media", "music"))
                .get("/search")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();
        SearchResultDto searchResultDto = new ObjectMapper().readValue(jsonPath.prettyPrint(), SearchResultDto.class);
        Assert.assertTrue(searchResultDto.getResults().stream().allMatch(result -> result.getTrackName().
                equals("bad guy")));

    }

    @Test
    public void getPrimaryGenreName() throws JsonProcessingException {
        JsonPath jsonPath = RestAssured.given()
                .header("Content-Type", "application/json")
                .baseUri("https://itunes.apple.com")
                .params(Map.of("term", "Madonna",
                        "country", "US",
                        "media", "music"))
                .get("/search")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();
        SearchResultDto searchResultDto = new ObjectMapper().readValue(jsonPath.prettyPrint(), SearchResultDto.class);
        Assert.assertTrue(searchResultDto.getResults().stream().allMatch(result -> result.getTrackName().
                equals("Pop")));

    }

}