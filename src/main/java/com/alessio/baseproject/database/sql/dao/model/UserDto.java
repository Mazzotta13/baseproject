package com.alessio.baseproject.database.sql.dao.model;

import java.time.LocalDateTime;

public class UserDto {
    private String utentiId;
    private String name;
    private LocalDateTime creationDate;

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public UserDto setCreationDate(LocalDateTime creationDate) {
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
                '}';
    }
}
