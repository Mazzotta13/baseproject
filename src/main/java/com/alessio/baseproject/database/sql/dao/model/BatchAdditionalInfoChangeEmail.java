package com.alessio.baseproject.database.sql.dao.model;

import java.util.List;

public class BatchAdditionalInfoChangeEmail extends BatchAdditionalInfo {
    private String oldEmailAddress;
    private String newEmailAddress;
    private String userId;
    private List<String> customerIds;

    public BatchAdditionalInfoChangeEmail(String type) {
        super(type);
    }

    public String getOldEmailAddress() {
        return oldEmailAddress;
    }

    public BatchAdditionalInfoChangeEmail setOldEmailAddress(String oldEmailAddress) {
        this.oldEmailAddress = oldEmailAddress;
        return this;
    }

    public String getNewEmailAddress() {
        return newEmailAddress;
    }

    public BatchAdditionalInfoChangeEmail setNewEmailAddress(String newEmailAddress) {
        this.newEmailAddress = newEmailAddress;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public BatchAdditionalInfoChangeEmail setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public List<String> getCustomerIds() {
        return customerIds;
    }

    public BatchAdditionalInfoChangeEmail setCustomerIds(List<String> customerIds) {
        this.customerIds = customerIds;
        return this;
    }

    @Override
    public String toString() {
        return "BatchAdditionalInfoChangeEmail{" +
                "oldEmailAddress='" + oldEmailAddress + '\'' +
                ", newEmailAddress='" + newEmailAddress + '\'' +
                ", userId='" + userId + '\'' +
                ", customerIds=" + customerIds +
                '}';
    }
}
