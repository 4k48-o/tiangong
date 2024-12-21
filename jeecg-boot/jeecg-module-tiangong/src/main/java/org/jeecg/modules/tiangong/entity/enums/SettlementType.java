package org.jeecg.modules.tiangong.entity.enums;

/**
 * 结算方式枚举
 */
public enum SettlementType {
    MARK_UP("底价加价"),
    COMMISSION("佣金"),
    UNKNOWN("未知类型");

    private final String description;

    SettlementType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
