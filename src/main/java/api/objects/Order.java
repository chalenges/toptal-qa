package api.objects;


import java.util.HashMap;

public class Order {
    private HashMap<String, String> metadata;
    private CustomerDefaults customerDefaults;
    private String orderRef;
    private Instruction[] instructions;

    public CustomerDefaults getCustomerDefaults() {
        return customerDefaults;
    }

    public void setCustomerDefaults(CustomerDefaults customerDefaults) {
        this.customerDefaults = customerDefaults;
    }

    public Instruction[] getInstructions() {
        return instructions;
    }

    public void setInstructions(Instruction[] instructions) {
        this.instructions = instructions;
    }

    public String getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }

    public HashMap<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(HashMap<String, String> metadata) {
        this.metadata = metadata;
    }
}
