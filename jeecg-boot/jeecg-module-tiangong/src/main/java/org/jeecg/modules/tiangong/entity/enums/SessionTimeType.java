package org.jeecg.modules.tiangong.entity.enums;

/**
 * 截止预定时间相较场次时间的类型枚举 
 * @author: 老杨
 * @date: 2024-12-22
 */
public enum SessionTimeType {

    SESSION_START("场次开始时间"),
    SESSION_END ("场次结束时"),
    OTHER ("其他"),
    UNKNOWN ("未知");
    
    private final String description;
    SessionTimeType(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
