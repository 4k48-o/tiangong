-- 创建预约类型字典
INSERT INTO sys_dict (id, dict_name, dict_code, description, del_flag, create_by, create_time, update_by, update_time, type, tenant_id) 
VALUES ('1737453746274258945', '预约类型', 'reservation_type', '预约类型', 0, 'admin', '2024-12-21 12:01:23', NULL, NULL, 0, 0);

INSERT INTO sys_dict_item (id, dict_id, item_text, item_value, description, sort_order, status, create_by, create_time, update_by, update_time) 
VALUES ('1737453746274258946', '1737453746274258945', '电话预约', 'PHONE', '电话预约', 1, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258947', '1737453746274258945', '官网预约', 'OFFICIAL', '官网预约', 2, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258948', '1737453746274258945', '供应商预约', 'SUPPLIER_APPOINTMENT', '供应商预约（二次预约）', 3, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258949', '1737453746274258945', '未知', 'UNKNOWN', '未知', 4, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL);

-- 创建实名制字典
INSERT INTO sys_dict (id, dict_name, dict_code, description, del_flag, create_by, create_time, update_by, update_time, type, tenant_id) 
VALUES ('1737453746274258950', '是否实名制', 'real_name_type', '是否实名制', 0, 'admin', '2024-12-21 12:01:23', NULL, NULL, 0, 0);

INSERT INTO sys_dict_item (id, dict_id, item_text, item_value, description, sort_order, status, create_by, create_time, update_by, update_time) 
VALUES ('1737453746274258951', '1737453746274258950', '实名', 'REAL_NAME', '实名', 1, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258952', '1737453746274258950', '非实名', 'NOT_REAL_NAME', '非实名', 2, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258953', '1737453746274258950', '未知', 'UNKNOWN', '未知', 3, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL);

-- 创建门票分类字典
INSERT INTO sys_dict (id, dict_name, dict_code, description, del_flag, create_by, create_time, update_by, update_time, type, tenant_id) 
VALUES ('1737453746274258954', '门票分类', 'ticket_category', '门票分类', 0, 'admin', '2024-12-21 12:01:23', NULL, NULL, 0, 0);

INSERT INTO sys_dict_item (id, dict_id, item_text, item_value, description, sort_order, status, create_by, create_time, update_by, update_time) 
VALUES ('1737453746274258955', '1737453746274258954', '普通门票', 'BIG_TICKET', '普通门票', 1, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258956', '1737453746274258954', '套票', 'PACKAGE_TICKET', '套票', 2, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258957', '1737453746274258954', '多景区联票', 'COUPONS_TICKET', '多景区联票', 3, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258958', '1737453746274258954', '游玩项目', 'PLAY_ITEM', '游玩项目', 4, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258959', '1737453746274258954', '其他', 'OTHER', '其他', 5, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258960', '1737453746274258954', '未知', 'UNKNOWN', '未知', 6, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL);

-- 创建出票类型字典
INSERT INTO sys_dict (id, dict_name, dict_code, description, del_flag, create_by, create_time, update_by, update_time, type, tenant_id) 
VALUES ('1737453746274258961', '出票类型', 'ticket_type', '出票类型', 0, 'admin', '2024-12-21 12:01:23', NULL, NULL, 0, 0);

INSERT INTO sys_dict_item (id, dict_id, item_text, item_value, description, sort_order, status, create_by, create_time, update_by, update_time) 
VALUES ('1737453746274258962', '1737453746274258961', '电子票', 'E_TICKET', '电子票', 1, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258963', '1737453746274258961', '实体票', 'PHYSICAL_TICKET', '实体票', 2, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258964', '1737453746274258961', '其他', 'OTHER', '其他', 3, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258965', '1737453746274258961', '未知', 'UNKNOWN', '未知', 4, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL);

-- 创建库存类型字典
INSERT INTO sys_dict (id, dict_name, dict_code, description, del_flag, create_by, create_time, update_by, update_time, type, tenant_id) 
VALUES ('1737453746274258966', '库存类型', 'stock_type', '产品库存类型', 0, 'admin', '2024-12-21 12:01:23', NULL, NULL, 0, 0);

INSERT INTO sys_dict_item (id, dict_id, item_text, item_value, description, sort_order, status, create_by, create_time, update_by, update_time) 
VALUES ('1737453746274258967', '1737453746274258966', '日历库存', 'CALENDAR_INVENTORY', '日历库存', 1, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258968', '1737453746274258966', '总库存', 'TOTAL_INVENTORY', '总库存', 2, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258969', '1737453746274258966', '日历价格总库存', 'CALENDAR_PRICE_TOTAL_INVENTORY', '日历价格总库存', 3, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258970', '1737453746274258966', '总价格日历库存', 'TOTAL_PRICE_CALENDAR_INVENTORY', '总价格日历库存', 4, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258971', '1737453746274258966', '未知', 'UNKNOWN', '未知', 5, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL);

-- 创建是否选项通用字典
INSERT INTO sys_dict (id, dict_name, dict_code, description, del_flag, create_by, create_time, update_by, update_time, type, tenant_id) 
VALUES ('1737453746274258972', '是否选项', 'options_type', '通用是否选项', 0, 'admin', '2024-12-21 12:01:23', NULL, NULL, 0, 0);

INSERT INTO sys_dict_item (id, dict_id, item_text, item_value, description, sort_order, status, create_by, create_time, update_by, update_time) 
VALUES ('1737453746274258973', '1737453746274258972', '是', 'YES', '是', 1, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258974', '1737453746274258972', '否', 'NO', '否', 2, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258975', '1737453746274258972', '未知', 'UNKNOWN', '未知', 3, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL);

-- 创建时间类型字典（用于发送凭证和二次确认）
INSERT INTO sys_dict (id, dict_name, dict_code, description, del_flag, create_by, create_time, update_by, update_time, type, tenant_id) 
VALUES ('1737453746274258976', '时间类型', 'time_type', '用于发送凭证和二次确认的时间类型', 0, 'admin', '2024-12-21 12:01:23', NULL, NULL, 0, 0);

INSERT INTO sys_dict_item (id, dict_id, item_text, item_value, description, sort_order, status, create_by, create_time, update_by, update_time) 
VALUES ('1737453746274258977', '1737453746274258976', '出行前', 'BEFORE_TRAVELING', '出行前', 1, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258978', '1737453746274258976', '下单后', 'AFTER_CREATE_ORDER', '下单后', 2, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL);

-- 创建结算方式字典
INSERT INTO sys_dict (id, dict_name, dict_code, description, del_flag, create_by, create_time, update_by, update_time, type, tenant_id) 
VALUES ('1737453746274258979', '结算方式', 'settlement_type', '结算方式', 0, 'admin', '2024-12-21 12:01:23', NULL, NULL, 0, 0);

INSERT INTO sys_dict_item (id, dict_id, item_text, item_value, description, sort_order, status, create_by, create_time, update_by, update_time) 
VALUES ('1737453746274258980', '1737453746274258979', '底价加价', 'MARK_UP', '底价加价', 1, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258981', '1737453746274258979', '佣金', 'COMMISSION', '佣金', 2, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258982', '1737453746274258979', '未知', 'UNKNOWN', '未知类型', 3, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL);

-- 创建旅客资料类型字典
INSERT INTO sys_dict (id, dict_name, dict_code, description, del_flag, create_by, create_time, update_by, update_time, type, tenant_id) 
VALUES ('1737453746274258983', '旅客资料类型', 'custom_type', '旅客资料类型', 0, 'admin', '2024-12-21 12:01:23', NULL, NULL, 0, 0);

INSERT INTO sys_dict_item (id, dict_id, item_text, item_value, description, sort_order, status, create_by, create_time, update_by, update_time) 
VALUES ('1737453746274258984', '1737453746274258983', '旅客代表人', 'CONTACT_TYPE', '旅客代表人', 1, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258985', '1737453746274258983', '每位旅客', 'TRAVELER_TYPE', '每位旅客', 2, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258986', '1737453746274258983', '寄送资料', 'SEND', '寄送资料', 3, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258987', '1737453746274258983', '联络资料', 'CONTACT', '联络资料', 4, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258988', '1737453746274258983', '未知', 'UNKNOWN', '未知', 5, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL);


INSERT INTO sys_dict (id, dict_name, dict_code, description, del_flag, create_by, create_time, update_by, update_time, type, tenant_id) 
VALUES ('1737453746274258989', '截止预定时间相较场次时间的类型', 'session_time_type', '截止预定时间相较场次时间的类型', 0, 'admin', '2024-12-21 12:01:23', NULL, NULL, 0, 0);



INSERT INTO sys_dict_item (id, dict_id, item_text, item_value, description, sort_order, status, create_by, create_time, update_by, update_time) 
VALUES ('1737453746274258990', '1737453746274258989', '场次开始时间', 'CONTACT_TYPE', '旅客代表人', 1, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258991', '1737453746274258989', '场次结束时', 'TRAVELER_TYPE', '每位旅客', 2, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258992', '1737453746274258989', '其他', 'SEND', '寄送资料', 3, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL),
       ('1737453746274258993', '1737453746274258989', '未知', 'CONTACT', '联络资料', 4, 1, 'admin', '2024-12-21 12:01:23', NULL, NULL);
