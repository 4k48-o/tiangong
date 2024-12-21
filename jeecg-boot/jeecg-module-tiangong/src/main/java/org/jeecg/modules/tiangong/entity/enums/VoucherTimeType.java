package org.jeecg.modules.tiangong.entity.enums;

/**
 * 凭证时间类型枚举
 */
public enum VoucherTimeType {
    BEFORE_TRAVELING("出行前"),
    AFTER_CREATE_ORDER("下单后");

    private final String description;

    VoucherTimeType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
