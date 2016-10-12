package com.shecc.eoms.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.shecc.eoms.web.common.ValTemplate;
import com.shecc.eoms.web.common.utils.JSONUtil;
import com.shecc.eoms.web.service.AuthService;
import com.shecc.eoms.web.service.MenuService;
import com.shecc.eoms.web.service.RoleService;
import com.shecc.eoms.web.service.UserService;
import com.shecc.eoms.core.model.Menu;
import com.shecc.eoms.core.model.Role;
import com.shecc.eoms.core.model.RoleMenu;
import com.shecc.eoms.core.model.User;
import com.shecc.eoms.core.model.UserRole;

/**
 * 
 * USER ray ray1192@163.com DATE 2014-2-13 下午09:09:23 INFO
 * com.shecc.eoms.web.controller AuthConntroller.java REMARK
 * 
 */
public class AuthConntroller extends MultiActionController {

	private static final Log log = LogFactory.getLog(AuthConntroller.class);

	private RoleService roleService;
	private AuthService authService;
	private UserService userService;
	private MenuService menuService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	private String authDefaultPage;
	private String authDefaultPage2;
	private String showmsgPage;
	
	private String changeRole;

	public void setAuthDefaultPage(String authDefaultPage) {
		this.authDefaultPage = authDefaultPage;
	}

	public void setShowmsgPage(String showmsgPage) {
		this.showmsgPage = showmsgPage;
	}

	public void setAuthDefaultPage2(String authDefaultPage2) {
		this.authDefaultPage2 = authDefaultPage2;
	}
	
	public void setChangeRole(String changeRole) {
		this.changeRole = changeRole;
	}
	
	private String sysMenuPage;
	
	public void setSysMenuPage(String sysMenuPage) {
		this.sysMenuPage = sysMenuPage;
	}
	
	private String userRolePage;

	public void setUserRolePage(String userRolePage) {
		this.userRolePage = userRolePage;
	}

	/**
	 * 角色菜单权限管理
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView authDefault(HttpServletRequest request,
			HttpServletResponse response) {

		List<Role> retList = roleService.queryRole();
		log.info("[系统]-[角色检索]-[角色检索数据提取完成]");

		// 定义响应model
		ModelAndView mv = null;
		mv = new ModelAndView(authDefaultPage);
		mv.addObject("retList", retList);

		return mv;
	}

	/**
	 * 查询出角色可配置的菜单
	 * 
	 * @param request
	 * @param response
	 * @return ser-AuthService
	 */
	public ModelAndView queryMenu(HttpServletRequest request,
			HttpServletResponse response) {

		// 角色ID，用于返回页面隐藏域，在提交菜单绑定关系时使用。
		String roleId = request.getParameter("authin");

		List<Menu> retList = authService.queryMenu();
		log.info("[系统]-[菜单检索]-[菜单检索数据提取完成]");

		// 定义响应model
		ModelAndView mv = null;
		mv = new ModelAndView(authDefaultPage);
		mv.addObject("retList2", retList);
		mv.addObject("retRoleId", roleId);
		return mv;
	}
	
	/**
	 * 查询系统菜单
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView querySysMenu(HttpServletRequest request,
			HttpServletResponse response){
		String id = request.getParameter("id");
		// 查询角色
		Role role = this.roleService.findRoleByRoleId(new Integer(id));
		List<Menu> retList = authService.queryMenu();
		// 查询角色菜单
		List<Menu> roleMenuList = this.menuService.queryRoleMenulist(new Integer(id));
		Map<String, Object> roleMenuMap = new HashMap<String, Object>();
		for(Menu menu : roleMenuList){
			roleMenuMap.put(menu.getMenuCode(), menu.getMenuCode());
		}
		
		// 设置菜单
		setMenuCheck(roleMenuMap, retList);
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 树形菜单
		//String menuListJson = JSONUtil.toJSonString(retList);
		String menuTree = loadMenu(retList);
		modelMap.put("menu", menuTree);
		//响应
		ModelAndView mv = new ModelAndView(sysMenuPage);
		mv.addObject("role",role);
		mv.addObject("modelMap", modelMap);
		return mv;
	}
	
	private String loadMenu(List<Menu> menuList){
		String menuNode = "";
		if(menuList != null && menuList.size() > 0){
			for(Menu menu : menuList){
				menuNode += "<li><span>" 
							+ "<input type=\"checkbox\" style=\"cursor:pointer;display:none\" name=\"menuIds\" id=\"menu_" + menu.getId() + "\" value=\"" + menu.getId() + "\" readonly=\"readonly\"" + ("0".equals(menu.getIsCheck()) ? "" : " checked=\"checked\"") + "/>"
							+ menu.getMenuName() + "</span>";
				String isParent = menu.getIsParent();
				List<Menu> subMenuList = menu.getSubMenuList();
				if("1".equals(isParent)
						&& (subMenuList != null && subMenuList.size() > 0)){
					menuNode += setSubMenu(subMenuList, String.valueOf(menu.getId()), menu.getId());
				}
				menuNode += "</li>";
			}
		}
		return menuNode;
	}

	private String setSubMenu(List<Menu> subMenuList, String parentIds, Integer parentId){
		String menuNode = "";
		if(subMenuList != null
				&& subMenuList.size() > 0){
			for(Menu subMenu : subMenuList){
				String subParent = subMenu.getIsParent();
				List<Menu> subMenuListTmp = subMenu.getSubMenuList();
				menuNode += "<ul><li><span>" 
						+ "<input type=\"hidden\" name=\"" + parentId + "\" value=\"" + subMenu.getId() + "\"/>"
						+ "<input type=\"checkbox\" name=\"menuIds\" id=\"menu_" + subMenu.getId() + "\" value=\"" + subMenu.getId() + "\" " + (subMenu.getIsCheck() == "0" ? "" : " checked=\"checked\"") + ((subMenuListTmp != null && subMenuListTmp.size() > 0) ? "style=\"cursor:pointer;display:none\" readonly=\"readonly\" onclick=\"return false\"" : "style=\"cursor:pointer\" onclick=\"checkParentBox('" + parentIds + "');\"") + "/>" 
						+ subMenu.getMenuName() + "</span>";
				if((subMenuListTmp != null && subMenuListTmp.size() > 0)
						&& "1".equals(subParent)){
					menuNode += setSubMenu(subMenuListTmp, subMenu.getId() + "_" +  parentIds, subMenu.getId());
				}
				menuNode += "</li></ul>";
			}
		}
		return menuNode;
	}
	
	private void setMenuCheck(Map<String, Object> roleMenuMap, List<Menu> retList){
		//筛选原始菜单  将一级菜单以及非一级菜单区分成新的LIST
		for (int i = 0; i < retList.size(); i++) {
			Menu tm = (Menu)retList.get(i);
			if(roleMenuMap.get(tm.getMenuCode()) != null){
				tm.setIsCheck("1");
			}else{
				tm.setIsCheck("0");
			}
			if(tm.getSubMenuList() != null
					&& tm.getSubMenuList().size() > 0){
				setMenuCheck(roleMenuMap, tm.getSubMenuList());
			}
		}
	}
	
	/**
	 * 添加系统菜单
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView addMenu(HttpServletRequest request,
			HttpServletResponse response) {
		String menuIds[] = request.getParameterValues("menuIds");
		String roleId = request.getParameter("roleId");
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			this.authService.addRoleMenuRnTx(menuIds, new Integer(roleId));
			returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_0000);
			returnMap.put("description", ValTemplate.V_T_VAL_MSG_RMK_0000);
			String result = JSONUtil.toJSonString(returnMap);
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
		} catch (IOException e) {
			logger.error("AppInfoConntroller.addAppInfo throws error",e);	
			returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_ERROR);
			returnMap.put("description", ValTemplate.V_T_VAL_MSG_RMK_ERROR);
		}
		return null;
	}
	
	/**
	 * 查询用户角色
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView queryUserRole(HttpServletRequest request,
			HttpServletResponse response){
		String id = request.getParameter("id");
		// 用户信息
		User user = this.userService.findById(new Integer(id));
		//对原始菜单排序
		List <Role> arrayList1 = this.authService.queryAuthRole(new Integer(id));//已授权
		List <Role> arrayList2 = this.authService.queryNonAuthRole(new Integer(id));//未授权
		
		//响应
		ModelAndView mv = new ModelAndView(userRolePage);
		mv.addObject("authRoleList", arrayList1);
		mv.addObject("nonAuthRoleList", arrayList2);
		mv.addObject("user",user);
		return mv;
	}
	
	/**
	 * 添加用户角色
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView addUserRole(HttpServletRequest request,
			HttpServletResponse response) {
		String roleIds[] = request.getParameterValues("roleIds");
		String userId = request.getParameter("userId");
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			this.authService.addUserRoleRnTx(roleIds, new Integer(userId));
			returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_0000);
			returnMap.put("description", ValTemplate.V_T_VAL_MSG_RMK_0000);
			String result = JSONUtil.toJSonString(returnMap);
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
		} catch (IOException e) {
			logger.error("AppInfoConntroller.addAppInfo throws error",e);	
			returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_ERROR);
			returnMap.put("description", ValTemplate.V_T_VAL_MSG_RMK_ERROR);
		}
		return null;
	}

	/**
	 * 角色菜单操作(增加或者删除)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView roleMenuOp(HttpServletRequest request,
			HttpServletResponse response) {
		// 定义响应model
		ModelAndView mv = null;

		String cbsList[] = request.getParameterValues("cbs");// 菜单ID
		String roleId = request.getParameter("hiddenVr");// 角色ID
		String type = request.getParameter("sss1");

		ArrayList<String> list = new ArrayList<String>();// cbsList[] 2 list

		for (String str : cbsList) {
			list.add(str);
		}

		List<RoleMenu> roleMenuList = authService.queryRoleMenuByRoleId(roleId);// 所操作角色已有菜单

		if (type.equals("o1")) {// 增加

			ArrayList<String> listTmp = new ArrayList<String>();// 存放需增加的菜单ID

			for (int i = 0; i < list.size(); i++) {

				if (check(list.get(i), roleMenuList) == false) {// 如不存在，则记录

					listTmp.add(list.get(i));
				}

			}

			ArrayList<RoleMenu> finalList = new ArrayList<RoleMenu>();// 需增加的LIST

			for (int i = 0; i < listTmp.size(); i++) {
				RoleMenu rm = new RoleMenu();
				rm.settRoleId(new Integer(roleId));
				rm.settMenuId(new Integer(listTmp.get(i)));
				finalList.add(rm);
			}

			try {
				if (finalList.size() > 0) {
					authService.batchCreateRnTx(finalList);
				}
				mv = new ModelAndView(showmsgPage);
				mv.addObject(ValTemplate.V_T_KEY_MSG_CODE,
						ValTemplate.V_T_VAL_MSG_CODE_0000);
				mv.addObject(ValTemplate.V_T_KEY_MSG_RMK,
						ValTemplate.V_T_VAL_MSG_RMK_0000);

				log.info("[系统]-[角色菜单管理]-[角色菜单增加完成。]");
			} catch (Exception e) {

				mv = new ModelAndView(showmsgPage);
				mv.addObject(ValTemplate.V_T_KEY_MSG_CODE,
						ValTemplate.V_T_VAL_MSG_CODE_0001);
				mv.addObject(ValTemplate.V_T_KEY_MSG_RMK,
						ValTemplate.V_T_VAL_MSG_RMK_0001);

				log.info("[系统]-[角色菜单管理]-[角色菜单增加失败。]");
			}

		} else if (type.equals("o2")) {// 删除

			ArrayList<RoleMenu> rmList = new ArrayList<RoleMenu>();

			for (int i = 0; i < list.size(); i++) {
				RoleMenu rm = new RoleMenu();
				rm.settRoleId(new Integer(roleId));
				rm.settMenuId(new Integer(list.get(i).trim()));
				rmList.add(rm);
			}

			try {
				if (rmList.size() > 0) {
					authService.batchDelRnTx(rmList);
				}
				mv = new ModelAndView(showmsgPage);
				mv.addObject(ValTemplate.V_T_KEY_MSG_CODE,
						ValTemplate.V_T_VAL_MSG_CODE_0000);
				mv.addObject(ValTemplate.V_T_KEY_MSG_RMK,
						ValTemplate.V_T_VAL_MSG_RMK_0000);
				log.info("[系统]-[角色菜单管理]-[角色菜单删除完成。]");

			} catch (Exception e) {

				mv = new ModelAndView(showmsgPage);
				mv.addObject(ValTemplate.V_T_KEY_MSG_CODE,
						ValTemplate.V_T_VAL_MSG_CODE_0001);
				mv.addObject(ValTemplate.V_T_KEY_MSG_RMK,
						ValTemplate.V_T_VAL_MSG_RMK_0001);
				log.info("[系统]-[角色菜单管理]-[角色菜单删除失败。]");
			}

		}

		return mv;
	}

	/**
	 * 检查
	 * 
	 * @param str
	 *            选择串
	 * @param roleMenuList
	 *            比较串
	 * @return true 选择串在比较串中存在 false 选择串在比较串中不存在
	 */
	private boolean check(String str, List<RoleMenu> roleMenuList) {

		boolean bv = false;

		for (int i = 0; i < roleMenuList.size(); i++) {
			if (str.trim().equals(roleMenuList.get(i).gettMenuId().toString())) {
				bv = true;
			}
		}
		return bv;
	}

	/*****************************************/

	/**
	 * 用户角色权限管理
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView authDefault2(HttpServletRequest request,
			HttpServletResponse response) {

		List<Role> retList = roleService.queryRole();

		List<User> retList2 = userService.queryUser();

		//

		log.info("[系统]-[用户&角色检索]-[用户&角色检索数据提取完成]");

		// 定义响应model
		ModelAndView mv = null;
		mv = new ModelAndView(authDefaultPage2);
		mv.addObject("retList", retList);
		mv.addObject("retList2", retList2);

		return mv;
	}

	/**
	 * 更新跳转
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView userRoleDispth(HttpServletRequest request, HttpServletResponse response) {
		//定义响应model
		ModelAndView mv = new ModelAndView(this.changeRole);
		String id = request.getParameter("id");
		User user = this.userService.findById(new Integer(id));
		// 查询用户角色
		
		return mv.addObject("user", user);
	}
	
	public ModelAndView userRole(HttpServletRequest request,
			HttpServletResponse response) {

		// 定义响应model
		ModelAndView mv = null;

		String userId = request.getParameter("userId");// 用户ID
		String roleId = request.getParameter("roleId");// 角色ID

		UserRole userRole = new UserRole();
		userRole.settUserId(new Integer(userId));
		userRole.settRoleId(new Integer(roleId));

		// 检查此用户是否已配置此角色
		List<UserRole> urs = authService.queryUserRole(new Integer(userId));
		
		boolean flag = false;
		
		if(urs != null && urs.size()>0){
			for(UserRole u : urs){
				if(u.gettRoleId() != null && u.gettRoleId().equals(userRole.gettRoleId())){
					flag = true;
					break;
				}
			}
		}
		

		if (flag) {

			try {
				authService.createUserRoleRnTx(userRole);

				mv = new ModelAndView(showmsgPage);
				mv.addObject(ValTemplate.V_T_KEY_MSG_CODE,ValTemplate.V_T_VAL_MSG_CODE_0000);
				mv.addObject(ValTemplate.V_T_KEY_MSG_RMK,ValTemplate.V_T_VAL_MSG_RMK_0000);
				log.info("[系统]-[用户角色管理]-[用户角色增加完成。]");

			} catch (Exception e) {
				mv = new ModelAndView(showmsgPage);
				mv.addObject(ValTemplate.V_T_KEY_MSG_CODE,ValTemplate.V_T_VAL_MSG_CODE_0001);
				mv.addObject(ValTemplate.V_T_KEY_MSG_RMK,ValTemplate.V_T_VAL_MSG_RMK_0001);
				log.info("[系统]-[用户角色管理]-[用户角色增加失败。]");
			}
		}else{
			mv = new ModelAndView(showmsgPage);
			mv.addObject(ValTemplate.V_T_KEY_MSG_CODE,ValTemplate.V_T_VAL_MSG_CODE_0003);
			mv.addObject(ValTemplate.V_T_KEY_MSG_RMK,ValTemplate.V_T_VAL_MSG_RMK_0003);
			log.info("[系统]-[用户角色管理]-[用户角色增加失败，已有绑定角色。]");
		}

		return mv;
	}

}
