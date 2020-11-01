package api.expections;

public class InstructionCreatedInvalidFields extends Exception {
    public InstructionCreatedInvalidFields(String errorMessage) {
        super(errorMessage);
    }
}
