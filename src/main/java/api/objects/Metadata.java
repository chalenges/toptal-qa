package api.objects;

import java.util.HashMap;

public class Metadata {
    private String duplicatedKey;
    private HashMap<String, String> additionalProperties;

    public String getDuplicatedKey() {
        return duplicatedKey;
    }

    public void setDuplicatedKey(String duplicatedKey) {
        this.duplicatedKey = duplicatedKey;
    }

    public HashMap<String, String> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(HashMap<String, String> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}
