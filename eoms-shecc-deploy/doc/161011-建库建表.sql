CREATE SCHEMA `shecc` ;

use shecc;

drop table if exists AUTH_MENU;

drop table if exists AUTH_ROLE;

drop table if exists AUTH_ROLE_MENU;

drop table if exists AUTH_USER;

drop table if exists AUTH_USER_ROLE;

drop table if exists BUS_DEVICE;

drop table if exists BUS_MAINTAIN_PLAN;

drop table if exists BUS_PROJECT;

drop table if exists BUS_REPAIR_ORDER;

drop table if exists BUS_SYSTEM;

drop table if exists INFO_BRAND;

drop table if exists INFO_CHECK_ITEM;

drop table if exists INFO_LOCATION;

drop table if exists INFO_MODEL;

drop table if exists INFO_MODEL_CHK_RELATION;

drop table if exists INFO_PROJECT_MANAGER_RELATION;

drop table if exists INFO_SYS_CUS_RELATION;

drop table if exists INFO_SYS_TYPE;

drop table if exists INFO_USER_RELATION;

drop index Index_24 on PARA_AREA_CITY;

drop table if exists PARA_AREA_CITY;

drop table if exists PARA_COMMON_PARAMETER;

drop table if exists PARA_DIC;

drop table if exists PARA_DICT_CODE;

drop table if exists PARA_DICT_INFO;

create table AUTH_MENU
(
   ID                   INT(10) not null auto_increment comment '菜单编号',
   MENUCODE             CHAR(40) character set LATIN1 not null comment '菜单代码',
   MENUNAME             CHAR(100) character set UTF8 comment '菜单名称',
   URL                  CHAR(100) character set LATIN1 default NULL comment '菜单URL',
   PARENT               INT(10) default NULL comment '父菜单编号',
   STATUS               CHAR(1) character set LATIN1 default '1' comment '菜单状态。0-隐藏；1-显示。',
   ORDERRUM             INT(3) default NULL comment '菜单顺序',
   primary key (ID)
)
ENGINE=INNODB AUTO_INCREMENT=26 DEFAULT CHARSET=UTF8;

alter table AUTH_MENU comment '【权限认证】功能权限信息';

create table AUTH_ROLE
(
   ID                   INT(10) not null auto_increment comment '角色编号',
   ROLECODE             CHAR(20) character set LATIN1 not null comment '角色代码',
   ROLENAME             CHAR(40) character set UTF8 comment '角色名称',
   STATUS               CHAR(1) character set LATIN1 default '1' comment '角色状态。0-停用；1-启用。',
   REMARK               CHAR(100) character set UTF8 comment '备注',
   primary key (ID)
)
ENGINE=INNODB AUTO_INCREMENT=15 DEFAULT CHARSET=UTF8;

alter table AUTH_ROLE comment '【权限认证】角色信息';

create table AUTH_ROLE_MENU
(
   ID                   INT(10) not null auto_increment comment '记录编号',
   T_ROLE_ID            INT(10) not null comment '角色编号',
   T_MENU_ID            INT(10) not null comment '菜单编号',
   primary key (ID)
)
ENGINE=INNODB AUTO_INCREMENT=1991 DEFAULT CHARSET=UTF8;

alter table AUTH_ROLE_MENU comment '【权限认证】角色权限组成';

create table AUTH_USER
(
   ID                   INT(10) not null auto_increment comment '编号',
   USERNAME             VARCHAR(100) character set UTF8 comment '登录名',
   PASSWD               VARCHAR(100) character set LATIN1 not null comment '密码',
   STATUS               CHAR(1) character set LATIN1 not null default '1' comment '状态。1-启用；2-冻结',
   MOBILENO             CHAR(11) character set LATIN1 default NULL comment '手机号码',
   REALNAME             VARCHAR(100) not null comment '姓名',
   EMAIL                VARCHAR(200) default NULL comment '电子邮箱',
   PHONE                VARCHAR(15) default NULL comment '电话号码',
   PHOTO                varchar(100) comment '照片',
   UP_UID               INT(10) comment '所属用户编号',
   UP_UNAME             VARCHAR(100) comment '所属用户姓名',
   REMARK               varchar(500) comment '备注',
   primary key (ID)
)
ENGINE=INNODB AUTO_INCREMENT=156 DEFAULT CHARSET=UTF8;

alter table AUTH_USER comment '【权限认证】用户信息';

create table AUTH_USER_ROLE
(
   ID                   INT(10) not null auto_increment comment '记录编号',
   T_ROLE_ID            INT(10) not null comment '角色编号',
   T_USER_ID            INT(10) not null comment '用户编号',
   primary key (ID)
)
ENGINE=INNODB AUTO_INCREMENT=143 DEFAULT CHARSET=UTF8;

alter table AUTH_USER_ROLE comment '【权限认证】用户角色关系';

create table BUS_DEVICE
(
   ID                   int not null auto_increment comment '编号',
   NAME                 VARCHAR(100) comment '设备名称',
   BRAND_ID             int comment '所属品牌编号',
   BRAND_NAME           VARCHAR(100) comment '所属品牌名称',
   MODEL_ID             int comment '所属项目编号',
   MODEL_NAME           VARCHAR(100) comment '所属项目名称',
   SYSTEM_ID            int comment '所属项目编号',
   SYSTEM_NAME          VARCHAR(100) comment '所属项目名称',
   SYS_TYPE_ID          int comment '所属系统类型编号',
   SYS_TYPE_NAME        VARCHAR(100) comment '所属系统类型名称',
   LOCATION_ID          int comment '位置编号',
   START_TIME           timestamp comment '启用时间',
   CONFIG               VARCHAR(100) comment '配置信息',
   DOCUMENT             varchar(100) comment '文档',
   PICTURE              varchar(100) comment '图片',
   SUPPLIER             VARCHAR(50) comment '供应商',
   REPAIR_TIME          timestamp comment '维修时间',
   ROUTING_TIME         timestamp comment '巡检时间',
   MAINTAIN_TIME        timestamp comment '维护时间',
   INPUT_UID            int comment '录入人编号',
   INPUT_UNAME          VARCHAR(50) comment '录入人姓名',
   INPUT_TIME           TIMESTAMP comment '录入时间',
   CHECK_UID            int comment '审核人编号',
   CHECK_UNAME          VARCHAR(50) comment '审核人姓名',
   CHECK_TIME           TIMESTAMP comment '审核时间',
   LAST_MODIFY_UID      int comment '最后修改人编号',
   LAST_MODIFY_UNAME    VARCHAR(50) comment '最后修改人姓名',
   LAST_MODIFY_TIME     TIMESTAMP comment '最后修改时间',
   ARCHIVE_FLAG         CHAR(1) default '1' comment '归档标志。1-未归档；2-已归档。',
   ARCHIVE_UID          int comment '归档人编号',
   ARCHIVE_UNAME        VARCHAR(50) comment '归档人姓名',
   ARCHIVE_TIME         TIMESTAMP comment '归档时间',
   L_RECORD_NO          int comment '原记录编号',
   REMARK               varchar(500) comment '备注',
   RESV_FLD1            varchar(500) comment '保留域1',
   RESV_FLD2            varchar(500) comment '保留域2',
   primary key (ID)
);

alter table BUS_DEVICE comment '【业务处理】设备信息';

create table BUS_MAINTAIN_PLAN
(
   ID                   int not null auto_increment comment '编号',
   TYPE                 CHAR(1) comment '类型。1-巡检计划；2-维护计划。',
   PROJECT_ID           int comment '所属项目编号',
   PROJECT_NAME         VARCHAR(100) comment '所属项目名称',
   SYSTEM_ID            int comment '所属系统编号',
   SYSTEM_NAME          VARCHAR(100) comment '所属系统名称',
   ENGINEER_ID          int comment '所属工程师编号',
   ENGINEER_NAME        VARCHAR(100) comment '所属工程师姓名',
   REPORT_ID            int comment '报表编号',
   PLAN_DATE            DATE comment '到达时间',
   COMPELTE_DATE        DATE comment '完成日期',
   STATUS               CHAR(1) comment '状态。1-计划；2-已下载；3-待确认；4-已完成。',
   CONCLUSION           varchar(500) comment '维护小结',
   ANALYSIS             varchar(500) comment '分析建议',
   CUS_SUGGEST          varchar(500) comment '客户建议',
   CUS_SIGN             varchar(100) comment '客户签字',
   SIGN_DATE            DATE comment '签字日期',
   ARCHIVE_FLAG         CHAR(1) default '1' comment '归档标志。1-未归档；2-已归档。',
   REMARK               varchar(500) comment '备注',
   RESV_FLD1            varchar(500) comment '保留域1',
   RESV_FLD2            varchar(500) comment '保留域2',
   primary key (ID)
);

alter table BUS_MAINTAIN_PLAN comment '【业务处理】巡检维护计划';

create table BUS_PROJECT
(
   ID                   int not null auto_increment comment '编号',
   NAME                 VARCHAR(100) comment '项目名称',
   ADDRESS              VARCHAR(100) comment '项目地址',
   LONGITUDE            INT comment '经度',
   LATITUDE             INT comment '纬度',
   PICTURE              varchar(100) comment '图片',
   INPUT_UID            int comment '录入人编号',
   INPUT_UNAME          VARCHAR(50) comment '录入人姓名',
   INPUT_TIME           TIMESTAMP comment '录入时间',
   CHECK_UID            int comment '审核人编号',
   CHECK_UNAME          VARCHAR(50) comment '审核人姓名',
   CHECK_TIME           TIMESTAMP comment '审核时间',
   LAST_MODIFY_UID      int comment '最后修改人编号',
   LAST_MODIFY_UNAME    VARCHAR(50) comment '最后修改人姓名',
   LAST_MODIFY_TIME     TIMESTAMP comment '最后修改时间',
   ARCHIVE_FLAG         CHAR(1) default '1' comment '归档标志。1-未归档；2-已归档。',
   ARCHIVE_UID          int comment '归档人编号',
   ARCHIVE_UNAME        VARCHAR(50) comment '归档人姓名',
   ARCHIVE_TIME         TIMESTAMP comment '归档时间',
   L_RECORD_NO          int comment '原记录编号',
   REMARK               varchar(500) comment '备注',
   RESV_FLD1            varchar(500) comment '保留域1',
   RESV_FLD2            varchar(500) comment '保留域2',
   primary key (ID)
);

alter table BUS_PROJECT comment '【业务处理】项目信息';

create table BUS_REPAIR_ORDER
(
   ID                   int not null auto_increment comment '编号',
   PROJECT_ID           int comment '报修项目编号',
   PROJECT_NAME         VARCHAR(100) comment '报修项目名称',
   PROJECT_ADDRESS      VARCHAR(100) comment '报修项目地址',
   SYSTEM_ID            int comment '报修系统编号',
   SYSTEM_NAME          VARCHAR(100) comment '报修系统名称',
   REPAIR_APPLY_UID     int comment '报修人编号',
   REPAIR_APPLY_UNAME   VARCHAR(50) comment '报修人姓名',
   URGENT_LEVEL         CHAR(1) comment '紧急程度。1-紧急；2-重要；3-一般',
   REPAIR_APPLY_TIME    TIMESTAMP comment '报修时间',
   RESPONSE_TIME        TIMESTAMP comment '响应时间',
   ARRIVE_TIME          TIMESTAMP comment '到达时间',
   COMPELTE_TIME        TIMESTAMP comment '完成时间',
   SERVICE_TYPE         CHAR(1) comment '服务类型。1-保修期内；2-保养合同内；3-收费服务；4-其它服务。',
   SERVICE_CONTENT      VARCHAR(100) comment '服务内容',
   FAULT_CAUSE          varchar(500) comment '故障原因',
   PROCESS              VARCHAR(100) comment '处理过程',
   STATUS               CHAR(1) comment '处理状态。1-已报修；2-已接单；3-待维修；4-待确认；4-已完成；5-已取消。',
   MATERIAL             VARCHAR(100) comment '使用材料',
   CUS_COMMENTS         varchar(500) comment '客户意见',
   CUS_THOUGHT          CHAR(1) comment '客户评价。1-满意；2-一般；3-不满意；4-其它。',
   CUS_COM_EXPLAIN      varchar(500) comment '客户意见说明',
   REPAIR_UID2          int comment '维修人编号',
   REPAIR_UNAME         VARCHAR(50) comment '维修人姓名',
   CUS_SIGN             varchar(100) comment '客户签字',
   SIGN_DATE            DATE comment '签字日期',
   ARCHIVE_FLAG         CHAR(1) default '1' comment '归档标志。1-未归档；2-已归档。',
   REMARK               varchar(500) comment '备注',
   RESV_FLD1            varchar(500) comment '保留域1',
   RESV_FLD2            varchar(500) comment '保留域2',
   primary key (ID)
);

alter table BUS_REPAIR_ORDER comment '【业务处理】项目单';

create table BUS_SYSTEM
(
   ID                   int not null auto_increment comment '编号',
   NAME                 VARCHAR(100) comment '系统名称',
   PROJECT_ID           int comment '所属项目编号',
   PROJECT_NAME         VARCHAR(100) comment '所属项目名称',
   ENGINEER_ID          int comment '所属工程师编号',
   ENGINEER_NAME        VARCHAR(100) comment '所属工程师姓名',
   INPUT_UID            int comment '录入人编号',
   INPUT_UNAME          VARCHAR(50) comment '录入人姓名',
   INPUT_TIME           TIMESTAMP comment '录入时间',
   CHECK_UID            int comment '审核人编号',
   CHECK_UNAME          VARCHAR(50) comment '审核人姓名',
   CHECK_TIME           TIMESTAMP comment '审核时间',
   LAST_MODIFY_UID      int comment '最后修改人编号',
   LAST_MODIFY_UNAME    VARCHAR(50) comment '最后修改人姓名',
   LAST_MODIFY_TIME     TIMESTAMP comment '最后修改时间',
   ARCHIVE_FLAG         CHAR(1) default '1' comment '归档标志。1-未归档；2-已归档。',
   ARCHIVE_UID          int comment '归档人编号',
   ARCHIVE_UNAME        VARCHAR(50) comment '归档人姓名',
   ARCHIVE_TIME         TIMESTAMP comment '归档时间',
   L_RECORD_NO          int comment '原记录编号',
   REMARK               varchar(500) comment '备注',
   RESV_FLD1            varchar(500) comment '保留域1',
   RESV_FLD2            varchar(500) comment '保留域2',
   primary key (ID)
);

alter table BUS_SYSTEM comment '【业务处理】系统信息';

create table INFO_BRAND
(
   ID                   int not null auto_increment comment '编号',
   NAME                 VARCHAR(100) comment '品牌名称',
   LOGO                 varchar(100) comment '品牌LOGO',
   "DESC"               varchar(500) comment '品牌介绍',
   INPUT_UID            int comment '录入人编号',
   INPUT_UNAME          VARCHAR(50) comment '录入人姓名',
   INPUT_TIME           TIMESTAMP comment '录入时间',
   CHECK_UID            int comment '审核人编号',
   CHECK_UNAME          VARCHAR(50) comment '审核人姓名',
   CHECK_TIME           TIMESTAMP comment '审核时间',
   LAST_MODIFY_UID      int comment '最后修改人编号',
   LAST_MODIFY_UNAME    VARCHAR(50) comment '最后修改人姓名',
   LAST_MODIFY_TIME     TIMESTAMP comment '最后修改时间',
   ARCHIVE_FLAG         CHAR(1) default '1' comment '归档标志。1-未归档；2-已归档。',
   ARCHIVE_UID          int comment '归档人编号',
   ARCHIVE_UNAME        VARCHAR(50) comment '归档人姓名',
   ARCHIVE_TIME         TIMESTAMP comment '归档时间',
   L_RECORD_NO          int comment '原记录编号',
   REMARK               varchar(500) comment '备注',
   RESV_FLD1            varchar(500) comment '保留域1',
   RESV_FLD2            varchar(500) comment '保留域2',
   primary key (ID)
);

alter table INFO_BRAND comment '【基础信息】品牌信息';

create table INFO_CHECK_ITEM
(
   ID                   int not null auto_increment comment '编号',
   NAME                 VARCHAR(100) comment '检查项名称',
   RESULT_TYPE          CHAR(1) comment '结果类型。1-布尔值；2-文本。',
   INPUT_UID            int comment '录入人编号',
   INPUT_UNAME          VARCHAR(50) comment '录入人姓名',
   INPUT_TIME           TIMESTAMP comment '录入时间',
   CHECK_UID            int comment '审核人编号',
   CHECK_UNAME          VARCHAR(50) comment '审核人姓名',
   CHECK_TIME           TIMESTAMP comment '审核时间',
   LAST_MODIFY_UID      int comment '最后修改人编号',
   LAST_MODIFY_UNAME    VARCHAR(50) comment '最后修改人姓名',
   LAST_MODIFY_TIME     TIMESTAMP comment '最后修改时间',
   ARCHIVE_FLAG         CHAR(1) default '1' comment '归档标志。1-未归档；2-已归档。',
   ARCHIVE_UID          int comment '归档人编号',
   ARCHIVE_UNAME        VARCHAR(50) comment '归档人姓名',
   ARCHIVE_TIME         TIMESTAMP comment '归档时间',
   L_RECORD_NO          int comment '原记录编号',
   REMARK               varchar(500) comment '备注',
   RESV_FLD1            varchar(500) comment '保留域1',
   RESV_FLD2            varchar(500) comment '保留域2',
   primary key (ID)
);

alter table INFO_CHECK_ITEM comment '【基础信息】检查项信息';

create table INFO_LOCATION
(
   ID                   int not null auto_increment comment '编号',
   NAME                 VARCHAR(100) comment '位置名称',
   UP_ID                int comment '上级位置编号',
   INPUT_UID            int comment '录入人编号',
   INPUT_UNAME          VARCHAR(50) comment '录入人姓名',
   INPUT_TIME           TIMESTAMP comment '录入时间',
   CHECK_UID            int comment '审核人编号',
   CHECK_UNAME          VARCHAR(50) comment '审核人姓名',
   CHECK_TIME           TIMESTAMP comment '审核时间',
   LAST_MODIFY_UID      int comment '最后修改人编号',
   LAST_MODIFY_UNAME    VARCHAR(50) comment '最后修改人姓名',
   LAST_MODIFY_TIME     TIMESTAMP comment '最后修改时间',
   ARCHIVE_FLAG         CHAR(1) default '1' comment '归档标志。1-未归档；2-已归档。',
   ARCHIVE_UID          int comment '归档人编号',
   ARCHIVE_UNAME        VARCHAR(50) comment '归档人姓名',
   ARCHIVE_TIME         TIMESTAMP comment '归档时间',
   L_RECORD_NO          int comment '原记录编号',
   REMARK               varchar(500) comment '备注',
   RESV_FLD1            varchar(500) comment '保留域1',
   RESV_FLD2            varchar(500) comment '保留域2',
   primary key (ID)
);

alter table INFO_LOCATION comment '【基础信息】位置信息';

create table INFO_MODEL
(
   ID                   int not null auto_increment comment '编号',
   NAME                 VARCHAR(100) comment '型号名称',
   PICTURE              varchar(100) comment '型号图片',
   REF_DOCUMENT         varchar(500) comment '相关文档',
   BRAND_ID             int comment '所属品牌编号',
   BRAND_NAME           VARCHAR(100) comment '所属品牌名称',
   INPUT_UID            int comment '录入人编号',
   INPUT_UNAME          VARCHAR(50) comment '录入人姓名',
   INPUT_TIME           TIMESTAMP comment '录入时间',
   CHECK_UID            int comment '审核人编号',
   CHECK_UNAME          VARCHAR(50) comment '审核人姓名',
   CHECK_TIME           TIMESTAMP comment '审核时间',
   LAST_MODIFY_UID      int comment '最后修改人编号',
   LAST_MODIFY_UNAME    VARCHAR(50) comment '最后修改人姓名',
   LAST_MODIFY_TIME     TIMESTAMP comment '最后修改时间',
   ARCHIVE_FLAG         CHAR(1) default '1' comment '归档标志。1-未归档；2-已归档。',
   ARCHIVE_UID          int comment '归档人编号',
   ARCHIVE_UNAME        VARCHAR(50) comment '归档人姓名',
   ARCHIVE_TIME         TIMESTAMP comment '归档时间',
   L_RECORD_NO          int comment '原记录编号',
   REMARK               varchar(500) comment '备注',
   RESV_FLD1            varchar(500) comment '保留域1',
   RESV_FLD2            varchar(500) comment '保留域2',
   primary key (ID)
);

alter table INFO_MODEL comment '【基础信息】型号信息';

create table INFO_MODEL_CHK_RELATION
(
   MODEL_ID             int not null auto_increment comment '型号编号',
   CHK_ID               int not null comment '检查项编号',
   primary key (MODEL_ID, CHK_ID)
);

alter table INFO_MODEL_CHK_RELATION comment '【基础信息】型号检查项对应关系';

create table INFO_PROJECT_MANAGER_RELATION
(
   PROJECT_ID           int not null auto_increment comment '项目编号',
   MANAGER_ID           int not null comment '项目经理编号',
   primary key (PROJECT_ID, MANAGER_ID)
);

alter table INFO_PROJECT_MANAGER_RELATION comment '【基础信息】项目与经理对应关系';

create table INFO_SYS_CUS_RELATION
(
   SYSTEM_ID            int not null auto_increment comment '系统编号',
   CUSTOMER_ID          int not null comment '客户编号',
   primary key (SYSTEM_ID, CUSTOMER_ID)
);

alter table INFO_SYS_CUS_RELATION comment '【基础信息】系统与客户对应关系';

create table INFO_SYS_TYPE
(
   ID                   int not null auto_increment comment '编号',
   NAME                 VARCHAR(100) comment '类型名称',
   INPUT_UID            int comment '录入人编号',
   INPUT_UNAME          VARCHAR(50) comment '录入人姓名',
   INPUT_TIME           TIMESTAMP comment '录入时间',
   CHECK_UID            int comment '审核人编号',
   CHECK_UNAME          VARCHAR(50) comment '审核人姓名',
   CHECK_TIME           TIMESTAMP comment '审核时间',
   LAST_MODIFY_UID      int comment '最后修改人编号',
   LAST_MODIFY_UNAME    VARCHAR(50) comment '最后修改人姓名',
   LAST_MODIFY_TIME     TIMESTAMP comment '最后修改时间',
   ARCHIVE_FLAG         CHAR(1) default '1' comment '归档标志。1-未归档；2-已归档。',
   ARCHIVE_UID          int comment '归档人编号',
   ARCHIVE_UNAME        VARCHAR(50) comment '归档人姓名',
   ARCHIVE_TIME         TIMESTAMP comment '归档时间',
   L_RECORD_NO          int comment '原记录编号',
   REMARK               varchar(500) comment '备注',
   RESV_FLD1            varchar(500) comment '保留域1',
   RESV_FLD2            varchar(500) comment '保留域2',
   primary key (ID)
);

alter table INFO_SYS_TYPE comment '【基础信息】系统类型信息';

create table INFO_USER_RELATION
(
   UP_UID               int not null auto_increment comment '上级用户编号',
   SUB_UID              int not null comment '下级用户编号',
   primary key (UP_UID, SUB_UID)
);

alter table INFO_USER_RELATION comment '【基础信息】用户对应关系。目前主要存放负责人与项目经理的对应关系。';

create table PARA_AREA_CITY
(
   CURRENT_CODE         VARCHAR(6) not null comment '当前代码',
   CODE_FLAG            CHAR(1) not null comment '代码标识
            1-省
            2-城市',
   TELE_CODE            VARCHAR(6) comment '电信区号',
   CURRENT_NAME         VARCHAR(100) comment '当前名字',
   PARENT_CODE          VARCHAR(6) comment '父亲代码',
   primary key (CURRENT_CODE, CODE_FLAG)
);

alter table PARA_AREA_CITY comment '【平台参数】国家行政区划信息';

create index Index_24 on PARA_AREA_CITY
(
   PARENT_CODE
);

create table PARA_COMMON_PARAMETER
(
   RECORD_NO            int not null comment '记录编号',
   PARA_CODE            VARCHAR(50) comment '参数代码',
   PARA_NAME            VARCHAR(50) comment '参数名称',
   PARA_VALUE           VARCHAR(50) comment '参数值',
   STATUS               CHAR(1) comment '状态
            A-新建待审核
            B-停用待审核
            C-启用待审核
            Z-作废待审核
            0-审核未通过
            1-正常
            2-停用
            9-作废',
   INPUT_UID            int comment '录入人编号',
   INPUT_UNAME          VARCHAR(50) comment '录入人姓名',
   INPUT_TIME           TIMESTAMP comment '录入时间',
   CHECK_UID            int comment '审核人编号',
   CHECK_UNAME          VARCHAR(50) comment '审核人姓名',
   CHECK_TIME           TIMESTAMP comment '审核时间',
   LAST_MODIFY_UID      int comment '最后修改人编号',
   LAST_MODIFY_UNAME    VARCHAR(50) comment '最后修改人姓名',
   LAST_MODIFY_TIME     TIMESTAMP comment '最后修改时间',
   ARCHIVE_FLAG         CHAR(1) default '1' comment '归档标志。1-未归档；2-已归档。',
   ARCHIVE_UID          int comment '归档人编号',
   ARCHIVE_UNAME        VARCHAR(50) comment '归档人姓名',
   ARCHIVE_TIME         TIMESTAMP comment '归档时间',
   L_RECORD_NO          int comment '原记录编号',
   REMARK               varchar(500) comment '备注',
   RESV_FLD1            varchar(500) comment '保留域1',
   RESV_FLD2            varchar(500) comment '保留域2',
   primary key (RECORD_NO)
);

alter table PARA_COMMON_PARAMETER comment '【平台参数】平台公共参数信息';

create table PARA_DIC
(
   ID                   INT(11) not null auto_increment comment '记录编号',
   DIC_TXT              VARCHAR(500) default NULL comment '字典值',
   TYPE                 INT(11) default NULL comment '类型',
   NOTE                 VARCHAR(100) default NULL comment '备注',
   STATE                INT(11) default 0 comment '字典状态。0-不可修改；1-可修改。',
   DIC_ID               INT(11) default NULL comment '字典编号',
   IS_DEFAULT           INT(11) default NULL comment '是否为默认值。0-否；1-是。',
   primary key (ID)
)
ENGINE=MYISAM AUTO_INCREMENT=433 DEFAULT CHARSET=UTF8;

alter table PARA_DIC comment '【平台参数】数据字典信息';

create table PARA_DICT_CODE
(
   CODE_ID              VARCHAR(8) not null comment '明细编号',
   CODE_VALUE           VARCHAR(50) not null comment '字典值',
   CODE_DESC            VARCHAR(100) comment '字典值描述',
   DICT_ID              VARCHAR(8) comment '字典编号',
   PRIORITY             INTEGER comment '优先级',
   primary key (CODE_ID, CODE_VALUE)
);

alter table PARA_DICT_CODE comment '【平台参数】数据字典值明细表';

create table PARA_DICT_INFO
(
   DICT_ID              VARCHAR(8) not null comment '字典编号',
   DICT_ENG             VARCHAR(50) comment '字典英文名',
   DICT_CHN             VARCHAR(50) comment '字典中文名',
   DICT_STATUS          CHAR(1) comment '字典状态
            1-启用
            2-停用
            ',
   REMARK               varchar(500) comment '字典描述',
   primary key (DICT_ID)
);

alter table PARA_DICT_INFO comment '【平台参数】数据字典';

