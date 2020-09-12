package com.alessio.baseproject.database.sql.dao.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = false
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BatchAdditionalInfoChangeEmail.class, name = BatchAdditionalInfoSubType.BATCH_ADDITIONAL_INFO_CHANGE_EMAIL),
})
public abstract class BatchAdditionalInfo {
    private String type;

    public BatchAdditionalInfo(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "BatchAdditionalInfo{" +
                "type='" + type + '\'' +
                '}';
    }
}
