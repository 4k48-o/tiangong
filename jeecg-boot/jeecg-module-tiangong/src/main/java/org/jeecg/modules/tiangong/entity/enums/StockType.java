package org.jeecg.modules.tiangong.entity.enums;

/**
 * 库存类型枚举
 */
public enum StockType {
    CALENDAR_INVENTORY("日历库存"),
    TOTAL_INVENTORY("总库存"),
    CALENDAR_PRICE_TOTAL_INVENTORY("日历价格总库存"),
    TOTAL_PRICE_CALENDAR_INVENTORY("总价格日历库存"),
    UNKNOWN("未知");

    private final String description;

    StockType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
