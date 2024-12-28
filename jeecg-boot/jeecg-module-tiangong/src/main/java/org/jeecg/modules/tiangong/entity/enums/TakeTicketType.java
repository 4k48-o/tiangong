package org.jeecg.modules.tiangong.entity.enums;


/**
 * 出票类型枚举
 * @author 老杨
 * @date 2024年12月25日14:15:36
 */
public enum TakeTicketType {

    
    E_TICKET("电子票"),
    PHYSICAL_TICKET("实体票"),
    OTHER("其他"),
    UNKNOWN("未知");

    private final String description;

    TakeTicketType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
