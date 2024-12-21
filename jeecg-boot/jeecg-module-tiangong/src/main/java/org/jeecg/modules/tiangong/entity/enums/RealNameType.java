package org.jeecg.modules.tiangong.entity.enums;

/**
 * 实名制类型枚举
 */
public enum RealNameType {
    REAL_NAME("实名"),
    NOT_REAL_NAME("非实名"),
    UNKNOWN("未知");

    private final String description;

    RealNameType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
