package api.objects;

import java.util.HashMap;

public class Instruction {


    private String instructionRef = "";
    private String customerRef = "";
    private String direction = "";
    private String financialInstrumentId = "";
    private String amount = "";
    private String currency = "";
    private String country = "";
    private String settledByDate = "";
    private String schemeId = "";
    private HashMap<String,String> metadata = new HashMap<>();

    public String getInstructionRef() {
        return instructionRef;
    }

    public void setInstructionRef(String instructionRef) {
        this.instructionRef = instructionRef;
    }

    public String getCustomerRef() {
        return customerRef;
    }

    public void setCustomerRef(String customerRef) {
        this.customerRef = customerRef;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getFinancialInstrumentId() {
        return financialInstrumentId;
    }

    public void setFinancialInstrumentId(String financialInstrumentId) {
        this.financialInstrumentId = financialInstrumentId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSettledByDate() {
        return settledByDate;
    }

    public void setSettledByDate(String settledByDate) {
        this.settledByDate = settledByDate;
    }

    public String getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId;
    }

    public HashMap<String,String> getMetadata() {
        return metadata;
    }

    public void setMetadata(HashMap<String,String> metadata) {
        this.metadata = metadata;
    }

}
