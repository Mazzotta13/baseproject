package com.alessio.baseproject.database.sql.dao.model;

import com.alessio.baseproject.serializer.DateTimeJsonDeserializer;
import com.alessio.baseproject.serializer.DateTimeJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.joda.time.DateTime;

public class UserDto {
    private String utentiId;
    private String name;
    @JsonSerialize(using = DateTimeJsonSerializer.class)
    @JsonDeserialize(using = DateTimeJsonDeserializer.class)
    private DateTime creationDate;

    private BatchAdditionalInfo additionalInfo;

    public BatchAdditionalInfo getAdditionalInfo() {
        return additionalInfo;
    }

    public UserDto setAdditionalInfo(BatchAdditionalInfo additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }

    public DateTime getCreationDate() {
        return creationDate;
    }

    public UserDto setCreationDate(DateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public String getUtentiId() {
        return utentiId;
    }

    public UserDto setUtentiId(String utentiId) {
        this.utentiId = utentiId;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDto setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "utentiId='" + utentiId + '\'' +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", additionalInfo=" + additionalInfo +
                '}';
    }
}
