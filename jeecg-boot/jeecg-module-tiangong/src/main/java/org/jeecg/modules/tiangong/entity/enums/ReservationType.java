package org.jeecg.modules.tiangong.entity.enums;

/**
 * 预约类型枚举
 */
public enum ReservationType {
    PHONE("电话预约"),
    OFFICIAL("官网预约"),
    SUPPLIER_APPOINTMENT("供应商预约"),
    UNKNOWN("未知");

    private final String description;

    ReservationType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
