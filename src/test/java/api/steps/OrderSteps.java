package api.steps;

import api.expections.OrderCreatedInvalidFields;
import api.objects.CustomerDefaults;
import api.objects.Instruction;
import api.objects.Order;
import api.requests.OrderRequests;
import bugcatcher.RestAssuredWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.restassured.response.ValidatableResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.util.HashMap;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

public class OrderSteps extends RestAssuredWrapper {

    private OrderRequests orderRequests = new OrderRequests();
    private ValidatableResponse orderPost;
    private Order order;
    private String body;

    public OrderSteps() throws IOException, ParseException {
    }

    @Given("I create an order object to post the create order with success")
    public void iCreateAnOrderObjectToPostTheCreateOrderWithSuccess() {
        order = new Order();

        Instruction[] instructions = {};
        order.setInstructions(instructions);
        order.setOrderRef("8");
        order.setCustomerDefaults(new CustomerDefaults());
        order.setMetadata(new HashMap<>());
    }

    @Given("I create an order object to post the create order with order reference that already exists")
    public void iCreateAnOrderObjectToPostTheCreateOrderWithOrderReferenceThatAlreadyExists() {
        order = new Order();
        Instruction[] instructions = {};
        order.setInstructions(instructions);
        order.setOrderRef(getConfigurator().getDataFromService("order", "orderAlreadyExisted"));
        order.setCustomerDefaults(new CustomerDefaults());
        order.setMetadata(new HashMap<>());
    }

    @Given("I create an order object to post the create order without order reference")
    public void iCreateAnOrderObjectToPostTheCreateOrderWithoutOrderReference() {
        order = new Order();
        Instruction[] instructions = {};
        order.setInstructions(instructions);
        order.setCustomerDefaults(new CustomerDefaults());
        order.setMetadata(new HashMap<>());
    }

    @Given("I create an order object to post the create order with an exceeded length order reference")
    public void iCreateAnOrderObjectToPostTheCreateOrderWithAnExceededLengthOrderReference() {
        order = new Order();
        Instruction[] instructions = {};
        order.setInstructions(instructions);
        order.setOrderRef(getConfigurator().getDataFromService("order", "orderRefExceededLength"));
        order.setCustomerDefaults(new CustomerDefaults());
        order.setMetadata(new HashMap<>());
    }

    @Given("I create an order object to post the create order with an invalid order reference")
    public void iCreateAnOrderObjectToPostTheCreateOrderWithAnInvalidOrderReference() {
        order = new Order();
        Instruction[] instructions = {};
        order.setInstructions(instructions);
        order.setOrderRef(getConfigurator().getDataFromService("order", "orderRefInvalid"));
        order.setCustomerDefaults(new CustomerDefaults());
        order.setMetadata(new HashMap<>());
    }

    @Given("I create an order object to post the create order with an exceeded length order metadata key")
    public void iCreateAnOrderObjectToPostTheCreateOrderWithAnExceededLengthOrderMetadataKey() {
        order = new Order();
        Instruction[] instructions = {};
        HashMap metadata = new HashMap<String, String>();
        metadata.put("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901", "outOfRangeKey");
        order.setInstructions(instructions);
        order.setOrderRef(getConfigurator().getDataFromService("order", "orderAlreadyExisted"));
        order.setCustomerDefaults(new CustomerDefaults());
        order.setMetadata(metadata);
    }

    @Given("I create an order object to post the create order with an exceeded length order metadata value")
    public void iCreateAnOrderObjectToPostTheCreateOrderWithAnExceededLengthOrderMetadataValue() {
        order = new Order();
        Instruction[] instructions = {};
        HashMap metadata = new HashMap<String, String>();
        metadata.put("outOfRangeValue", "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901");
        order.setInstructions(instructions);
        order.setOrderRef(getConfigurator().getDataFromService("order", "orderAlreadyExisted"));
        order.setCustomerDefaults(new CustomerDefaults());
        order.setMetadata(metadata);
    }

    @Given("I create an order object to post the create order with duplicated metadata key")
    public void iCreateAnOrderObjectToPostTheCreateOrderWithDuplicatedMetadataKey() {
        body = "{\"metadata\":{\"duplicatedKey\":\"1\",\"duplicatedKey\":\"2\"},\"customerDefaults\":{\"customerRef1\":{\"financialInstrumentId\":\"\",\"schemeId\":\"\"},\"customerRef2\":{\"financialInstrumentId\":\"\",\"schemeId\":\"\"},\"customerRef3\":{\"financialInstrumentId\":\"\",\"schemeId\":\"\"}},\"orderRef\":\"100\",\"instructions\":[]}";
    }

    @Given("I create an order object to post the create order with null metadata value")
    public void iCreateAnOrderObjectToPostTheCreateOrderWithNullMetadataKey() {
        order = new Order();
        Instruction[] instructions = {};
        HashMap metadata = new HashMap<String, String>();
        metadata.put("nullValue", null);
        order.setInstructions(instructions);
        order.setOrderRef(getConfigurator().getDataFromService("order", "orderAlreadyExisted"));
        order.setCustomerDefaults(new CustomerDefaults());
        order.setMetadata(metadata);
    }

    @When("I do the post create order")
    public void iDoThePostCreateOrder() throws JsonProcessingException {
        orderPost = orderRequests.createOrderPost(order);
    }

    @When("I do the post create order without object")
    public void iDoThePostCreateOrderWithoutObject() throws JsonProcessingException {
        orderPost = orderRequests.createOrderPostWithString(body);
    }

    @When("I do the post create order to succeed")
    public void iDoThePostCreateOrderToSucceed() throws JsonProcessingException {
        orderPost = orderRequests.createOrderWithSuccess(order);
    }

    @When("I do the post create order to succeed with string")
    public void iDoThePostCreateOrderToSucceedWithString() throws JsonProcessingException, ParseException {
        orderPost = orderRequests.createOrderWithSuccessWithString(body);
    }

    @Then("I expect this order is created")
    public void iExpectToBeCreated() {
        orderPost.statusCode(201).statusLine("HTTP/1.1 201 Created");
    }

    @Then("I expect to receive the ORDER_ALREADY_EXISTS response")
    public void iExpectToReceiveTheORDER_ALREADY_EXISTSResponse() throws OrderCreatedInvalidFields {
        assertCreationResponse("Order shouldn't be created with already existent order reference", "ORDER_ALREADY_EXISTS");
    }

    @Then("I expect to receive the ORDER_REF_IS_REQUIRED response")
    public void iExpectToReceiveTheORDER_REF_IS_REQUIREDResponse() throws OrderCreatedInvalidFields {
        assertCreationResponse("Order shouldn't be created without order reference", "ORDER_REF_IS_REQUIRED");
    }

    @Then("I expect to receive the ORDER_REF_LENGTH_OUT_OF_RANGE response")
    public void iExpectToReceiveTheORDER_REF_LENGTH_OUT_OF_RANGEResponse() throws OrderCreatedInvalidFields {
        assertCreationResponse("Order shouldn't be created with an out of range order reference", "ORDER_REF_LENGTH_OUT_OF_RANGE");
    }

    @Then("I expect to receive the ORDER_REF_CONTAINS_INVALID_CHARACTERS response")
    public void iExpectToReceiveTheORDER_REF_CONTAINS_INVALID_CHARACTERSResponse() throws OrderCreatedInvalidFields {
        assertCreationResponse("Order shouldn't be created with invalid order reference", "ORDER_REF_CONTAINS_INVALID_CHARACTERS");
    }


    @Then("I expect to receive the METADATA_KEY_SIZE_OUT_OF_RANGE response")
    public void iExpectToReceiveTheMETADATA_KEY_SIZE_OUT_OF_RANGEResponse() throws OrderCreatedInvalidFields {
        assertCreationResponse("Order shouldn't be created with an out of range metadata key", "METADATA_KEY_SIZE_OUT_OF_RANGE");
    }

    @Then("I expect to receive the METADATA_VALUE_SIZE_OUT_OF_RANGE response")
    public void iExpectToReceiveTheMETADATA_VALUE_SIZE_OUT_OF_RANGEResponse() throws OrderCreatedInvalidFields {
        assertCreationResponse("Order shouldn't be created with an out of range metadata value", "METADATA_VALUE_SIZE_OUT_OF_RANGE");
    }

    @Then("I expect to receive the METADATA_DUPLICATED_KEY response")
    public void iExpectToReceiveTheMETADATA_DUPLICATED_KEYResponse() throws OrderCreatedInvalidFields {
        assertCreationResponse("Order shouldn't be created with a duplicated metadata key", "METADATA_DUPLICATED_KEY");
    }


    @Then("I expect to receive the status code 400 due null order metadata value")
    public void iExpectToReceiveThe400DueNullOrderMetadataValue() throws OrderCreatedInvalidFields {
        if (orderPost.extract().statusCode() == 201) {
            throw new OrderCreatedInvalidFields("Order shouldn't be created with a null metadata value");
        }
        orderPost.statusCode(400).statusLine("HTTP/1.1 400 Bad Request");
    }

    private void assertCreationResponse(String errorMessage, String errorCode) throws OrderCreatedInvalidFields {
        if (orderPost.extract().statusCode() == 201) {
            throw new OrderCreatedInvalidFields(errorMessage);
        }
        orderPost.statusCode(400).statusLine("HTTP/1.1 400 Bad Request");
        Assert.assertEquals("Error message is not the expected", errorCode, orderPost.extract().response().jsonPath().getString("errors[0].errorCode"));
    }
}
