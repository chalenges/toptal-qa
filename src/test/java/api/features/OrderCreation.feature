@OrderCreation
Feature: Order Creation

  @OrderCreationWithSuccess
  Scenario: Create Order with success
    Given I create an order object to post the create order with success
    When I do the post create order to succeed
    Then I expect this order is created

  @OrderCreationWithExistentOrderReference
  Scenario: Create Order with response ORDER_ALREADY_EXISTS
    Given I create an order object to post the create order with order reference that already exists
    When I do the post create order
    Then I expect to receive the ORDER_ALREADY_EXISTS response

  @OrderCreationWithNullOrderReference
  Scenario: Create Order with response ORDER_REF_IS_REQUIRED
    Given I create an order object to post the create order without order reference
    When I do the post create order
    Then I expect to receive the ORDER_REF_IS_REQUIRED response

  @OrderCreationWithExceededLengthOrderReference
  Scenario: Create Order with response ORDER_REF_LENGTH_OUT_OF_RANGE
    Given I create an order object to post the create order with an exceeded length order reference
    When I do the post create order
    Then I expect to receive the ORDER_REF_LENGTH_OUT_OF_RANGE response

  @OrderCreationWithInvalidOrderReference
  Scenario: Create Order with response ORDER_REF_CONTAINS_INVALID_CHARACTERS
    Given I create an order object to post the create order with an invalid order reference
    When I do the post create order
    Then I expect to receive the ORDER_REF_CONTAINS_INVALID_CHARACTERS response

  @OrderCreationWithExceededLengthOrderMetadataKey
  Scenario: Create Order with response METADATA_KEY_SIZE_OUT_OF_RANGE
    Given I create an order object to post the create order with an exceeded length order metadata key
    When I do the post create order to succeed
    Then I expect to receive the METADATA_KEY_SIZE_OUT_OF_RANGE response

  @OrderCreationWithExceededLengthOrderMetadataValue
  Scenario: Create Order with response METADATA_VALUE_SIZE_OUT_OF_RANGE
    Given I create an order object to post the create order with an exceeded length order metadata value
    When I do the post create order to succeed
    Then I expect to receive the METADATA_VALUE_SIZE_OUT_OF_RANGE response

  @OrderCreationWithDuplicatedOrderMetadataKeys
  Scenario: Create Order with response METADATA_DUPLICATED_KEY
    Given I create an order object to post the create order with duplicated metadata key
    When I do the post create order to succeed with string
    Then I expect to receive the METADATA_DUPLICATED_KEY response

  @OrderCreationWithNullValueOrderMetadataValue
  Scenario: Create Order with status code 400 due null order metadata value
    Given I create an order object to post the create order with null metadata value
    When I do the post create order to succeed
    Then I expect to receive the status code 400 due null order metadata value