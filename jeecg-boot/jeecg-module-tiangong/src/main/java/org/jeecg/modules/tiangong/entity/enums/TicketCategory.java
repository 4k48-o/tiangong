package org.jeecg.modules.tiangong.entity.enums;

/**
 * 门票分类枚举
 */
public enum TicketCategory {
    BIG_TICKET("普通门票"),
    PACKAGE_TICKET("套票"),
    COUPONS_TICKET("多景区联票"),
    PLAY_ITEM("游玩项目"),
    OTHER("其他"),
    UNKNOWN("未知");

    private final String description;

    TicketCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
