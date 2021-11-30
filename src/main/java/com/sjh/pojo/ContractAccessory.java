package com.sjh.pojo;

public class ContractAccessory {
    private Long id;

    private String accessoryName;

    private String accessoryUrl;

    private Long contractId;

    private Long accessorySize;

    private String accessoryType;

    private String accessoryComment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccessoryName() {
        return accessoryName;
    }

    public void setAccessoryName(String accessoryName) {
        this.accessoryName = accessoryName == null ? null : accessoryName.trim();
    }

    public String getAccessoryUrl() {
        return accessoryUrl;
    }

    public void setAccessoryUrl(String accessoryUrl) {
        this.accessoryUrl = accessoryUrl == null ? null : accessoryUrl.trim();
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getAccessorySize() {
        return accessorySize;
    }

    public void setAccessorySize(Long accessorySize) {
        this.accessorySize = accessorySize;
    }

    public String getAccessoryType() {
        return accessoryType;
    }

    public void setAccessoryType(String accessoryType) {
        this.accessoryType = accessoryType == null ? null : accessoryType.trim();
    }

    public String getAccessoryComment() {
        return accessoryComment;
    }

    public void setAccessoryComment(String accessoryComment) {
        this.accessoryComment = accessoryComment;
    }
}