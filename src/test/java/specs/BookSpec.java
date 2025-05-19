package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureFilter.withCustomTemplates;
import static io.restassured.RestAssured.with;

public class BookSpec {

    public static RequestSpecification request = with()
            .filter(withCustomTemplates())
            .contentType("application/json")
            .log().all();

    private static ResponseSpecification spec(int status) {
        return new ResponseSpecBuilder()
                .expectStatusCode(status)
                .log(LogDetail.ALL)
                .build();
    }

    public static final ResponseSpecification response200 = spec(200);
    public static final ResponseSpecification response201 = spec(201);
    public static final ResponseSpecification response204 = spec(204);
}