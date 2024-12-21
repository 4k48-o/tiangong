package org.jeecg.modules.tiangong.entity.enums;

/**
 * 旅客资料类型枚举
 */
public enum CustomType {
    CONTACT_TYPE("旅客代表人"),
    TRAVELER_TYPE("每位旅客"),
    SEND("寄送资料"),
    CONTACT("联络资料"),
    UNKNOWN("未知");

    private final String description;

    CustomType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
