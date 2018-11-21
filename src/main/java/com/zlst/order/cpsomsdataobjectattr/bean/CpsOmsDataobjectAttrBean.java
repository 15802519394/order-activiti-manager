package com.zlst.order.cpsomsdataobjectattr.bean;

import javax.persistence.Column;

/**
 * 对象bean
 * Created by T016 on 2018/11/21.
 *
 *
 *         VARCHAR2(16)                    not null,
               VARCHAR2(32)                    not null,
 ATTR_NAME            VARCHAR2(40)                    not null,
 EXT_CODE             VARCHAR2(32),
 ALIAS                VARCHAR2(256),
 LENGTH               VARCHAR2(16),
 DATA_TYPE            VARCHAR2(8),
 MIN_VALUE            number(12),
 MAX_VALUE            number(12),
 DEFAULT_VALUE        VARCHAR2(256),
 IS_MANDATORY         CHAR(1)                        default 'Y' not null,
 NOTES                VARCHAR2(2048),
 IS_USER_DEFINED      char(1)                        default 'Y',
 IS_ENUM              varchar2(4)                    default 'N',
 DICT_ID              varchar2(32),
 */
public class CpsOmsDataobjectAttrBean {

    @Column(name = "DATAOBJECT_NO")
    private String dataobjectNo;

    //@Column(name = "ATTR_NO")
}
