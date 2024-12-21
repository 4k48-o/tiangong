package org.jeecg.modules.tiangong.entity.enums;

/**
 * 通用是否选项枚举
 */
public enum OptionsType {
    YES("是"),
    NO("否"),
    UNKNOWN("未知");

    private final String description;

    OptionsType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
