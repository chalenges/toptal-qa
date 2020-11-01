package api.expections;

public class OrderCreatedInvalidFields extends Exception {
    public OrderCreatedInvalidFields(String errorMessage) {
        super(errorMessage);
    }
}
