package org.jeecg.modules.tiangong.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 枚举类，用于表示截止预定时间相较场次时间的类型。
 */
public enum SessionTimeType {
    SESSION_START("SESSION_START"), // 场次开始时间
    SESSION_END("SESSION_END"),     // 场次结束时间
    OTHER("OTHER"),                 // 其他
    UNKNOWN("UNKNOWN");             // 未知

    private final String value;

    SessionTimeType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static SessionTimeType fromValue(String value) {
        for (SessionTimeType type : SessionTimeType.values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown enum type " + value);
    }
}