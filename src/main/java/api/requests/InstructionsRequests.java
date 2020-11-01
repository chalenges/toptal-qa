package api.requests;


import api.objects.*;
import bugcatcher.RestAssuredWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.restassured.response.ValidatableResponse;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class InstructionsRequests extends RestAssuredWrapper {

    private final String baseUrl;

    public InstructionsRequests() throws IOException, ParseException {
        baseUrl = getConfigurator().getBaseUrl();
    }

    public ValidatableResponse createInstructionPost(String orderRef, Instruction instruction) throws JsonProcessingException {
        String orderEndpoint = getConfigurator().getDataFromService("order", "createOrderEndpoint");
        String endpoint = getConfigurator().getDataFromService("instruction", "createInstructionEndpoint");

        return getRestClient()
            .when()
            .body(parseObjectToJson(instruction))
            .log().all()
            .header("Content-Type", "application/json-patch+json")
            .header("x-account-id", getConfigurator().getAccountId())
            .header("x-tenant-id", getConfigurator().getTenantId())
            .post(baseUrl + orderEndpoint + "/" + orderRef + "/" + endpoint)
            .then().log().all();
    }

    public ValidatableResponse cancelInstructionPost(String orderRef, String instructionRef) throws JsonProcessingException {
        String orderEndpoint = getConfigurator().getDataFromService("order", "createOrderEndpoint");
        String endpoint = getConfigurator().getDataFromService("instruction", "createInstructionEndpoint");

        return getRestClient()
            .when()
            .body("{\"reason\":\"test\"}")
            .log().all()
            .header("Content-Type", "application/json-patch+json")
            .header("x-account-id", getConfigurator().getAccountId())
            .header("x-tenant-id", getConfigurator().getTenantId())
            .post(baseUrl + orderEndpoint + "/" + orderRef + "/" + endpoint + "/" + instructionRef + "/cancel")
            .then().log().all();
    }


    public ValidatableResponse createInstructionWithSuccess(String orderRef, Instruction instruction) throws JsonProcessingException {
        ValidatableResponse instructionPost = createInstructionPost(orderRef, instruction);
        if (instructionPost.extract().statusCode() == 201) {
            return instructionPost;
        }
        if (instructionPost.extract().response().jsonPath().getString("errors[0].errorCode").equals("INSTRUCTION_ALREADY_EXISTS")) {
            boolean instructionAlreadyExists = true;
            while (instructionAlreadyExists) {
                int instructionReference = Integer.parseInt(instruction.getInstructionRef());
                instruction.setInstructionRef(String.valueOf(instructionReference + 1));
                ValidatableResponse instructionPostLoop = createInstructionPost(orderRef, instruction);

                if (instructionPostLoop.extract().statusCode() == 201 || !instructionPostLoop.extract().response().jsonPath().getString("errors[0].errorCode").equals("INSTRUCTION_ALREADY_EXISTS")) {
                    instructionAlreadyExists = false;
                    System.out.println("Instruction ref is :" + instruction.getInstructionRef());
                    instructionPost = instructionPostLoop;
                }
            }
        }
        return instructionPost;
    }

}
