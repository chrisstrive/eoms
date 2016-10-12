/**
 *  File: BaseTestCase.java
 *  Description:
 *  Copyright 2006-2012 HNAPAY Corporation. All rights reserved.
 *  Date      Author      Changes
 *  Jul 19, 2012   watertao     Create
 *
 */
package com.shecc.eoms.core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * 
 */
@ContextConfiguration(locations = { "classpath*:context/**/*.xml", "classpath:overwrite-context/test-overwrite-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public abstract class BaseTestCase extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	@Qualifier("boxDs")
	private DataSource ds;
	
	@Autowired
	public void setDataSource(@Qualifier("boxDs") DataSource ds) {
		super.setDataSource(ds);
	}
	
	
	protected void insertRow(String table, Map<String, Object> row) throws Exception {
		
		if (ds == null) {
			throw new IllegalStateException(
					"DataSource is not inject into test context, no unique data source is defined in context");
		}

		StringBuilder sb = new StringBuilder();
		sb.append("select * from ");
		sb.append(table);
		sb.append(" where 1=2");

		PreparedStatement pstmt = DataSourceUtils.getConnection(ds).prepareStatement(sb.toString());
		ResultSet rs = pstmt.executeQuery();
		int columnCnt = rs.getMetaData().getColumnCount();
		
		StringBuilder sqlTemplate = new StringBuilder();
		sqlTemplate.append("insert into ");
		sqlTemplate.append(table);
		sqlTemplate.append("(");
		for (int i = 1; i <= columnCnt; i++) {
			String columnName = rs.getMetaData().getColumnName(i);
			sqlTemplate.append(columnName.toUpperCase());
			if (i != columnCnt) {
				sqlTemplate.append(",");
			}
			
			// 添加默认的字段参数
			if (row.get(columnName.toUpperCase()) == null) {
				row.put(columnName.toUpperCase(), null);
			}
		}
		sqlTemplate.append(") values(");
		for (int i = 1; i <= columnCnt; i++) {
			String columnName = rs.getMetaData().getColumnName(i);
			sqlTemplate.append(":" + columnName.toUpperCase());
			if (i != columnCnt) {
				sqlTemplate.append(",");
			}
		}
		sqlTemplate.append(")");
		pstmt.close();
		
		simpleJdbcTemplate.update(sqlTemplate.toString(), row);
	}
	
}
