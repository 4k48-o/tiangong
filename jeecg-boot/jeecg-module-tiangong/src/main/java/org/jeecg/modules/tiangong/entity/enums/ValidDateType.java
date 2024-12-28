package org.jeecg.modules.tiangong.entity.enums;

public enum ValidDateType {
    

    WITHIN_A_FIXED_PERIOD("固定时间段内"),
    DATE_OF_PLAY("游玩日期当天"),
    PLAY_DATES_UNTIL_SPECIFIED_DATES("游玩日期至指定日期"),
    WITHIN_X_DAYS_AFTER_PLACING_THE_ORDER("下单后X天内"),
    THE_SECOND_DAY_OF_THE_ORDER_UNTIL_THE_SPECIFIED_DATE("下单第二天至指定日期"),
    WITHIN_X_DAYS_BEFORE_THE_DATE_OF_PLAY("游玩日期前X天内"),
    WITHIN_X_DAYS_AFTER_THE_DATE_OF_PLAY("游玩日期后X天内"),
    WITHIN_X_DAYS_OF_THE_DATE_OF_PLAY("游玩日期前后X天内"),
    UNKNOWN("未知");




    private final String description;

    ValidDateType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
