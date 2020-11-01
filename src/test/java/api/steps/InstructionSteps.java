package api.steps;

import api.expections.InstructionCreatedInvalidFields;
import api.objects.Instruction;
import api.requests.InstructionsRequests;
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

public class InstructionSteps extends RestAssuredWrapper {

    private InstructionsRequests instructionsRequests = new InstructionsRequests();
    private ValidatableResponse instructionPost;
    private Instruction instruction;

    public InstructionSteps() throws IOException, ParseException {
    }

    @Given("I create an instruction object to post the create instruction with success")
    public void iCreateAnInstructionObjectToPostTheCreateInstructionWithSuccess() {
        instruction = new Instruction();
        instruction.setAmount("10");
        instruction.setCountry("IE");
        instruction.setCurrency("EUR");
        instruction.setCustomerRef("1");
        instruction.setDirection("DEBIT");
        instruction.setInstructionRef("2");
        instruction.setMetadata(new HashMap<>());
        instruction.setSchemeId("28117598D567061E439F0B49573EC27F");
        instruction.setSettledByDate("2021-10-10");
    }

    @Given("I create an instruction object to post the create instruction with null instruction reference")
    public void iCreateAnInstructionObjectToPostTheCreateInstructionWithANullInstructionReference() {
        instruction = new Instruction();
        instruction.setAmount("10");
        instruction.setCountry("IE");
        instruction.setCurrency("EUR");
        instruction.setCustomerRef("1");
        instruction.setDirection("DEBIT");
        instruction.setInstructionRef(null);
        instruction.setMetadata(new HashMap<>());
        instruction.setSchemeId("28117598D567061E439F0B49573EC27F");
        instruction.setSettledByDate("2021-10-10");
    }

    @Given("I create an instruction object to post the create instruction with an instruction reference that already exists")
    public void iCreateAnInstructionObjectToPostTheCreateInstructionWithInstructionReferenceThatAlreadyExists() {
        instruction = new Instruction();
        instruction.setAmount("10");
        instruction.setCountry("IE");
        instruction.setCurrency("EUR");
        instruction.setCustomerRef("1");
        instruction.setDirection("DEBIT");
        instruction.setInstructionRef("2");
        instruction.setMetadata(new HashMap<>());
        instruction.setSchemeId("28117598D567061E439F0B49573EC27F");
        instruction.setSettledByDate("2021-10-10");
    }

    @Given("I create an instruction object to post the create instruction with a canceled instruction reference")
    public void iCreateAnInstructionObjectToPostTheCreateInstructionWithACanceledInstructionReference() {
        instruction = new Instruction();
        instruction.setAmount("10");
        instruction.setCountry("IE");
        instruction.setCurrency("EUR");
        instruction.setCustomerRef("1");
        instruction.setDirection("DEBIT");
        instruction.setInstructionRef("1");
        instruction.setMetadata(new HashMap<>());
        instruction.setSchemeId("28117598D567061E439F0B49573EC27F");
        instruction.setSettledByDate("2021-10-10");
    }

    @Given("I create an instruction object to post the create instruction with an exceeded length instruction reference")
    public void iCreateAnInstructionObjectToPostTheCreateInstructionWithAnExceededLengthInstructionReference() {
        instruction = new Instruction();
        instruction.setAmount("10");
        instruction.setCountry("IE");
        instruction.setCurrency("EUR");
        instruction.setCustomerRef("1");
        instruction.setDirection("DEBIT");
        instruction.setInstructionRef("123456789012345678901234567890123456789012345678901234567890");
        instruction.setMetadata(new HashMap<>());
        instruction.setSchemeId("28117598D567061E439F0B49573EC27F");
        instruction.setSettledByDate("2021-10-10");
    }

    @Given("I create an instruction object to post the create instruction with an invalid instruction reference")
    public void iCreateAnInstructionObjectToPostTheCreateInstructionWithAnInvalidInstructionReference() {
        instruction = new Instruction();
        instruction.setAmount("10");
        instruction.setCountry("IE");
        instruction.setCurrency("EUR");
        instruction.setCustomerRef("1");
        instruction.setDirection("DEBIT");
        instruction.setInstructionRef("@");
        instruction.setMetadata(new HashMap<>());
        instruction.setSchemeId("28117598D567061E439F0B49573EC27F");
        instruction.setSettledByDate("2021-10-10");
    }

    @Given("I create an instruction object to post the create instruction with null customer reference")
    public void iCreateAnInstructionObjectToPostTheCreateInstructionWithAnNullCustomerReference() {
        instruction = new Instruction();
        instruction.setAmount("10");
        instruction.setCountry("IE");
        instruction.setCurrency("EUR");
        instruction.setCustomerRef(null);
        instruction.setDirection("DEBIT");
        instruction.setInstructionRef("2");
        instruction.setMetadata(new HashMap<>());
        instruction.setSchemeId("28117598D567061E439F0B49573EC27F");
        instruction.setSettledByDate("2021-10-10");
    }

    @Given("I create an instruction object to post the create instruction with invalid customer reference")
    public void iCreateAnInstructionObjectToPostTheCreateInstructionWithAnInvalidCustomerReference() {
        instruction = new Instruction();
        instruction.setAmount("10");
        instruction.setCountry("IE");
        instruction.setCurrency("EUR");
        instruction.setCustomerRef("@");
        instruction.setDirection("DEBIT");
        instruction.setInstructionRef("2");
        instruction.setMetadata(new HashMap<>());
        instruction.setSchemeId("28117598D567061E439F0B49573EC27F");
        instruction.setSettledByDate("2021-10-10");
    }

    @Given("I create an instruction object to post the create instruction with an exceeded length customer reference")
    public void iCreateAnInstructionObjectToPostTheCreateInstructionWithAnExceededLengthCustomerReference() {
        instruction = new Instruction();
        instruction.setAmount("10");
        instruction.setCountry("IE");
        instruction.setCurrency("EUR");
        instruction.setCustomerRef("123456789012345678901234567890123456789012345678901234567890'");
        instruction.setDirection("DEBIT");
        instruction.setInstructionRef("2");
        instruction.setMetadata(new HashMap<>());
        instruction.setSchemeId("28117598D567061E439F0B49573EC27F");
        instruction.setSettledByDate("2021-10-10");
    }

    @Given("I create an instruction object to post the create instruction with null amount")
    public void iCreateAnInstructionObjectToPostTheCreateInstructionWithAnNullAmount() {
        instruction = new Instruction();
        instruction.setAmount(null);
        instruction.setCountry("IE");
        instruction.setCurrency("EUR");
        instruction.setCustomerRef("1");
        instruction.setDirection("DEBIT");
        instruction.setInstructionRef("2");
        instruction.setMetadata(new HashMap<>());
        instruction.setSchemeId("28117598D567061E439F0B49573EC27F");
        instruction.setSettledByDate("2021-10-10");
    }

    @Given("I create an instruction object to post the create instruction with invalid amount")
    public void iCreateAnInstructionObjectToPostTheCreateInstructionWithAnInvalidAmount() {
        instruction = new Instruction();
        instruction.setAmount("@");
        instruction.setCountry("IE");
        instruction.setCurrency("EUR");
        instruction.setCustomerRef("1");
        instruction.setDirection("DEBIT");
        instruction.setInstructionRef("2");
        instruction.setMetadata(new HashMap<>());
        instruction.setSchemeId("28117598D567061E439F0B49573EC27F");
        instruction.setSettledByDate("2021-10-10");
    }

    @Given("I create an instruction object to post the create instruction with an exceeded length amount")
    public void iCreateAnInstructionObjectToPostTheCreateInstructionWithAnExceededLengthAmount() {
        instruction = new Instruction();
        instruction.setAmount("123456789012345678910.111111123456789023456789678923456789034567890456789");
        instruction.setCountry("IE");
        instruction.setCurrency("EUR");
        instruction.setCustomerRef("1");
        instruction.setDirection("DEBIT");
        instruction.setInstructionRef("2");
        instruction.setMetadata(new HashMap<>());
        instruction.setSchemeId("28117598D567061E439F0B49573EC27F");
        instruction.setSettledByDate("2021-10-10");
    }

    @Given("I create an instruction object to post the create instruction with null currency")
    public void iCreateAnInstructionObjectToPostTheCreateInstructionWithAnNullCurrency() {
        instruction = new Instruction();
        instruction.setAmount("10");
        instruction.setCountry("IE");
        instruction.setCurrency(null);
        instruction.setCustomerRef("1");
        instruction.setDirection("DEBIT");
        instruction.setInstructionRef("2");
        instruction.setMetadata(new HashMap<>());
        instruction.setSchemeId("28117598D567061E439F0B49573EC27F");
        instruction.setSettledByDate("2021-10-10");
    }

    @Given("I create an instruction object to post the create instruction with invalid currency")
    public void iCreateAnInstructionObjectToPostTheCreateInstructionWithAnInvalidCurrency() {
        instruction = new Instruction();
        instruction.setAmount("10");
        instruction.setCountry("IE");
        instruction.setCurrency("AAA");
        instruction.setCustomerRef("1");
        instruction.setDirection("DEBIT");
        instruction.setInstructionRef("2");
        instruction.setMetadata(new HashMap<>());
        instruction.setSchemeId("28117598D567061E439F0B49573EC27F");
        instruction.setSettledByDate("2021-10-10");
    }

    @Given("I create an instruction object to post the create instruction with an exceeded length currency")
    public void iCreateAnInstructionObjectToPostTheCreateInstructionWithAnExceededLengthCurrency() {
        instruction = new Instruction();
        instruction.setAmount("10");
        instruction.setCountry("IE");
        instruction.setCurrency("1234567890");
        instruction.setCustomerRef("1");
        instruction.setDirection("DEBIT");
        instruction.setInstructionRef("2");
        instruction.setMetadata(new HashMap<>());
        instruction.setSchemeId("28117598D567061E439F0B49573EC27F");
        instruction.setSettledByDate("2021-10-10");
    }

    @Given("I create an instruction object to post the create instruction with null country")
    public void iCreateAnInstructionObjectToPostTheCreateInstructionWithAnNullCountry() {
        instruction = new Instruction();
        instruction.setAmount("10");
        instruction.setCountry(null);
        instruction.setCurrency("EUR");
        instruction.setCustomerRef("1");
        instruction.setDirection("DEBIT");
        instruction.setInstructionRef("2");
        instruction.setMetadata(new HashMap<>());
        instruction.setSchemeId("28117598D567061E439F0B49573EC27F");
        instruction.setSettledByDate("2021-10-10");
    }

    @Given("I create an instruction object to post the create instruction with invalid country")
    public void iCreateAnInstructionObjectToPostTheCreateInstructionWithAnInvalidCountry() {
        instruction = new Instruction();
        instruction.setAmount("10");
        instruction.setCountry("ZZ");
        instruction.setCurrency("EUR");
        instruction.setCustomerRef("1");
        instruction.setDirection("DEBIT");
        instruction.setInstructionRef("2");
        instruction.setMetadata(new HashMap<>());
        instruction.setSchemeId("28117598D567061E439F0B49573EC27F");
        instruction.setSettledByDate("2021-10-10");
    }

    @Given("I create an instruction object to post the create instruction with an exceeded length country")
    public void iCreateAnInstructionObjectToPostTheCreateInstructionWithAnExceededLengthCountry() {
        instruction = new Instruction();
        instruction.setAmount("10");
        instruction.setCountry("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        instruction.setCurrency("EUR");
        instruction.setCustomerRef("1");
        instruction.setDirection("DEBIT");
        instruction.setInstructionRef("2");
        instruction.setMetadata(new HashMap<>());
        instruction.setSchemeId("28117598D567061E439F0B49573EC27F");
        instruction.setSettledByDate("2021-10-10");
    }

    @Given("I create an instruction object to post the create instruction with null direction")
    public void iCreateAnInstructionObjectToPostTheCreateInstructionWithAnNullDirection() {
        instruction = new Instruction();
        instruction.setAmount("10");
        instruction.setCountry("IE");
        instruction.setCurrency("EUR");
        instruction.setCustomerRef("1");
        instruction.setDirection(null);
        instruction.setInstructionRef("2");
        instruction.setMetadata(new HashMap<>());
        instruction.setSchemeId("28117598D567061E439F0B49573EC27F");
        instruction.setSettledByDate("2021-10-10");
    }

    @Given("I create an instruction object to post the create instruction with invalid direction")
    public void iCreateAnInstructionObjectToPostTheCreateInstructionWithAnInvalidDirection() {
        instruction = new Instruction();
        instruction.setAmount("10");
        instruction.setCountry("IE");
        instruction.setCurrency("EUR");
        instruction.setCustomerRef("1");
        instruction.setDirection("DEBITO");
        instruction.setInstructionRef("2");
        instruction.setMetadata(new HashMap<>());
        instruction.setSchemeId("28117598D567061E439F0B49573EC27F");
        instruction.setSettledByDate("2021-10-10");
    }

    @Given("I create an instruction object to post the create instruction with not supported scheme id")
    public void iCreateAnInstructionObjectToPostTheCreateInstructionWithNotSupportedSchemeId() {
        instruction = new Instruction();
        instruction.setAmount("1");
        instruction.setCountry("PT");
        instruction.setCurrency("GBP");
        instruction.setCustomerRef("1");
        instruction.setDirection("CREDIT");
        instruction.setInstructionRef("2");
        instruction.setMetadata(new HashMap<>());
        instruction.setSchemeId("28117598D567061E439F0B49573EC27F");
        instruction.setSettledByDate("2021-10-10");
    }

    @Given("I create an instruction object to post the create instruction with not recognised scheme id")
    public void iCreateAnInstructionObjectToPostTheCreateInstructionWithNotRecognisedSchemeId() {
        instruction = new Instruction();
        instruction.setAmount("10");
        instruction.setCountry("IE");
        instruction.setCurrency("EUR");
        instruction.setCustomerRef("1");
        instruction.setDirection("DEBIT");
        instruction.setInstructionRef("2");
        instruction.setMetadata(new HashMap<>());
        instruction.setSchemeId("28117598D567061E439F0B49573EC2dd7F");
        instruction.setSettledByDate("2021-10-10");
    }

    @Given("I create an instruction object to post the create instruction with null settleDate")
    public void iCreateAnInstructionObjectToPostTheCreateInstructionWithAnNullSettleDate() {
        instruction = new Instruction();
        instruction.setAmount("10");
        instruction.setCountry("IE");
        instruction.setCurrency("EUR");
        instruction.setCustomerRef("1");
        instruction.setDirection("DEBIT");
        instruction.setInstructionRef("2");
        instruction.setMetadata(new HashMap<>());
        instruction.setSchemeId("28117598D567061E439F0B49573EC27F");
        instruction.setSettledByDate(null);
    }

    @Given("I create an instruction object to post the create instruction with invalid settleDate")
    public void iCreateAnInstructionObjectToPostTheCreateInstructionWithAnInvalidSettleDate() {
        instruction = new Instruction();
        instruction.setAmount("10");
        instruction.setCountry("IE");
        instruction.setCurrency("EUR");
        instruction.setCustomerRef("1");
        instruction.setDirection("DEBIT");
        instruction.setInstructionRef("2");
        instruction.setMetadata(new HashMap<>());
        instruction.setSchemeId("28117598D567061E439F0B49573EC27F");
        instruction.setSettledByDate("10-10-10");
    }

    @When("I do the post create instruction")
    public void iDoThePostCreateInstruction() throws JsonProcessingException {
        instructionPost = instructionsRequests.createInstructionPost("1", instruction);
    }


    @When("I do the post create instruction to succeed")
    public void iDoThePostCreateInstructionToSucceed() throws JsonProcessingException {
        instructionPost = instructionsRequests.createInstructionWithSuccess("1", instruction);
    }

    @Then("I expect the instruction is created")
    public void iExpectTheInstructionIsCreated() {
        instructionPost.statusCode(201).statusLine("HTTP/1.1 201 Created");
    }

    @Then("I expect to receive the INSTRUCTION_REF_IS_REQUIRED response")
    public void iExpectToReceiveTheINSTRUCTION_REF_IS_REQUIREDResponse() throws InstructionCreatedInvalidFields {
        expectedResponse("Instruction shouldn't be created with a null instruction reference", "INSTRUCTION_REF_IS_REQUIRED");
    }

    @Then("I expect to receive the INSTRUCTION_ALREADY_EXISTS response")
    public void iExpectToReceiveTheINSTRUCTION_ALREADY_EXISTSResponse() throws InstructionCreatedInvalidFields {
        expectedResponse("Instruction shouldn't be created with an already existent instruction reference", "INSTRUCTION_ALREADY_EXISTS");
    }

    @Then("I expect to receive the INSTRUCTION_CANCELLED response")
    public void iExpectToReceiveTheINSTRUCTION_CANCELLEDResponse() throws InstructionCreatedInvalidFields {
        expectedResponse("Instruction shouldn't be created with an already canceled instruction reference", "INSTRUCTION_CANCELLED");
    }

    @Then("I expect to receive the INSTRUCTION_REF_LENGTH_OUT_OF_RANGE response")
    public void iExpectToReceiveTheINSTRUCTION_REF_LENGTH_OUT_OF_RANGEResponse() throws InstructionCreatedInvalidFields {
        expectedResponse("Instruction shouldn't be created with an exceeded length instruction reference", "INSTRUCTION_REF_LENGTH_OUT_OF_RANGE");
    }

    @Then("I expect to receive the INSTRUCTION_REF_CONTAINS_INVALID_CHARACTERS response")
    public void iExpectToReceiveTheINSTRUCTION_REF_CONTAINS_INVALID_CHARACTERSResponse() throws InstructionCreatedInvalidFields {
        expectedResponse("Instruction shouldn't be created with invalid instruction reference", "INSTRUCTION_REF_CONTAINS_INVALID_CHARACTERS");
    }

    @Then("I expect to receive the CUSTOMER_REF_IS_REQUIRED response")
    public void iExpectToReceiveTheCUSTOMER_REF_IS_REQUIRED_CHARACTERSResponse() throws InstructionCreatedInvalidFields {
        expectedResponse("Instruction shouldn't be created with null customer reference", "CUSTOMER_REF_IS_REQUIRED");
    }

    @Then("I expect to receive the CUSTOMER_REF_CONTAINS_INVALID_CHARACTERS response")
    public void iExpectToReceiveTheCUSTOMER_REF_CONTAINS_INVALID_CHARACTERSResponse() throws InstructionCreatedInvalidFields {
        expectedResponse("Instruction shouldn't be created with invalid customer reference", "CUSTOMER_REF_CONTAINS_INVALID_CHARACTERS");
    }


    @Then("I expect to receive the CUSTOMER_REF_LENGTH_OUT_OF_RANGE response")
    public void iExpectToReceiveTheCUSTOMER_REF_LENGTH_OUT_OF_RANGEResponse() throws InstructionCreatedInvalidFields {
        expectedResponse("Instruction shouldn't be created with an exceeded length customer reference", "CUSTOMER_REF_LENGTH_OUT_OF_RANGE");
    }

    @Then("I expect to receive the AMOUNT_IS_REQUIRED response")
    public void iExpectToReceiveTheAMOUNT_IS_REQUIREDResponse() throws InstructionCreatedInvalidFields {
        expectedResponse("Instruction shouldn't be created with null amount", "AMOUNT_IS_REQUIRED");
    }

    @Then("I expect to receive the AMOUNT_IS_INVALID response")
    public void iExpectToReceiveTheAMOUNT_IS_INVALIDResponse() throws InstructionCreatedInvalidFields {
        expectedResponse("Instruction shouldn't be created with invalid amount", "AMOUNT_IS_INVALID");
    }


    @Then("I expect to receive the AMOUNT_OUT_OF_RANGE response")
    public void iExpectToReceiveTheAMOUNT_OUT_OF_RANGEResponse() throws InstructionCreatedInvalidFields {
        expectedResponse("Instruction shouldn't be created with an exceeded length amount", "AMOUNT_OUT_OF_RANGE");
    }

    @Then("I expect to receive the CURRENCY_IS_REQUIRED response")
    public void iExpectToReceiveTheCURRENCY_IS_REQUIREDResponse() throws InstructionCreatedInvalidFields {
        expectedResponse("Instruction shouldn't be created with null currency", "CURRENCY_IS_REQUIRED");
    }

    @Then("I expect to receive the CURRENCY_NOT_SUPPORTED response")
    public void iExpectToReceiveTheCURRENCY_NOT_SUPPORTEDResponse() throws InstructionCreatedInvalidFields {
        expectedResponse("Instruction shouldn't be created with invalid currency", "CURRENCY_NOT_SUPPORTED");
    }

    @Then("I expect to receive the CURRENCY_LENGTH_OUT_OF_RANGE response")
    public void iExpectToReceiveTheCURRENCY_LENGTH_OUT_OF_RANGEResponse() throws InstructionCreatedInvalidFields {
        expectedResponse("Instruction shouldn't be created with an exceeded length currency", "CURRENCY_LENGTH_OUT_OF_RANGE");
    }

    @Then("I expect to receive the COUNTRY_IS_REQUIRED response")
    public void iExpectToReceiveTheCOUNTRY_IS_REQUIREDResponse() throws InstructionCreatedInvalidFields {
        expectedResponse("Instruction shouldn't be created with null country", "COUNTRY_IS_REQUIRED");
    }

    @Then("I expect to receive the COUNTRY_NOT_SUPPORTED response")
    public void iExpectToReceiveTheCOUNTRY_NOT_SUPPORTEDResponse() throws InstructionCreatedInvalidFields {
        expectedResponse("Instruction shouldn't be created with invalid country", "COUNTRY_NOT_SUPPORTED");
    }

    @Then("I expect to receive the COUNTRY_LENGTH_OUT_OF_RANGE response")
    public void iExpectToReceiveTheCOUNTRY_LENGTH_OUT_OF_RANGEResponse() throws InstructionCreatedInvalidFields {
        expectedResponse("Instruction shouldn't be created with an exceeded length country", "COUNTRY_LENGTH_OUT_OF_RANGE");
    }

    @Then("I expect to receive the DIRECTION_IS_REQUIRED response")
    public void iExpectToReceiveTheDIRECTION_IS_REQUIREDResponse() throws InstructionCreatedInvalidFields {
        expectedResponse("Instruction shouldn't be created with null direction", "DIRECTION_IS_REQUIRED");
    }

    @Then("I expect to receive the DIRECTION_IS_NOT_RECOGNISED response")
    public void iExpectToReceiveTheDIRECTION_IS_NOT_RECOGNISEDResponse() throws InstructionCreatedInvalidFields {
        expectedResponse("Instruction shouldn't be created with invalid direction", "DIRECTION_IS_NOT_RECOGNISED");
    }

    @Then("I expect to receive the SCHEME_ID_NOT_SUPPORTED response")
    public void iExpectToReceiveTheSCHEME_ID_NOT_SUPPORTEDResponse() throws InstructionCreatedInvalidFields {
        expectedResponse("Instruction shouldn't be created with not supported scheme id (against the direction of the instructions, country, amount and currency)", "SCHEME_ID_NOT_SUPPORTED");
    }

    @Then("I expect to receive the SCHEME_ID_NOT_RECOGNISED response")
    public void iExpectToReceiveTheSCHEME_ID_NOT_RECOGNISEDResponse() throws InstructionCreatedInvalidFields {
        expectedResponse("Instruction shouldn't be created with not recognised scheme id", "SCHEME_ID_NOT_RECOGNISED");
    }

    @Then("I expect to receive the SETTLED_BY_DATE_IS_REQUIRED response")
    public void iExpectToReceiveTheSETTLED_BY_DATE_IS_REQUIREDResponse() throws InstructionCreatedInvalidFields {
        expectedResponse("Instruction shouldn't be created with null settleDate", "SETTLED_BY_DATE_IS_REQUIRED");
    }

    @Then("I expect to receive the SETTLED_BY_DATE_IS_INVALID response")
    public void iExpectToReceiveTheSETTLED_BY_DATE_IS_INVALIDResponse() throws InstructionCreatedInvalidFields {
        expectedResponse("Instruction shouldn't be created with invalid settleDate", "SETTLED_BY_DATE_IS_INVALID");
    }

    private void expectedResponse(String errorMessage, String errorCode) throws InstructionCreatedInvalidFields {
        if (instructionPost.extract().statusCode() == 201) {
            throw new InstructionCreatedInvalidFields(errorMessage);
        }
        instructionPost.statusCode(400).statusLine("HTTP/1.1 400 Bad Request");
        Assert.assertEquals("Error message is not the expected", errorCode, instructionPost.extract().response().jsonPath().getString("errors[0].errorCode"));
    }
}
