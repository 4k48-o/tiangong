CREATE TABLE `biz_advance_booking_rule` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `name` varchar(100) DEFAULT NULL COMMENT '规则名称',
  `sn` varchar(50) DEFAULT NULL COMMENT '规则编号',
  `advance_booking_days` int DEFAULT NULL COMMENT '截止预定时间相较出行日的提前天数',
  `advance_booking_time` varchar(5) DEFAULT NULL COMMENT '截止预定时间的时刻',
  `session_time_type` varchar(20) DEFAULT NULL COMMENT '截止预定时间相较场次时间的类型',
  `advance_booking_minutes_session_offset` int DEFAULT NULL COMMENT '截止预定时间相较场次时间的偏移值',
  `earliest_booking_days` int DEFAULT NULL COMMENT '最早可购买时间相较出行日的提前天数',
  `earliest_booking_time` varchar(5) DEFAULT NULL COMMENT '最早可购买时间的时刻',
  `pass_limit_hours` int DEFAULT NULL COMMENT '下单后多少小时可用',
  `pass_limit_minutes` int DEFAULT NULL COMMENT '下单后多少分钟可用',
  `description` text COMMENT '预定说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='预定信息规则';