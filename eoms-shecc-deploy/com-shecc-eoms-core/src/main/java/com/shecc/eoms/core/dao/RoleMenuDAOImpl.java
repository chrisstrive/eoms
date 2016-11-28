package com.shecc.eoms.core.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.shecc.eoms.core.common.ibaits.impl.DefaultBaseDAOImpl;
import com.shecc.eoms.core.model.RoleMenu;

/**
 *
 * USER ray ray1192@163.com
 * DATE 2014-2-10 下午09:37:10
 * INFO com.scorpio.dao.impl RoleMenuDAOImpl.java
 * REMARK 
 *
 */
public class RoleMenuDAOImpl extends DefaultBaseDAOImpl<RoleMenu>{
	
	
	public List<RoleMenu> queryRoleMenuByRoleId(String roleId) {
		
		Map<String,Object> map = new HashMap<String,Object>();
	    map.put("roleId", roleId);
	
	    return (List<RoleMenu>)this.getSqlMapClientTemplate().queryForList(this.namespace.concat("queryRoleMenuByRoleId"),map);
		
	}
	
	public void batchDel(final List<RoleMenu>list) {
		
	    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
	        public Object doInSqlMapClient(SqlMapExecutor executor)
	                throws SQLException {
	            executor.startBatch();
	            // 每次提交最大条数
	            final int batchSize = 200;
	            int count = 0;
	            for (RoleMenu rm:list) {
	                executor.delete("ns-roleMenu.deleteSelective", rm);
	                if (++count % batchSize == 0) {
	                    executor.executeBatch();
	                }
	            }
	            // 提交剩余的数据
	            executor.executeBatch();
	            return null;
	        }
	    });
}
}

