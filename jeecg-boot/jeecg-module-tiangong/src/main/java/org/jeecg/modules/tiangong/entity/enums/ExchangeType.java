package org.jeecg.modules.tiangong.entity.enums;
/**
 * 换票方式。
 * @author 老杨
 * @date 2024年12月25日14:21:00
 */
public enum ExchangeType {
    
    OFFLINE_EXCHANGE("线下兑换"),
    ONLINE_EXCHANGE("线上兑换"),
    UNKNOWN("未知类型");


    private final String description;

    ExchangeType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
