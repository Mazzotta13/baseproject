package com.alessio.baseproject.database.sql.dao.model;

import org.joda.time.DateTime;

public class UserDto {
    private String id;
    private String name;
    private DateTime creationDate;

    public String getId() {
        return id;
    }

    public UserDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDto setName(String name) {
        this.name = name;
        return this;
    }

    public DateTime getCreationDate() {
        return creationDate;
    }

    public UserDto setCreationDate(DateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
