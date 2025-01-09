CREATE TABLE biz_scenic_area (
    id VARCHAR(36) PRIMARY KEY COMMENT '景区唯一标识',
    name VARCHAR(255) NOT NULL COMMENT '景区名称',
    type_id VARCHAR(36) NOT NULL COMMENT '景区类型ID',
    status varchar(32) NOT NULL DEFAULT 1 COMMENT '激活状态',
    tenant_id VARCHAR(36) NOT NULL COMMENT '租户ID',
    created_by VARCHAR(36) NOT NULL COMMENT '创建人ID',
    updated_by VARCHAR(36) NOT NULL COMMENT '修改人ID',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT='景区表';

-- 创建门区表
CREATE TABLE `biz_gate` (
  `id` varchar(36) COLLATE utf8mb4_general_ci NOT NULL,
  `create_by` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_by` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新日期',
  `sys_org_code` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '所属部门',
  `gate_name` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '门区名称',
  `gate_type` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '门区类型',
  `gate_desc` text COLLATE utf8mb4_general_ci COMMENT '门区描述',
  `scenic_area_id` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '隶属景点',
  PRIMARY KEY (`id`)
) COMMENT='门区表' ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- 创建设备表
CREATE TABLE biz_device (
    id VARCHAR(36) PRIMARY KEY COMMENT '设备唯一标识',
    name VARCHAR(255) NOT NULL COMMENT '设备名称（例如：三棍闸机001）',
    type_id VARCHAR(36) NOT NULL COMMENT '设备类型ID（逻辑关联）',
    gate_id VARCHAR(36) NOT NULL COMMENT '所属门区ID（逻辑关联）',
    device_sn VARCHAR(255) NOT NULL COMMENT '设备序列号',
    installed_at DATE NOT NULL COMMENT '安装时间',
    tenant_id VARCHAR(36) NOT NULL COMMENT '租户ID',
    created_by VARCHAR(36) NOT NULL COMMENT '创建人ID',
    updated_by VARCHAR(36) NOT NULL COMMENT '修改人ID',
    created_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT='设备表';

-- 创建设备类型表
CREATE TABLE biz_device_type (
    id VARCHAR(36) PRIMARY KEY COMMENT '设备类型唯一标识',
    name VARCHAR(255) NOT NULL COMMENT '设备类型名称',
    description TEXT COMMENT '设备类型描述',
    tenant_id VARCHAR(36) NOT NULL COMMENT '租户ID',
    created_by VARCHAR(36) NOT NULL COMMENT '创建人ID',
    updated_by VARCHAR(36) NOT NULL COMMENT '修改人ID',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT='设备类型表';