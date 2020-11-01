package api.requests;

import api.objects.*;
import bugcatcher.RestAssuredWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.restassured.response.ValidatableResponse;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.parser.ParseException;

public class OrderRequests extends RestAssuredWrapper {

    private final String baseUrl;

    public OrderRequests() throws IOException, ParseException {
        baseUrl = getConfigurator().getBaseUrl();
    }

    public ValidatableResponse createOrderPost(Order order) throws JsonProcessingException {

        String endpoint = getConfigurator().getDataFromService("order", "createOrderEndpoint");

        return getRestClient()
            .when()
            .body(parseObjectToJson(order))
            .log().all()
            .header("Content-Type", "application/json-patch+json")
            .header("x-account-id", getConfigurator().getAccountId())
            .header("x-tenant-id", getConfigurator().getTenantId())
            .post(baseUrl + endpoint)
            .then().log().all();
    }

    public ValidatableResponse createOrderPostWithString(String body) throws JsonProcessingException {

        String endpoint = getConfigurator().getDataFromService("order", "createOrderEndpoint");

        return getRestClient()
            .when()
            .body(body)
            .log().all()
            .header("Content-Type", "application/json-patch+json")
            .header("x-account-id", getConfigurator().getAccountId())
            .header("x-tenant-id", getConfigurator().getTenantId())
            .post(baseUrl + endpoint)
            .then().log().all();
    }

    public ValidatableResponse createOrderWithSuccess(Order order) throws JsonProcessingException {
        ValidatableResponse orderPost = createOrderPost(order);
        if (orderPost.extract().statusCode() == 201) {
            return orderPost;
        }

        if (orderPost.extract().response().jsonPath().getString("errors[0].errorCode").equals("ORDER_ALREADY_EXISTS")) {
            boolean orderAlreadyExists = true;
            while (orderAlreadyExists) {
                int orderReference = Integer.parseInt(order.getOrderRef());
                order.setOrderRef(String.valueOf(orderReference + 1));
                ValidatableResponse orderPostLoop = createOrderPost(order);

                if (orderPostLoop.extract().statusCode() == 201 || !orderPostLoop.extract().response().jsonPath().getString("errors[0].errorCode").equals("ORDER_ALREADY_EXISTS")) {
                    orderAlreadyExists = false;
                    System.out.println("Order ref is :" + order.getOrderRef());
                    orderPost = orderPostLoop;
                }
            }
        }
        return orderPost;
    }

    public ValidatableResponse createOrderWithSuccessWithString(String body) throws JsonProcessingException, ParseException {
        ValidatableResponse orderPost = createOrderPostWithString(body);
        if (orderPost.extract().response().jsonPath().getString("errors[0].errorCode").equals("ORDER_ALREADY_EXISTS")) {
            boolean orderAlreadyExists = true;
            while (orderAlreadyExists) {

                int orderReference = Integer.parseInt(StringUtils.substringBetween(body, "orderRef\":\"", "\"").trim());
                body = body.replace(String.valueOf(orderReference), String.valueOf(orderReference + 1));
                ValidatableResponse orderPostLoop = createOrderPostWithString(body);

                if (orderPostLoop.extract().statusCode() == 201 || !orderPostLoop.extract().response().jsonPath().getString("errors[0].errorCode").equals("ORDER_ALREADY_EXISTS")) {
                    orderAlreadyExists = false;
                    System.out.println("Order ref is :" + orderReference + 1);
                    orderPost = orderPostLoop;
                }
            }
        }
        return orderPost;
    }

}
