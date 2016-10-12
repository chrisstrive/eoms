package com.shecc.eoms.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.shecc.eoms.core.model.Menu;
import com.shecc.eoms.core.model.User;
import com.shecc.eoms.web.common.ValTemplate;
import com.shecc.eoms.web.common.md5.MD5;
import com.shecc.eoms.web.dto.UserDTO;
import com.shecc.eoms.web.service.MenuService;
import com.shecc.eoms.web.service.UserService;
/**
 * 
 * 登录
 * @author ray
 *
 */
public class LoginController extends MultiActionController {
	
	private static final Log log = LogFactory.getLog(LoginController.class);
	
	private UserService userService;
	private MenuService menuService;
	
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private String homePage;
	private String indexPage;
	private String loginoutPage;
	private String loginPage;

	public void setLoginoutPage(String loginoutPage) {
		this.loginoutPage = loginoutPage;
	}
	public void setIndexPage(String indexPage) {
		this.indexPage = indexPage;
	}
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}
	/**
	 * 登录
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) {
		
		//定义响应model
		ModelAndView mv = null;
		
		//获取登录信息
		String loginName = request.getParameter("user_name");
		String passWord = request.getParameter("user_password");
		String isAutoLogin = request.getParameter("isAutoLogin");
		if(StringUtils.isNotBlank(passWord)
				&& StringUtils.equals("0", isAutoLogin)){
			passWord =  MD5.getMD5Str(passWord);
		}
		
		//登录参数 完整 或 不完整
		if(StringUtils.isBlank(loginName) 
				|| StringUtils.isBlank(passWord)){
			log.info("[系统]-[登录]-[登录参数不完整]");
			mv = new ModelAndView(loginPage);
		}
		else{
			log.info("[系统]-[登录]-[登录参数完整]");
			
			//验证用户、密码
			log.info("[系统]-[登录]-[验证用户&密码]");
			User user = userService.queryUserByNameAndPwd(loginName, passWord);
			
			if(user != null
					&& StringUtils.equals(user.getStatus(), "1")){//验证正确
				//加载用户配置
				log.info("[系统]-[登录]-[加载用户私有配置]");
				//加载原始菜单
			//	List<Menu> menuList = menuService.queryMenuByUserId(user.getId());
				List<Map<String, Object>> menuList = menuService.queryMenuByUser(user.getId());
//				String menu = loadMenu(menuList);
				
				//用户信息处理写入SESSION 且 返回至 TOP
				UserDTO ud = new UserDTO();
				ud.setId(user.getId());
				ud.setUserName(user.getUserName());
				ud.setRealName(user.getRealName());
				ud.setPassWd(user.getPassWd());
				
				HttpSession session = request.getSession();
				session.setAttribute("user", ud);
				
				session.setAttribute(ValTemplate.V_T_USER_NAME, ud.getUserName());
				session.setAttribute(ValTemplate.V_T_USER_PWD, ud.getPassWd());
				
				Map<String, Object> modelMap = new HashMap<String, Object>();
				//响应
				mv = new ModelAndView(homePage);
				mv.addObject("userDto",ud);
				// 树形菜单
//				String menuListJson = JSONUtil.toJSonString(menuList);
//				modelMap.put("menu", menuListJson);
//				mv.addObject("modelMap", modelMap);
				mv.addObject("menuList", menuList);
				
				// 设置Cookie
				Cookie userNameCookie=new Cookie("userName", loginName); 
				// 设置cookie生命值
				userNameCookie.setMaxAge(24*60*60*30);
				response.addCookie(userNameCookie);
				Cookie passWordCookie=new Cookie("passWord", passWord); 
				// 设置cookie生命值
				passWordCookie.setMaxAge(24*60*60*30);
				response.addCookie(passWordCookie);
			}
			else{//验证错误

				mv = new ModelAndView(loginoutPage);
				mv.addObject("msgInfo","信息有误，请输入有效信息或拨打联系电话需求支持。");
				
			}
			
		}
		
		return mv;
	}
	
	private String loadMenu(List<Menu> menuList){
		String menuNode = "";
		if(menuList != null
				&& menuList.size() > 0){
			for(Menu menu : menuList){
				menuNode += "<li state=\"closed\"><span class=\"nav\">" + menu.getMenuName() + "</span>";
				String isParent = menu.getIsParent();
				List<Menu> subMenuList = menu.getSubMenuList();
				if("1".equals(isParent)
						&& (subMenuList != null && subMenuList.size() > 0)){
					menuNode += setSubMenu(subMenuList);
				}
				menuNode += "</li>";
			}
		}
		return menuNode;
	}

	private String setSubMenu(List<Menu> subMenuList){
		String menuNode = ""; 
		if(subMenuList != null
				&& subMenuList.size() > 0){
			menuNode += "<ul>";
			for(Menu subMenu : subMenuList){
				menuNode += "<li><span class=\"nav\">" 
						+ (StringUtils.isNotBlank(subMenu.getUrl()) ? ("<a href=\"<@sp.contextPath/>" + subMenu.getUrl() + "\" target=\"centerIframe\">" + subMenu.getMenuName() + "</a>") : subMenu.getMenuName()) 
						+ "</span>";
				String subParent = subMenu.getIsParent();
				List<Menu> subMenuListTmp = subMenu.getSubMenuList();
				if(StringUtils.equals(subParent, "1")
						&& (subMenuListTmp != null && subMenuListTmp.size() > 0)){
					menuNode += setSubMenu(subMenuListTmp);
				}
			}
			menuNode += "</ul>";
		}
		
		return menuNode;
	}

	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView(loginoutPage);
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.removeAttribute(ValTemplate.V_T_USER_NAME);
		session.removeAttribute(ValTemplate.V_T_USER_PWD);
		mv.addObject("msgInfo", "成功退出系统。");
		return mv;
	}
	
}
