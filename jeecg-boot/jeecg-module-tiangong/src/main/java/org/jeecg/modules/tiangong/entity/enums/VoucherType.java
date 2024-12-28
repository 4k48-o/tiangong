package org.jeecg.modules.tiangong.entity.enums;


/**
 * 凭证类型
 * @author 老杨
 * @date 2024年12月25日14:24:06
 */
public enum VoucherType {
 
    ID_CARD("身份证"),
    PHONE("手机号"),
    QR_CODE("二维码"),
    QR_CODE_OR_ID_CARD("二维码或身份证"),
    NUMBER("数字码"),
    PDF_OR_WEB_PAGE("PDF或网页"),
    OTHER("其他"),
    UNKNOWN("未知类型");



    private final String description;

    VoucherType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
