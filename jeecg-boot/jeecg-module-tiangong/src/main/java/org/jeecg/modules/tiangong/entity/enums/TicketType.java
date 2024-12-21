package org.jeecg.modules.tiangong.entity.enums;

/**
 * 出票类型枚举
 */
public enum TicketType {
    E_TICKET("电子票"),
    PHYSICAL_TICKET("实体票"),
    OTHER("其他"),
    UNKNOWN("未知");

    private final String description;

    TicketType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
