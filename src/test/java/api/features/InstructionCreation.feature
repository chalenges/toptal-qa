@InstructionCreation
Feature: Instruction Creation

  @InstructionCreationWithSuccess
  Scenario: Create Instruction with success
    Given I create an instruction object to post the create instruction with success
    When I do the post create instruction to succeed
    Then I expect the instruction is created

  @InstructionCreationWithNullInstructionReference
  Scenario: Create Instruction with response INSTRUCTION_REF_IS_REQUIRED
    Given I create an instruction object to post the create instruction with null instruction reference
    When I do the post create instruction to succeed
    Then I expect to receive the INSTRUCTION_REF_IS_REQUIRED response

  @InstructionCreationWithAnExistentInstructionReference
  Scenario: Create Instruction with response INSTRUCTION_ALREADY_EXISTS
    Given I create an instruction object to post the create instruction with an instruction reference that already exists
    When I do the post create instruction
    Then I expect to receive the INSTRUCTION_ALREADY_EXISTS response

  @InstructionCreationWithAnCanceledInstructionReference
  Scenario: Create Instruction with response INSTRUCTION_CANCELLED
    Given I create an instruction object to post the create instruction with a canceled instruction reference
    When I do the post create instruction to succeed
    Then I expect to receive the INSTRUCTION_CANCELLED response

  @InstructionCreationWithExceededLengthInstructionReference
  Scenario: Create Order with response INSTRUCTION_REF_LENGTH_OUT_OF_RANGE
    Given I create an instruction object to post the create instruction with an exceeded length instruction reference
    When I do the post create instruction to succeed
    Then I expect to receive the INSTRUCTION_REF_LENGTH_OUT_OF_RANGE response

  @InstructionCreationWithInvalidInstructionReference
  Scenario: Create Order with response INSTRUCTION_REF_CONTAINS_INVALID_CHARACTERS
    Given I create an instruction object to post the create instruction with an invalid instruction reference
    When I do the post create instruction to succeed
    Then I expect to receive the INSTRUCTION_REF_CONTAINS_INVALID_CHARACTERS response


  @InstructionCreationWithNullCustomerReference
  Scenario: Create Instruction with response CUSTOMER_REF_IS_REQUIRED
    Given I create an instruction object to post the create instruction with null customer reference
    When I do the post create instruction to succeed
    Then I expect to receive the CUSTOMER_REF_IS_REQUIRED response

  @InstructionCreationWithInvalidCustomerReference
  Scenario: Create Instruction with response CUSTOMER_REF_CONTAINS_INVALID_CHARACTERS
    Given I create an instruction object to post the create instruction with invalid customer reference
    When I do the post create instruction to succeed
    Then I expect to receive the CUSTOMER_REF_CONTAINS_INVALID_CHARACTERS response

  @InstructionCreationWithAnExceededLengthCustomerReference
  Scenario: Create Instruction with response CUSTOMER_REF_LENGTH_OUT_OF_RANGE
    Given I create an instruction object to post the create instruction with an exceeded length customer reference
    When I do the post create instruction to succeed
    Then I expect to receive the CUSTOMER_REF_LENGTH_OUT_OF_RANGE response

  @InstructionCreationWithNullAmount
  Scenario: Create Instruction with response AMOUNT_IS_REQUIRED
    Given I create an instruction object to post the create instruction with null amount
    When I do the post create instruction to succeed
    Then I expect to receive the AMOUNT_IS_REQUIRED response

  @InstructionCreationWithInvalidAmount
  Scenario: Create Instruction with response AMOUNT_IS_INVALID
    Given I create an instruction object to post the create instruction with invalid amount
    When I do the post create instruction to succeed
    Then I expect to receive the AMOUNT_IS_INVALID response

  @InstructionCreationWithAnExceededLengthAmount
  Scenario: Create Instruction with response AMOUNT_OUT_OF_RANGE
    Given I create an instruction object to post the create instruction with an exceeded length amount
    When I do the post create instruction to succeed
    Then I expect to receive the AMOUNT_OUT_OF_RANGE response

  @InstructionCreationWithNullCurrency
  Scenario: Create Instruction with response CURRENCY_IS_REQUIRED
    Given I create an instruction object to post the create instruction with null currency
    When I do the post create instruction to succeed
    Then I expect to receive the CURRENCY_IS_REQUIRED response

  @InstructionCreationWithInvalidCurrency
  Scenario: Create Instruction with response CURRENCY_NOT_SUPPORTED
    Given I create an instruction object to post the create instruction with invalid currency
    When I do the post create instruction to succeed
    Then I expect to receive the CURRENCY_NOT_SUPPORTED response

  @InstructionCreationWithAnExceededLengthCurrency
  Scenario: Create Instruction with response CURRENCY_LENGTH_OUT_OF_RANGE
    Given I create an instruction object to post the create instruction with an exceeded length currency
    When I do the post create instruction to succeed
    Then I expect to receive the CURRENCY_LENGTH_OUT_OF_RANGE response

  @InstructionCreationWithNullCountry
  Scenario: Create Instruction with response COUNTRY_IS_REQUIRED
    Given I create an instruction object to post the create instruction with null country
    When I do the post create instruction to succeed
    Then I expect to receive the COUNTRY_IS_REQUIRED response

  @InstructionCreationWithInvalidCountry
  Scenario: Create Instruction with response COUNTRY_NOT_SUPPORTED
    Given I create an instruction object to post the create instruction with invalid country
    When I do the post create instruction to succeed
    Then I expect to receive the COUNTRY_NOT_SUPPORTED response

  @InstructionCreationWithAnExceededLengthCountry
  Scenario: Create Instruction with response COUNTRY_LENGTH_OUT_OF_RANGE
    Given I create an instruction object to post the create instruction with an exceeded length country
    When I do the post create instruction to succeed
    Then I expect to receive the COUNTRY_LENGTH_OUT_OF_RANGE response

  @InstructionCreationWithNullDirection
  Scenario: Create Instruction with response DIRECTION_IS_REQUIRED
    Given I create an instruction object to post the create instruction with null direction
    When I do the post create instruction to succeed
    Then I expect to receive the DIRECTION_IS_REQUIRED response

  @InstructionCreationWithInvalidDirection
  Scenario: Create Instruction with response DIRECTION_IS_NOT_RECOGNISED
    Given I create an instruction object to post the create instruction with invalid direction
    When I do the post create instruction to succeed
    Then I expect to receive the DIRECTION_IS_NOT_RECOGNISED response

  @InstructionCreationWithNotSupportedSchemeId
  Scenario: Create Instruction with response SCHEME_ID_NOT_SUPPORTED
    Given I create an instruction object to post the create instruction with not supported scheme id
    When I do the post create instruction to succeed
    Then I expect to receive the SCHEME_ID_NOT_SUPPORTED response

  @InstructionCreationWithNotRecognisedSchemeId
  Scenario: Create Instruction with response SCHEME_ID_NOT_RECOGNISED
    Given I create an instruction object to post the create instruction with not recognised scheme id
    When I do the post create instruction to succeed
    Then I expect to receive the SCHEME_ID_NOT_RECOGNISED response

  @InstructionCreationWithNullSettleDate
  Scenario: Create Instruction with response SETTLED_BY_DATE_IS_REQUIRED
    Given I create an instruction object to post the create instruction with null settleDate
    When I do the post create instruction to succeed
    Then I expect to receive the SETTLED_BY_DATE_IS_REQUIRED response

  @InstructionCreationWithInvalidSettleDate
  Scenario: Create Instruction with response SETTLED_BY_DATE_IS_INVALID
    Given I create an instruction object to post the create instruction with invalid settleDate
    When I do the post create instruction to succeed
    Then I expect to receive the SETTLED_BY_DATE_IS_INVALID response